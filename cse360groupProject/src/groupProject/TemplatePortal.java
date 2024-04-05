package groupProject;

import javafx.scene.*;
import javafx.scene.layout.*;

public class TemplatePortal extends Portal {
	private Account user;
	public Scene createPortal(Account newUser) {
		this.user = newUser;
		//HBox root = new HBox();
		welcomeLbl.setText("Welcome Patient/Doctor/Nurse " + user.getFName());
		
		scene = new Scene(welcomeLbl,1280,720);
		return scene;
	}
}
