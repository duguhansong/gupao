package com.yitian.practice.netty.rpc.consumer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.yitian.practice.netty.rpc.protocol.InvokerProtocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class RpcProxy {

	@SuppressWarnings("unchecked")
	public static <T> T createProxy(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
															new Class[] {clazz},
															new MethodInvoke<T>(clazz));
	}
}

class MethodInvoke<T> implements InvocationHandler{
	private Class<T> clazz = null;
	private RpcProxyHandler handler = null;
	public MethodInvoke(Class<T> clazz) {
		this.clazz = clazz;
	}
	public void init(final InvokerProtocol msg) throws InterruptedException {
		System.out.println("nio 初始化开始");
		handler = new RpcProxyHandler(msg);
		EventLoopGroup group = new NioEventLoopGroup();//work线程池
		try {
			Bootstrap strap = new Bootstrap();
			strap.group(group);
			strap.channel(NioSocketChannel.class);
			strap.option(ChannelOption.SO_KEEPALIVE,true);
			strap.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ChannelPipeline pipeline = ch.pipeline();
					pipeline.addLast("frameDecoder",new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
					pipeline.addLast("frameEncoder",new LengthFieldPrepender(4));
					pipeline.addLast("encoder",new ObjectEncoder());
					pipeline.addLast("decoder",new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
					pipeline.addLast("handler",handler);
				}
			});
			ChannelFuture f =  strap.connect("127.0.0.1",8080).sync();
			f.channel().closeFuture().sync();
		}finally {
			group.shutdownGracefully();
		}
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		InvokerProtocol msg = new InvokerProtocol();
		msg.setClassName(this.clazz.getName());
		msg.setMethodName(method.getName());
		msg.setPrames(method.getParameterTypes());
		msg.setValues(args);
		init(msg);
		return handler.getResponse();
	}
}
