package groupProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//TODO: make sure username is at least 3 characters no more than 32, no spaces
// password: 1 character no more than 32

public class createNewAccountPage {
	private Scene scene;
	private Button signUpButton;
	private TextField usernameField;
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField emailField;
	private TextField phoneNumberField;
	private PasswordField passField;
	private PasswordField confirmPassField;
	private Label errMsg;
	
	public createNewAccountPage() throws IOException {
		  Label heading = new Label("Tempe Pediatric Center");
		  heading.setFont(Font.font("Arial", FontWeight.BOLD, 15));
	      heading.setTextFill(javafx.scene.paint.Color.RED);
	      heading.setUnderline(true);
	      
	      Label emailLabel = new Label("Email");
	      Label phoneNumberLabel = new Label("Phone Number");
	      Label usernameLabel = new Label("Username");
	      Label passLabel = new Label("Password");
	      Label confirmPassLabel = new Label("Confirm Password");
	      
	      Label firstNameLabel = new Label("First Name");
	      firstNameLabel.setAlignment(Pos.CENTER_LEFT);
	      Label lastNameLabel = new Label("Last Name");
	      lastNameLabel.setAlignment(Pos.CENTER_LEFT);
	      
	      emailField = new TextField();
	      emailField.setPrefWidth(100);
	      emailField.setPrefHeight(20);
	      phoneNumberField = new TextField();
	      phoneNumberField.setPrefWidth(100);
	      phoneNumberField.setPrefHeight(20);
	      usernameField = new TextField();
	      firstNameField = new TextField();
	      firstNameField.setPrefWidth(100);
	      firstNameField.setPrefHeight(20);
	      lastNameField = new TextField();
	      lastNameField.setPrefWidth(100);
	      lastNameField.setPrefHeight(20);
	      passField = new PasswordField();
	      confirmPassField = new PasswordField();
	               
	      Image image = new Image(new FileInputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/groupProject/TPClogo.png"));
	      ImageView imageView = new ImageView(image);
	      imageView.setPreserveRatio(true);
	      imageView.setFitWidth(200);
	      imageView.setImage(image);
	      
	      VBox firstField = new VBox(5);
	      firstField.getChildren().addAll(firstNameLabel, firstNameField);
	      
	      VBox lastField = new VBox(5);
	      lastField.getChildren().addAll(lastNameLabel, lastNameField);
	      HBox firstLastField = new HBox(50);
	      firstLastField.getChildren().addAll(firstField,lastField);
	      firstLastField.setAlignment(Pos.CENTER);
	      
	      
	      VBox leftHeadings = new VBox(15);
	      leftHeadings.getChildren().addAll(emailLabel, phoneNumberLabel, usernameLabel, passLabel, confirmPassLabel);
	      
	      VBox rightHeadings = new VBox(5);
	      rightHeadings.getChildren().addAll(emailField, phoneNumberField, usernameField, passField, confirmPassField);
	      
	      
	      HBox userPassConfirm = new HBox(5);
	      userPassConfirm.getChildren().addAll(leftHeadings, rightHeadings);
	      userPassConfirm.setAlignment(Pos.CENTER);
	      
	      signUpButton = new Button("Sign Up");
	      signUpButton.setAlignment(Pos.CENTER_RIGHT);
	      
	   // Set up event handler for sign up button
	        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                // Call authenticate() method when sign up button is pressed
	            	if(createNewAuthenticate()) {
	            		try {
	            		FileInputStream fis = new FileInputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/database.ser");
	                    ObjectInputStream ois = new ObjectInputStream(fis);
	                    SystemDatabase database = (SystemDatabase) ois.readObject();
	                    ois.close();
	            		String username = usernameField.getText();
	            		String firstName = firstNameField.getText();
	            		String lastName = lastNameField.getText();
	            		String password = passField.getText();
	            		String email = emailField.getText();
	            		String pn = phoneNumberField.getText();
	            		database.insertPatient(username, password, 'p', firstName, lastName, pn, email, "");
                        FileOutputStream fos = new FileOutputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/database.ser");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
	                    oos.writeObject(database);
	                    oos.close();
	            		} catch(IOException ex){
	            			ex.printStackTrace();
	            		} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            	}
	            }
	        });
	      
	      errMsg = new Label();
	      errMsg.setTextFill(Color.RED);
	      
	      VBox root = new VBox(10);
	      root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

	      errMsg = new Label();
	      errMsg.setTextFill(Color.RED);
	      
	      root.getChildren().addAll(imageView, heading, firstLastField, userPassConfirm, signUpButton, errMsg);
	      root.setAlignment(Pos.CENTER);
	      root.setPadding(new Insets(20, 20, 20, 20));
	      
	      scene = new Scene(root, 400, 600);
    }
	public Scene getScene() {return scene;}
	
	public boolean createNewAuthenticate() {
  		//TODO: find stuff in authentication database
  		if (firstNameField.getText().isBlank() || passField.getText().isBlank() 
  				|| emailField.getText().isBlank() || phoneNumberField.getText().isBlank()
  				|| usernameField.getText().isBlank() || lastNameField.getText().isBlank()
  				|| confirmPassField.getText().isBlank()) {
  			errMsg.setText("A field is empty!");
  			return false;
  		}
  		if (!passField.getText().equals(confirmPassField.getText())) {
  			errMsg.setText("Passwords do not match!");
  			return false;
  		}
  		
  		errMsg.setText("");
  		return true;
      }
	
	//instance of database
	//verify all fields are filled, error message: not all fields filled
	//direct to patient portal
	
	
	
}