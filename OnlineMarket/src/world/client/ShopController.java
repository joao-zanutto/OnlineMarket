package world.client;

import java.net.URL;
import java.util.ResourceBundle;

import world.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShopController extends Application{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Product> prod;

    @FXML
    private TextField prodForne;

    @FXML
    private TextField prodVal;

    @FXML
    private Button buy;

    @FXML
    private TextField prodName;

    @FXML
    private TextField prodPrice;
    
    @FXML
    private Pane root;

    @FXML
    void initialize() {
    	ObservableList<Product> options = FXCollections.observableArrayList(ConnectionHandler.getConnectionHandler().requestList());
    	prod.setItems(options);
    }
    
    @FXML
    void updateItemInfo(){
    	if(prod.getSelectionModel().getSelectedItem() != null){
    		prodName.setText(prod.getSelectionModel().getSelectedItem().getName());
    		prodPrice.setText("R$ "+prod.getSelectionModel().getSelectedItem().getPrice());
    		prodVal.setText("" + prod.getSelectionModel().getSelectedItem().getExpDay() + "/" + prod.getSelectionModel().getSelectedItem().getExpMonth() + "/" +
    				prod.getSelectionModel().getSelectedItem().getExpYear());
    		prodForne.setText(prod.getSelectionModel().getSelectedItem().getProvider());
    	}
    }
    
    // Loader do FXML
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ShopWindow.fxml"));
	public void start(Stage mainStage) throws Exception {
		mainStage.setScene(new Scene( (Parent) loader.load()));
		mainStage.show();
	}
}
