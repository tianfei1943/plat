package imageDraw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 该类将生成的图片存储到一个文件中， 需要设置fileName成员变量值， 该成员变量值表示图片的存储全路径。
 * 
 * @author fei
 *
 */
public class FileImageCreator extends AbstractImageCreator {

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileImageCreator(Drawer drawer) {
		super(drawer);
	}

	public FileImageCreator(Drawer drawer, String fileName) {
		super(drawer);
		this.fileName = fileName;
	}

	@Override
	protected void saveImage(BufferedImage image) throws IOException {
		ImageIO.write(image, getFormatName(), new File(fileName));
	}

}
