
public class PathfinderUnitTester {
	
	public static void main (String[] args) {
		
		PathfinderCharacter[] characterArray = new PathfinderCharacter[5];
		
		PathfinderHalfOrcCharacter firstCharacter = new PathfinderHalfOrcCharacter("Hank");
		
		PathfinderDwarfCharacter secondCharacter = new PathfinderDwarfCharacter("Bill");
		
		PathfinderHalfOrcCharacter thirdCharacter = new PathfinderHalfOrcCharacter ("Hank");
		PathfinderHalfOrcCharacter forthCharacter = new PathfinderHalfOrcCharacter("Hank");
		
		PathfinderCharacter fifthCharacter = new PathfinderCharacter();
		
		characterArray[0] = firstCharacter;
		characterArray[1] = secondCharacter;
		characterArray[2] = thirdCharacter;
		characterArray[3] = forthCharacter;
		characterArray[4] = fifthCharacter;
		
		System.out.println("Setting thirdCharacter's bonus stat point allocation to dexterity instead of default strength\n");
		thirdCharacter.setStatBonusChoice(1);
		
		System.out.println("Test for reflexivity between first and first character: true");
		if(firstCharacter.equals(firstCharacter)) {
			System.out.println(true+"\n");
		} else {
			System.out.println(false+"\n");
		}
		
		System.out.println("Test for Symmetry between first and forth Character: true");
		if(firstCharacter.equals(forthCharacter)) {
			System.out.println(true+"\n");
		} else {
			System.out.println(false+"\n");
		}
		
		System.out.println("Test for Symmetry between first and third Character: false");
		if(firstCharacter.equals(thirdCharacter)) {
			System.out.println(true+"\n");
		} else {
			System.out.println(false+"\n");
		}
		
		System.out.println("Testing the toString method of grandChild class");
		System.out.println(firstCharacter.toString()+"\n");
		
		System.out.println("Upcasting firstCharacter to Generic Character to test if grandChild array clone funtion in the constructor is working correctly");
		GenericCharacter tempCharacter = (GenericCharacter) firstCharacter;
		System.out.println("0: " + tempCharacter.getStatNode(0).getStatValue()+"\n");//should base stats using the GenericCharacter getStatNode method call
		System.out.println("0: " + firstCharacter.getStatNodeValue(0)+"\n");//should base stats using the PathfinderCharacter retrieve Node Value method
		StatNode[] tempArray = firstCharacter.getTotalStatArray();//retrieving half-orc total stat (base stats + racial stat modifiers) 
		System.out.println("2: " + tempArray[0].getStatValue()+"\n");//displaying the modified strength stat
		
		System.out.println("firstCharacter, Hank....");
		firstCharacter.meaninglessAction();
		firstCharacter.moveDistance();
		
		System.out.print("\n");
		
		System.out.println("secondCharacter, Bill....");
		secondCharacter.meaninglessAction();
		secondCharacter.moveDistance();
		
		System.out.print("\n");
		
		System.out.println("fifthCharacter, noName....");
		fifthCharacter.meaninglessAction();
		characterArray[4].moveDistance();
		
		System.out.print("\n");
		
		System.out.println("fifthCharacter pretends to be firstCharacter, noName....");
		
		fifthCharacter = (PathfinderCharacter) firstCharacter;
		
		fifthCharacter.meaninglessAction();
		fifthCharacter.moveDistance();
		
		System.out.print("\n");
		StatNode firstNode = new StatNode();
		firstNode.setStatName("Jack");
		StatNode secondNode = new StatNode();
		secondNode.copy(firstNode);
		System.out.println("Testing copy function of StatNode. FirstNode is named Jack, Second has an empty field");
		System.out.println("SecondNode name is: "+secondNode.getStatName());
		
		System.out.print("\n");
		
		System.out.println("----------Start of Module 2 Homework-------------");
		
		System.out.println("Number of Character Objects generated is: "+GenericCharacter.getNumberOfObjs());
		
		System.out.println(firstCharacter.getName()+ "'s Level is: " +firstCharacter.getLevel());
		
		firstCharacter.setExperiencePoints(10000);
		
		System.out.println("10,000 experience points added to (Hank) and the current leveling speed is: " + firstCharacter.getLevelFormat().toString());
		
		System.out.println(firstCharacter.getName()+ "'s Level is: " +firstCharacter.getLevel());
		
		firstCharacter.setExperiencePoints(firstCharacter.getLevelFormat().returnBaseExperiencePoint(10));
		
		System.out.println("Hank's experience has been set to the minimum experience for a lv 10 and is: " + firstCharacter.getExperiencePoints());
		
		System.out.println(firstCharacter.getName()+ "'s Level is: " +firstCharacter.getLevel());
		
		System.out.println("Switching leveling format to FAST");
		
		firstCharacter.setLevelFormat(PathfinderLevelFormat.FAST);
		
		System.out.println(firstCharacter.getName()+ "'s Level is: " +firstCharacter.getLevel());
		
		firstCharacter.setExperiencePoints(firstCharacter.getLevelFormat().returnBaseExperiencePoint(20));
		
		System.out.println("Hank's experience has been set to the minimum experience for a lv 20 and is: " + firstCharacter.getExperiencePoints());
		
		System.out.println(firstCharacter.getName()+ "'s Level is: " +firstCharacter.getLevel());
		
		System.out.println("Switching leveling format back to SLOW");
		
		firstCharacter.setLevelFormat(PathfinderLevelFormat.SLOW);
		
		System.out.println(firstCharacter.getName()+ "'s Level is: " +firstCharacter.getLevel());
		
		System.out.println(secondCharacter.getName()+ "'s Level is: " +secondCharacter.getLevel());
		
		System.out.println("The level difference between Hank and Bill is: " + firstCharacter.compareTo(secondCharacter));
		
		System.out.println("The level difference between Bill and Bill is: " + secondCharacter.compareTo(secondCharacter));
		
		System.out.println("The level difference between Bill and Hank is: " + secondCharacter.compareTo(firstCharacter));
		
		
		

	}

}
