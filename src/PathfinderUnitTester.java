import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PathfinderUnitTester {
	
	public static void main (String[] args) {
		
		//M3 using builder method built in to the class
		PathfinderDwarfCharacter firstCharacter = (PathfinderDwarfCharacter) new PathfinderDwarfCharacter.PathfinderDwarfBuilder("Hank")
				.str(10).dex(10).con(10).inte(10).wis(10).cha(10).build(); 
		
		System.out.println(firstCharacter);
		
		//M3 using factory 'PathfinderCharacterFactory' method that uses abstract builder method
		PathfinderHalfOrcCharacter secondCharacter = (PathfinderHalfOrcCharacter) PathfinderCharacterFactory.newCharacter("halfOrc", "Bill");
		
		System.out.println(secondCharacter);
		System.out.println();
		
		//M3 Sorting using comparator
		
		//firstCharacter is level 0 and secondCharacter is level 5
		secondCharacter.setLevel(5);
		
		ArrayList<PathfinderCharacter> list = new ArrayList<PathfinderCharacter>();
		
		list.add(firstCharacter);
		list.add(secondCharacter);
		
		Collections.sort(list, PathfinderCharacter.characterComparator);
		
		for(PathfinderCharacter temp: list) {
			System.out.println(temp);
		}
		
		System.out.println();
		
		//firstCharacter is level 10 and secondCharacter is level 5
		firstCharacter.setLevel(10);
		
		Collections.sort(list, PathfinderCharacter.characterComparator);
		
		for(PathfinderCharacter temp: list) {
			System.out.println(temp);
		}
		
		//M3 Using money interface which is implemented by 'PathfinderOrcPurse' and 'PathfinderDwarfPurse'. 'PathfinderCharacter' will randomly select one of them.
		
		System.out.println();
		System.out.println("M3 Testing Money Interface");
		
		System.out.println(firstCharacter);
		System.out.println(firstCharacter.getMoney().moneyPrint());
		
		System.out.println();
		
		System.out.println(secondCharacter);
		System.out.println(secondCharacter.getMoney().moneyPrint());
		
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
