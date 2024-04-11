//desc: login page view

package groupProject;


//import java.awt.Color;
import java.io.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
//import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
//import javafx.stage.Stage;
 

public class LoginPage {
	private Scene scene;
	private Button submitButton;
	private Button createNewButton;
	private TextField userField;
	private PasswordField passField;
	private Label errMsg;
	private SystemDatabase database;
	public LoginPage() throws IOException {
      Label userLabel = new Label("Username:");
      Label passLabel = new Label("Password:");
      
      userField = new TextField();
      passField = new PasswordField();
               
      Image image = new Image(new FileInputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/groupProject/TPCLogo.png"));
      ImageView imageView = new ImageView(image);
      imageView.setPreserveRatio(true);
      imageView.setFitWidth(200);
      
      HBox userSection = new HBox(5);
      userSection.getChildren().addAll(userLabel,userField);
      HBox passSection = new HBox(5);
      passSection.getChildren().addAll(passLabel,passField);
      passSection.setAlignment(Pos.CENTER);
      userSection.setAlignment(Pos.CENTER);
      
      submitButton = new Button("Login");
      createNewButton = new Button("I Don't Have An Account");
      Label rememberInfoLabel = new Label("Remember my Login");
      CheckBox rememberInfoCheck = new CheckBox();
      HBox rememberSection = new HBox(20);
      rememberSection.getChildren().addAll(rememberInfoLabel,rememberInfoCheck,submitButton);
      rememberSection.setAlignment(Pos.CENTER);
      
      VBox root = new VBox(10);
      root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

      errMsg = new Label();
      errMsg.setTextFill(Color.RED);
      
      root.getChildren().add(imageView);
      root.getChildren().addAll(userSection,passSection,rememberSection, createNewButton, errMsg);
      root.setAlignment(Pos.CENTER);
      root.setPadding(new Insets(20, 20, 20, 20));
      
      scene = new Scene(root, 500, 400);
      
      FileOutputStream fos = new FileOutputStream("database.ser");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
	  oos.writeObject(database);
	  oos.close();
      
	}
	public Scene getScene() {return scene;}
	public Button getButton() {return submitButton;}
	public Button getCreateNewButton() {return createNewButton;}
	public boolean authenticate() {
		//: find stuff in authentication database
		if (userField.getText().isBlank() || passField.getText().isBlank()) {
			errMsg.setText("Username or password is empty!");
			return false;
		}
		if (!database.authenticate(userField.getText(), passField.getText())) {
			errMsg.setText("Username or password is invalid!");
			return false;
		}
		errMsg.setText("");
		return true;
	}
	public Account getLogin() throws IOException, ClassNotFoundException {
		// get account info from authentication database
    	FileInputStream fis = new FileInputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/database.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SystemDatabase database = (SystemDatabase) ois.readObject();
        ois.close();
		return database.getLogin(userField.getText(), passField.getText());
	}
	
}
