package map;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;


public class MapTest {

	@Test
	public void test() {
		Comparator<String> customerComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		};
		Map<String,String> treeMap = new TreeMap<String,String>(customerComparator);
		treeMap.put("a", "tianA");
		treeMap.put("c", "tianC");
		treeMap.put("b", "tianB");
		Iterator<Entry<String, String>> iterator = treeMap.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String> next = iterator.next();
			System.out.println(next.getKey()+"--"+next.getValue());
		}
	}
	
	@Test
	public void testLinkedHashMap(){
		
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("a", "tian1");
		linkedHashMap.put("b", "tian2");
		linkedHashMap.put("d", "tian3");
		linkedHashMap.put("c", "tian4");
		Iterator<Entry<String, String>> iterator = linkedHashMap.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String> next = iterator.next();
			System.out.println(next.getKey()+"--"+next.getValue());
		}
	}
	
	@Test
	public void testHashMap(){
		Map<String, String> linkedHashMap = new HashMap<String, String>();
		linkedHashMap.put("a", "tian1");
		linkedHashMap.put("b", "tian2");
		linkedHashMap.put("d", "tian3");
		linkedHashMap.put("E", "tian3");
		linkedHashMap.put("c", "tian4");
		Iterator<Entry<String, String>> iterator = linkedHashMap.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String> next = iterator.next();
			System.out.println(next.getKey()+"--"+next.getValue());
		}
	}
	
	@Test
	public void testAsii(){
		String s2 = "\u5317\u4eac\u5e02";
		System.out.println(s2);
//		try {
//			String s = new String(s2.getBytes("GBK"),"UTF-8");
//			System.out.println(s);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
	}

}
