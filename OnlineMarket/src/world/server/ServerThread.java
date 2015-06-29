package world.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable{

	private ServerSocket serv;
	@Override
	public void run(){
		try {
			serv = new ServerSocket(1234);
			while(true){
				Socket sc = serv.accept();
				System.out.println("Someone connected!");
				Thread t = new Thread(new ClientThread(sc));
				t.start();
			}
		} catch (IOException e) {
			System.out.println("Erro no servidor");
		}
	}
	
	void startThread(){
		Thread t = new Thread(new ServerThread());
		t.start();
	}
	
}
