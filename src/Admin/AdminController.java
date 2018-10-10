package Admin;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminController {
	@FXML
	private Button clearFieldsButton;
	@FXML
	private Button createUserButton;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField email;
	@FXML
	private TextField createUsername;
	@FXML
	private TextField createPassword;
	@FXML
	private TextField confirmPassword;
	@FXML
	private TextField Location;
	@FXML
	private DatePicker dob;
	@FXML
	private TextField Age;
	@FXML
	private TextField interests;
	@FXML
	private TextField division;
	@FXML
	private TableView<UserData> userTable;
	@FXML
	private TableColumn<UserData, String> firstNameColumn;
	@FXML
	private TableColumn<UserData, String> lastNameColumn;
	@FXML
	private TableColumn<UserData, String> emailColumn;
	@FXML
	private TableColumn<UserData, String> username_column;
	@FXML
	private TableColumn<UserData, String> passwordColumn;
	@FXML
	private TableColumn<UserData, String> confirmPasswordColumn;
	@FXML
	private TableColumn<UserData, String> locationColumn;
	@FXML
	private TableColumn<UserData, String> dobColumn;
	@FXML
	private TableColumn<UserData, String> ageColumn;
	@FXML
	private TableColumn<UserData, String> interestsColumn;
	@FXML
	private TableColumn<UserData, String> divisionColumn;
	private dbConnection dc;
	
	private ObservableList<UserData> data;
	

	
	private String sql = "SELECT * FROM Users";
	
	public void initialize(URL url, ResourceBundle rb) {
		this.dc = new dbConnection();
	}
	
	@FXML
	private void loadUserData(ActionEvent event) throws SQLException {
		try {
			Connection conn  = dbConnection.getConnection();
			this.data = FXCollections.observableArrayList();
			
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			while(rs.next()) {
				this.data.add(new UserData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
			}
		}catch(SQLException e) {
			System.err.println("Error" + e);
		}
		
		this.username_column.setCellValueFactory(new PropertyValueFactory<UserData, String>("create_username"));
		this.passwordColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("create_password"));
		this.divisionColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("Division"));
		this.confirmPasswordColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("confirm_password"));
		this.firstNameColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("first_name"));
		this.lastNameColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("last_name"));
		this.emailColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("e_mail"));
		this.locationColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("Location"));
		this.dobColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("DOB"));
		this.ageColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("AGE"));
		this.interestsColumn.setCellValueFactory(new PropertyValueFactory<UserData, String>("Interests"));
		
		this.userTable.setItems(null);
		this.userTable.setItems(this.data);
	}
	
	@FXML
	private void addUser(ActionEvent event) {
		String sqlInsert = "INSERT INTO Users (`username`, `password`, `division`, `confirmPassword`, `firstName`, `lastName`, `email`, `location`, `dob`, `age`, `interests`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
		try {
			Connection conn = dbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlInsert);
			
			stmt.setString(1, this.createUsername.getText());
			stmt.setString(2, this.createPassword.getText());
			stmt.setString(3, this.division.getText());
			stmt.setString(4, this.confirmPassword.getText());
			stmt.setString(5, this.firstName.getText());
			stmt.setString(6, this.lastName.getText());
			stmt.setString(7, this.email.getText());
			stmt.setString(8, this.Location.getText());
			stmt.setString(9, this.dob.getEditor().getText());
			stmt.setString(10, this.Age.getText());
			stmt.setString(11, this.interests.getText());

			stmt.execute(); 
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void clearFields(ActionEvent event) {
		firstName.setText("");
		this.lastName.setText("");
		this.email.setText("");
		this.createUsername.setText("");
		this.createPassword.setText("");
		this.confirmPassword.setText("");
		this.Location.setText("");
		this.dob.setValue(null);
		this.Age.setText("");
		this.interests.setText("");
		this.division.setText("");
	}
	
	@FXML
	private MenuItem logOutButton;
	
	@FXML
	public void logOut(ActionEvent event) throws IOException{
		Parent logOutParent = FXMLLoader.load(getClass().getResource("/Login.fxml"));
		Scene logOutLayout = new Scene(logOutParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(logOutLayout); 
		window.show();
	}
	
}
