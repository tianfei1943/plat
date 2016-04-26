package imageDraw;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

/**
 * 该类将生成的图片存储到一个输出流中，需要设置stream成员变量值。
 * 
 * @author fei
 *
 */
public class StreamImageCreator extends AbstractImageCreator {

	private OutputStream stream;

	public OutputStream getStream() {
		return stream;
	}

	public void setStream(OutputStream stream) {
		this.stream = stream;
	}

	public StreamImageCreator(Drawer drawer) {
		super(drawer);
	}

	public StreamImageCreator(Drawer drawer, OutputStream stream) {
		super(drawer);
		this.stream = stream;
	}

	@Override
	protected void saveImage(BufferedImage image) throws IOException {
		ImageIO.write(image, getFontName(), stream);
	}

}
