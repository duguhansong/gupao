package com.yitian.practice.netty.rpc.provider;

import com.yitian.practice.netty.rpc.api.IRpcHelloService;

public class RpcHelloServiceImpl implements IRpcHelloService{
	//����
	public final static RpcHelloServiceImpl ins = new RpcHelloServiceImpl();
	private RpcHelloServiceImpl() {
		
	}
	

	public String hello(String name) {
		System.out.println("Server:hello����" + name);
		return "Hello " +name +"!";
	}

}
