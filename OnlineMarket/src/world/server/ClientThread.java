package world.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import world.Client;
import world.Product;

public class ClientThread implements Runnable{
	private Socket sock;
	
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
			
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
					String login = in.readLine();
					String password = in.readLine();
					
					if(ClientHandler.getClientHandler().verifyLogin(login, password))
						pw.println("1");
					else
						pw.println("2");	

				} else if (cmd == 3){
					for(Product p: ProductHandler.getProductHandler().getProductList()){
						pw.println("1");
						pw.println(p.getName());
						pw.println(p.getPrice());
						pw.println(p.getExpDay());
						pw.println(p.getExpMonth());
						pw.println(p.getExpYear());
						pw.println(p.getProvider());
					}
					pw.println("0");
				} else if (cmd == 4){
					String prodName = in.readLine();
					ProductHandler.getProductHandler().removeByName(prodName);
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
