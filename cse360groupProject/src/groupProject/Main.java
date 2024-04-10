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
    	Account user = new Nurse("JaneDoe", "123abc", 'd', "Jane", "Doe");
//    	
//    	SystemDatabase database = new SystemDatabase();
//    	database.insertStaff("JaneDoe", "123abc", 'd', "Jane", "Doe");
//    	database.insertStaff("JohnSmith", "123abc", 'n', "John", "Smith");
//    	
//    	FileOutputStream fos = new FileOutputStream("database.ser");
//    	ObjectOutputStream oos = new ObjectOutputStream(fos);
//    	oos.writeObject(database);
//    	oos.close();
    	
    	
//    	FileInputStream fis = new FileInputStream("database.ser");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        SystemDatabase database = (SystemDatabase) ois.readObject();
//        ois.close();
        
//        System.out.println(database.authenticate("JaneDoe", "123abc"));
        
    	
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
65
            public void handle(ActionEvent event) {
66
              primaryStage.setScene(createNewAccountPage.getScene());
67
              primaryStage.centerOnScreen();
68
            }
69
        });
//    	Stage stage = new Stage();
//    	stage.show();
    }
}
