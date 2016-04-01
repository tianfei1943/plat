package appacheCommon.io;

import static org.junit.Assert.*;

import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String filename = "/Users/fei/Downloads/IMG_0240-1.JPG";
		System.out.println(FilenameUtils.getBaseName(filename));
		Random random = new Random();
		System.out.println(FilenameUtils.getExtension(filename));
	}

}
