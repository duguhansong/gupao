package com.yitian.practice.netty.rpc.provider;

import com.yitian.practice.netty.rpc.api.IRpcService;

public class RpcServiceImpl implements IRpcService {
	public final static RpcServiceImpl ins = new RpcServiceImpl();
	private RpcServiceImpl() {
		
	}

	public int add(int a, int b) {
		return  a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int mult(int a, int b) {
		return  a * b;
	}

	public int div(int a, int b) {
		return a / b;
	}

}
