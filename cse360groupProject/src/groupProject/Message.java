package groupProject;

import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = 12312312;
	private Account sender; //username of sender
	private Account patient; //username of patient. If patient is the sender, patient==sender
	private String txt;
	public Message(Account sender, Account patient, String txt) {
		this.sender=sender;
		this.patient = patient;
		this.txt = txt;
	}
	public Account getSender() { return sender; }
	public Account getPatient() { return patient; }
	public String getMsg() { return txt; }
}
