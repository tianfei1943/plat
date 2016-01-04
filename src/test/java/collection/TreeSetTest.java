package collection;

import java.util.TreeSet;

import org.junit.Test;

public class TreeSetTest {

	@Test
	public void test() {
		TreeSet<Student> treeSet = new TreeSet<Student>();
		new TreeSet<Student>();
		treeSet.add(new Student(1,"tianfei001",20));
		treeSet.add(new Student(2,"tianfei002",20));
		treeSet.add(new Student(3,"tianfei003",21));
		for(Student s : treeSet){
			System.out.println(s);
		}
		//System.out.println(treeSet);
	}

}

