package groupProject;

import javafx.scene.*;
import javafx.scene.control.*;

public class Portal {
	private Button logOutBttn;
	private Label welcomeLbl;
	private Scene scene;
	public Portal() {
		logOutBttn = new Button();
		welcomeLbl = new Label("Welcome");
	}
	public Scene getScene() { return scene; }
	public Button getLogOutButton() { return logOutBttn; }
	public void setText(String msg) { welcomeLbl.setText(msg); }
}
