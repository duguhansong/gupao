package com.yitian.practice.pattern.single;

public final class HoldSingleton {

	private HoldSingleton() {
		if(Hold.ins != null) {
			throw new UnsupportedOperationException("��֧�ֶ�ʵ��");
		}
	}
	public static HoldSingleton getIns() {
		return Hold.ins;
	}
	private static class Hold{
		private final static  HoldSingleton ins =new HoldSingleton();
	}
}
