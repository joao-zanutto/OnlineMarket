package world.client;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import world.Client;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClientController extends Application{
	Socket sock;
	boolean connection = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField newAddres;

    @FXML
    private TextField newPhone;

    @FXML
    private TextField newName;

    @FXML
    private TextField newLogin;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField newEmail;
    
    @FXML
    private TextField login;
    
    @FXML
    private TextField password;
    
    @FXML
    private Button confirm;
    
    @FXML
    private Text error;
    
    @FXML
    private TextField ip;
    
    @FXML
    private Button connect;
    
    @FXML
    private Text cerror;
    
    @FXML
    private Text loginError;

    @FXML
    void initialize() {
        
    }
    
    // Método que faz a conexão com o servidor
    @FXML
    void connectToServer(){
    	if(connection)
    		return;
    	try {
			Socket sc = new Socket(ip.getText(), 1234);
			sock = sc;
			ConnectionHandler.getConnectionHandler().setSocket(sc);
			connection = true;
			cerror.setText("");
			cerror.setFill(Color.TRANSPARENT);
		} catch (UnknownHostException e) {
			cerror.setText("Erro na conexão com o servidor");
			cerror.setFill(Color.RED);
		} catch (IOException e) {
			cerror.setText("Erro na conexão com o servidor");
			cerror.setFill(Color.RED);
		}
    }
    
    // Método que faz o login do usuário e abre a loja caso esteja tudo certo
    @FXML
    void login() throws Exception{
    	if(login.getText().equals("") || password.getText().equals("")){
    		loginError.setText("Nenhum campo pode estar vazio");
    		loginError.setFill(Color.RED);
    	} else if(!connection){
    		loginError.setText("Você deve se conectar ao servidor");
    		loginError.setFill(Color.RED);
    	} else {
    		loginError.setText("");
    		loginError.setFill(Color.TRANSPARENT);
    		boolean b = ConnectionHandler.getConnectionHandler().passLogin(login.getText(), password.getText());
    		if(b){
    			new ShopController().start(new Stage());
    		} else {
    			loginError.setText("Login ou senha errados");
    			loginError.setFill(Color.RED);
    		}
    	}
    }
    
    // Método que faz o registro do usuário
    @FXML
    void registerAction(){
    	if(newName.getText().equals("") || newAddres.getText().equals("") || newPhone.getText().equals("") || newEmail.getText().equals("") || newLogin.getText().equals("")
    			|| newPassword.equals("")){
    		error.setText("Nenhum campo pode estar vazio");
    		error.setFill(Color.RED);
    	} else if(!connection){
    		error.setText("Você deve se connectar ao servidor");
    		error.setFill(Color.RED);
    	} else {
    		error.setText("");
    		error.setFill(Color.TRANSPARENT);
    		
    		Client c = new Client(newName.getText(), newAddres.getText(), newPhone.getText(), newEmail.getText(), newLogin.getText(), newPassword.getText());
    		ConnectionHandler.getConnectionHandler().passRegister(c);
    	}
    }
    
    // Método que limpa os campos na tela de registro
    @FXML
    void clearForm(){
    	newName.setText("");
    	newAddres.setText("");
    	newPhone.setText("");
    	newEmail.setText("");
    	newLogin.setText("");
    	newPassword.setText("");
    }
    
    // Loader do FXML
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientWindow.fxml"));
	public void start(Stage mainStage) throws Exception {
		mainStage.setScene(new Scene( (Parent) loader.load()));
		mainStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
