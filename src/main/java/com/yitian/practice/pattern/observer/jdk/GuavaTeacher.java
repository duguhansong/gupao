package com.yitian.practice.pattern.observer.jdk;

import java.util.Observable;

public class GuavaTeacher extends Observable{

	private String name;
	public GuavaTeacher(String name) {
		this.name = name;
	}
	
	public void questioin(String content) {
		Question q = new Question(this,content);
		super.setChanged();
		super.notifyObservers(q);
	}

	public String getName() {
		return name;
	}	
}
