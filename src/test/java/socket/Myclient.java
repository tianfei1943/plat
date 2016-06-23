package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Myclient {
	public static final String IP = "127.0.0.1";
	public static final int port = 8962;
	private Socket s;

	public Myclient() throws IOException {
		try {
			s = new Socket(IP, port);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void setConnection() throws IOException {

		InputStream is;

		try {
//			is = s.getInputStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//			System.out.println(br.readLine());
//			is.close();
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("hello server");
			bw.write("hello server");
			bw.write("hello server");
			bw.close();
			s.close();
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String args[]) throws IOException {
		
		Myclient mc = new Myclient();
		mc.setConnection();

	}
}