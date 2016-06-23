package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Myserver {
	// 建立ServerSocket，并设置其端口号
	private ServerSocket ss;
	
	private boolean isStop;

	public static final int port = 8962;

	public Myserver() {

		try {

			ss = new ServerSocket(port);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void setConnection() throws IOException {
		// 建立服务器端的Socket
		Socket s = null;
//		OutputStream os;
		try { // ServerSocke.accept()t返回一个Socket对象
			while(!isStop){
				s = ss.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				System.out.println(br.readLine());
				br.close();	
			}
//			os = s.getOutputStream();
//			os.write("hello client".getBytes());
//			os.close();
			s.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {

		Myserver ms = new Myserver();
		ms.setConnection();

	}
}