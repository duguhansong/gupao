package com.yitian.practice.proxy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		try {
			new Client().testJDKProxy();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void testStatic() {
		StaticOrderProxy orderService = new StaticOrderProxy();
		orderService.saveOrder();
	}
	public void testJDKProxy() throws FileNotFoundException, IOException {
		IOrderService ins = new OrderServiceImpl();
		InvocationHandler invocat = new JDKProxy(ins);
		Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), 
								OrderServiceImpl.class.getInterfaces(),
								invocat);
		OutputStream fout = null;
		ObjectOutputStream oos = null;
		try {
			fout = new FileOutputStream("E:/temp/IOrderService.class");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(o);
			oos.flush();
		}finally {
			if(fout != null) fout.close();
			if(oos != null) oos.close();
		}
	}
}
