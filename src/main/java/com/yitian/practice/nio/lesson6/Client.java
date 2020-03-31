package com.yitian.practice.nio.lesson6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Client {
	private Selector selector;
	private Scanner scan = new Scanner(System.in);

	private Client() {
	}

	public void init() throws IOException {
		selector = Selector.open();
	}

	public void start() throws IOException {
		SocketChannel socket = SocketChannel.open();
		socket.configureBlocking(false);
		socket.connect(new InetSocketAddress(8899));
		socket.register(selector,SelectionKey.OP_CONNECT );
		
		boolean isRunning = true;
		while (isRunning) {
			selector.select();
			Set<SelectionKey> keys = selector.selectedKeys();
			
			Iterator<SelectionKey> iterabtor = keys.iterator();
			while (iterabtor.hasNext()) {
				SelectionKey key = iterabtor.next(); 
				if (key.isConnectable()) {
					handConnec(key);
				} else if (key.isReadable()) {
					handRead(key);
				} else if (key.isWritable()) {
					isRunning=handWrite(key);
				}
			}
		}
		System.out.println("client closed ...");
	}

	private void handConnec(SelectionKey key) throws IOException {
		// ��ȡ�����˽������ӵ�ͨ��
        SocketChannel channel = (SocketChannel) key.channel();
        if (channel.isConnectionPending()) {
            // channel.finishConnect()�����������
            channel.finishConnect();
        }
        channel.configureBlocking(false);
        String str = getCommandStr();
        // ����д��ͨ��
        channel.write(ByteBuffer.wrap(new String(str.getBytes(Charset.forName("utf-8"))).getBytes()));
 
        // ͨ��ע�ᵽѡ�������������ͨ��ֻ�Զ��¼�����Ȥ
        channel.register(selector, SelectionKey.OP_READ);
	}

	private void handRead(SelectionKey key) throws IOException {
		System.out.println("handRead start");
		SocketChannel channel = (SocketChannel) key.channel();

		// ��ͨ����ȡ���ݵ�������
		ByteBuffer buffer = ByteBuffer.allocate(128);
		channel.read(buffer);

		// ����ͻ��˷��͹�������Ϣ
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println(msg);
		channel.register(selector, SelectionKey.OP_WRITE);
	}

	private boolean handWrite(SelectionKey key) throws IOException {
		System.out.println("handwrite start");
		String commandStr = getCommandStr();
		if ("shutdown".equalsIgnoreCase(commandStr))
			return false;
		SocketChannel channel = (SocketChannel) key.channel();
		// ��ͨ����ȡ���ݵ�������
		ByteBuffer buffer = ByteBuffer.wrap(commandStr.getBytes(Charset.forName("utf-8")));
		channel.write(buffer);
		channel.register(selector, SelectionKey.OP_READ);
		return true;
	}
	private String getCommandStr() {
		return scan.next();
	}

	public static void main(String[] args) throws IOException {
		Client client = new Client();

		client.init();
		client.start();
	}
}
