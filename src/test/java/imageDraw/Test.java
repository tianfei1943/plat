package imageDraw;

import java.awt.Color;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(" 中华人民共和国\n");
			sb.append("中华人民共和国中华人民共和国\n");
			sb.append("中华人民共和国\n");

			FileImageCreator creator = new FileImageCreator(new SimpleDrawer(),
					"/Users/fei/Downloads/test.jpeg");
			//如果不设置高度或者宽度，则自动根据算出宽度和高度
//			creator.setWidth(150);  // 图片宽度
//			creator.setHeight(100); // 图片高度
			creator.setBgColor(Color.white);
			creator.setFontColor(Color.black);
			//creator.setLineNum(20); // 干扰线条数
//			creator.setFontSize(20); // 字体大小
//			creator.setFontName("宋体");

			// 文字旋转
//			creator.setRadian(30.0); // 旋转弧度
//			creator.setRotateX(creator.getWidth() / 5);
//			creator.setRotateY(creator.getHeight() * 5 / 10);

			creator.generateImage(sb.toString());

			System.out.println("ok");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
