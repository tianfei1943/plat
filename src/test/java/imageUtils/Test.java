package imageUtils;

import imageUtils.ImageMagick.ImageFile;
import imageUtils.ImageMagick.JMagickUtil;

public class Test {
	
	public static void main(String[] args) {
		try {
			// System.setProperty("jmagick.systemclassloader", "no");//
			System.out.println(Test.class.getResource("Test.class").getPath());
			System.out.println(System.getProperty("java.library.path"));
//			ImageFile imgFile = JMagickUtil.getImageInfo("/Users/fei/Desktop/IMG/tian_1.png");
//			JMagickUtil
//			System.out.println(imgFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
