package appacheCommon;

public class Student {
	private int age;
	private String name;
	private String sNum;
	public Student(){}
	public Student(int age, String name,String sUm) {
		super();
		this.age = age;
		this.name = name;
		this.sNum = sUm;
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
	public String getsNum() {
		return sNum;
	}
	public void setsNum(String sNum) {
		this.sNum = sNum;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", sNum=" + sNum
				+ "]";
	}
	
}
