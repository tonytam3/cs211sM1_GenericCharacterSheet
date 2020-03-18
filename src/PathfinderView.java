import java.util.*;

import javax.swing.BorderFactory;

import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;


public class PathfinderView{
	
	Label characterName, characterStrength, characterDexterity, characterConstitution, characterIntelligence, characterWisdom,
	characterCharisma, campaignType, raceType;
	
	TextField characterNameField;
	
	ComboBox<String> campaignTypeBox, raceTypeBox;
	
	ComboBox<Integer> strengthField, dexterityField, constitutionField, intelligenceField, wisdomField, charismaField;
	
	Separator line, line2, line3;
	
	GridPane gridPane1, gridPane2;
	
	Text abilityScoreAmountTitle, abilityScoreAmount, displayCharacter;
	
	Button calculateAbilityPoints, buildButton,back;
	
	StackPane abilityScoreStack;
	
	//CharacterBasics Font Variable
	static final private int fontSize = 14;
	
	
	public PathfinderView () {
		
		System.setProperty("glass.accessible.force", "false");
		
		//GridPane Settings
		gridPane1 = new GridPane();
	    gridPane1.setHgap(10);
	    gridPane1.setVgap(10);
	    gridPane1.setPadding(new Insets(20));
	    gridPane1.setGridLinesVisible(false);
		
		//Setup for Character Name
		characterName = basicInfoLabel("Character Name:");
	    
		characterNameField = new TextField();
		characterNameField.setPromptText("Enter Character Name");
		
	    gridPane1.add(characterName, 0, 0);
	    gridPane1.add(characterNameField, 1, 0);
	    
	    //Set Seperator
	    
	    line = new Separator(Orientation.HORIZONTAL);
	    gridPane1.add(line, 0, 1, 2,1 );
	    
				
		//Setup for Character Stats
	    
	    abilityScoreStack = new StackPane();
	    abilityScoreAmountTitle = new Text("Ability Score Points Left:");
	    abilityScoreAmount = new Text("0");
	    abilityScoreStack.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	    abilityScoreStack.setBorder(new Border (new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
	    abilityScoreStack.setPadding(new Insets(5));
	    abilityScoreStack.getChildren().add(abilityScoreAmount);
	    
	    gridPane1.add(abilityScoreAmountTitle, 2, 2);
	    gridPane1.add(abilityScoreStack, 2, 3);
	    
		//Ability Point Button
		calculateAbilityPoints = new Button("Calculate Ability Point");
		gridPane1.add(calculateAbilityPoints, 2, 4);
	    
	    
	    //Strength
		characterStrength = basicInfoLabel("Strength:");
	    
		strengthField = new ComboBox<Integer>();
		strengthField.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18);
		strengthField.setValue(10);
		//strengthField.setPromptText("Enter Strength Stat");
		
		gridPane1.add(characterStrength, 0, 2);
		GridPane.setHalignment(characterStrength, HPos.RIGHT);
		gridPane1.add(strengthField, 1, 2);
		
		//Dexterity
		characterDexterity = basicInfoLabel("Dexterity");
	    
		dexterityField = new ComboBox<Integer>();
		dexterityField.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18);
		dexterityField.setValue(10);
		//dexterityField.setPromptText("Enter Dexterity Stat");
		
		gridPane1.add(characterDexterity, 0, 3);
		GridPane.setHalignment(characterDexterity, HPos.RIGHT);
		gridPane1.add(dexterityField, 1, 3);
		
		//Constitution
		characterConstitution = basicInfoLabel("Constitution");
	    
		constitutionField = new ComboBox<Integer>();
		constitutionField.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18);
		constitutionField.setValue(10);
		//constitutionField.setPromptText("Enter Constitution Stat");
		
		gridPane1.add(characterConstitution, 0, 4);
		GridPane.setHalignment(characterConstitution, HPos.RIGHT);
		gridPane1.add(constitutionField, 1, 4);
		
		//Intelligence
		characterIntelligence = basicInfoLabel("Intelligence");
	    
