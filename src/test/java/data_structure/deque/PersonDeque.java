package data_structure.deque;

import java.util.ArrayDeque;
import java.util.Deque;

import data_structure.Person;

/**
 * 栈的实现方式2：优先使用
 * @author fei
 *
 */
public class PersonDeque {
	
	private Deque<Person> deque = new ArrayDeque<Person>();
	
	public void push(Person person){
		deque.addFirst(person);
	}
	
	public Person pop(){
		return deque.removeFirst();
	}
	
	public Person peek(){
		return deque.peekFirst();
	}
	
	public boolean isEmpty(){
		return deque.isEmpty();
	}
	
}
