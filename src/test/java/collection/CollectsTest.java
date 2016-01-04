package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class CollectsTest {
	
	//抽奖 shuffle--用法，用于打乱固有的排序，一般用于抽奖或者加密传输等地方
	@Test
	public void test() {
		String[] str1 = {"tianfei","jiangzeming","huxiaoqin","suszu"};
		List<String> list = Arrays.asList(str1);
		List<String> list2 = new ArrayList<String>(list);
		list2.add("kkk");
		System.out.println(list2);
		//抽奖开始
		for(int i=0;i<3;i++){
			Collections.shuffle(list2);
			System.out.println("第"+(i+1)+"名"+list2.remove(0));
		}
		System.out.println("剩余人数："+list2);
	}

	
}
