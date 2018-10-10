package app;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SwitchingScenes extends Application{
	
	static Stage window;
	static Scene scene1, scene2, scene3;
	
	
	//////// MAIN METHOD //////////
	public static void main(String[] args) {
		launch(args);
	}
	
	
	///////// START METHOD /////////
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("/Login.fxml"));
		window = primaryStage;
		window.setTitle("Robles Network");
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
		
	    BorderPane rootPane1 = new BorderPane();
		// top
		rootPane1.setTop(addVBox());
		
		// center
		GridPane centerPane = addGridPane();
		centerPane.setPadding(new Insets(50, 1, 1, 600));  //top, right, bottom, left
		rootPane1.setCenter(centerPane);	
		
		scene1 = new Scene(root, 1500, 750);
		scene1.getStylesheets().add("RoblesNetwork.css");
		
		
		///DISPLAY WINDOW
		window.setScene(scene1);
		window.show();
	}
	
		///////LAYOUT 1//////
	private GridPane addGridPane() {
		GridPane grid = new GridPane();
		//
		grid.setPadding(new Insets(10, 0, 0, 100));  //top, right, bottom, left
		
		//WIDGETS
		
		Label username_label = new Label("Username: ");
		grid.add(username_label, 0, 0);  //column, row
		username_label.getStyleClass().add("entry-label");
		
		TextField username_field = new TextField();
		username_field.setPromptText("Username");
		username_field.setMinSize(10, 20);
		grid.add(username_field, 1, 0);
		username_field.setMaxWidth(200);
		
		Label password_label = new Label("Password: ");
		grid.add(password_label, 0, 1);
		password_label.getStyleClass().add("entry-label");
		
		PasswordField password_field = new PasswordField();
		password_field.setPromptText("Password");
		password_field.setMinSize(10, 20);
		grid.add(password_field, 1, 1);  //column, row
		password_field.setMaxWidth(200);
			
	    ////////////PORTALS/////////////////
			
		/////   To Login Screen
		Button login_button = new Button("Log In");
		login_button.setOnAction(e -> LoginScreen.layout_2());
		grid.add(login_button, 0, 2, 2, 1);  //(row, column, column_span, row_span)
		login_button.setMaxSize(Double.MAX_VALUE, Double.MIN_VALUE);
		
		Label or_label = new Label("  OR");
		grid.add(or_label, 1, 3);
		
		/////   To Sign Up Screen
		Button sign_up_button = new Button("Sign Up");
		sign_up_button.setOnAction(e -> SignUpScreen.layout_3());
		grid.add(sign_up_button, 0, 4, 2, 1);  //(row, column, row_span, column_span)
		sign_up_button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		/////   To Random Screen
		Label random_label = new Label("\nLabel");
		grid.add(random_label, 5, 14);
		
		Button random_button = new Button("Button");
		random_button.setOnAction(e -> RandomClass.randomScene());
		grid.add(random_button, 5, 15);
		
		//connection label
		Label isConnected = new Label("dbStatus");
		grid.add(isConnected, 5, 16);
		
		grid.setVgap(5);
		
		return grid;
	}	
	
	private VBox addVBox() {
			VBox v = new VBox();
		
		v.setPadding(new Insets(5, 5, 0, 300));   //top, right, bottom, left
        v.setSpacing(10);
        
		Label welcome_label = new Label("Welcome User");
		welcome_label.getStyleClass().add("title-label");
		welcome_label.setPadding( new Insets(1, 1, 1, 300));  //top, right, bottom, left
		
		Label explanation_label = new Label("	Hello. This network is a simple attempt so simulate data storage and  account\n" + 
				" management of social networks or simple user interface functions. It models a \n" + 
				" user creating an account and being able to sign in to that account.");
		explanation_label.setPadding( new Insets(1, 1, 1, 100));  //top, right, bottom, left
		explanation_label.getStyleClass().add("description-label");
		
		v.getChildren().addAll(welcome_label, explanation_label);
		
	
		return v;
	}
	
	private void closeProgram() {
		Boolean answer = ConfirmBox.display("Exit Request", "Are you sure you want to close this window?");
		if (answer) {
			window.close();
		}
		else {
			
		}
	}
}
	
