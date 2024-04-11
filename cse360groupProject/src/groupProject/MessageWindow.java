package groupProject;

import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MessageWindow {
	private Account user;
	private Scene scene;
	private ComboBox<String> selectPatients;
	private Button submitButton;
	private MessageBox box;
	private Label welcomeLabel;
	VBox root;
	
	public MessageWindow() {
		box = new MessageBox();
		submitButton = new Button("Submit Message");
	}
	
	public Scene createMessageWindow(Account newUser)  {
//		box = new MessageBox();
		SystemDatabase database;
		try {
			FileInputStream fis = new FileInputStream("database.ser");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    database = (SystemDatabase) ois.readObject();
		    ois.close();
		    
		    this.user = newUser;
		    
			root = new VBox();
			welcomeLabel = new Label();
	    	welcomeLabel.setFont(new Font("Arial", 24));
	    	welcomeLabel.setAlignment(Pos.CENTER);
	    	root.getChildren().add(welcomeLabel);
	    	
			if (user.getRole()=='p') {
				welcomeLabel.setText("Message Doctors");
				box.createBox(database.getMessages(newUser.getUsername()));
				root.getChildren().addAll(box.getBox());				
			}
			else {
				welcomeLabel.setText("Message Patients");
				selectPatients = new ComboBox<String>();
			    for (Patient p:database.getPatients()) 
			    	selectPatients.getItems().add(p.getUsername()+": "+p.getFName()+" "+p.getLName());
			    
			    root.getChildren().addAll(selectPatients,box.getBox());			    
			}
			root.getChildren().add(submitButton);
			
			
			scene = new Scene(root,600,720);
//			scene = new Scene(box.getBox(),1280,720);
//			
//			box.getButton().setOnAction(new EventHandler<>() {
//	            public void handle(ActionEvent event) {
//	            	System.out.println("button");
//	            	database.submitMessage(newUser.getUsername(), newUser.getUsername(), box.getMessageSent());
//	            	
//	            	try {
//	            	FileOutputStream fos = new FileOutputStream("database.ser");
//	            	ObjectOutputStream oos = new ObjectOutputStream(fos);
//	            	oos.writeObject(database);
//	            	oos.close(); }
//	            	catch(FileNotFoundException e) {
//	        			// TODO Auto-generated catch block
//	        			e.printStackTrace();
//	        		} catch (IOException e) {
//	        			// TODO Auto-generated catch block
//	        			e.printStackTrace();
//	        		}
//	            	
//	            	box.getMsgField().setText("");
//	            	box.createBox(database.getMessages(newUser.getUsername()));
//	            	
//	            	root.getChildren().add(selectPatients);
//	            	
//	            	scene = new Scene(root,1280,720);
//	            }
//	        });
		}
		catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return scene;	
	}
	public Scene getScene() {return scene;}
	public Button getSubmitButton() {return submitButton;}
	public Account getUser() {return user;}
	public ComboBox getComboBox() {return selectPatients;}
	public String getSelectedPatientUsername() {
		if (user.getRole() != 'p') {
			String val = selectPatients.getValue();
			return val.split(":")[0];
		}
		else return user.getUsername();
	}
	public String getMessageSent() { return box.getMessageSent();}
	//public ComboBox getComboBox() {return 
	public void update(Message m) {
		box.addMessage(m);
	}
	
}
