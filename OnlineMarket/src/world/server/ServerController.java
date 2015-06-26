package world.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import world.Product;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ServerController extends Application{
	ProductHandler ph = ProductHandler.getProductHandler();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField yearField;

    @FXML
    private TextField monthField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField dayField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField providerField;

    @FXML
    private Text error;

    @FXML
    private Button confirmButton;

    @FXML
    private TextArea list;
    
    @FXML
    void initialize() {
    	readFile();
    	
        confirmButton.setOnAction(event->{
        	if(verifyConfirmation()){
        		registerStages();
        		ph.makeFile();
        	}
        });
        
        
    }
    
    // Printa o produto na lista de produtos
    void printList(Product p){
    	list.setText(list.getText() + p + "\n");
    }
    
    // Método que registra um produto baseado nas informações da interface gráfica
    void registerStages(){
    	Product p = new Product(nameField.getText(), Double.parseDouble(priceField.getText()), Integer.parseInt(dayField.getText()),
				Integer.parseInt(monthField.getText()), Integer.parseInt(yearField.getText()), providerField.getText());
		ph.registerProduct(p);
		nameField.setText("");
		priceField.setText("");
		dayField.setText("");
		monthField.setText("");
		yearField.setText("");
		providerField.setText("");
		
		printList(p);
    }
    
    // Método que lê o arquivo e recuper informações de produtos
    private void readFile(){
    	File file = new File("productlist.csv");
    	if(!file.exists()){
    		return;
    	}
    	
    	try {
			Scanner sc = new Scanner(file);
			sc.useDelimiter(", ");
			while(sc.hasNextLine()){
				String name = sc.next();
				double price = Double.parseDouble(sc.next());
				int day = Integer.parseInt(sc.next());
				int month = Integer.parseInt(sc.next());
				int year = Integer.parseInt(sc.next());
				String provider = sc.next();
				sc.skip(", ");
				int quantity = Integer.parseInt(sc.nextLine());
				
				Product p = new Product(name, price, day, month, year, provider);
				p.setQuantity(quantity);
				ph.registerProduct(p);
				printList(p);
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Something wrong happened while reading from file");
		}
    }
    
    // Método que verifica se uma string é um double
    boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Método que verifica se uma string é um int
    boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Método que verifica os critérios para criar um novo produto
    private boolean verifyConfirmation(){
    	if(nameField.getText().equals("")){
    		error.setText("O nome do produto não pode estar vazio");
    		error.setFill(Color.RED);
    	} else if (!isDouble(priceField.getText())){
    		error.setText("O preço do produto deve ser numérico");
    		error.setFill(Color.RED);
    	} else if (!isInt(dayField.getText()) || !isInt(monthField.getText()) || !isInt(yearField.getText())){
    		error.setText("A data deve ser no formato inteiro");
    		error.setFill(Color.RED);
    	} else if (providerField.getText().equals("")){
    		error.setText("O nome do fornecedor não pode estar vazio");
    		error.setFill(Color.RED);
    	} else {
    		error.setFill(Color.TRANSPARENT);
    		return true;
    	}
    	return false;
    }
    
    // Loader do FXML
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ServerWindow.fxml"));
	public void start(Stage mainStage) throws Exception {
		mainStage.setScene(new Scene( (Parent) loader.load()));
		mainStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
