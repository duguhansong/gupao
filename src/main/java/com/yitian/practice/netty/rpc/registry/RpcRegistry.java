package com.yitian.practice.netty.rpc.registry;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class RpcRegistry {
	private int port = 8080;
	

	//ServerSocket--ServerBootStrap
	//Selector 主线程,work线程
	public void start() throws InterruptedException {
		
		EventLoopGroup parentGroup = new NioEventLoopGroup();//配置boss线程池--selector
		EventLoopGroup childGroup = new NioEventLoopGroup();//work线程池
		
		ServerBootstrap server = new ServerBootstrap();
		server.group(parentGroup, childGroup);
		server.channel(NioServerSocketChannel.class);//轮训所有的slectkey
		server.childHandler(new ChannelInitializer<SocketChannel>() {
			//把所有的鹅业务逻辑处理全部归总一个队列中，队列中包含了各种各样的处理逻辑,
			//对这些处理逻辑在Netty中的一个封装
			//Pipline
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ChannelPipeline pipeline =   ch.pipeline();
				//自定义协议内容 解码
				ChannelHandler decoderHandler = new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4,0,4); 
				pipeline.addLast(decoderHandler);
				
				//编码
				ChannelHandler encodeHandler = new LengthFieldPrepender(4);
				pipeline.addLast(encodeHandler);
				//实参处理：完成对数据的解析,
				pipeline.addLast("encodeer",new ObjectEncoder());
				pipeline.addLast("decodeer",new ObjectDecoder(Integer.MAX_VALUE,ClassResolvers.cacheDisabled(null)));
				
				//业务处理piple
				pipeline.addLast(new RegistryHandler());
			}
		});
		server.option(ChannelOption.SO_BACKLOG, 128);
		server.option(ChannelOption.SO_KEEPALIVE, true);
		
		ChannelFuture future = server.bind(this.port);
		future.channel().closeFuture().sync();
	}
	public static void main(String[] args) throws InterruptedException {
		try {
			new RpcRegistry().start();
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw e;
		};
	}
}
