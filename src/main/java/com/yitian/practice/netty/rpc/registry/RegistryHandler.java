package com.yitian.practice.netty.rpc.registry;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.yitian.practice.netty.rpc.api.IRpcHelloService;
import com.yitian.practice.netty.rpc.api.IRpcService;
import com.yitian.practice.netty.rpc.protocol.InvokerProtocol;
import com.yitian.practice.netty.rpc.provider.RpcHelloServiceImpl;
import com.yitian.practice.netty.rpc.provider.RpcServiceImpl;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class RegistryHandler extends ChannelHandlerAdapter {
	private final Map<String,Object> services  = new HashMap<String,Object>();
	public RegistryHandler() {
		services.put(IRpcHelloService.class.getName(), RpcHelloServiceImpl.ins);
		services.put(IRpcService.class.getName(), RpcServiceImpl.ins);
	}
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("server:channelReadµ÷ÓÃ");
		InvokerProtocol req = (InvokerProtocol)msg;
		System.out.println("server:"+req.toString());
		Object result = new Object();
		Object obj = services.get(req.getClassName());
		if(obj != null) {
			Method m = obj.getClass().getMethod(req.getMethodName(), req.getPrames());
			result = m.invoke(services.get(req.getClassName()), req.getValues());
		}
		System.out.println("server result:"+result.toString());
        ctx.writeAndFlush(result);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		super.exceptionCaught(ctx, cause);
	}
}
