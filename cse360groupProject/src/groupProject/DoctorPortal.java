package groupProject;



import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DoctorPortal extends Portal {
	private Account user;
	public Scene createPortal(Account newUser) {
		this.user = newUser;
		
		
		
		GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        
		//HBox root = new HBox();
		Text welcome = new Text("Welcome Doctor " + user.getFName());
        welcome.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        grid.add(welcome,1,0,1,1);
        welcome.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        
        
        Text physicaltest = new Text("Enter the physical test results below: ");
        physicaltest.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(physicaltest,1,5,1,1);
        
        TextField physicaltestbox = new TextField();
        grid.add(physicaltestbox, 1, 6,1,1);
        
        Button submitform = new Button("Submit");
        submitform.setPrefWidth(75);
        submitform.setPrefHeight(25);
        submitform.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        grid.add(submitform, 1, 7,1,1);
        
        Text prescription = new Text("Enter the prescription information below: ");
        prescription.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(prescription,1,8,1,1);
        
        Text name = new Text("Name: ");
        name.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(name,1,9,1,1);
        
        TextField namebox = new TextField();
        grid.add(namebox, 1, 10,1,1);
        
        Text purpose = new Text("Purpose: ");
        purpose.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(purpose,1,11,1,1);
        
        TextField purposebox = new TextField();
        grid.add(purposebox, 1, 12,1,1);
        
        
        Text dosage = new Text("Dosage: ");
        dosage.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(dosage,1,13,1,1);
        
        TextField dosagebox = new TextField();
        grid.add(dosagebox, 1, 14,1,1);
        
        Text startdate = new Text("Start Date: ");
        startdate.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(startdate,1,15,1,1);
        
        TextField startdatebox = new TextField();
        grid.add(startdatebox, 1, 16,1,1);
        
        Text endstate = new Text("End State: ");
        endstate.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(endstate,1,17,1,1);
        
        TextField enddatebox = new TextField();
        grid.add(enddatebox, 1, 18,1,1);
        
        Text instruction = new Text("Instructions: ");
        instruction.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(instruction,1,19,1,1);
        
        TextField instructionbox = new TextField();
        grid.add(instructionbox, 1, 20,1,1);
        
        Button submitprescription = new Button("Submit Prescription");
        submitprescription.setPrefWidth(200);
        submitprescription.setPrefHeight(25);
        submitprescription.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        grid.add(submitprescription, 2, 21,1,1);

        Text recomendations = new Text("Additional Recomendations: ");
        recomendations.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(recomendations,25,15,1,1);
        
        TextField recomendationsbox = new TextField();
        recomendationsbox.setPrefHeight(500);
        recomendationsbox.setPrefWidth(500);
        grid.add(recomendationsbox, 25, 17,1,1);
        
        Button submitrecomendations = new Button("Submit Recomendations");
        submitrecomendations.setPrefWidth(200);
        submitrecomendations.setPrefHeight(25);
        submitrecomendations.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        grid.add(submitrecomendations, 25, 25,1,1);
        
        Text currentprescriptions = new Text("Current Prescriptions: ");
        currentprescriptions.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(currentprescriptions,25,5,1,1);
        
        TextArea currentprescriptionsbox = new TextArea();
        currentprescriptionsbox.setPrefHeight(50);
        currentprescriptionsbox.setPrefWidth(50);
        grid.add(currentprescriptionsbox, 25, 7,1,1);
        
        Text vaccinationhistory = new Text("Vaccination History: ");
        vaccinationhistory.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(vaccinationhistory,25,8,1,1);
		
        TextArea vaccinationhistorybox = new TextArea();
        vaccinationhistorybox.setPrefHeight(50);
        vaccinationhistorybox.setPrefWidth(50);
        grid.add(vaccinationhistorybox, 25, 9,1,1);
        
        Text visithistory = new Text("Visit History: ");
        visithistory.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(visithistory,25,10,1,1);
		
        TextArea visithistorybox = new TextArea();
        visithistorybox.setPrefHeight(50);
        visithistorybox.setPrefWidth(50);
        grid.add(visithistorybox, 25, 11,1,1);
        
        Text knownallergies = new Text("Known Allergies: ");
        knownallergies.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(knownallergies,25,12,1,1);
		
        TextArea knownallergiesbox = new TextArea();
        knownallergiesbox.setPrefHeight(50);
        knownallergiesbox.setPrefWidth(50);
        grid.add(knownallergiesbox, 25, 13,1,1);
        
        Button message = new Button("Message Patient");
        message.setPrefWidth(200);
        message.setPrefHeight(25);
        message.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        grid.add(message, 25, 19,1,1);
        
		scene = new Scene(grid,1280,720);
		return scene;
	}
}
