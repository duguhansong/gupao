package com.yitian.practice.pattern.proxy.jdk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

import com.yitian.practice.pattern.proxy.IOrderService;
import com.yitian.practice.pattern.proxy.OrderServiceImpl;

@SuppressWarnings("restriction")
public class Client {

	public static void main(String[] args) {
		try {
			Client test = new Client();
			test.testJDKProxy();
			test.export();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testJDKProxy() throws FileNotFoundException, IOException {
		JDKProxy proxy = new JDKProxy(new OrderServiceImpl());
		IOrderService service = (IOrderService)Proxy.newProxyInstance(this.getClass().getClassLoader(), 
										  OrderServiceImpl.class.getInterfaces(),
										  proxy);
		service.saveOrder();
	}

	public void export() {
		String path ="e://tmp";
		String className= "$Proxy0";
//		byte[] classFile = ProxyGenerator.generateProxyClass(className, OrderServiceImpl.class.getInterfaces());
		byte[] classFile = null;
		FileOutputStream out = null;
		try {
			String filePath = path + "/" + className + ".class";
			out = new FileOutputStream(filePath);
			out.write(classFile);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
