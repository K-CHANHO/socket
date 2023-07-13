package chatting.client;

import java.io.*;

public class Send implements Runnable {
	
	DataOutputStream out;
	
	// 채팅 내용을 받아오는 역할
	BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
	
	public Send(DataOutputStream out) {
		this.out = out;
	}

	@Override
	public void run() {
		while(true) {
				String msg;
				try {
					msg = in2.readLine();
					out.writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
