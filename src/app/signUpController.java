package app;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.dbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class signUpController implements Initializable{
	
	@FXML
	private Button backToLoginButton;
	
	@FXML
	private Button createButton;
	
	public void BackToLoginEvent(ActionEvent event) throws IOException {
		Parent signUpParent = FXMLLoader.load(getClass().getResource("/Login.fxml"));
		Scene signUpLayout = new Scene(signUpParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(signUpLayout);
		window.show();
	}
	
	////  TEXT INPUT FIELDS
	@FXML
	private TextField sign_firstName;
	@FXML
	private TextField sign_lastName;
	@FXML
	private TextField sign_email;
	@FXML
	private TextField sign_createUsername;
	@FXML
	private TextField sign_createPassword;
	@FXML
	private TextField sign_confirmPassword;
	@FXML
	private TextField sign_option;
	@FXML
	private TextField sign_location;
	@FXML
	private DatePicker sign_dob;
	@FXML
	private TextField sign_age;
	@FXML
	private TextField sign_interests;
	
	//// ERROR LABELS
	
	@FXML
	private Label usernameError;
	@FXML
	private Label passwordError;
	@FXML
	private Label divisionError;
	@FXML
	private Label matchError;
	@FXML
	private Label firstNameError;
	@FXML
	private Label lastNameError;
	@FXML
	private Label emailError;
	@FXML
	private Label locationError;
	@FXML
	private Label dobError;
	@FXML
	private Label ageError;
	@FXML
	private Label interestsError;
	
	private dbConnection dc;
	
	public void initialize(URL url, ResourceBundle rb) {
		this.dc = new dbConnection();
	}
	
	
	@FXML
	private void addSignUpUser(ActionEvent event) {
		String sqlInsert = "INSERT INTO Users (`username`, `password`, `division`, `confirmPassword`, `firstName`, `lastName`, `email`, `location`, `dob`, `age`, `interests`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
		try {
			//this.createButton.setOnAction(e -> {
		    //  USERNAME ERROR
			if (this.sign_createUsername.getText().isEmpty()) {
				usernameError.setText("Please enter a username.");
			}
			//  PASSWORD ERROR
			if (!passwordIsValid(this.sign_createPassword)) {
				this.passwordError.setText("Please enter a valid password.");
			}
			//  DIVISION ERROR
			if (this.sign_option.getText() != "User" || this.sign_option.getText() != "Admin") {
				this.divisionError.setText("Please enter 'User' or 'Admin'.");
			}
			//  PASSWORD MATCH ERROR
			if (!passwordMatches(this.sign_createPassword, this.sign_confirmPassword)) {
				this.matchError.setText("Please make sure the passwords match.");
			}
			//  FIRST NAME ERROR
			if (this.sign_firstName.getText().isEmpty()) {
				this.firstNameError.setText("Please enter a first name.");
			}
			//  LAST NAME ERROR
			if (this.sign_lastName.getText().isEmpty()) {
				this.lastNameError.setText("Please enter a last name.");
			}
			//  EMAIL ERROR
			if (this.sign_email.getText().isEmpty()) {
				this.emailError.setText("Please enter an email.");
			}
			//  LOCATION ERROR
			if (this.sign_location.getText().isEmpty()) {
				this.locationError.setText("Please enter a location.");
			}
			//  DOB ERROR
			if (this.sign_dob.getEditor().getText().isEmpty()) {
				this.dobError.setText("Please enter a date of birth.");
			}
			//  AGE ERROR
			if(!isInt(this.sign_age)) {
				this.ageError.setText("Please enter a number for age.");
			}
			//  INTERESTS ERROR
			if (this.sign_interests.getText().isEmpty()) {
				this.interestsError.setText("Please list some interests.");
			}
			
			else {
				Scene scene_1 = SwitchingScenes.scene1;
				SwitchingScenes.window.setScene(scene_1);
				
			}
			
		//});
			
			Connection conn = dbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlInsert);
			
			stmt.setString(1, this.sign_createUsername.getText());
			stmt.setString(2, this.sign_createPassword.getText());
			stmt.setString(3, this.sign_option.getText());
			stmt.setString(4, this.sign_confirmPassword.getText());
			stmt.setString(5, this.sign_firstName.getText());
			stmt.setString(6, this.sign_lastName.getText());
			stmt.setString(7, this.sign_email.getText());
			stmt.setString(8, this.sign_location.getText());
			stmt.setString(9, this.sign_dob.getEditor().getText());
			stmt.setString(10, this.sign_age.getText());
			stmt.setString(11, this.sign_interests.getText());

			stmt.execute(); 
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		/*try {

		}catch(Exception localException) {
			
		}*/

	}
	
	@FXML
	private void clearSignUpFields() {
		
	}
	
	private static boolean isInt(TextField input) {
		try {
			int age = Integer.parseInt(input.getText());
			return true;
		}catch(NumberFormatException e) { 
			return false;
		}
				
	}
	
	////   PASSWORD VERIFICATION
	private static boolean passwordIsValid(TextField pass) {
		String passInput = pass.getText();
		
		//case verification
		boolean hasUppercase = !passInput.equals(passInput.toLowerCase());
		boolean hasLowercase = !passInput.equals(passInput.toUpperCase());
		//length
		boolean isAtLeast8   =  passInput.length() >= 8;
		//special char
		boolean hasSpecial   = !passInput.matches("[A-Za-z0-9 ]*");
		////
		if(hasUppercase && hasLowercase && isAtLeast8 && hasSpecial) {
			return true;
		}
		else {
			return false;
		}	
	}	
	
	private static boolean passwordMatches(TextField pass, TextField passConf) {
		String passInput = pass.getText();
		String confirm = passConf.getText();
		
		boolean passMatch = passInput.equals(confirm);
		
		//case verification
		boolean hasUppercase = !confirm.equals(confirm.toLowerCase());
		boolean hasLowercase = !confirm.equals(confirm.toUpperCase());
		//length
		boolean isAtLeast8   =  confirm.length() >= 8;
		//special char
		boolean hasSpecial   = !confirm.matches("[A-Za-z0-9 ]*");
		
		if(passMatch && hasUppercase && hasLowercase && isAtLeast8 && hasSpecial) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
