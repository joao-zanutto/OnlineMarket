package world;

public class Client {
	private String name;
	private String addres;
	private String phone;
	private String email;
	private String login;
	private String password;
	
	// GETTERS E SETTERS DA CLASSE = BEGGINING
	public Client(String name, String addres, String phone, String email, String login, String password){
		this.name = name;
		this.addres = addres;
		this.phone = phone;
		this.email = email;
		this.login = login;
		this.password = password;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAddres(){
		return addres;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getLogin(){
		return login;
	}
	
	public String getPassword(){
		return password;
	}
	// GETTERS E SETTERS = END
}
