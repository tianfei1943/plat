package FileOpe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.log4j.Logger;


public class EhFile {

	protected Logger log = Logger.getLogger(this.getClass().getName());
	
	public static void main(String[] args) {
		createEhFile();

	}
	
	public static void createEhFile(){
        File file = new File("C:/fbR_HD_20150522.eh");
        System.out.println(file.getName());
            //写入文件
        FileOutputStream fos  = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            //File file = new File("c:/AH_GEN_20130827.csv");
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos, "GBK");
            bw = new BufferedWriter(osw);
            String str = "<省市实时计划文件::传输说明 time='2015-05-22 13:42:21'>\n";
            str += "@#顺序 属性名 属性值1\n";
            str += "#0 标识 'fbD_HD_20150522.eh'\n";
            str += "#1 发送地址 华东.省市实时计划数据\n";
            str += "#2 接收地址 安徽.省市实时计划数据\n";
            str += "#3 传输类型 文件\n";
            str += "#4 内容 'AH20150501InterchangeScheD.xml' 'HD_20150501_QWSDJH.txt' 'AH20150501DayContracts.xml' 'HD_20150501_TLDC.txt' 'AH20150501DayContractsAdj.xml' 'HD_20150501_TZTLDC.txt' 'AH20150501PlantInterChangeScheD.xml'\n";
            str += "#5 文件 'AH20150501InterchangeScheD.xml' 'HD_20150501_QWSDJH.txt' 'AH20150501DayContracts.xml' 'HD_20150501_TLDC.txt' 'AH20150501DayContractsAdj.xml' 'HD_20150501_TZTLDC.txt' 'AH20150501PlantInterChangeScheD.xml'\n";
            str += "<省市实时计划文件::传输说明>\n";
            bw.write(str);
//            log.info(moduleName+file.getName()+"数据文件生成成功");
        } catch (FileNotFoundException ex) {
//            log.error(moduleName+file.getName()+"文件生成失败，失败原因为", ex);
        } catch(IOException ex){
//            log.error(moduleName+file.getName()+"文件生成失败，失败原因为", ex);
        } finally {
            try {
                bw.close();
                osw.close();
                fos.close();
            } catch (IOException ex) {
//                log.error(ex);
            }
        }
    }

}
