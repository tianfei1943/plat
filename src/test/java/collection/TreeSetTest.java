package collection;

import java.util.TreeSet;

import org.junit.Test;

public class TreeSetTest {

	@Test
	public void test() {
		TreeSet<Student> treeSet = new TreeSet<Student>();
		treeSet.add(new Student("tianfei001",20));
		treeSet.add(new Student("tianfei004",21));
		treeSet.add(new Student("tianfei003",21));
		System.out.println(treeSet);
	}

}

class Student implements Comparable<Student>{
	
	private String name;
	
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

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

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Student o) {
		Student s = (Student)o;
		if(this.age > s.age){
			return 1;
		}
		if(this.age == s.age){
			return this.name.compareTo(o.name);
		}
		return -1;
	}
	
	

}
