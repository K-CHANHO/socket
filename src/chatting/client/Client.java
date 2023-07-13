package chatting.client;

import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) throws IOException {
		
		InetAddress ia = InetAddress.getLocalHost();
//		Socket socket = new Socket(ia, 4444);
		Socket socket = new Socket("192.168.1.118", 4444);
		DataInputStream in = new DataInputStream(socket.getInputStream());
		BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
		System.out.print("닉네임을 입력해주세요 : ");
		String data = in2.readLine();
		
		out.writeUTF(data);
		Thread th = new Thread(new Send(out));
		th.start();
		
		while(true) {
			String str2 = in.readUTF();
			System.out.println(str2);
		}
	
	}

}
