package com.yitian.practice.pattern.observer.guava;

import com.google.common.eventbus.EventBus;

public class Client {

	public static void main(String[] args) {
		GuavaTeacher tom = new GuavaTeacher("Tom");
		GuavaTeacher mic = new GuavaTeacher("Mic");
		
		EventBus bus = new EventBus();
		bus.register(tom);
		bus.register(mic);
		
		GuavaStudent stu = new GuavaStudent("小明");
		GuavaQuestion q = new GuavaQuestion();
		q.setContent("Mic老师为什么这么可爱");
		q.setStu(stu);
		
		bus.post(q);
	}

}
