package com.yitian.practice.pattern.observer.guava;

public class GuavaQuestion {

	private GuavaStudent stu;//提问学生
	private String content;//提问内容
	
	public GuavaQuestion() {
		
	}
	public GuavaQuestion(GuavaStudent stu,String content) {
		this.stu = stu;
		this.content = content;
	}
	
	public GuavaStudent getStu() {
		return stu;
	}
	public void setStu(GuavaStudent stu) {
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
		sb.append("提问学生:").append(this.stu.getName())
		  .append("\n提问内容:").append(this.getContent())
		  .append("\n");
		return sb.toString();
	}
}
