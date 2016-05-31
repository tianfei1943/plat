package io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test1 {

	public static void main(String[] args) throws IOException {
		String file = "/Users/fei/Downloads/stream.txt";
		String charset = "UTF-8";
		// 写字符换转成字节流
		FileOutputStream outputStream = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream,charset));
		try {
			bw.write("这是要保存的中文字符这是要保文字符\n");
			bw.write("这是要保存的中文文字符");
		} finally {
			bw.close();
		}
		// 读取字节转换成字符
		FileInputStream inputStream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset));
		try {
			String line = null;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
		} finally {
			br.close();
		}
		
	}

}
