package app;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SignUpScreen {
	
	
	public static void layout_3() {
		
		//  TOP PANE  //
		BorderPane layout3 = new BorderPane();
		layout3.setTop(addHBox());
		
		//  CENTER PANE  //
		GridPane centerPane = addGrid();
		centerPane.setPadding(new Insets(50, 1, 1, 600));  //top, right, bottom, left
		layout3.setCenter(addGrid());
		
		//  SCENE  //
		Scene scene3 = new Scene(layout3, 1500, 750);
		scene3.getStylesheets().add("RoblesNetworkStyle.css");
		
		//  STAGE  //
		Stage window_1 = SwitchingScenes.window; //imports the window from the SwitchingScenes class
		window_1.setScene(scene3);
		window_1.show();
		
	}
	
	private static HBox addHBox() {
		HBox h = new HBox(20);
		
	    h.setPadding(new Insets(10, 0, 0, 10));
		h.setSpacing(10);
	    
		Label title_label1 = new Label("Welcome");
		title_label1.getStyleClass().add("title-label");
		title_label1.setPadding( new Insets(0, 0, 0, 400));  //top, right, bottom, left
		
		Label title_label2 = new Label("New");
		title_label2.getStyleClass().add("title-label-white");
		
		Label title_label3 = new Label("User");
		title_label3.getStyleClass().add("title-label");
		
		Button back_button = new Button("Back");
		
		Scene scene_1 = SwitchingScenes.scene1;  //imports the scene from the SwitchingScenes class
		back_button.setOnAction(e -> SwitchingScenes.window.setScene(scene_1));
		
		h.getChildren().addAll(back_button, title_label1, title_label2, title_label3);
		
	
		return h;
	}
	
	public static GridPane addGrid() {
		GridPane grid = new GridPane();
		//
		grid.setPadding(new Insets(100, 0, 0, 600));  //top, right, bottom, left
		grid.setVgap(10);
		/////   WIDGETS
		
		//FIRST NAME
		Label first_name_label = new Label("First Name: ");
		grid.add(first_name_label, 0, 0);  //column, row
		first_name_label.getStyleClass().add("entry-label");
		
		TextField first_name_field = new TextField();
		first_name_field.setPromptText("First Name");
		first_name_field.setMinSize(10, 20);
		grid.add(first_name_field, 1, 0);
		first_name_field.setMaxWidth(200);
		
		//LAST NAME
		Label last_name_label = new Label("Last Name: ");
		grid.add(last_name_label, 0, 1);  //column, row
		last_name_label.getStyleClass().add("entry-label");
		
		TextField last_name_field = new TextField();
		last_name_field.setPromptText("Last Name");
		last_name_field.setMinSize(10, 20);
		grid.add(last_name_field, 1, 1);
		last_name_field.setMaxWidth(200);
		
		//EMAIL
		Label email_label = new Label("E-Mail: ");
		grid.add(email_label, 0, 2);  //column, row
		email_label.getStyleClass().add("entry-label");
		
		TextField email_field = new TextField();
		email_field.setPromptText("E-Mail");
		email_field.setMinSize(10, 20);
		grid.add(email_field, 1, 2);
		email_field.setMaxWidth(200);
		
		//USERNAME
		Label username_label = new Label("Username: ");
		grid.add(username_label, 0, 3);  //column, row
		username_label.getStyleClass().add("entry-label");
		
		TextField username_field = new TextField();
		username_field.setPromptText("Username");
		username_field.setMinSize(10, 20);
		grid.add(username_field, 1, 3);
		username_field.setMaxWidth(200);
		
		//PASSWORD
		Label password_label = new Label("Password: ");
		grid.add(password_label, 0, 4);
		password_label.getStyleClass().add("entry-label");
		
		PasswordField password_field = new PasswordField();
		password_field.setPromptText("Password");
		password_field.setMinSize(10, 20);
		grid.add(password_field, 1, 4);  //column, row
		password_field.setMaxWidth(200);
		
		// CONFIRM PASSWORD
		Label confirm_password_label = new Label("Confirm\nPassword: ");
		grid.add(confirm_password_label, 0, 5);
		confirm_password_label.getStyleClass().add("entry-label");
		
		PasswordField confirm_password_field = new PasswordField();
		confirm_password_field.setPromptText("Re-Enter Password");
		confirm_password_field.setMinSize(10, 20);
		grid.add(confirm_password_field, 1, 5);  //column, row
		confirm_password_field.setMaxWidth(200);
		
		//LOCATION
		Label location_label = new Label("Location: ");
		grid.add(location_label, 0, 6);
		location_label.getStyleClass().add("entry-label");
		
		TextField location_field = new TextField();
		location_field.setPromptText("Location");
		location_field.setMinSize(10, 20);
		grid.add(location_field, 1, 6);  //column, row
		location_field.setMaxWidth(200);
		
		//DATE OF BIRTH
		Label dob_label = new Label("Date of\nBirth: ");
		grid.add(dob_label, 0, 7);
		dob_label.getStyleClass().add("entry-label");
		
        DatePicker dateOfBirth = new DatePicker();
		grid.add(dateOfBirth, 1, 7);
				
		//AGE    //could change to comboBox
		Label age_label = new Label("Age: ");
		grid.add(age_label, 0, 8);
		age_label.getStyleClass().add("entry-label");
		
		TextField age_field = new TextField();
		age_field.setPromptText("Age");
		age_field.setMinSize(10, 20);
		grid.add(age_field, 1, 8);  //column, row
		age_field.setMaxWidth(200);
		
		
		//INTERESTS
		Label interests_label = new Label("Interests: ");
		grid.add(interests_label, 0, 9);
		interests_label.getStyleClass().add("entry-label");
		
		TextField interests_field = new TextField();
		interests_field.setPromptText("Interests");
		interests_field.setMinSize(10, 20);
		grid.add(interests_field, 1, 9);  //column, row
		interests_field.setMaxWidth(200);
		
		//CREATE ACCOUNT BUTTON
		Button create_button = new Button("Create Account");
		create_button.setOnAction(e -> {

			if (first_name_field.getText().isEmpty()) {
				Label firstNameError = new Label("Please enter a first name.");
				grid.add(firstNameError, 2, 0);
				firstNameError.setPadding(new Insets(0, 0, 0, 5));  //top, right, bottom, left
				firstNameError.getStyleClass().add("error-label");
			}
			
			if (last_name_field.getText().isEmpty()) {
				Label lastNameError = new Label("Please enter a last name.");
				grid.add(lastNameError, 2, 1);
				lastNameError.setPadding(new Insets(0, 0, 0, 5));  //top, right, bottom, left
				lastNameError.getStyleClass().add("error-label");
			}
			
			if (email_field.getText().isEmpty()) {
				Label emailError = new Label("Please enter an email.");
				grid.add(emailError, 2, 2);
				emailError.setPadding(new Insets(0, 0, 0, 5));  //top, right, bottom, left
				emailError.getStyleClass().add("error-label");
			}
			if (username_field.getText().isEmpty()) {
				Label usernameError = new Label("Please enter a username.");
				grid.add(usernameError, 2, 3);
				usernameError.setPadding(new Insets(0, 0, 0, 5));  //top, right, bottom, left
				usernameError.getStyleClass().add("error-label");
			}
			
			if (!passwordIsValid(password_field)) {
				Label passError = new Label("Please enter a valid password.");
				grid.add(passError, 2, 4);
				passError.getStyleClass().add("error-label");
				passError.setPadding(new Insets(0, 0, 0, 5));  //top, right, bottom, left
			}
			
			if (!passwordMatches(password_field, confirm_password_field)) {
				Label matchError = new Label("Please make sure the passwords match.");
				grid.add(matchError, 2, 5);
				matchError.setPadding(new Insets(0, 0, 0, 5));  //top, right, bottom, left
				matchError.getStyleClass().add("error-label");
			}
			
			if (location_field.getText().isEmpty()) {
				Label locationError = new Label("Please enter a location.");
				grid.add(locationError, 2, 6);
				locationError.setPadding(new Insets(0, 0, 0, 5));  //top, right, bottom, left
				locationError.getStyleClass().add("error-label");
			}
			
			if(!isInt(age_field)) {
				Label ageError = new Label("Please enter a number for age.");
				grid.add(ageError, 2, 8);
				ageError.getStyleClass().add("error-label");
				ageError.setPadding(new Insets(0, 0, 0, 5));  //top, right, bottom, left
			}
			
			if (interests_field.getText().isEmpty()) {
				Label interestsError = new Label("Please list some interests.");
				grid.add(interestsError, 2, 9);
				interestsError.setPadding(new Insets(0, 0, 0, 5));  //top, right, bottom, left
				interestsError.getStyleClass().add("error-label");
			}
			
			else {
				Scene scene_1 = SwitchingScenes.scene1;
				SwitchingScenes.window.setScene(scene_1);
				
			}
			
		});
		
		grid.add(create_button, 0, 10, 2, 1);  //(row, column, column_span, row_span)
		create_button.setMaxSize(Double.MAX_VALUE, Double.MIN_VALUE);
		
		return grid;
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
