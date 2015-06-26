package world.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import world.*;

public class ProductHandler {
	// Singleton Design Pattern = BEGGINING
	private static final ProductHandler instance = new ProductHandler();
	
	private ProductHandler(){}
	
	public static ProductHandler getProductHandler(){
		return instance;
	}
	// Singleton Design Pattern = END
	
	
	private List<Product> productList = new ArrayList<Product>(); // ProductList
	
	// List Handling Methods = BEGGINING
	public void registerProduct(Product p){
		this.productList.add(p);
	}
	
	// Adiciona uma unidade do produto p
	public void addQuantity(Product p){
		p.setQuantity(p.getQuantity() + 1);
	}
	
	// Remove uma unidade do produto p
	public void removeQuantity(Product p){
		int num = p.getQuantity();
		
		if(num > 0){
			p.setQuantity(num - 1);
		}
	}
	
	// Retorna a lista de produtos
	public List<Product> getProductList(){
		return productList;
	}
	
	// Método que cria o arquivo com o banco de dados do estoque de produtos disponiveis
	public void makeFile(){
		// Garante que o arquivo seja criado novamente cada vez que a função é executada
		File file = new File("productlist.csv");
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
			
			
			for(Product p : productList){
				String content = p.getName() + ", " + p.getPrice() + ", " + p.getExpDay() + ", " + p.getExpMonth() + ", " +
						p.getExpYear() + ", " + p.getProvider() + ", " + p.getQuantity() + "\n";
				
				bw.write(content);
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Fim do procedimento de escrita no arquivo
	}
	
	// List Handling Methods = END
 }
