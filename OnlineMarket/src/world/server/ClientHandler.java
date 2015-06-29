package world.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import world.Client;


public class ClientHandler{
	// Singleton Design Pattern = BEGGINING
	private static final ClientHandler instance = new ClientHandler();
	
	private ClientHandler(){}
	
	public static ClientHandler getClientHandler(){
		return instance;
	}
	// Singleton Design Pattern = END
	
	private List<Client> clientList = new ArrayList<Client>(); // ClientList
	
	// ClientList methods = BEGGINING
	public void registerClient(Client c){
		this.clientList.add(c);
		makeFile();
	}
	
	public void addClient(Client c){
		this.clientList.add(c);
	}
	
	// Escreve o arquivo lista de clientes
	public void makeFile(){
		// Garante que o arquivo seja criado novamente cada vez que a função é executada
		File file = new File("clientlist.csv");
		if(file.exists()){
			file.delete();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Something happened while creating a file");
		}
		// Fim do procedimento de criação de arquivo
		
		// Procedimento de escrita no arquivo
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			for(Client c : clientList){
				String content = c.getName() + ", " + c.getAddres() + ", " + c.getPhone() + ", " + c.getEmail() + ", " +
						c.getLogin() + ", " + c.getPassword() + "\n";
				
				bw.write(content);
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Fim do procedimento de escrita no arquivo
	}
	
	
	// ClientList methods = END
}
