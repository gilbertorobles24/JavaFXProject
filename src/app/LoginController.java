package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import users.UsersController;

public class LoginController implements Initializable {
	
	@FXML
	public Button signUpButton;
	
	
	//  Database
	LoginModel loginModel = new LoginModel();
	
	@FXML
	private Label dbStatus;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private Button loginButton;
	@FXML
	private ComboBox<option> combobox;
	@FXML
	private Label loginStatus;
	
	public void initialize(URL url, ResourceBundle rb) {
		if(this.loginModel.isConnected()) {
			dbStatus.setText("Connected");
			System.out.println("Connected");
		}
		else {
			dbStatus.setText("Not Connected");
			System.out.println("Not connected");
		}
		
		this.combobox.setItems(FXCollections.observableArrayList(option.values()));
	
	}

	
	@FXML
	public void Login(ActionEvent event) {
		try {
			if(this.loginModel.isLogin(this.username.getText(), this.password.getText(), ((option)this.combobox.getValue()).toString())) {
				Stage stage = (Stage)this.loginButton.getScene().getWindow();
				stage.close();
				
				switch (((option) this.combobox.getValue()).toString()) {
					case "Admin":
						AdminLogin();
						break;
					case "User":
						UserLogin();
				}
			}
			else {
				this.loginStatus.setText("Wrong Username or Password");
			}
		}catch(Exception localException) {
			
		}
	}
	
	public void UserLogin() {
		try {
			Stage userStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = (Pane)loader.load(getClass().getResource("/UsersFXML.fxml").openStream());
			
			UsersController usersController = (UsersController)loader.getController();
			Scene scene = new Scene(root);
			userStage.setScene(scene);
			userStage.setTitle("User Dashboard");
			userStage.setOnCloseRequest(e -> {
				e.consume();
				closeProgram(userStage);
			});
			userStage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void AdminLogin() {
		try {
			Stage adminStage = new Stage();
			FXMLLoader adminLoader = new FXMLLoader();
			Pane adminRoot = (Pane)adminLoader.load(getClass().getResource("/AdminFXML.fxml").openStream());
			
			AdminController adminController = (AdminController)adminLoader.getController();
			Scene scene = new Scene(adminRoot);
			adminStage.setScene(scene);
			adminStage.setTitle("Admin Dashboard");
			adminStage.setOnCloseRequest(e -> {
				e.consume();
				closeProgram(adminStage);
			});
			adminStage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void SignUpEvent (ActionEvent event) throws IOException {
		Parent signUpParent = FXMLLoader.load(getClass().getResource("/signUpFXML.fxml"));
		Scene signUpLayout = new Scene(signUpParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(signUpLayout);
		window.show();
	}
	
	private void closeProgram(Stage window) {
		Boolean answer = ConfirmBox.display("Exit Request", "Are you sure you want to close this window?");
		if (answer) {
			window.close();
		}
		else {
			
		}
	}

}
