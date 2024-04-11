package groupProject;



import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DoctorPortal extends Portal {
	private Account user;
	private Button submitprescription;
	private Button submitrecommendations;
	private Button message;
	
	private TextField physicaltestbox;
	private TextField namebox;
	private TextField purposebox;
	private TextField dosagebox;
	private TextField startdatebox;
	private TextField enddatebox;
	private TextField instructionbox;	
	private TextField recomendationsbox;
	
	private TextArea vaccinationhistorybox;
	private TextArea currentprescriptionsbox;
	private TextArea visithistorybox;
	
	public DoctorPortal() {
		submitrecommendations = new Button();
		submitprescription = new Button();
		submitrecommendations = new Button();
		message = new Button();
	}
	
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
        
        physicaltestbox = new TextField();
        grid.add(physicaltestbox, 1, 6,1,1);
        
//        this.submitForm = new Button("Submit");
//        submitForm.setPrefWidth(75);
//        submitForm.setPrefHeight(25);
//        submitForm.setStyle("-fx-background-color: black; -fx-text-fill: white;");
//        grid.add(submitForm, 1, 7,1,1);
        
        Text prescription = new Text("Enter the prescription information below: ");
        prescription.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(prescription,1,8,1,1);
        
        Text name = new Text("Name: ");
        name.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(name,1,9,1,1);
        
        namebox = new TextField();
        grid.add(namebox, 1, 10,1,1);
        
        Text purpose = new Text("Purpose: ");
        purpose.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(purpose,1,11,1,1);
        
        purposebox = new TextField();
        grid.add(purposebox, 1, 12,1,1);
        
        
        Text dosage = new Text("Dosage: ");
        dosage.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(dosage,1,13,1,1);
        
        dosagebox = new TextField();
        grid.add(dosagebox, 1, 14,1,1);
        
        Text startdate = new Text("Start Date: ");
        startdate.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(startdate,1,15,1,1);
        
        startdatebox = new TextField();
        grid.add(startdatebox, 1, 16,1,1);
        
        Text endstate = new Text("End State: ");
        endstate.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(endstate,1,17,1,1);
        
        enddatebox = new TextField();
        grid.add(enddatebox, 1, 18,1,1);
        
        Text instruction = new Text("Instructions: ");
        instruction.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(instruction,1,19,1,1);
        
        instructionbox = new TextField();
        grid.add(instructionbox, 1, 20,1,1);
        
        this.submitprescription.setText("Submit Prescription");
        submitprescription.setPrefWidth(200);
        submitprescription.setPrefHeight(25);
        submitprescription.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        grid.add(submitprescription, 2, 21,1,1);

        Text recomendations = new Text("Additional Recomendations: ");
        recomendations.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(recomendations,25,15,1,1);
        
        this.recomendationsbox = new TextField();
        recomendationsbox.setPrefHeight(500);
        recomendationsbox.setPrefWidth(500);
        grid.add(recomendationsbox, 25, 17,1,1);
        
//        Button submitrecomendations = new Button("Submit Recomendations");
//        submitrecomendations.setPrefWidth(200);
//        submitrecomendations.setPrefHeight(25);
//        submitrecomendations.setStyle("-fx-background-color: black; -fx-text-fill: white;");
//        grid.add(submitrecomendations, 25, 25,1,1);
        
        Text currentprescriptions = new Text("Current Prescriptions: ");
        currentprescriptions.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(currentprescriptions,25,5,1,1);
        
        this.currentprescriptionsbox = new TextArea();
        this.currentprescriptionsbox.setPrefHeight(50);
        this.currentprescriptionsbox.setPrefWidth(50);
        grid.add(this.currentprescriptionsbox, 25, 7,1,1);
        
        Text vaccinationhistory = new Text("Vaccination History: ");
        vaccinationhistory.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(vaccinationhistory,25,8,1,1);
		
        this.vaccinationhistorybox = new TextArea();
        this.vaccinationhistorybox.setPrefHeight(50);
        this.vaccinationhistorybox.setPrefWidth(50);
        grid.add(this.vaccinationhistorybox, 25, 9,1,1);
        
        Text visithistory = new Text("Visit History: ");
        visithistory.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(visithistory,25,10,1,1);
		
        this.visithistorybox = new TextArea();
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
        
        this.message = new Button("Message Patient");
        message.setPrefWidth(200);
        message.setPrefHeight(25);
        message.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        grid.add(message, 25, 20,1,1);

        this.submitrecommendations.setText("Submit Recommendation");
        submitrecommendations.setPrefWidth(200);
        submitrecommendations.setPrefHeight(25);
        submitrecommendations.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        grid.add(submitrecommendations, 25, 19,1,1);
        
		scene = new Scene(grid,1280,720);
		return scene;
	}
	
	public Button getsubmitprescriptionButton() {return submitprescription;}
	public Button getsubmitrecommendationsButton() {return this.submitrecommendations;}
	public Button getmessageButton() {return message;}
	
	public String getPhysTest() {return physicaltestbox.getText();}
	public String getName() {return namebox.getText();}
	public String getPurpose() {return purposebox.getText();}
	public String getDosage() {return dosagebox.getText();}
	public String getStart() {return startdatebox.getText();}
	public String getEnd() {return enddatebox.getText();}
	public String getInstruction() {return instructionbox.getText();}
	public String getRecommendations() {return recomendationsbox.getText();}
	
	public void setVaccinations(String recommendations) {
		System.out.println("Did this");
		vaccinationhistorybox.setText(recommendations);
	}
	
	public void setPrescription(String recommendations) {
		System.out.println("Did this 2");
		currentprescriptionsbox.setText(recommendations);
	}
	
	public void setVisit(String visit) {
		System.out.println("Did this 3");
		visithistorybox.setText(visit);
	}
	
}
