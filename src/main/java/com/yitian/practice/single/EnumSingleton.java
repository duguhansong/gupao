package com.yitian.practice.single;

public enum EnumSingleton {
	helloIns("helloʵ��"){
		@Override
		public void say() {
			System.out.println("my name is helloʵ��");
		}
	},
	wordIns("wordʵ��");
	private String singletonname = null;
	private EnumSingleton(String name) {
		this.singletonname = name;
	}
	public  void say() {
		System.out.println(singletonname);
	}
}
