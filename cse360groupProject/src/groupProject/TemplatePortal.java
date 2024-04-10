package groupProject;

import java.io.*;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.layout.*;

public class TemplatePortal extends Portal {
	private Account user;
	
	public Scene createPortal(Account newUser)  {
		SystemDatabase database;
		try {
			FileInputStream fis = new FileInputStream("database.ser");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    database = (SystemDatabase) ois.readObject();
		    ois.close();
		    this.user = newUser;
			//HBox root = new HBox();
			welcomeLbl.setText("Welcome Patient/Doctor/Nurse " + user.getFName());
			System.out.println(newUser.getUsername());
			MessageBox box = new MessageBox(database.getMessages(newUser.getUsername()));
			scene = new Scene(box.getBox(),1280,720);
			box.getButton().setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	            	System.out.println("button");
	            	database.submitMessage(newUser.getUsername(), newUser.getUsername(), box.getMessageSent());
	            	
	            	try {
	            	FileOutputStream fos = new FileOutputStream("database.ser");
	            	ObjectOutputStream oos = new ObjectOutputStream(fos);
	            	oos.writeObject(database);
	            	oos.close(); }
	            	catch(FileNotFoundException e) {
	        			// TODO Auto-generated catch block
	        			e.printStackTrace();
	        		} catch (IOException e) {
	        			// TODO Auto-generated catch block
	        			e.printStackTrace();
	        		} 
	            
	            	
	            	box.getMsgField().setText("");
	            	box.createBox(database.getMessages(newUser.getUsername()));
	            	scene = new Scene(box.getBox(),1280,720);
	            }
	        });
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
}
