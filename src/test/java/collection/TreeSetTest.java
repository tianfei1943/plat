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

