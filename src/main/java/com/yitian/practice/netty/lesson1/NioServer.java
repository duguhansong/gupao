package com.yitian.practice.netty.lesson1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

	private int port = 8899;
	private String ip = "localhost";
	private Selector selector=null;
	
	public void start() throws IOException {
		selector = Selector.open();
		
		ServerSocketChannel server = ServerSocketChannel.open();
		server.configureBlocking(false);
		SocketAddress addr = new InetSocketAddress(ip, port);
		server.socket().bind(addr);
		
		server.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("初始化完成.");
		while(true) {
			if(selector.select() <= 0) continue;		
			Set<SelectionKey> keys =selector.selectedKeys();
			Iterator< SelectionKey> iterator = keys.iterator();
			while(iterator.hasNext()) {
				SelectionKey key = iterator.next();
				if(key.isAcceptable()) {
					processAccept(key.channel());
				}else if(key.isConnectable()) {
					
				}else if(key.isReadable()) {
					processRead((SocketChannel)key.channel());
				}else if(key.isWritable()) {
					
				}else if(key.isValid()) {
					
				}
			}
		}
	}
	
	private void processAccept(SelectableChannel channel) throws IOException {
		System.out.println("接受请求:");
		ServerSocketChannel server = (ServerSocketChannel)channel;
		
		SocketChannel client = server.accept();
		client.configureBlocking(false);
		client.register(selector, SelectionKey.OP_READ);
	}
	private void processRead(SocketChannel channel) throws IOException {
	        ByteBuffer buffer = ByteBuffer.allocate(1024);
	        
	        if (channel.read(buffer)!= -1){
	            String msg = new String(buffer.array()).trim();
	            System.out.println("NIO server received message =  " + msg);
	            
	            channel.register(selector, SelectionKey.OP_WRITE);
	            System.out.println("NIO server reply =  " + msg);
	            channel.write(ByteBuffer.wrap( msg.getBytes()));
	        }else{
	            channel.close();
	        }
	}
	public static void main(String[] args) throws IOException {
		NioServer server = new NioServer();
		server.start();
	}

}
