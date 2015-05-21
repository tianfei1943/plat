package gson;

import org.junit.Test;

import com.google.gson.Gson;

public class ArrayToJsonTest {

	@Test
	public void testArr2Json() {
		int[] intArr = {1,2,3,4,5};
		String[] strArr = {"one","two","three"};
		Gson gson = new Gson();
		String intJson = gson.toJson(intArr);
		String strJson = gson.toJson(strArr);
		System.out.println(intJson);
		System.out.println(strJson);
	}
	
	@Test
	public void testJson2Arr() {
		String intJson = "[1,2,3,4,5]";
		String strJson = "[\"one\",\"two\",\"three\"]";
		Gson gson = new Gson();
		int[] intArr = gson.fromJson(intJson, int[].class);
		String[] strArr = gson.fromJson(strJson, String[].class);
		System.out.println(intArr[0]);
		System.out.println(strArr[0]);
	}

}
