import javafx.application.*;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;


public class PathfinderUnitTester extends Application{
	
	//CharacterBasics Font Variable
	static final private int fontSize = 14;
	
	@Override
	public void start(final Stage primaryStage) {
		//Setting up 
		Group root = new Group();
		
		//GridPane Settings
		GridPane gridPane = new GridPane();
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);
	    gridPane.setPadding(new Insets(20));
	    gridPane.setGridLinesVisible(false);
		
		primaryStage.setTitle("Pathfinder Character Creation");
		Scene scene = new Scene(gridPane, 500, 500, Color.BEIGE);
		
		//Setup for Character Name
		Label characterName = basicInfoLabel("Character Name:");
	    
		TextField characterNameField = new TextField();
		characterNameField.setPromptText("Enter Character Name");
		
	    gridPane.add(characterName, 0, 0);
	    gridPane.add(characterNameField, 1, 0);
	    
	    //Set Seperator
	    
	    Separator line = new Separator(Orientation.HORIZONTAL);
	    gridPane.add(line, 0, 1, 2,1 );
	    
				
		//Setup for Character Stats
	    
	    //Strength
		Label characterStrength = basicInfoLabel("Strength:");
	    
		TextField strengthField = new TextField();
		strengthField.setPromptText("Enter Strength Stat");
		
		gridPane.add(characterStrength, 0, 2);
		GridPane.setHalignment(characterStrength, HPos.RIGHT);
		gridPane.add(strengthField, 1, 2);
		
		//Dexterity
		Label characterDexterity = basicInfoLabel("Dexterity");
	    
		TextField dexterityField = new TextField();
		dexterityField.setPromptText("Enter Dexterity Stat");
		
		gridPane.add(characterDexterity, 0, 3);
		GridPane.setHalignment(characterDexterity, HPos.RIGHT);
		gridPane.add(dexterityField, 1, 3);
		
		//Constitution
		Label characterConstitution = basicInfoLabel("Constitution");
	    
		TextField constitutionField = new TextField();
		constitutionField.setPromptText("Enter Constitution Stat");
		
		gridPane.add(characterConstitution, 0, 4);
		GridPane.setHalignment(characterConstitution, HPos.RIGHT);
		gridPane.add(constitutionField, 1, 4);
		
		//Intelligence
		Label characterIntelligence = basicInfoLabel("Intelligence");
	    
		TextField intelligenceField = new TextField();
		intelligenceField.setPromptText("Enter Intelligence Stat");
		
		gridPane.add(characterIntelligence, 0, 5);
		GridPane.setHalignment(characterIntelligence, HPos.RIGHT);
		gridPane.add(intelligenceField, 1, 5);
		
		//Wisdom
		Label characterWisdom = basicInfoLabel("Wisdom");
	    
		TextField wisdomField = new TextField();
		wisdomField.setPromptText("Enter Wisdom Stat");
		
		gridPane.add(characterWisdom, 0, 6);
		GridPane.setHalignment(characterWisdom, HPos.RIGHT);
		gridPane.add(wisdomField, 1, 6);
		
		//Charisma 
		Label characterCharisma = basicInfoLabel("Charisma");
	    
		TextField charismaField = new TextField();
		charismaField.setPromptText("Enter Charisma Stat");
		
		gridPane.add(characterCharisma, 0, 7);
		GridPane.setHalignment(characterCharisma, HPos.RIGHT);
		gridPane.add(charismaField, 1, 7);
		
		//Campaign Type Selection
		Label campaignType = basicInfoLabel("Campaign Type");
		
		ComboBox<String> campaignTypeBox = new ComboBox<String>();
		campaignTypeBox.getItems().addAll("Low Fantasy","Standard Fantasy","High Fantasy","Epic Fantasy");
		campaignTypeBox.setPromptText("Select Type");
		
		gridPane.add(campaignType, 0, 8);
		GridPane.setHalignment(campaignType, HPos.RIGHT);
		gridPane.add(campaignTypeBox, 1, 8);
		
