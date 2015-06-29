package world.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import world.Client;

public class ClientThread implements Runnable{
	private Socket sock;
	
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			while(true){
				int cmd = Integer.parseInt(in.readLine());
				if(cmd == 1){
					String name = in.readLine();
					String addres = in.readLine();
					String phone = in.readLine();
					String email = in.readLine();
					String login = in.readLine();
					String password = in.readLine();
					
					Client c = new Client(name, addres, phone, email, login, password);
					ClientHandler.getClientHandler().registerClient(c);
				} else if (cmd == 2){
					System.out.print("Login");
				}
			}
		} catch (IOException e) {
			 System.out.println("Erro no socket");
		}
		
	}
	public ClientThread(Socket s){
		this.sock = s;
	}
}
