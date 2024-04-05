package groupProject;

public class Message {
	private String sender; //username of sender
	private String patient; //username of patient. If patient is the sender, patient==sender
	private String txt;
	public Message(String sender, String patient, String txt) {
		this.sender=sender;
		this.patient = patient;
		this.txt = txt;
	}
	public String getSender() { return sender; }
	public String getPatient() { return patient; }
	public String getMsg() { return txt; }
}
