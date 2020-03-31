package com.yitian.practice.nio.lesson6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class Server {

	public static void main(String[] args) {

		try {
			Server server = new Server();
			server.init();
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private Selector selector;
	private Server() {
		
	}
	public void init() throws IOException {
		selector = Selector.open();
		ServerSocketChannel serverSocket = ServerSocketChannel.open();
		serverSocket.bind(new InetSocketAddress(8899));
		serverSocket.configureBlocking(false);
		serverSocket.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("����������");
	}
	public void start() throws IOException {
		while(selector.select() > 0) {
			System.out.println("accept--start");
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> iterabtor = keys.iterator();
			while(iterabtor.hasNext()) {
				SelectionKey key = iterabtor.next();
				iterabtor.remove();
				if(key.isAcceptable()) {
					handleAccept(key);
				}else if(key.isReadable()) {
					handleRead(key);
				}else if(key.isWritable()) {
					handleWrite(key);
				}
			}
		}
	}
    private  void handleAccept(SelectionKey key) throws IOException {
    	System.out.println("handleAccept--start");
        // ��ȡ�ͻ�������ͨ��
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = server.accept();
        socketChannel.configureBlocking(false);
 
        // ��Ϣͨ��ͨ�����͸��ͻ���
        socketChannel.write(ByteBuffer.wrap(new String("Hello Client!").getBytes()));
 
        // ��ͨ�����ö��¼����ͻ��˼��������¼��󣬽��ж�ȡ����
        socketChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("handleAccept--end");
    }
    private  void handleRead(SelectionKey key) throws IOException {
    	ByteBuffer buffer = (ByteBuffer) key.attachment();
    	
    	SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer readBuff = ByteBuffer.allocate(32);
        channel.read(readBuff);
        readBuff.flip();

        // ����ͻ��˷��͹�������Ϣ
        byte[] data = readBuff.array();
        String msg = new String(data).trim();
        System.out.println("server receive msg from client��" + msg);
        
   
        key.attach(buffer);
        channel.register(selector, SelectionKey.OP_WRITE);
    }    
    private  void handleWrite(SelectionKey key) throws IOException {
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        buffer.flip();// �Ѽ�����Ϊλ�ã���λ����Ϊ0
        String data = decode(buffer);
        if (data.indexOf("\r\n") == -1) {
            return;
        }
        String outputData = data.substring(0, data.indexOf("\n") + 1);
        System.out.print(outputData);
        ByteBuffer outputBuffer = encode("echo:" + outputData);
        while (outputBuffer.hasRemaining()) {
            socketChannel.write(outputBuffer);
        }
        ByteBuffer temp = encode(outputData);
        buffer.position(temp.limit());
        buffer.compact();// ɾ���Ѿ�������ַ���

        socketChannel.register(selector, SelectionKey.OP_READ);
    }   
    private Charset charset = Charset.forName("utf-8");
    public String decode(ByteBuffer buffer) {
        CharBuffer charBuffer = charset.decode(buffer);
        return charBuffer.toString();
    }

    public ByteBuffer encode(String str) {
        return charset.encode(str);
    }    
}
