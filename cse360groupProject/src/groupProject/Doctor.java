package groupProject;

import java.io.Serializable;

public class Doctor extends Account implements Serializable {
	private static final long serialVersionUID = 1;
	public Doctor(String _username, String _password, char _role, String _firstName, String _lastName) {
		super(_username, _password, _role, _firstName, _lastName);
	}
	public boolean isDoctor() {return true;}
}

