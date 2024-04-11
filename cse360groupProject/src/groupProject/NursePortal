package groupProject;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class nursePortal extends Portal {
    private Account user;

    public Scene createPortal(Account newUser) {
        this.user = newUser;
        
        GridPane pane = new GridPane();
        pane.setHgap(1);


        Label wlcme = new Label("Welcome Nurse " + user.getFName() + " " + user.getLName());
        
        wlcme.setFont(new Font("Arial", 24));
        pane.add(wlcme, 1, 0,1,1);
        wlcme.setAlignment(Pos.CENTER);
        
        Label checkIn = new Label("Initial Check-in Information");
        GridPane.setHalignment(checkIn, HPos.CENTER);
        pane.add(checkIn, 1, 4,1,1);
        
        Label name = new Label("Name: ");
        pane.add(name, 1, 5, 1, 1);
        
        TextField nameInfo = new TextField();
        pane.add(nameInfo, 1, 6, 1, 1);
        
        Label weight = new Label("Weight: ");
        pane.add(weight, 1, 7, 1, 1);
        
        TextField weightInfo = new TextField();
        pane.add(weightInfo, 1, 8, 1, 1);
        
        Label wLabel = new Label(" lbs");
        pane.add(wLabel, 2, 8,1,1);
        
        Label Height = new Label("Height: ");
        pane.add(Height, 1, 9,1,1);
        
        TextField heightInfo = new TextField();
        pane.add(heightInfo, 1, 10,1,1);
        
        Label hLabel = new Label(" inches");
        pane.add(hLabel, 2, 10,1,1);
        
        Label temp = new Label("Temperature: ");
        pane.add(temp, 1, 11, 1, 1);
        
        TextField tempInfo = new TextField();
        pane.add(tempInfo, 1, 12, 1, 1);
        
        Label tLabel = new Label(" °F");
        pane.add(tLabel, 2, 12);
        
        Label bloodP = new Label("Blood Pressure: ");
        pane.add(bloodP, 1, 13, 1, 1);
        
        TextField bloodPInfo = new TextField();
        pane.add(bloodPInfo, 1, 14, 1, 1);
        
        Label isUnder12 = new Label("Age");
        pane.add(isUnder12, 1, 15);
        
        CheckBox isUnder12Info = new CheckBox("Age Under 12");
        pane.add(isUnder12Info, 1, 16);

        Label misc = new Label("Miscellaneous: ");
        pane.add(misc, 1, 17, 1, 1);
        
        TextArea miscInfo = new TextArea();
        pane.add(miscInfo, 1, 18, 1, 1);
        
        Label symptoms = new Label("Symptoms: ");
        pane.add(symptoms, 1, 19);
        symptoms.setAlignment(Pos.CENTER);
        
        TextArea symptomInfo = new TextArea();
        pane.add(symptomInfo, 1, 20);
        
        Button submitInfo = new Button("Submit Check-In Information");
        GridPane.setHalignment(submitInfo, HPos.CENTER);
        pane.add(submitInfo, 1, 21);
        
        Button messageButton = new Button("Message");
        GridPane.setHalignment(messageButton, HPos.CENTER);
        pane.add(messageButton, 1, 29);
        
        Button logoutButton = new Button("Logout");
        GridPane.setHalignment(logoutButton, HPos.CENTER);
        pane.add(logoutButton, 1, 30);
        
        Label currentPrescriptions  = new Label("Current Prescriptions");
        pane.add(currentPrescriptions, 6, 3);
        
        TextArea prescriptionInfo = new TextArea();
        pane.add(prescriptionInfo, 6, 4);
        
        Label vacHistory = new Label("Vaccination History");
        pane.add(vacHistory, 6, 6);
        
        TextArea vacInfo = new TextArea();
        pane.add(vacInfo, 6, 7);
        
        Label visitHistory = new Label("Visit History");
        pane.add(visitHistory, 6, 8);
        
        TextArea visitInfo = new TextArea();
        pane.add(visitInfo, 6, 9);
        
        Label allergyExist = new Label("Known Allergies");
        pane.add(allergyExist, 6, 11);
        
        TextArea allergyExistInfo = new TextArea();
        pane.add(allergyExistInfo, 6, 12);
        
        Label healthInfo = new Label("Health Concerns Information");
        GridPane.setHalignment(healthInfo, HPos.CENTER);
        pane.add(healthInfo, 6, 14);
        
        Label healthConcern = new Label("Health Concerns");
        pane.add(healthConcern, 6, 15);
        
        TextArea concernInfo = new TextArea();
        pane.add(concernInfo, 6, 16);
        
        Label allergyNew = new Label("Allergy Information");
        pane.add(allergyNew, 6, 17);
        
        TextArea allergyNewInfo = new TextArea();
        pane.add(allergyNewInfo, 6, 18);
        
        
        Button submitConcern = new Button("Submit Concerns");
        GridPane.setHalignment(submitConcern, HPos.CENTER);
        pane.add(submitConcern, 6, 20);
        
        isUnder12Info.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		if (isUnder12Info.isSelected()) {
        			System.out.println("The patient is under the age of 12");
        		}
        		
        		else {
        			System.out.println("The patient is above the age of 12");
        		}
        	}
        });
        	
        
       submitInfo.setOnAction(new EventHandler<ActionEvent>() {
    	   @Override
    	   public void handle(ActionEvent event) {
    		   //database
    		   
    		   
    	   }
    	   
       });
       
       submitInfo.setOnAction(new EventHandler<ActionEvent>() {
    	   @Override
    	   public void handle(ActionEvent event) {
    		   //date time
    	   }
       });
       
       messageButton.setOnAction(new EventHandler<ActionEvent>() {
    	   @Override
    	   public void handle(ActionEvent event) {
    		   //msg
    	   }
       });
       
       logoutButton.setOnAction(new EventHandler<ActionEvent>() {
    	   @Override
    	   public void handle(ActionEvent event) {
    		   //logout
    	   }
       });
       
       submitConcern.setOnAction(new EventHandler<ActionEvent>() {
    	   @Override
    	   public void handle(ActionEvent event) {
    		   //submit a concern
    		   
    	   }
       });
        
        pane.setHgap(5);
        pane.setVgap(0);
        
        pane.setPadding(new Insets(5,10,5,10));
        

        Scene scene = new Scene(pane, 800, 600);
        return scene;
            }
        
}
