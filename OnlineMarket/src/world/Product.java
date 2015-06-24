package world;

public class Product {
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
	
	String getName(){
		return this.name;
	}
	
	double getPrice(){
		return this.price;
	}
	
	String getProvider(){
		return this.provider;
	}
	
	int getExpDay(){
		return this.expiration.day;
	}
	
	int getExpMonth(){
		return this.expiration.month;
	}
	
	int getExpYear(){
		return this.expiration.year;
	}
}
