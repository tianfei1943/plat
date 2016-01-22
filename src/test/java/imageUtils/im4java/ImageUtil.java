package imageUtils.im4java;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.im4java.core.CompositeCmd;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;
import com.drew.metadata.jpeg.JpegDirectory;


public class ImageUtil {

	/**
	 * ImageMagick的路径
	 */
	//private final  String IMAGEMAGICKPATH = "C:\\Program Files\\ImageMagick-6.9.3-Q16";
	private final  String IMAGEMAGICKPATH = "/opt/local/bin";
	
	private static ImageUtil imageTools = new ImageUtil();
	
	private ImageUtil(){
		
	}
	
	public static ImageUtil getInstance(){
		return imageTools;
	}

	/**
	 * 
	 * 根据坐标裁剪图片
	 * 
	 * @param srcPath   要裁剪图片的路径
	 * @param newPath   裁剪图片后的路径
	 * @param x         起始横坐标
	 * @param y         起始纵坐标
	 * @param x1        结束横坐标
	 * @param y1        结束纵坐标
	 */

	public static void cutImage(String srcPath, String newPath, int x, int y, int x1,	int y1) throws Exception {
		int width = x1 - x;
		int height = y1 - y;
		IMOperation op = new IMOperation();
		op.addImage(srcPath);
		op.crop(width, height, x, y);
		op.addImage(newPath);
		ConvertCmd convert = new ConvertCmd();
		convert.run(op);
	}
	
	 /**  
     * 根据尺寸缩放图片  
     * @param width  缩放后的图片宽度  
     * @param height  缩放后的图片高度  
     * @param srcPath   源图片路径  
     * @param newPath   缩放后图片的路径  
     */    
    public  void zoomImage(Integer width, Integer height, String srcPath, String newPath) throws Exception {    
        IMOperation op = new IMOperation();    
        op.addImage(srcPath);    
        if(width == null){//根据高度缩放图片  
            op.resize(null, height);      
        }else if(height == null){//根据宽度缩放图片  
            op.resize(width, null);  
        }else {  
            op.resize(width, height);  
        }  
        op.addImage(newPath);    
        ConvertCmd convert = new ConvertCmd();  
        convert.setSearchPath(IMAGEMAGICKPATH);
        convert.run(op);    
    } 

    
    /**  
     * 给图片加水印  
     * @param srcPath   源图片路径  
     */    
    public  void addImgText(String srcPath,String content) throws Exception {    
        IMOperation op = new IMOperation();    
        op.font("微软雅黑");  
        op.gravity("southeast");  
        op.pointsize(18).fill("#BCBFC8").draw("text 0,0 "+content);   //("x1 x2 x3 x4") x1 格式，x2 x轴距离 x3 y轴距离  x4名称      
        op.addImage();    
        op.addImage();    
        ConvertCmd convert = new ConvertCmd();    
        convert.setSearchPath(IMAGEMAGICKPATH);
        try {  
          convert.run(op,srcPath,srcPath);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }    
    /** 
     * 图片水印 
     * 
     * @param srcImagePath   源图片 
     * @param waterImagePath 水印 
     * @param destImagePath  生成图片 
     * @param gravity  图片位置 
     * @param dissolve 水印透明度 
     */  
    public  void waterMark(String waterImagePath, String srcImagePath, String destImagePath, String gravity, int dissolve) {  
        IMOperation op = new IMOperation();  
        op.gravity(gravity);  
        op.dissolve(dissolve);  
        op.addImage(waterImagePath);  
        op.addImage(srcImagePath);  
        op.addImage(destImagePath);  
        CompositeCmd cmd = new CompositeCmd();  
        cmd.setSearchPath(IMAGEMAGICKPATH);
        try {  
            cmd.run(op);  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (IM4JavaException e) {  
            e.printStackTrace();  
        }  
    } 
	
	/**
	 * 图片自动校正
	 * @param srcPath 校正前图片
	 * @param newPath 校正后图片
	 * @throws Exception
	 */
	public  void auto(String srcPath,String newPath) throws Exception {
		IMOperation op = new IMOperation();
		op.autoOrient();
		op.addImage(srcPath);
		op.addImage(newPath);
		
		ConvertCmd convert = new ConvertCmd();
		convert.setSearchPath(IMAGEMAGICKPATH);
		convert.run(op);
	}
	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public ImageInfo getImageInfo(String filePath){
		File file = new File(filePath);
		ImageInfo imgInfo = new ImageInfo();
		try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            imgInfo.setFile(file);
    		//gps
            GpsDirectory gps = metadata.getDirectory(GpsDirectory.class);  
            if (gps != null) {
            	//定位
            	imgInfo.setGeoLocation(gps.getGeoLocation());
            }
          //方向
            ExifIFD0Directory exifIFD0 = metadata.getDirectory(ExifIFD0Directory.class);  
            if (exifIFD0 != null) {
            	String orientationStr =  exifIFD0.getString(ExifIFD0Directory.TAG_ORIENTATION);
            	if(StringUtils.isNotEmpty(orientationStr)){
            		imgInfo.setOrientation(new Integer(orientationStr));
            	}
            }
          //  宽度和高度
            JpegDirectory jpeg = metadata.getDirectory(JpegDirectory.class);  
            if (jpeg != null) {
            	imgInfo.setWidth(new Integer(jpeg.getString(JpegDirectory.TAG_IMAGE_WIDTH)));
            	imgInfo.setHeight(new Integer(jpeg.getString(JpegDirectory.TAG_IMAGE_HEIGHT)));
            }
        //  时间
            ExifSubIFDDirectory exifSubIFD = metadata.getDirectory(ExifSubIFDDirectory.class);  
            if (exifSubIFD != null) {
            	String dateStr = exifSubIFD.getString(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
            	System.out.println("datetime:"+dateStr);
            	if(StringUtils.isNotEmpty(dateStr)){
            		//dateStr = "2016:01:11 13:44:30";
            		try {
            			imgInfo.setDateTimeOriginal(DateUtils.parseDate(dateStr, "yyyy:MM:dd HH:mm:ss"));
    				} catch (ParseException e) {
    					e.printStackTrace();
    					throw new RuntimeException(dateStr+" parse 解析失败"+e.getMessage());
    				}
            	}
            }
    		//size
            imgInfo.setSize(file.length());
   
            
        } catch (ImageProcessingException e) {
        	 e.printStackTrace();
        	 throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
           e.printStackTrace();
           throw new RuntimeException(e.getMessage());
        }
		return imgInfo;
	}
	
	
	public static void main(String[] args) throws Exception {
		ImageUtil tool = ImageUtil.getInstance();
		//System.out.println(tool.getImageInfo("c:\\IMG_20160111_135957.jpg"));
		//tool.auto("c:\\IMG_20160111_135957.jpg", "c:\\IMG_20160111_135957-1.jpg");
		//tool.zoomImage(1000, 1000,"c:\\tian_2.png" , "c:\\tian_2-1.png");
		System.out.println(tool.getImageInfo("/Users/fei/Desktop/IMG/33.png"));
		//tool.addImgText("/Users/fei/Desktop/IMG/tian_1.png", "ttt");
		//tool.waterMark("/Users/fei/Desktop/IMG/gao_1.png","/Users/fei/Desktop/IMG/tian_1.png","/Users/fei/Desktop/IMG/tian_1-1.png","southeast", 100);
	}
}