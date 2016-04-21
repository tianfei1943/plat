package data_structure.stack;

import java.util.Stack;

import data_structure.Person;

/**
 * 栈的实现--目前官方已经不推荐，推荐deque
 * @author fei
 *
 */
public class PersonStack {
	Stack<Person> stack = new Stack<Person>();
	
	public void push(Person person){
		stack.push(person);
	}
	
	public Person pop(){
		return stack.pop();
	}
	/**
	 * 获取栈顶元素，单不弹出
	 * @return
	 */
	public Person peek(){
		return stack.peek();
	}
	
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
}
