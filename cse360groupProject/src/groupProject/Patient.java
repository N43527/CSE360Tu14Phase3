package groupProject;

import java.io.Serializable;
import java.util.ArrayList;

public class Patient extends Account implements Serializable{
	private static final long serialVersionUID = 3;
	private String phoneNumber;
	private String email;
	private ArrayList<String> perscriptions;
	private ArrayList<String> visitHistory;
	private String allergies;
	private String immunizationRecord;
	private ArrayList<Message> messages;
	public Patient(String _username, String _password, char _role, String _firstName, String _lastName, String pn, String email, String allergies) {
		super(_username, _password, _role, _firstName, _lastName);
		this.phoneNumber = pn;
		this.email = email;
		this.allergies = allergies;
		perscriptions = new ArrayList<String>();
		visitHistory = new ArrayList<String>();
		messages = new ArrayList<Message>();
	}
	public void update(String _username, String _password, char _role, String _firstName, String _lastName, String pn, String email, String allergies) {
		super.update(_username, _password, _role, _firstName, _lastName);
		this.phoneNumber = pn;
		this.email = email;
		this.allergies = allergies;
	}
	public void changeContactInfo(String phoneNumber, String email) {
		if (!phoneNumber.isBlank()) this.phoneNumber = phoneNumber;
		if (!email.isBlank()) this.email = email;
	}
	public String getPN() { return phoneNumber; }
	public String getEmail() { return email; }
	public ArrayList<String> getPerscriptions() { return perscriptions; }
	public ArrayList<String> getVisitHistory() { return visitHistory; }
	public String getAllergies() { return allergies; }
	public String getImmunizationRecord() { return immunizationRecord; }
	public ArrayList<Message> getMessages() {return messages;}
}
