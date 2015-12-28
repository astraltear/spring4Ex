package sample.spring.chapter08.simpledb;

import java.util.Date;

public class SimpleDTO {
	private String name;
	private String sex;
	private int age;
	private Date regDate;
	
	public SimpleDTO() {
	}
	
	public SimpleDTO(String name, String sex, int age, Date regDate) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.regDate = regDate;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "SimpleDTO [name=" + name + ", sex=" + sex + ", age=" + age + ", regDate=" + regDate + "]";
	}
	
	
}
