package com.yitian.practice.pattern.observer.jdk;

public class Question {

	private GuavaTeacher stu;//提问学生
	private String content;//提问内容
	
	public Question() {
		
	}
	public Question(GuavaTeacher stu,String content) {
		this.stu = stu;
		this.content = content;
	}
	
	public GuavaTeacher getStu() {
		return stu;
	}
	public void setStu(GuavaTeacher stu) {
		this.stu = stu;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n提问学生:").append(this.stu.getName())
		  .append("\n提问内容:").append(this.getContent());
		return sb.toString();
	}
}
