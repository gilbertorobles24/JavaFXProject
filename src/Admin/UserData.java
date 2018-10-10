package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserData {
	private final StringProperty first_name;
	private final StringProperty last_name;
	private final StringProperty e_mail;
	private final StringProperty create_username;
	private final StringProperty create_password;
	private final StringProperty confirm_password;
	private final StringProperty Location;
	private final StringProperty DOB;
	private final StringProperty AGE;
	private final StringProperty Interests;
	private final StringProperty Division;
	
	public UserData(String createUsername, String createPassword, String division, String confirmPassword, String firstName, String lastName, String email, String location, String dob, String age, String interests) {
		this.create_username = new SimpleStringProperty(createUsername);
		this.create_password = new SimpleStringProperty(createPassword);
		this.Division = new SimpleStringProperty(division);
		this.confirm_password = new SimpleStringProperty(confirmPassword);
		this.first_name = new SimpleStringProperty(firstName);
		this.last_name = new SimpleStringProperty(lastName);
		this.e_mail = new SimpleStringProperty(email);
		this.Location = new SimpleStringProperty(location);
		this.DOB = new SimpleStringProperty(dob);
		this.AGE = new SimpleStringProperty(age);
		this.Interests = new SimpleStringProperty(interests);
	}

	public String getFirst_name() {
		return (String)this.first_name.get();
	}

	public String getLast_name() {
		return (String)this.last_name.get();
	}

	public String getE_mail() {
		return (String)this.e_mail.get();
	}

	public String getCreate_username() {
		return (String)this.create_username.get();
	}

	public String getCreate_password() {
		return (String)this.create_password.get();
	}

	public String getConfirm_password() {
		return (String)this.confirm_password.get();
	}
	
	public String getLocation() {
		return (String)this.Location.get();
	}

	public String getDOB() {
		return (String)this.DOB.get();
	}
	
	public String getAGE() {
		return (String)this.AGE.get();
	}

	public String getInterests() {
		return (String)this.Interests.get();
	}
	
	public String getDivision() {
		return (String)this.Division.get();
	}
	
	public void setfirstName(String value) {
		this.first_name.set(value);
	}
	
	public void setlastName(String value) {
		this.last_name.set(value);
	}
	
	public void setemail(String value) {
		this.e_mail.set(value);
	}
	
	public void setUsername(String value) {
		this.create_username.set(value);
	}
	
	public void setPassword(String value) {
		this.create_password.set(value);
	}
	
	public void setConfirmPassword(String value) {
		this.confirm_password.set(value);
	}
	
	public void setLocation(String value) {
		this.Location.set(value);
	}
	
	public void setDOB(String value) {
		this.DOB.set(value);
	}
	
	public void setAge(String value) {
		this.AGE.set(value);
	}
	
	public void setInterests(String value) {
		this.Interests.set(value);
	}
	
	public void setDivision(String value) {
		this.Division.set(value);
	}
}

