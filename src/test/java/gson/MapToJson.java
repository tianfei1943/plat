package gson;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class MapToJson {

	@Test
	public void test() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("customer_name", "tianfei");
		map.put("default_sales_person", 1);
		map.put("default_order_type", 1);
		map.put("default_price_list", 1);
		map.put("default_payment", 1);
		map.put("default_currency", "RMB");
		map.put("default_ship_from", 1);
		map.put("ship_to", 1);
		map.put("bill_to", 1);
		
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
	}

}
