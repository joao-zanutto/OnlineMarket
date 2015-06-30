package world.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import world.Client;
import world.Product;

public class ConnectionHandler {
	// Singleton DECLARATION
	private static final ConnectionHandler instance = new ConnectionHandler();
	
	private ConnectionHandler(){}
	
	public static ConnectionHandler getConnectionHandler(){
		return instance;
	}
	
	public void setSocket(Socket sc){
		try {
			pw = new PrintWriter(sc.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
		} catch (IOException e) {
			System.out.println("Erro no PrintWriter");
		}
	}
	// SingletonProperties = END
	
	private PrintWriter pw;
	private BufferedReader br;
	private List<Product> productList = new ArrayList<Product>();
	
	public void passRegister(Client c){
		pw.println("1");
		pw.println(c.getName());
		pw.println(c.getAddres());
		pw.println(c.getPhone());
		pw.println(c.getEmail());
		pw.println(c.getLogin());
		pw.println(c.getPassword());
	}
	
	public boolean passLogin(String login, String password){
		pw.println("2");
		pw.println(login);
		pw.println(password);
		
		try {
			int success = Integer.parseInt(br.readLine());
			if(success == 1){
				return true;
			}
			if(success == 2)
				return false;
		} catch (NumberFormatException e) {
			System.out.println("Error");
		} catch (IOException e) {
			System.out.println("Error");
		}
		
		return false;
	}
	
	public void getList(){
		pw.println("3");
		
		try {
			int hasNext = Integer.parseInt(br.readLine());
			
			while(hasNext == 1){
				String name = br.readLine();
				double price = Double.parseDouble(br.readLine());
				int expDay = Integer.parseInt(br.readLine());
				int expMonth = Integer.parseInt(br.readLine());
				int expYear = Integer.parseInt(br.readLine());
				String provider = br.readLine();
				
				Product p = new Product(name, price, expDay, expMonth, expYear, provider);
				productList.add(p);
				
				hasNext = Integer.parseInt(br.readLine());
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("ERROR");
		}
	}
	
	public List<Product> requestList(){
		getList();
		return productList;
	}
}
