package world.server;

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
	
	public void addQuantity(Product p){
		p.setQuantity(p.getQuantity() + 1);
	}
	
	public void removeQuantity(Product p){
		int num = p.getQuantity();
		
		if(num > 0){
			p.setQuantity(num - 1);
		}
	}
	
	public List<Product> getProductList(){
		return productList;
	}
	// List Handling Methods = END
 }
