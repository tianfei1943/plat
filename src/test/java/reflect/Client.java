package reflect;

import java.lang.reflect.Field;

public class Client {

	
	public static void getObjClass(){
		try {
			Class<Student> c1 = Student.class;
			//Class c1 = Class.forName("reflectDemo.Student");
			Student student = c1.newInstance();
			System.out.println(student);
			
			Field[] fieldArr  = c1.getDeclaredFields();
			for(Field f : fieldArr){
				System.out.println(f);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		getObjClass();

	}
	
	

}
