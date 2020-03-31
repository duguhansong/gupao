package com.yitian.practice.netty.echoServer;

import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class EchoServer {

	public static void main(String[] args) {
		new EchoServer().start();
	}

	private  void start() {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		
		ServerBootstrap strap = new ServerBootstrap();
		strap.group(bossGroup,workGroup);
		strap.channel(NioServerSocketChannel.class);
		strap.childHandler(new ChannelInitializer<SocketChannel>() {

			ByteBuf delimiter = Unpooled.copiedBuffer("&_".getBytes(Charset.forName("utf-8")));
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,delimiter));
				ch.pipeline().addLast(new StringDecoder(Charset.forName("utf-8")));
				ch.pipeline().addLast(new EchoServerHandler());
			}
		});
		ChannelFuture f = null;
		try {
			f= strap.bind(8080).sync();
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
		
	}
}
class EchoServerHandler extends ChannelHandlerAdapter{
	private AtomicInteger counter = new AtomicInteger(0);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String body = (String)msg;
		System.out.println("receive order : " + body + "; the counter is :" + (counter.incrementAndGet()));
		ByteBuf resp = Unpooled.copiedBuffer(body.concat("&_").getBytes());
		ctx.writeAndFlush(resp);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
	
}
