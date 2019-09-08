package com.yitian.practice.pattern.single;
/**
 * 优点：java sdk在序列化反序列化时,增加了对枚举单例的处理.
 * 缺点: 此写法不太常用
 */
public enum EnumSingleton {
	helloIns("enum singleton"){
		@Override
		public void say() {
			String msg = String.format("这是枚举式单例示例 :%s", this.singletonname);
			System.out.println(msg);
		}
	};
	protected String singletonname = null;
	private EnumSingleton(String name) {
		this.singletonname = name;
	}
	public abstract void say();
	
	public static void main(String[] args) {
		EnumSingleton.helloIns.say();
	}
}