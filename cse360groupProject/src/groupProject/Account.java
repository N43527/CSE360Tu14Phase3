package groupProject;

public class Account {
	private String username;
	private String password;
	private char role;
	public String fName;
	public String lName;
	public Account (String _username, String _password, char _role, String _firstName, String _lastName) {
		username = _username;
		password = _password;
		role = _role;
		fName = _firstName;
		lName = _lastName;
	}
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public boolean isNurse() { return role=='n'; }
	public boolean isDoctor() { return role=='d'; }
	public boolean isPatient() { return role=='p'; }
}
