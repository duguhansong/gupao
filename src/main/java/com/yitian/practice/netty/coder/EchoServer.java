package com.yitian.practice.netty.coder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class EchoServer {

	private void start() throws InterruptedException {
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup work = new NioEventLoopGroup();
		
		ServerBootstrap starp = new ServerBootstrap();
		starp.group(boss,work);
		starp.channel(NioServerSocketChannel.class);
		starp.childHandler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast("frameDecoder",new LengthFieldBasedFrameDecoder(635535, 0, 2,0,2));
				ch.pipeline().addLast("msgpack decoder",new MsgpackDecoder() );
				ch.pipeline().addLast("frameEncoder",new LengthFieldPrepender(2));
				ch.pipeline().addLast("msgpack encoder",new MsgpackEncoder() );
				ch.pipeline().addLast(new EchoServerHandler());
			}
		});
		ChannelFuture f = starp.bind(8080).sync();
		f.channel().closeFuture().sync();
		boss.shutdownGracefully();
		work.shutdownGracefully();
		System.out.println("server shutdowned...");
	}
	
	public static void main(String[] args) {
		try {
			new EchoServer().start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class EchoServerHandler extends ChannelHandlerAdapter{
	

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("client connected..");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("server recive message :" + msg);
		ctx.writeAndFlush(msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
}