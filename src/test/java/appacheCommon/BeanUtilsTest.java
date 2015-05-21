package appacheCommon;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class BeanUtilsTest {

	@Test
	public void test() throws IllegalAccessException, InvocationTargetException {
		Student o1 = new Student(1,"tianfei","sssss");
		Teacher o2 = new Teacher();
		BeanUtils.copyProperties(o2, o1);
		System.out.println(o2);
		System.out.println(o1);
	}

}

