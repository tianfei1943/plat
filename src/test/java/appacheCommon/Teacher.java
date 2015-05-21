package appacheCommon;

public class Teacher {
	private int age;
	private String name;
	private String tNum;
	public Teacher(){}
	public Teacher(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String gettNum() {
		return tNum;
	}
	public void settNum(String tNum) {
		this.tNum = tNum;
	}
	@Override
	public String toString() {
		return "Teacher [age=" + age + ", name=" + name + ", tNum=" + tNum
				+ "]";
	}
	
	
}
