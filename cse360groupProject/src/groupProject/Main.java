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
        
//        doctorPortal.getsubmitFormButton().setOnAction(new EventHandler<>() {
//            public void handle(ActionEvent event) {
//              // update the user's info
//            }
//        });
//    	Stage stage = new Stage();
//    	stage.show();
    }
}
