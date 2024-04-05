//database
package groupProject;

import java.io.Serializable;
import java.util.Hashtable;

//import java.util.HashTable;

public class SystemDatabase implements Serializable{
	private static final long serialVersionUID = 4;
	private Hashtable<String,Account> accounts;
	public SystemDatabase() {
		accounts = new Hashtable<String,Account>();
	}
	public boolean insertStaff(String username, String password, char role, String fName, String lName) {
		if (accounts.containsKey(username+" "+password))
			return false;
		else {
			Account a;
			if (role == 'n')
				a = new Nurse(username, password, role, fName, lName);
			else
				a = new Doctor(username, password, role, fName, lName);
			accounts.put(username + " " + password, a);
		}
		return false;
	}
	public boolean insertPatient(String username, String password, char role, String fName, String lName, String pn, String email, String allergies) {
		if (accounts.containsKey(username+" "+password))
			return false;
		else {
			Account a = new Patient(username, password, 'p', fName, lName, pn, email, allergies);
			accounts.put(username + " " + password, a);
		}
		return false;
	}
	
	public boolean authenticate(String username, String password) {
		return accounts.containsKey(username + " " + password);
	}
	public Account getLogin(String username, String password) {
		return accounts.get(username + " " + password);
	}
}
