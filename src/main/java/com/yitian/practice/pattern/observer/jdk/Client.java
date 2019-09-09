package com.yitian.practice.pattern.observer.jdk;

public class Client {

	public static void main(String[] args) {
		Teacher tom = new Teacher("Tom");
		Teacher mic = new Teacher("Mic");
		
		GuavaTeacher stu = new GuavaTeacher("С��");
		stu.addObserver(tom);
		stu.addObserver(mic);
		
		stu.questioin("Tom ��ʦΪʲô��ô˧...");
	}

}
