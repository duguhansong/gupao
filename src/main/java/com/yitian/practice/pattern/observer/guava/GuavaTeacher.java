package com.yitian.practice.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

public class GuavaTeacher {
	private String name;
	
	public GuavaTeacher(String name) {
		this.name = name;
	}
	@Subscribe
	public void answer(GuavaQuestion question) {
		System.out.println(name + "老师解答问题:");
		System.out.println(question.toString());
	}
}
