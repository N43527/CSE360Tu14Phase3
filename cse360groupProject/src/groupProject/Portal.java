package groupProject;

import javafx.scene.*;
import javafx.scene.control.*;

public class Portal {
	protected Button logOutBttn;
	protected Label welcomeLbl;
	protected Scene scene;
	public Portal() {
		logOutBttn = new Button();
		welcomeLbl = new Label("Welcome");
	}
	public Scene createPortal(Account user) {
		return scene;
	}
	public Scene getScene() { return scene; }
	public Button getLogOutButton() { return logOutBttn; }
	public void setText(String msg) { welcomeLbl.setText(msg); }
}
