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
	//Selector ���߳�,work�߳�
	public void start() throws InterruptedException {
		
		EventLoopGroup parentGroup = new NioEventLoopGroup();//����boss�̳߳�--selector
		EventLoopGroup childGroup = new NioEventLoopGroup();//work�̳߳�
		
		ServerBootstrap server = new ServerBootstrap();
		server.group(parentGroup, childGroup);
		server.channel(NioServerSocketChannel.class);//��ѵ���е�slectkey
		server.childHandler(new ChannelInitializer<SocketChannel>() {
			//�����еĶ�ҵ���߼�����ȫ������һ�������У������а����˸��ָ����Ĵ����߼�,
			//����Щ�����߼���Netty�е�һ����װ
			//Pipline
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ChannelPipeline pipeline =   ch.pipeline();
				//�Զ���Э������ ����
				ChannelHandler decoderHandler = new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4,0,4); 
				pipeline.addLast(decoderHandler);
				
				//����
				ChannelHandler encodeHandler = new LengthFieldPrepender(4);
				pipeline.addLast(encodeHandler);
				//ʵ�δ�����ɶ����ݵĽ���,
				pipeline.addLast("encodeer",new ObjectEncoder());
				pipeline.addLast("decodeer",new ObjectDecoder(Integer.MAX_VALUE,ClassResolvers.cacheDisabled(null)));
				
				//ҵ����piple
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
