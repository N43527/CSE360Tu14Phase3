package groupProject;

import java.io.Serializable;

public class Account implements Serializable{
	private static final long serialVersionUID = 48998765;
	private String username;
	private String password;
	private char role;
	public String fName;
	public String lName;
	public Account () {
		username = null;
		password = null;
		role = 'u'; //u for undefined
		fName = null;
		lName = null;
	}
	public Account (String _username, String _password, char _role, String _firstName, String _lastName, String _birthday) {
		username = _username;
		password = _password;
		role = _role;
		fName = _firstName;
		lName = _lastName;
		birthday = _birthday;
	}
	public void update(String _username, String _password, char _role, String _firstName, String _lastName, String _birthday) {
		username = _username;
		password = _password;
		role = _role;
		fName = _firstName;
		lName = _lastName;
		birthday = _birthday;
	}
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public char getRole() { return role; }
	public String getFName() { return fName; }
	public String getLName() { return lName; }
	public String getBirthday() { return birthday; }
	public boolean isNurse() { return role=='n'; }
	public boolean isDoctor() { return role=='d'; }
	public boolean isPatient() { return role=='p'; }
}
