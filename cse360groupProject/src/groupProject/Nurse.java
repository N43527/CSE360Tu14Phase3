package groupProject;

import java.io.Serializable;

public class Nurse extends Account implements Serializable {
	private static final long serialVersionUID = 2;
	public Nurse(String _username, String _password, char _role, String _firstName, String _lastName, String _birthday) {
		super(_username, _password, _role, _firstName, _lastName, _birthday);
	}
	public boolean isNurse() {return true;}
}
