package com.yitian.practice.pattern.observer.jdk;

public class Client {

	public static void main(String[] args) {
		Teacher tom = new Teacher("Tom");
		Teacher mic = new Teacher("Mic");
		
		GuavaTeacher stu = new GuavaTeacher("小明");
		stu.addObserver(tom);
		stu.addObserver(mic);
		
		stu.questioin("Tom 老师为什么这么帅...");
	}

}
