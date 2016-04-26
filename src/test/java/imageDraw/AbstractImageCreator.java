package imageDraw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractImageCreator {
	private static Random rnd = new Random(new Date().getTime());
	private Drawer drawer;

	// 图片宽度
	private int width;

	// 图片高度
	private int height;

	// 外框颜色
	private Color rectColor;

	// 背景色
	private Color bgColor;

	// 干扰线数目
	private int lineNum = 0;

	// 图片格式
	private String formatName = "JPEG";

	// 字体颜色
	private Color fontColor = new Color(0, 0, 0);

	// 字体名称
	private String fontName = "宋体";

	// 字体大小
	private int fontSize = 15;

	// 文字旋转的弧度数
	private double radian = 0;
	private double rotateX = 0;
	private double rotateY = 0;

	// 缩放
	private double scale = 1;

	public AbstractImageCreator(Drawer drawer) {
		this.drawer = drawer;
	}

	/**
	 * 画干扰线
	 */
	private void drawRandomLine(Graphics graph) {
		for (int i = 0; i < lineNum; i++) {
			// 线条的颜色
			graph.setColor(getRandomColor(100, 155));

			// 线条两端坐标值
			int x1 = rnd.nextInt(width);
			int y1 = rnd.nextInt(height);

			int x2 = rnd.nextInt(width);
			int y2 = rnd.nextInt(height);

			// 画线条
			graph.drawLine(x1, y1, x2, y2);
		}
	}

	/**
	 * 随机获取颜色对象
	 */
	private Color getRandomColor(int base, int range) {
		if ((base + range) > 255)
			range = 255 - base;

		int red = base + rnd.nextInt(range);
		int green = base + rnd.nextInt(range);
		int blue = base + rnd.nextInt(range);

		return new Color(red, green, blue);
	}
	/**
	 * 如果不设置高度和宽度，则自动算出
	 * @param text
	 */
	private void generateWithAndHeight(String text){
		String[] strArr = StringUtils.split(text,"\n");
		String str = "";
		for(int i=0;i<strArr.length;i++){
			if(str.length()<strArr[i].length()){
				str = strArr[i];
			}
		}
		Font font = new Font(str, Font.PLAIN,fontSize);
		Rectangle2D r2 = font.getStringBounds(str, new FontRenderContext(
				AffineTransform.getScaleInstance(1, 1), false, false));
		int unitHeight = (int) Math.floor(r2.getHeight())+5;// 把单个字符的高度+3，保证容纳
		this.width = (int) Math.round(r2.getWidth()) + 20;//宽度+20
		this.height = unitHeight*strArr.length;//单元高度*数组的长度
	}

	public void generateImage(String text) throws IOException {
		if(width == 0 || height == 0){
			generateWithAndHeight(text);
		}
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);

		if (rectColor == null)
			rectColor = new Color(0, 0, 0);
		if (bgColor == null)
			bgColor = new Color(240, 251, 200);

		// 获取画布
		Graphics2D g = (Graphics2D) image.getGraphics();

		// 画长方形
		g.setColor(bgColor);
		g.fillRect(0, 0, width, height);

		// 外框
		g.setColor(rectColor);
		g.drawRect(0, 0, width - 1, height - 1);

		// 画干扰线
		drawRandomLine(g);

		// 画字符串
		drawer.draw(this, g, text);

		// 执行
		g.dispose();

		// 输出图片结果
		saveImage(image);
	}

	protected abstract void saveImage(BufferedImage image) throws IOException;

	public static Random getRnd() {
		return rnd;
	}

	public static void setRnd(Random rnd) {
		AbstractImageCreator.rnd = rnd;
	}

	public Drawer getDrawer() {
		return drawer;
	}

	public void setDrawer(Drawer drawer) {
		this.drawer = drawer;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getRectColor() {
		return rectColor;
	}

	public void setRectColor(Color rectColor) {
		this.rectColor = rectColor;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public String getFormatName() {
		return formatName;
	}

	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public double getRadian() {
		return radian;
	}

	public void setRadian(double radian) {
		this.radian = radian;
	}

	public double getRotateX() {
		return rotateX;
	}

	public void setRotateX(double rotateX) {
		this.rotateX = rotateX;
	}

	public double getRotateY() {
		return rotateY;
	}

	public void setRotateY(double rotateY) {
		this.rotateY = rotateY;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

}
