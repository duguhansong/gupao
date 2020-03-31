package com.yitian.practice.netty.lesson3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileIo {

	public static void main(String[] args) {
		method2();
	}

	public static void method1() {
		FileInputStream fin  = null;
		try {
			fin = new FileInputStream("F:\\tmp\\a.txt");
			byte bytes[] = fin.readAllBytes();
			System.out.println(new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fin != null)
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static void method2() {
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("F:\\tmp\\a.txt");
			FileChannel fc = fin.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(8);
			while (fc.read(buf) > 0) {
				buf.flip();
				System.out.print(new String(buf.array(),0,buf.limit(),Charset.forName("gbk")));
				buf.clear();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fin != null)
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
