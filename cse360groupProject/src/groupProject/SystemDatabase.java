//database
package groupProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

//import java.util.HashTable;

public class SystemDatabase implements Serializable{
	private static final long serialVersionUID = 4;
	private Hashtable<String,Account> accounts;				//key is username
	private Hashtable<String,ArrayList<Message>> messages;	//key is username of patient
	public SystemDatabase() {
		accounts = new Hashtable<String,Account>();
		messages = new Hashtable<String,ArrayList<Message>>();
	}
	public void submitMessage(String sender, String patient, String txt) {
		Message newMessage = new Message(sender, patient, txt);
		messages.get(patient).add(newMessage);
	}
	public boolean insertStaff(String username, String password, char role, String fName, String lName) {
		if (accounts.containsKey(username))
			return false;
		else {
			Account a;
			if (role == 'n')
				a = new Nurse(username, password, role, fName, lName);
			else
				a = new Doctor(username, password, role, fName, lName);
			accounts.put(username, a);
		}
		return false;
	}
	public boolean insertPatient(String username, String password, char role, String fName, String lName, String pn, String email, String allergies) {
		if (accounts.containsKey(username))
			return false;
		else {
			Account a = new Patient(username, password, 'p', fName, lName, pn, email, allergies);
			accounts.put(username, a);
		}
		return false;
	}
	public boolean authenticate(String username, String password) {
		return accounts.containsKey(username) && accounts.get(username).getPassword().equals(password);
	}
	public Account getLogin(String username, String password) {
		return accounts.get(username);
	}
	public ArrayList<Message> getMessages(String patientUsername) {
		return messages.get(patientUsername);
	}
}
