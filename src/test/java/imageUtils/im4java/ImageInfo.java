package imageUtils.im4java;

import java.io.File;
import java.util.Date;

import com.drew.lang.GeoLocation;



public class ImageInfo {

	private Integer width;// 图片宽度

	private Integer height;// 图片高度

	private long size;// 图片大小
	/**
	 * 1:不旋转
	 * 3
	 * 6
	 * 8
	 * 0：已经调整过了
	 */
	private Integer orientation;//图片方向
	
	private Date dateTimeOriginal;//创建时间
	
	private GeoLocation geoLocation;//gps
	
	private File file;

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public long getSize() {
		return size;
	}

	public Integer getOrientation() {
		return orientation;
	}

	public Date getDateTimeOriginal() {
		return dateTimeOriginal;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public File getFile() {
		return file;
	}
	
	

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public void setOrientation(Integer orientation) {
		this.orientation = orientation;
	}

	public void setDateTimeOriginal(Date dateTimeOriginal) {
		this.dateTimeOriginal = dateTimeOriginal;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "ImageInfo [width=" + width + ", height=" + height + ", size="
				+ size + ", orientation=" + orientation + ", dateTimeOriginal="
				+ dateTimeOriginal + ", geoLocation=" + geoLocation + ", file="
				+ file.getName() + "]";
	}

	

}
