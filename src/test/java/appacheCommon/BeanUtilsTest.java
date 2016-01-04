package appacheCommon;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

public class BeanUtilsTest {

	@Test
	public void test() throws IllegalAccessException, InvocationTargetException {
		Student o1 = new Student(1,"tianfei","sssss");
		Teacher o2 = new Teacher();
		BeanUtils.copyProperties(o2, o1);
		System.out.println(o2);
		System.out.println(o1);
		
		System.out.println(DateFormatUtils.format(DateUtils.truncate(new Date(), Calendar.MONTH),"yyyyMMdd HH:mm:ss"));
		
	}

}

