package groupProject;

import java.util.*;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.ObjectInputStream;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class MessageBox {
	private VBox box;
	private Button submitBttn;
	private TextField msgField;
	public MessageBox(ArrayList<Message> msgs) {
	      box = new VBox(10);
	      box.setAlignment(Pos.CENTER);
	      System.out.println(msgs.size());
	      VBox msgPane = new VBox();
	      msgPane.setStyle("-fx-border-color: black");
	      submitBttn = new Button("Submit Message");
	      msgField = new TextField("");
	      msgField.setAlignment(Pos.BOTTOM_CENTER);
	      
	      for (Message m:msgs) {
	    	  Account s = m.getSender();
	    	  String title = "";
	    	  switch (s.getRole()) {
	    	  case 'p':
	    		  title = "Patient";
	    		  break;
	    	  case 'd':
	    		  title = "Doctor";
	    		  break;
	    	  case 'n':
	    		  title = "Nurse";
	    		  break;
	    	  }
	    	  
    		  Label lbl = new Label(title + " " + s.getFName() + " "+ s.getLName());
    		  Text msg = new Text("\t" + m.getMsg() + "\n");
    		  msgPane.getChildren().addAll(lbl,msg);
	      }
	      
	      msgPane.setPrefHeight(300);
	      msgField.setPrefHeight(50);
	      box.getChildren().addAll(msgPane,msgField,submitBttn);
	}
	public VBox createBox(ArrayList<Message> msgs) {
	      box = new VBox(10);
	      box.setAlignment(Pos.CENTER);
	      System.out.println(msgs.size());
	      VBox msgPane = new VBox();
	      msgPane.setStyle("-fx-border-color: black");
	      submitBttn = new Button("Submit Message");
	      msgField = new TextField("");
	      msgField.setAlignment(Pos.BOTTOM_CENTER);
	      
	      for (Message m:msgs) {
	    	  Account s = m.getSender();
	    	  String title = "";
	    	  switch (s.getRole()) {
	    	  case 'p':
	    		  title = "Patient";
	    		  break;
	    	  case 'd':
	    		  title = "Doctor";
	    		  break;
	    	  case 'n':
	    		  title = "Nurse";
	    		  break;
	    	  }
	    	  
	  		  Label lbl = new Label(title + " " + s.getFName() + " "+ s.getLName());
	  		  Text msg = new Text("\t" + m.getMsg() + "\n");
	  		  msgPane.getChildren().addAll(lbl,msg);
	      }
	      
	      msgPane.setPrefHeight(300);
	      msgField.setPrefHeight(50);
	      box.getChildren().addAll(msgPane,msgField,submitBttn);
	      return box;
	}
	public VBox getBox() {return box;}
	public Button getButton() {return submitBttn;}
	public String getMessageSent() {return msgField.getText();}
	public TextField getMsgField() {return msgField;}
}
