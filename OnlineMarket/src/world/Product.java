package world;

public class Product {
	public String toString(){
		return "Nome: " + name + "\n" + "Preço: " + price + "\n" + "Validade: " + expiration.day + "/" + expiration.month + "/" + expiration.year + "\n"
				+ "Fornecedor: " + provider + "\n" + "Quantidade no estoque: " + quantity + "\n";
	}
	
	class Date {
		int day;
		int month;
		int year;
		
		Date(int day, int month, int year){
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
	
	private int quantity = 0;
	private String name;
	private double price;
	private Date expiration;
	private String provider;
	
	public Product(String name, double price, int day, int month, int year, String provider){
		this.name = name;
		this.price = price;
		this.expiration= new Date(day, month, year);
		this.provider = provider;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public String getProvider(){
		return this.provider;
	}
	
	public int getExpDay(){
		return this.expiration.day;
	}
	
	public int getExpMonth(){
		return this.expiration.month;
	}
	
	public int getExpYear(){
		return this.expiration.year;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public void setQuantity(int num){
		this.quantity = num;
	}
}
