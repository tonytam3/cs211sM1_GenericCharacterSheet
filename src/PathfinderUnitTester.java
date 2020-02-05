
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
		
		System.out.println("Upcasting firstCharacter to Generic Character to test if grandChild array clone funtion is working correctly");
		GenericCharacter tempCharacter = (GenericCharacter) firstCharacter;
		System.out.println(tempCharacter.getStatNode(0).getStatValue()+"\n");
		System.out.println(firstCharacter.getStatNodeValue(0)+"\n");
		StatNode[] tempArray = firstCharacter.getTotalStatArray();
		System.out.println(tempArray[0].getStatValue()+"\n");
		
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
		characterArray[4].moveDistance();

	}

}
