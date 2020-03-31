package com.yitian.practice.netty.timeServer;

import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TimeClient {
	private void connect() {
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap strap = new Bootstrap();
		strap.group(group);
		strap.channel(NioSocketChannel.class);
		strap.option(ChannelOption.TCP_NODELAY, true);
		strap.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
				ch.pipeline().addLast(new StringDecoder(Charset.forName("utf-8")));
				ch.pipeline().addLast(new TimeClientHandler());
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
	public static void main(String[] args) {
		new TimeClient().connect();
	}

}

class TimeClientHandler extends ChannelHandlerAdapter{

	private AtomicInteger counter = new AtomicInteger(0);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String tmp = "query time" + System.getProperty("line.separator");
		 byte[] req = tmp.getBytes(Charset.forName("utf-8"));
		ByteBuf message = null;
		for(int i = 0; i < 100; i++) {
			message = Unpooled.buffer(req.length);
			message.writeBytes(req);
			ctx.writeAndFlush(message);
		}
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String body = (String)msg;
		System.out.println("Now is :"  + body + "; the counter is = " + (counter.incrementAndGet()));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
}
