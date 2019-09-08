package com.yitian.practice.pattern.single;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

public class Client {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ClassNotFoundException {
		System.out.println(DirectSingleton.getIns());
		System.out.println(HoldSingleton.getIns());
		System.out.println(LazySingle.getIns());
		System.out.println(HoldSingleton.getIns());
		System.out.println(HoldSingleton.getIns());
		EnumSingleton.helloIns.say();
		
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(byteArray);
		os.writeObject(DirectSingleton.getIns());
		
		ByteArrayInputStream  bins = new ByteArrayInputStream (byteArray.toByteArray());
		ObjectInputStream oin = new ObjectInputStream(bins);
		DirectSingleton tmp = (DirectSingleton)oin.readObject();
		System.out.println(DirectSingleton.getIns() == tmp);
	}
}
