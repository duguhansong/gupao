package com.yitian.practice.netty.rpc.consumer;

import com.yitian.practice.netty.rpc.api.IRpcHelloService;
import com.yitian.practice.netty.rpc.api.IRpcService;
import com.yitian.practice.netty.rpc.consumer.proxy.RpcProxy;

public class Consumer {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		IRpcHelloService helloService = RpcProxy.createProxy(IRpcHelloService.class);
		System.out.println(helloService.hello("yitian"));
		
		int a = 10001;
		int b = 10006;
		IRpcService rpcService = RpcProxy.createProxy(IRpcService.class);
		System.out.println(String.format("%d + %d = %d ",a , b ,rpcService.add(a, b)));
		System.out.println(String.format("%d - %d = %d ",a , b ,rpcService.div(a, b)));
		System.out.println(String.format("%d * %d = %d ",a , b ,rpcService.mult(a, b)));
		System.out.println(String.format("%d / %d = %d ",a , b ,rpcService.sub(a, b)));
	}

}
