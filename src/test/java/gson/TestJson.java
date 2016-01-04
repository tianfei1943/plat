package gson;

import org.junit.Test;

import com.google.gson.Gson;

public class TestJson {

	
	
	@Test
	public void test2(){
		Gson gson = new Gson();
		Obj o = new Obj();
		o.setAge(11);
		o.setName("fei");
		System.out.println(gson.toJson(o));
	}
	

}
