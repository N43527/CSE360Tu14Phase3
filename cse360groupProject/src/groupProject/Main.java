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
    	Portal portal = new TemplatePortal();
    	Account user = new Nurse("JaneDoen", "123abc", 'd', "Jane", "Doe");
    	
//    	SystemDatabase database = new SystemDatabase();
//    	database.insertStaff("JaneDoen", "123abc", 'd', "Jane", "Doe");
//    	database.insertStaff("JohnSmith", "123abc", 'n', "John", "Smith");
//    	
//    	FileOutputStream fos = new FileOutputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/database.ser");
//    	ObjectOutputStream oos = new ObjectOutputStream(fos);
//    	oos.writeObject(database);
//    	oos.close();
    	
    	
    	FileInputStream fis = new FileInputStream("/Users/nivedh/eclipse-workspace/CSE360Tu14Phase3/cse360groupProject/src/database.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SystemDatabase database1 = (SystemDatabase) ois.readObject();
        ois.close();
        
        System.out.println(database1.authenticate("0", "00"));
        
    	
    	primaryStage.setScene(loginPage.getScene());
    	primaryStage.show();
    	
    	Button loginSubmitButton = loginPage.getButton();
        Button loginCreateNewButton = loginPage.getCreateNewButton();
    	loginSubmitButton.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	user.update("JaneDoe", "123abc", 'd', "Jane", "Doe");
            	//portal = new TemplatePortal(user);
            	
            	primaryStage.setScene(portal.createPortal(user));
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
//    	Stage stage = new Stage();
//    	stage.show();
    }
}
