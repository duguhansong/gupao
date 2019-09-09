package com.yitian.practice.pattern.observer.guava;

import com.google.common.eventbus.EventBus;

public class Client {

	public static void main(String[] args) {
		GuavaTeacher tom = new GuavaTeacher("Tom");
		GuavaTeacher mic = new GuavaTeacher("Mic");
		
		EventBus bus = new EventBus();
		bus.register(tom);
		bus.register(mic);
		
		GuavaStudent stu = new GuavaStudent("С��");
		GuavaQuestion q = new GuavaQuestion();
		q.setContent("Mic��ʦΪʲô��ô�ɰ�");
		q.setStu(stu);
		
		bus.post(q);
	}

}
