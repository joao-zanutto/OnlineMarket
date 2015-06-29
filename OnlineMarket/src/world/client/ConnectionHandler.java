package world.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import world.Client;

public class ConnectionHandler {
	private PrintWriter pw;
	
	public ConnectionHandler(Socket sc){
		try {
			pw = new PrintWriter(sc.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println("Erro no PrintWriter");
		}
	}
	
	public void passRegister(Client c){
		pw.println("1");
		pw.println(c.getName());
		pw.println(c.getAddres());
		pw.println(c.getPhone());
		pw.println(c.getEmail());
		pw.println(c.getLogin());
		pw.println(c.getPassword());
	}
	
	public void passLogin(){
		pw.println("2");
	}
}
