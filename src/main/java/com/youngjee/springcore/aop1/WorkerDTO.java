package com.youngjee.springcore.aop1;

public class WorkerDTO {
	private String name;
	private int age;
	private String job;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public void getWorkerInfo() {
		System.out.println("getStudentInfo::getName["+getName()+"] getAge["+getAge()+"] getJob["+getJob()+"] ");
		
	}
}