		//Race Selection
		Label raceType = basicInfoLabel("Race Type");
		
		ComboBox<String> raceTypeBox = new ComboBox<String>();
		raceTypeBox.getItems().addAll("Dwarf","Half-Orc");
		
	    //Set Separator
	    
	    Separator line2 = new Separator(Orientation.HORIZONTAL);
	    gridPane.add(line2, 0, 1, 2,1 );
		
		
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
	    

	    primaryStage.setScene(scene);
	    primaryStage.show();
	    
	    }
		
	private Label basicInfoLabel (String labelName) {
		
		Label tempLabel = new Label(labelName);
		tempLabel.setPadding(new Insets(5));
		tempLabel.setFont(Font.font(fontSize));
		tempLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		return tempLabel;
		
	}
	
	
	public static void main (String[] args) {
		
		launch(args);

		
//		//M3 using builder method built in to the class
//		PathfinderDwarfCharacter firstCharacter = (PathfinderDwarfCharacter) new PathfinderDwarfCharacter.PathfinderDwarfBuilder("Hank")
//				.str(10).dex(10).con(10).inte(10).wis(10).cha(10).build(); 
//		
//		System.out.println(firstCharacter);
//		
//		//M3 using factory 'PathfinderCharacterFactory' method that uses abstract builder method
//		PathfinderHalfOrcCharacter secondCharacter = (PathfinderHalfOrcCharacter) PathfinderCharacterFactory.newCharacter("halfOrc", "Bill");
//		
//		System.out.println(secondCharacter);
//		System.out.println();
//		
//		//M3 Sorting using comparator
//		
//		//firstCharacter is level 0 and secondCharacter is level 5
//		secondCharacter.setLevel(5);
//		
//		ArrayList<PathfinderCharacter> list = new ArrayList<PathfinderCharacter>();
//		
//		list.add(firstCharacter);
//		list.add(secondCharacter);
//		
//		Collections.sort(list, PathfinderCharacter.characterComparator);
//		
//		for(PathfinderCharacter temp: list) {
//			System.out.println(temp);
//		}
//		
//		System.out.println();
//		
//		//firstCharacter is level 10 and secondCharacter is level 5
//		firstCharacter.setLevel(10);
//		
//		Collections.sort(list, PathfinderCharacter.characterComparator);
//		
//		for(PathfinderCharacter temp: list) {
//			System.out.println(temp);
//		}
//		
//		//M3 Using money interface which is implemented by 'PathfinderOrcPurse' and 'PathfinderDwarfPurse'. 'PathfinderCharacter' will randomly select one of them.
//		
//		System.out.println();
//		System.out.println("M3 Testing Money Interface");
//		
//		System.out.println(firstCharacter);
//		System.out.println(firstCharacter.getMoney().moneyPrint());
//		
//		System.out.println();
//		
//		System.out.println(secondCharacter);
//		System.out.println(secondCharacter.getMoney().moneyPrint());
		
		/*
		 * PathfinderCharacter[] characterArray = new PathfinderCharacter[5];
		 * 
		 * PathfinderHalfOrcCharacter firstCharacter = new
		 * PathfinderHalfOrcCharacter("Hank");
		 * 
		 * PathfinderDwarfCharacter secondCharacter = new
		 * PathfinderDwarfCharacter("Bill");
		 * 
		 * PathfinderHalfOrcCharacter thirdCharacter = new PathfinderHalfOrcCharacter
		 * ("Hank"); PathfinderHalfOrcCharacter forthCharacter = new
		 * PathfinderHalfOrcCharacter("Hank");
		 * 
		 * PathfinderCharacter fifthCharacter = new PathfinderCharacter();
		 * 
		 * characterArray[0] = firstCharacter; characterArray[1] = secondCharacter;
		 * characterArray[2] = thirdCharacter; characterArray[3] = forthCharacter;
		 * characterArray[4] = fifthCharacter;
		 * 
		 * System.out.
		 * println("Setting thirdCharacter's bonus stat point allocation to dexterity instead of default strength\n"
		 * ); thirdCharacter.setStatBonusChoice(1);
		 * 
		 * System.out.
		 * println("Test for reflexivity between first and first character: true");
		 * if(firstCharacter.equals(firstCharacter)) { System.out.println(true+"\n"); }
		 * else { System.out.println(false+"\n"); }
		 * 
		 * System.out.
		 * println("Test for Symmetry between first and forth Character: true");
		 * if(firstCharacter.equals(forthCharacter)) { System.out.println(true+"\n"); }
		 * else { System.out.println(false+"\n"); }
		 * 
		 * System.out.
		 * println("Test for Symmetry between first and third Character: false");
		 * if(firstCharacter.equals(thirdCharacter)) { System.out.println(true+"\n"); }
		 * else { System.out.println(false+"\n"); }
		 * 
		 * System.out.println("Testing the toString method of grandChild class");
		 * System.out.println(firstCharacter.toString()+"\n");
		 * 
		 * System.out.
		 * println("Upcasting firstCharacter to Generic Character to test if grandChild array clone funtion in the constructor is working correctly"
		 * ); GenericCharacter tempCharacter = (GenericCharacter) firstCharacter;
		 * System.out.println("0: " +
		 * tempCharacter.getStatNode(0).getStatValue()+"\n");//should base stats using
		 * the GenericCharacter getStatNode method call System.out.println("0: " +
		 * firstCharacter.getStatNodeValue(0)+"\n");//should base stats using the
		 * PathfinderCharacter retrieve Node Value method StatNode[] tempArray =
		 * firstCharacter.getTotalStatArray();//retrieving half-orc total stat (base
		 * stats + racial stat modifiers) System.out.println("2: " +
		 * tempArray[0].getStatValue()+"\n");//displaying the modified strength stat
		 * 
		 * System.out.println("firstCharacter, Hank....");
		 * firstCharacter.meaninglessAction(); firstCharacter.moveDistance();
		 * 
		 * System.out.print("\n");
		 * 
		 * System.out.println("secondCharacter, Bill....");
		 * secondCharacter.meaninglessAction(); secondCharacter.moveDistance();
		 * 
		 * System.out.print("\n");
		 * 
		 * System.out.println("fifthCharacter, noName....");
		 * fifthCharacter.meaninglessAction(); characterArray[4].moveDistance();
		 * 
		 * System.out.print("\n");
		 * 
		 * System.out.println("fifthCharacter pretends to be firstCharacter, noName...."
		 * );
		 * 
		 * fifthCharacter = (PathfinderCharacter) firstCharacter;
		 * 
		 * fifthCharacter.meaninglessAction(); fifthCharacter.moveDistance();
		 * 
		 * System.out.print("\n"); StatNode firstNode = new StatNode();
		 * firstNode.setStatName("Jack"); StatNode secondNode = new StatNode();
		 * secondNode.copy(firstNode); System.out.
		 * println("Testing copy function of StatNode. FirstNode is named Jack, Second has an empty field"
		 * ); System.out.println("SecondNode name is: "+secondNode.getStatName());
		 * 
		 * System.out.print("\n");
		 * 
		 * System.out.println("----------Start of Module 2 Homework-------------");
		 * 
		 * //Novel static variable for keeping track of number of characters generated
		 * 
		 * System.out.println("Number of Character Objects generated is: "
		 * +GenericCharacter.getNumberOfObjs());
		 * 
		 * //Testing Enum PathfinderLevel Format
		 * 
		 * System.out.
		 * println("\n(Testing Enum 'PathfinderLevelFormat' class and methods' effects on int variable 'level' in the Parent Class.)"
		 * );
		 * 
		 * System.out.println(firstCharacter.getName()+ "'s Level is: "
		 * +firstCharacter.getLevel());
		 * 
		 * firstCharacter.setExperiencePoints(10000);
		 * 
		 * System.out.
		 * println("10,000 experience points added to (Hank) and the current leveling speed is: "
		 * + firstCharacter.getLevelFormat().toString());
		 * 
		 * System.out.println(firstCharacter.getName()+ "'s Level is: "
		 * +firstCharacter.getLevel());
		 * 
		 * firstCharacter.setExperiencePoints(firstCharacter.getLevelFormat().
		 * returnBaseExperiencePoint(10));
		 * 
		 * System.out.
		 * println("Hank's experience has been set to the minimum experience for a lv 10 and is: "
		 * + firstCharacter.getExperiencePoints());
		 * 
		 * System.out.println(firstCharacter.getName()+ "'s Level is: "
		 * +firstCharacter.getLevel());
		 * 
		 * System.out.println("Switching leveling format to FAST");
		 * 
		 * firstCharacter.setLevelFormat(PathfinderLevelFormat.FAST);
		 * 
		 * System.out.println(firstCharacter.getName()+ "'s Level is: "
		 * +firstCharacter.getLevel());
		 * 
		 * firstCharacter.setExperiencePoints(firstCharacter.getLevelFormat().
		 * returnBaseExperiencePoint(20));
		 * 
		 * System.out.
		 * println("Hank's experience has been set to the minimum experience for a lv 20 and is: "
		 * + firstCharacter.getExperiencePoints());
		 * 
		 * System.out.println(firstCharacter.getName()+ "'s Level is: "
		 * +firstCharacter.getLevel());
		 * 
		 * System.out.println("Switching leveling format back to SLOW");
		 * 
		 * firstCharacter.setLevelFormat(PathfinderLevelFormat.SLOW);
		 * 
		 * System.out.println(firstCharacter.getName()+ "'s Level is: "
		 * +firstCharacter.getLevel());
		 * 
		 * //Testing compareTo Method
		 * 
		 * System.out.
		 * println("\n(compareTo method is set to only compare character level)");
		 * 
		 * System.out.println(firstCharacter.getName()+ "'s Level is: "
		 * +firstCharacter.getLevel());
		 * 
		 * System.out.println(secondCharacter.getName()+ "'s Level is: "
		 * +secondCharacter.getLevel());
		 * 
		 * System.out.println("The level difference between Hank and Bill is: " +
		 * firstCharacter.compareTo(secondCharacter));
		 * 
		 * System.out.println("The level difference between Bill and Bill is: " +
		 * secondCharacter.compareTo(secondCharacter));
		 * 
		 * System.out.println("The level difference between Bill and Hank is: " +
		 * secondCharacter.compareTo(firstCharacter));
		 * 
		 * //Using Arrays.sort on characterArray using PathfinderCharacter compareTo
		 * method
		 * 
		 * System.out.
		 * println("\n(Updating Characters to have difference levels for sorting)\n");
		 * 
		 * thirdCharacter.setExperiencePoints(secondCharacter.getLevelFormat().
		 * returnBaseExperiencePoint(5));
		 * 
		 * System.out.println("\nthirdCharacter" + "'s Level is: "
		 * +thirdCharacter.getLevel());
		 * 
		 * forthCharacter.setExperiencePoints(forthCharacter.getLevelFormat().
		 * returnBaseExperiencePoint(2));
		 * 
		 * System.out.println("forthCharacter" + "'s Level is: "
		 * +forthCharacter.getLevel());
		 * 
		 * System.out.
		 * println("fifthCharacter in the characterArray is the original noName fifthCharacter and it"
		 * + "'s Level: " +characterArray[4].getLevel());
		 * 
		 * System.out.println();
		 * 
		 * for(PathfinderCharacter temp : characterArray) {
		 * System.out.println(temp.getName() + "'s level is: " + temp.getLevel()); }
		 * 
		 * Arrays.sort(characterArray);
		 * 
		 * System.out.
		 * println("\nUsing Java Class Array sort method on 'characterArray'\n");
		 * 
		 * for(PathfinderCharacter temp : characterArray) {
		 * System.out.println(temp.getName() + "'s level is: " + temp.getLevel()); }
		 */

	}



}
