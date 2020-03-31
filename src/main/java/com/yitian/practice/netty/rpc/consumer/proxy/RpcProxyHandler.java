package com.yitian.practice.netty.rpc.consumer.proxy;

import com.yitian.practice.netty.rpc.protocol.InvokerProtocol;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class RpcProxyHandler extends ChannelHandlerAdapter{
	private Object response = null;

	private InvokerProtocol msg; 
	public RpcProxyHandler(InvokerProtocol msg) {
		this.msg = msg;
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("client:" + msg.toString());
		ctx.writeAndFlush(msg);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("server response:" + msg);
		response = msg;
	}
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelReadComplete");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
	}
	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
}
