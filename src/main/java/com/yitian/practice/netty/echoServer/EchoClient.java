package com.yitian.practice.netty.echoServer;

import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class EchoClient {

	public static void main(String[] args) {
		new EchoClient().start();
	}

	private void start() {
		EventLoopGroup group = new NioEventLoopGroup();
		
		Bootstrap strap = new Bootstrap();
		strap.group(group);
		strap.channel(NioSocketChannel.class);
		strap.handler(new ChannelInitializer<SocketChannel>() {
			ByteBuf delimiter = Unpooled.copiedBuffer("&_".getBytes(Charset.forName("utf-8")));
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				
				ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,delimiter));
				ch.pipeline().addLast(new StringDecoder(Charset.forName("utf-8")));
				ch.pipeline().addLast(new EchoClientHandler());
			}
		});
		ChannelFuture f;
		try {
			f = strap.connect("127.0.0.1",8080).sync();
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			group.shutdownGracefully();
		}
		
	}
}
class EchoClientHandler extends ChannelHandlerAdapter{
	private AtomicInteger counter = new AtomicInteger(0);
	private final String sendmsg = "Hello cainiao,welcome to netty.&_";
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for(int i =0; i < 20; i++) {
			ByteBuf msg = Unpooled.copiedBuffer(sendmsg.getBytes(Charset.forName("utf-8")));
			ctx.writeAndFlush(msg);
		}
	}
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String body = (String)msg;
		System.out.println("Server echo  is :"  + body + "; the counter is = " + (counter.incrementAndGet()));
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
	
}