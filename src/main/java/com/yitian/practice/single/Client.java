package com.yitian.practice.single;

public class Client {
	public static void main(String[] args) {
		System.out.println(DirectSingleton.getIns());
		System.out.println(HoldSingleton.getIns());
		System.out.println(LazySingle.getIns());
		System.out.println(HoldSingleton.getIns());
		System.out.println(HoldSingleton.getIns());
		EnumSingleton.helloIns.say();
		EnumSingleton.wordIns.say();
	}
	
	private Client ins = new Client(){
		
	};
}
