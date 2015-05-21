package thread.p1;

import java.util.HashMap;
import java.util.Map;

public class AbsFactory {

	private static Map<String,SignInfo> map = new HashMap<String,SignInfo>();
	
	public static SignInfo getSignInfo(String key){
		SignInfo signInfo = null;
		if(map.containsKey(key)){
			signInfo = map.get(key);
		}else{
			signInfo = new SignInfo(key);
			map.put(key, signInfo);
		}
		return signInfo;
	}
	
}
