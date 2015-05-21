package gson.domain;

public class Student {

	private String name;
	
	private int age;
	
	private School school;
	
	public Student(String name, int age,School school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
	}
	
	

	public String getName() {
		return name;
	}



	public int getAge() {
		return age;
	}



	public School getSchool() {
		return school;
	}



	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school
				+ "]";
	}

	
}
