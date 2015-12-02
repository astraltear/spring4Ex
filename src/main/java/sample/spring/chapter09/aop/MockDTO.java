package sample.spring.chapter09.aop;

public class MockDTO {
	private String name;
	private int age;
	private boolean isMan;
	
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
	public boolean isMan() {
		return isMan;
	}
	public void setMan(boolean isMan) {
		this.isMan = isMan;
	}
	@Override
	public String toString() {
		return "MockDTO toString [name=" + name + ", age=" + age + ", isMan=" + isMan + "]";
	}
	
}
