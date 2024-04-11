//ASU CSE 360 phase 3 spring2024
// Adrian Zhang
// Description: Controller for the system

package groupProject;

import java.io.*;
import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {

    	LoginPage loginPage = new LoginPage();
        createNewAccountPage createNewAccountPage = new createNewAccountPage();
    	//Portal portal = new Portal();
    	DoctorPortal doctorPortal = new DoctorPortal();
    	NursePortal nursePortal = new NursePortal();
    	PatientPortal patientPortal = new PatientPortal();
//    	Account user = new Nurse("JaneDoe", "123abc", 'd', "Jane", "Doe", "May 4, 1999");
    	
//    	SystemDatabase database = new SystemDatabase();
//    	database.insertStaff("JaneDoe", "123abc", 'd', "Jane", "Doe", "May 4 1998");
//    	database.insertStaff("JohnSmith", "123abc", 'n', "John", "Smith", "May 4 1997");
//    	
//    	FileOutputStream fos = new FileOutputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/database.ser");
//    	ObjectOutputStream oos = new ObjectOutputStream(fos);
//    	oos.writeObject(database);
//    	oos.close();
    	
    	
    	FileInputStream fis = new FileInputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/database.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SystemDatabase database = (SystemDatabase) ois.readObject();
        ois.close();
        
        System.out.println(database.authenticate("JaneDoe", "123abc"));
        
    	
    	primaryStage.setScene(loginPage.getScene());
    	primaryStage.show();
    	
    	Button loginSubmitButton = loginPage.getButton();
        Button loginCreateNewButton = loginPage.getCreateNewButton();
        
//        Button submitForm = doctorPortal.getsubmitFormButton();
        Button getsubmitprescriptionButton = doctorPortal.getsubmitprescriptionButton();
        Button getsubmitrecommendationsButton = doctorPortal.getsubmitrecommendationsButton();
        Button getmessageButton = doctorPortal.getmessageButton();
        
    	loginSubmitButton.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
//            	user.update("JaneDoe", "123abc", 'd', "Jane", "Doe", "May 4, 1999");
            	Account newUser = null;
            	try {
            		if (!loginPage.authenticate()) {
            			return;
            		}
					newUser = loginPage.getLogin();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	//portal = new TemplatePortal(user);
              System.out.println(newUser.getRole());
              switch(newUser.getRole()) {
              case 'd':
                  primaryStage.setScene(doctorPortal.createPortal(newUser));
                  break;
              case 'n':
                  primaryStage.setScene(nursePortal.createPortal(newUser));
                  break;
              case 'p':
                  primaryStage.setScene(patientPortal.createPortal(newUser));
                  break;
              }
//            	primaryStage.setScene(doctorPortal.createPortal(newUser));
            	primaryStage.centerOnScreen();
//            	loginPage.autheticna()
//            	primaryStage.setScene(null);
            }
        });
        loginCreateNewButton.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
              primaryStage.setScene(createNewAccountPage.getScene());
              primaryStage.centerOnScreen();
            }
        });
        
        
        getsubmitrecommendationsButton.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
//            	System.out.println("hi");
              // update the user's info
            	String username = "";
            	try {
            	username = doctorPortal.getName();
            	FileInputStream fis = new FileInputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/database.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                SystemDatabase database = (SystemDatabase) ois.readObject();
                ois.close();
            	} catch (IOException ex){
            		
            	} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	Patient patient = database.getPatient(username);
            	patient.updateVaccinations(doctorPortal.getRecommendations());
            	
            	doctorPortal.setVaccinations(doctorPortal.getRecommendations());
            	
            	try { 
            	FileOutputStream fos = new FileOutputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/database.ser");
            	ObjectOutputStream oos = new ObjectOutputStream(fos);
            	oos.writeObject(database);
            	oos.close();
            	} 
            	catch (IOException ex){
            		
            	}
            }
        });
        
        getsubmitprescriptionButton.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
//            	System.out.println("hi");
              // update the user's info
            	String username = "";
            	try {
            	username = doctorPortal.getName();
            	FileInputStream fis = new FileInputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/database.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                SystemDatabase database = (SystemDatabase) ois.readObject();
                ois.close();
            	} catch (IOException ex){
            		
            	} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	Patient patient = database.getPatient(username);
            	String prescription = "";
            	prescription += doctorPortal.getName() + " ";
            	prescription += doctorPortal.getPurpose() + " ";
            	prescription += doctorPortal.getDosage() + " ";
            	prescription += doctorPortal.getStart() + " ";
            	prescription += doctorPortal.getEnd() + " ";
            	prescription += doctorPortal.getInstruction() + " ";
            	patient.updatePrescription(prescription);
            	
            	patient.updateVisits(doctorPortal.getPhysTest());
            	
            	doctorPortal.setPrescription(prescription);
            	doctorPortal.setVisit(doctorPortal.getPhysTest());
            	
            	try { 
            	FileOutputStream fos = new FileOutputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/database.ser");
            	ObjectOutputStream oos = new ObjectOutputStream(fos);
            	oos.writeObject(database);
            	oos.close();
            	} 
            	catch (IOException ex){
            		
            	}
            }
        });
//    	Stage stage = new Stage();
//    	stage.show();
    }
}
