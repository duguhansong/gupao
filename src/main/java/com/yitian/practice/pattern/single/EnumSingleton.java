package com.yitian.practice.pattern.single;
/**
 * �ŵ㣺java sdk�����л������л�ʱ,�����˶�ö�ٵ����Ĵ���.
 * ȱ��: ��д����̫����
 */
public enum EnumSingleton {
	helloIns("enum singleton"){
		@Override
		public void say() {
			String msg = String.format("����ö��ʽ����ʾ�� :%s", this.singletonname);
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