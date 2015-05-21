package cloneable.collectionClone;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestClone {

	@Test
	public void test() throws CloneNotSupportedException {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1,"tian"));
		
		List<Student> list2 = (ArrayList<Student>)list.clone();
		System.out.println(list2);
		System.out.println(list);
		Student s1 = new Student(1,"fei");
		Student s2 =(Student)s1.clone();
		System.out.println(s1);
		System.out.println(s2);
		
	}

}
