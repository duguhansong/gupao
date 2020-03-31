package com.yitian.practice.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Class.forName(ServerSocket.class.getName());
		ServerSocket server = new ServerSocket(8000); 
		System.out.println(server);
	}

}
