//database
package groupProject;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.*;

public class SystemDatabase implements Serializable{
	private static final long serialVersionUID = 4;
	private ArrayList<Account> accounts; //list of all accounts
	private ArrayList<Patient> patients; //list of all patients
	//private ArrayList<ArrayList<Message>> messages; //column is the same as the patient's index in patients
	public SystemDatabase() {
		accounts = new ArrayList<Account>();
		patients = new ArrayList<Patient>();
//		messages = new ArrayList<ArrayList<Message>>();
	}
	public boolean hasUsername(String username) {
		for (Account a:accounts) 
			if (a.getUsername().equals(username)) return true;
		return false;
	}
	public boolean insertStaff(String username, String password, char role, String fName, String lName) {
		if (hasUsername(username))
			return false;
		else {
			Account a;
			if (role == 'n')
				a = new Nurse(username, password, role, fName, lName);
			else
				a = new Doctor(username, password, role, fName, lName);
			a.update(username, password, role, fName, lName);
			accounts.add(a);
			//messages.add(new ArrayList<Message>());
		}
		return false;
	}
	public boolean insertPatient(String username, String password, char role, String fName, String lName, String pn, String email, String allergies) {
		if (hasUsername(username))
			return false;
		else {
			Account a = new Patient(username, password, 'p', fName, lName, pn, email, allergies);
			Patient p = new Patient(username, password, 'p', fName, lName, pn, email, allergies);
			accounts.add(a);
			patients.add(p);
		}
		return false;
	}
//	public int getIndex(String username) {
//		for (int i=0; i<accounts.size(); i++) {
//			if (accounts.get(i).getUsername().equals(username)) return i;
//		}
//		return -1;
//	}
//	public int getPatientIndex(String username) {
//		for (int i=0; i<patients.size(); i++) {
//			if (patients.get(i).getUsername().equals(username)) return i;
//		}
////		for (Account p:patients) 
////			if p.getUsername().equals(username) return true;
//		return -1;
//	}
	public boolean authenticate(String username, String password) {
		for (Account a:accounts) 
			if (a.getUsername().equals(username) && a.getPassword().equals(password)) return true;
		return false;
	}
	public Account getLogin(String username, String password) {
		for (Account a:accounts) 
			if (a.getUsername().equals(username) && a.getPassword().equals(password)) return a;
		return new Account();
	}
	public ArrayList<Message> getMessages(String patientUsername) {
//		return messages.get(getPatientIndex(patientUsername));
		return getPatient(patientUsername).getMessages();
	}
	private Account getAccount(String username) {
		for (Account a:accounts) 
			if (a.getUsername().equals(username)) return a;
		return null;
	}
	public Patient getPatient(String username) {
		for (Patient p:patients) 
			if (p.getUsername().equals(username)) return p;
		return null;
	}
	public void submitMessage(String sender, String patient, String txt) { //sender and patient are usernames
		Message newMessage = new Message(getAccount(sender), getAccount(patient), txt);
//		messages.get(getPatientIndex(patient)).add(newMessage);
		getMessages(patient).add(newMessage);
	}
//	public boolean authenticate(String username, String password) {
//		return accounts.containsKey(username) && accounts.get(username).getPassword().equals(password);
//	}
//	public Account getLogin(String username, String password) {
//		return accounts.get(username);
//	}
//	public ArrayList<Message> getMessages(String patientUsername) {
//		return messages.get(patientUsername);
//	}
}
