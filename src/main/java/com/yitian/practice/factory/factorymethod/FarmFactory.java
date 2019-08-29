package com.yitian.practice.factory.factorymethod;

import com.yitian.practice.factory.Apple;
import com.yitian.practice.factory.Grape;
import com.yitian.practice.factory.Peach;
import com.yitian.practice.factory.Product;
import com.yitian.practice.factory.Type;

/**
 * ��̬��������
 * @author xianjianyi
 *
 */
public class FarmFactory {
	private FarmFactory() {
		throw new UnsupportedOperationException("��֧�ִ���");
	}
	//��̬��������
	public static Product getProduct(Type type) {
		switch (type) {
		case apple:
			return new Apple();
		case grape:
			return new Grape();
		case peach:
			return new Peach();
		default:
			throw new UnsupportedOperationException("û������ˮ�� ");
		}
	}
}