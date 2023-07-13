package chatting.server;

import java.io.DataInputStream;
import java.net.Socket;

public class Reciever implements Runnable {
	
	Socket socket;
	DataInputStream in;
	String name;
	User user;

	public Reciever(User user, Socket socket) throws Exception {
		this.user = user;
		this.socket = socket;
		in = new DataInputStream(socket.getInputStream());
		this.name = in.readUTF();
		user.AddClient(name, socket);
	}

	@Override
	public void run() {
		try {
			while(true) {
				String msg = in.readUTF();
				user.sendMsg(msg,name);
			}
		} catch (Exception e) {
			user.RemoveClient(this.name);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