		intelligenceField = new ComboBox<Integer>();
		intelligenceField.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18);
		intelligenceField.setValue(10);
		//intelligenceField.setPromptText("Enter Intelligence Stat");
		
		gridPane1.add(characterIntelligence, 0, 5);
		GridPane.setHalignment(characterIntelligence, HPos.RIGHT);
		gridPane1.add(intelligenceField, 1, 5);
		
		//Wisdom
		characterWisdom = basicInfoLabel("Wisdom");
	    
		wisdomField = new ComboBox<Integer>();
		wisdomField.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18);
		wisdomField.setValue(10);
		//wisdomField.setPromptText("Enter Wisdom Stat");
		
		gridPane1.add(characterWisdom, 0, 6);
		GridPane.setHalignment(characterWisdom, HPos.RIGHT);
		gridPane1.add(wisdomField, 1, 6);
		
		//Charisma 
		characterCharisma = basicInfoLabel("Charisma");
	    
		charismaField = new ComboBox<Integer>();
		charismaField.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18);
		charismaField.setValue(10);
		//charismaField.setPromptText("Enter Charisma Stat");
		
		gridPane1.add(characterCharisma, 0, 7);
		GridPane.setHalignment(characterCharisma, HPos.RIGHT);
		gridPane1.add(charismaField, 1, 7);
		
		//Campaign Type Selection
		campaignType = basicInfoLabel("Campaign Type");
		
		campaignTypeBox = new ComboBox<String>();
		campaignTypeBox.getItems().addAll("Low Fantasy","Standard Fantasy","High Fantasy","Epic Fantasy");
		campaignTypeBox.setValue("Low Fantasy");
		//campaignTypeBox.setPromptText("Select Type");
		
		gridPane1.add(campaignType, 0, 8);
		GridPane.setHalignment(campaignType, HPos.RIGHT);
		gridPane1.add(campaignTypeBox, 1, 8);
		
	    //Set Separator
	    
	    line2 = new Separator(Orientation.HORIZONTAL);
	    gridPane1.add(line2, 0, 9, 2, 1 );
	    
		//Race Selection
		raceType = basicInfoLabel("Race Type");
		
		raceTypeBox = new ComboBox<String>();
		raceTypeBox.getItems().addAll("Dwarf","Half-Orc");
		raceTypeBox.setValue("Dwarf");
		raceTypeBox.setPromptText("Select Race");
		
		gridPane1.add(raceType, 0, 10);
		GridPane.setHalignment(raceType, HPos.RIGHT);
		gridPane1.add(raceTypeBox, 1, 10);
		
	    //Set Separator
	    
	    line3 = new Separator(Orientation.HORIZONTAL);
	    gridPane1.add(line3, 0, 11, 2, 1 );
		
		//Build Button
		
		buildButton = new Button ("Build Character");
		gridPane1.add(buildButton, 0, 12);
		
		//Display Built Character
		
		gridPane2 = new GridPane();
		displayCharacter = new Text();
		back = new Button("Back");
		
		gridPane2.add(displayCharacter, 0, 0);
		gridPane2.add(back, 0, 1);
		
//	    Button btn = new Button();
//	    btn.setText("Open Dialog");
//	    
//	    btn.setStyle("-fx-focus-color: transparent;");
//
//	    btn.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
//	    btn.setOnAction(
//	        new EventHandler<ActionEvent>() {
//	            @Override
//	            public void handle(ActionEvent event) {
//	                final Stage dialog = new Stage();
//	                dialog.initModality(Modality.APPLICATION_MODAL);
//	                dialog.initOwner(primaryStage);
//	                
//	                GridPane dialogBox = new GridPane();
//	                dialogBox.add(new Text ("This is a dialog"), 0, 0);
//	                
//	                
//	                /*
//	                VBox dialogVbox = new VBox(20);
//	                dialogVbox.getChildren().add(new Text("This is a Dialog"));
//	                */
//	                Scene dialogScene = new Scene(dialogBox, 300, 200);
//	                dialog.setScene(dialogScene);
//	                dialog.show();
//	            }
//	         }
//	        );
	    
	    }
	
	public Parent getParent1() {
		return gridPane1;
	}
	
	public Parent getParent2() {
		return gridPane2;
	}
	
	public void setOnCalculateAbilityPoints (EventHandler<ActionEvent> handle) {
		calculateAbilityPoints.setOnAction(handle);
	}
	
	public void setOnCampaignTypeBox (EventHandler<ActionEvent> handle) {
		campaignTypeBox.setOnAction(handle);
	}
	
	public String getCharacterRace () {
		return raceTypeBox.getValue();
	}
	
	public void setOnBuildButton (EventHandler<ActionEvent> handle) {
		buildButton.setOnAction(handle);
	}
	
	public void setAbilityScoreAmount (int number) {
		abilityScoreAmount.setText(String.valueOf(number));
	}
	
	public int getAbilityScoreAmount () {
		return Integer.valueOf(abilityScoreAmount.getText());
	}
	
	public String getCharacterName () {
		return characterNameField.getText();
	}
	
	public int getStrength () {
		return strengthField.getValue();
	}
	
	public int getDexterity () {
		return dexterityField.getValue();
	}
	
	public int getConstitution() {
		return constitutionField.getValue();
	}
	
	public int getIntelligence() {
		return intelligenceField.getValue();
	}
	
	public int getWisdom() {
		return wisdomField.getValue();
	}
	
	public int getCharisma() {
		return charismaField.getValue();
	}
	
	
	

	private Label basicInfoLabel (String labelName) {
		
		Label tempLabel = new Label(labelName);
		tempLabel.setPadding(new Insets(5));
		tempLabel.setFont(Font.font(fontSize));
		tempLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		return tempLabel;
		
	}

}
