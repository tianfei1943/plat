package gson;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestJson {

	
	
	@Test
	public void test2(){
		Gson gson = new Gson();
		Obj o = new Obj();
		o.setAge(11);
		o.setName("fei");
		System.out.println(gson.toJson(o));
		
		
		JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse("");
        if(jsonObject.has("err")){
        		//后台报错
        }else{
        		if(jsonObject.isJsonNull()){
        			//正常
        		}else{
        			//空窜
        		}
        }
		
		
	}
	

}
