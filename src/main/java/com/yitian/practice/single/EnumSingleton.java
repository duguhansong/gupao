package com.yitian.practice.single;

public enum EnumSingleton {
	helloIns("helloÊµÀý"){
		@Override
		public void say() {
			System.out.println("my name is helloÊµÀý");
		}
	},
	wordIns("wordÊµÀý");
	private String singletonname = null;
	private EnumSingleton(String name) {
		this.singletonname = name;
	}
	public  void say() {
		System.out.println(singletonname);
	}
}
