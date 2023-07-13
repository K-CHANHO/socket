package chatting.server;

import java.net.*;

public class Server {

	public static void main(String[] args) {
		
		ServerSocket server_socket = null; // 접속을 받기 위한 소켓 
		Socket socket = null; // 통신을 위한 소켓
		User user = new User();
		
		int count = 0;
		Thread thread[] = new Thread[10];
		
		try {
			server_socket = new ServerSocket(4444); // 서버포트
			while(true) {
				socket = server_socket.accept();
				thread[count] = new Thread(new Reciever(user, socket));
				thread[count].start();
				count++;
			}
		} catch(Exception e) {
			
		};
		

	}

}
