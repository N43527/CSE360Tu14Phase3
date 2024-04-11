package groupProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PatientPortal extends Portal {
	
	private Account user;
	
    public Scene createPortal(Account newUser) {
    	this.user = newUser;
    
    	GridPane pane = new GridPane();

    	Label welcomeLabel = new Label("Welcome Patient " + user.getFName() + " " + user.getLName());
    
    	welcomeLabel.setFont(new Font("Arial", 24));
    	pane.add(welcomeLabel, 1, 0,1,1);
    	welcomeLabel.setAlignment(Pos.CENTER);
    	
    	
    	Label name = new Label("Name: " + user.getFName() + " " + user.getLName());
    	pane.add(name, 1, 2);
    	
    	Label birthday = new Label("Birthday: " + user.getBirthday());
    	pane.add(birthday, 1, 3);
    	
    	Label pharmacy = new Label("Pharmacy: Pharmacy B");
    	pane.add(pharmacy, 1, 4);
    	
    	Label insurance = new Label("Insurance: State Farm");
    	pane.add(insurance, 1, 5);
    	
    	//Button changeContact = new Button("Change Contact Info.");
    	
    	Text currentprescriptions = new Text("Current Prescriptions: ");
        currentprescriptions.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        pane.add(currentprescriptions,1,8,1,1);
        
        TextArea currentprescriptionsbox = new TextArea();
        currentprescriptionsbox.setPrefHeight(50);
        currentprescriptionsbox.setPrefWidth(50);
        pane.add(currentprescriptionsbox, 1, 9,1,1);
        
        
        Text visithistory = new Text("Visit History: ");
        visithistory.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        pane.add(visithistory,1,11,1,1);
		
        TextArea visithistorybox = new TextArea();
        visithistorybox.setPrefHeight(50);
        visithistorybox.setPrefWidth(50);
        pane.add(visithistorybox, 1, 12,1,1);
        
        Text messagePortal = new Text("Message ");
        messagePortal.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        pane.add(messagePortal,6,3);
		
        TextArea messagePortalText = new TextArea();
        //messagePortalText.setPrefHeight(50);
        //messagePortalText.setPrefWidth(50);
        pane.add(messagePortalText, 6, 4);
        
        
        
    	
    	


    	
    	
    	
    	Scene scene = new Scene(pane, 800, 600);
        return scene;
    	
    }

}
