package com.yitian.practice.netty.httpFileServer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelProgressiveFuture;
import io.netty.channel.ChannelProgressiveFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.stream.ChunkedFile;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;


public class HttpFileServer {

	private void start() throws InterruptedException {
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup work = new NioEventLoopGroup();
		
		ServerBootstrap strap = new ServerBootstrap();
		strap.channel(NioServerSocketChannel.class);
		strap.group(boss,work);
		strap.childHandler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast("http-decoder",new HttpRequestDecoder());
				ch.pipeline().addLast("http-aggregator",new HttpObjectAggregator(65536));
				ch.pipeline().addLast("http-encoder",new HttpResponseEncoder());
				ch.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
				ch.pipeline().addLast("fileServerHandler",new HttpFileServerHandler());
			}
		});
		ChannelFuture f;
		try {
			int port =8080;
			f = strap.bind(port).sync();
			System.out.println(String.format("文件服务器启动,端口:%d",port));
			f.channel().closeFuture().sync();
		} finally {
			boss.shutdownGracefully();
			work.shutdownGracefully();
		}
	}
	public static void main(String[] args) {
		try {
			new HttpFileServer().start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest>{
	 private static final Pattern INSECURE_URI = Pattern.compile(".*[<>&\"].*");
	 private final String url="/";
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
		if(!req.getDecoderResult().isSuccess()) {
			sendError(ctx,HttpResponseStatus.BAD_REQUEST);
			return;
		}
		if(req.getMethod() != HttpMethod.GET) {
			sendError(ctx,HttpResponseStatus.METHOD_NOT_ALLOWED);
			return;
		}
		final String url = req.getUri();
		final String path = sanitizeUri(url);
		if(path == null) {
				sendError(ctx,HttpResponseStatus.FORBIDDEN);
				return;
		}
		File file =  new File(path);
		if(file.isHidden() || !file.exists()) {
			sendError(ctx,HttpResponseStatus.NOT_FOUND);
			return;
		}
		if(file.isDirectory()) {
            if(url.endsWith("/"))
            {
                sendListing(ctx, file);
            }else{
                sendRedirect(ctx, url + "/");
            }
            return;
		}
		if(!file.isFile()) {
			sendError(ctx,HttpResponseStatus.FORBIDDEN);
			return;
		}
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile(file, "r");
			long fileLength = randomAccessFile.length();
			HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
			HttpHeaders.setContentLength(response, fileLength);
			//todo
			if(HttpHeaders.isKeepAlive(req)) {
				response.headers().set(HttpHeaders.Names.CONNECTION,HttpHeaders.Values.KEEP_ALIVE);
			}
			ctx.write(response);
			ChunkedFile chunkedFile = new ChunkedFile(randomAccessFile,0,fileLength,8192);
			ChannelFuture sendFileFuture  = ctx.write(chunkedFile,ctx.newProgressivePromise());
			sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
				public void operationProgressed(ChannelProgressiveFuture future, long progress, long total) throws Exception {
					  if (total < 0) { // total unknown
		                    System.err.println("Transfer progress: " + progress);
		                } else {
		                    System.err.println("Transfer progress: " + progress + " / " + total);
		                }
				}

				public void operationComplete(ChannelProgressiveFuture future) throws Exception {
					System.out.println("Transfer complete.");
				}
			});
			  ChannelFuture lastContentFuture = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
		        if (!HttpHeaders.isKeepAlive(req)) {
		            lastContentFuture.addListener(ChannelFutureListener.CLOSE);
		        }
		}catch(FileNotFoundException fnfe) {
			sendError(ctx,HttpResponseStatus.NOT_FOUND);
			return;
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        if(ctx.channel().isActive())
            sendError(ctx, HttpResponseStatus.INTERNAL_SERVER_ERROR);
	}

	////////////////////////////////////////辅助方法////////////////////////////////////////////////////////
    private static void sendError(ChannelHandlerContext ctx,HttpResponseStatus status){
    	ByteBuf buf = Unpooled.copiedBuffer("Failure: "+status.toString()+"\r\n",CharsetUtil.UTF_8);
        FullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,status,buf);
        response.headers().set(HttpHeaders.Names.CONTENT_TYPE,"text/html;charset=UTF-8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
    private String sanitizeUri(String uri) {
        try {
            uri = URLDecoder.decode(uri, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            try {
                uri = URLDecoder.decode(uri, "ISO-8859-1");
            } catch (UnsupportedEncodingException e1) {
                throw new Error();
            }
        }
        if (!uri.startsWith(url)) {
            return null;
        }
        if (!uri.startsWith("/")) {
            return null;
        }
        uri = uri.replace('/', File.separatorChar);
        if (uri.contains(File.separator + '.')
        		|| uri.contains('.' + File.separator)
        		|| uri.startsWith(".") 
        		|| uri.endsWith(".")
        		|| INSECURE_URI.matcher(uri).matches()) {
        	
            return null;
        }
        return "F://"+ File.separator + uri;
    }
   
    
    private static final Pattern ALLOWED_FILE_NAME = Pattern.compile("[A-Za-z0-9][-_A-Za-z0-9\\.]*");
    private static void sendListing(ChannelHandlerContext ctx, File dir){
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
//        response.headers().set("CONNECT_TYPE", "text/html;charset=UTF-8");
        response.headers().set(HttpHeaders.Names.CONTENT_TYPE, "text/html;charset=UTF-8");
        
        String dirPath = dir.getPath();
        StringBuilder buf = new StringBuilder();
        
        buf.append("<!DOCTYPE html>\r\n");
        buf.append("<html><head><title>");
        buf.append(dirPath);
        buf.append("目录:");
        buf.append("</title></head><body>\r\n");
        
        buf.append("<h3>");
        buf.append(dirPath).append(" 目录：");
        buf.append("</h3>\r\n");
        buf.append("<ul>");
        buf.append("<li>链接：<a href=\" ../\")..</a></li>\r\n");
        for (File f : dir.listFiles()) {
            if(f.isHidden() || !f.canRead()) {
                continue;
            }
            String name = f.getName();
            if (!ALLOWED_FILE_NAME.matcher(name).matches()) {
                continue;
            }
            
            buf.append("<li>链接：<a href=\"");
            buf.append(name);
            buf.append("\">");
            buf.append(name);
            buf.append("</a></li>\r\n");
        }
        
        buf.append("</ul></body></html>\r\n");
        
        ByteBuf buffer = Unpooled.copiedBuffer(buf,CharsetUtil.UTF_8);  
        response.content().writeBytes(buffer);  
        buffer.release();  
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE); 
    }
    private static void sendRedirect(ChannelHandlerContext ctx, String newUri){
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FOUND);
//        response.headers().set("LOCATIN", newUri);
        response.headers().set(HttpHeaders.Names.LOCATION, newUri);
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
}
