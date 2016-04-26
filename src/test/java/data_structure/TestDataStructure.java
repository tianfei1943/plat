package data_structure;

import java.util.LinkedList;

import org.junit.Test;

import data_structure.deque.PersonDeque;
import data_structure.stack.PersonStack;

public class TestDataStructure {

	Person s1 = new Person("tian1",32);
	Person s2 = new Person("tian2",32);
	Person s3 = new Person("tian3",32);
	Person s4 = new Person("tian4",32);
	
	@Test
	public void testStack() {
		PersonStack stack = new PersonStack();
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		stack.push(s4);
		
		while(!stack.isEmpty()){
			System.out.println(stack.peek().getName());
			Person s = stack.pop();
			System.out.println(s.getName());
		}
		
	}
	
	@Test
	public void testDeque() {
		PersonDeque stack = new PersonDeque();
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		stack.push(s4);
		
		while(!stack.isEmpty()){
			System.out.println(stack.peek().getName());
			Person s = stack.pop();
			System.out.println(s.getName());
		}
		
	}
	
	@Test
	public static void testLink(){
		LinkedList<Person> list = new LinkedList<Person>();
	}

}
