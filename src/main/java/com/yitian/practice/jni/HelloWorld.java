package com.yitian.practice.jni;

public class HelloWorld  extends IHelloWorld {
	
	public native void say(String name);//只需要有签名
	static {
		System.loadLibrary("HelloWorld");
	}

	public static void main(String[] args) {
		
		HelloWorld say = new HelloWorld();
		say.say("Tom");
	}
}
