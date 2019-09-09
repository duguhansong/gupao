package com.yitian.practice.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer{
	private String name;
	
	public Teacher(String name) {
		this.name = name;
	}
	public void update(Observable observable, Object question) {
		System.out.println(question.toString());
		System.out.println("\nΩ‚¥¿œ ¶:" + this.name);
	}

}
