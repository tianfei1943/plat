package gson;

import gson.domain.School;
import gson.domain.Student;
import gson.domain.Temp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

public class ObjectToJsonTest {

	@Test
	public void testObj2Json() {
		School school = new School("苏州大学");
		Student student = new Student("tian",30,school);
		Gson gson = new Gson();
		String str = gson.toJson(student);
		System.out.println(str);
	}
	
	@Test
	public void testJson2Obj() {
		String strJson = "{\"name\":\"tian\",\"age\":44}";
		Gson gson = new Gson();
		Student student = gson.fromJson(strJson, Student.class);
		System.out.println(student);
	}
	
	@Test
	public void testObj2JsonList() {
		School school = new School("苏州大学");
		Student student0 = new Student("tian0",30,school);
		Student student1 = new Student("tian1",30,school);
		Student student2 = new Student("tian2",30,school);
		Student student3 = new Student("tian3",30,school);
		Student student4 = new Student("tian4",30,school);
		Student student5 = new Student("tian5",30,school);
		
		List<Student> insertedList = new ArrayList<Student>();
		List<Student> updatedList = new ArrayList<Student>();
		List<Student> deletedList = new ArrayList<Student>();
		insertedList.add(student0);
		insertedList.add(student1);
		updatedList.add(student2);
		updatedList.add(student3);
		deletedList.add(student4);
		deletedList.add(student5);
		
		Temp temp = new Temp(insertedList,updatedList,deletedList);
		
		Gson gson = new Gson();
		String str = gson.toJson(temp);
		System.out.println(str);
	}
	
	@Test
	public void testJson2ObjList() {
		String strJson = "{'insertedList':[{'name':'tian0','age':30,'school':{'name':'苏州大学'}},{'name':'tian1','age':30,'school':{'name':'苏州大学'}}],'updatedList':[{'name':'tian2','age':30,'school':{'name':'苏州大学'}},{'name':'tian3','age':30,'school':{'name':'苏州大学'}}],'deletedList':[{'name':'tian4','age':30,'school':{'name':'苏州大学'}},{'name':'tian5','age':30,'school':{'name':'苏州大学'}}]}";
		Gson gson = new Gson();
		Temp temp = gson.fromJson(strJson, Temp.class);
		System.out.println(temp.getUpdatedList().get(0).getSchool().getName());
	}
	
	@Test
	public void testJson2ObjList2() {
		String strJson = "{'insertedList':[],'updatedList':[{'name':'tian2','age':30,'school':{'name':'苏州大学'}},{'name':'tian3','age':30,'school':{'name':'苏州大学'}}],'deletedList':[{'name':'tian4','age':30,'school':{'name':'苏州大学'}},{'name':'tian5','age':30,'school':{'name':'苏州大学'}}]}";
		Gson gson = new Gson();
		Temp temp = gson.fromJson(strJson, Temp.class);
		System.out.println(temp.getUpdatedList().get(0).getSchool().getName());
	}
	
	

}
