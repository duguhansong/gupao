package com.yitian.practice.netty.rpc.provider;

import com.yitian.practice.netty.rpc.api.IRpcHelloService;

public class RpcHelloServiceImpl implements IRpcHelloService{
	//µ¥Àý
	public final static RpcHelloServiceImpl ins = new RpcHelloServiceImpl();
	private RpcHelloServiceImpl() {
		
	}
	

	public String hello(String name) {
		System.out.println("Server:helloµ÷ÓÃ" + name);
		return "Hello " +name +"!";
	}

}
