package com.yitian.practice.pattern.observer.jdk;

public class Question {

	private GuavaTeacher stu;//����ѧ��
	private String content;//��������
	
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
		sb.append("\n����ѧ��:").append(this.stu.getName())
		  .append("\n��������:").append(this.getContent());
		return sb.toString();
	}
}
