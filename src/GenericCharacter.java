import java.lang.StringBuilder;

public abstract class GenericCharacter {

	/*
	 * Parent Class for a Generic Character Sheet. Most table top role playing
	 * systems have numerous differences, but the what constitutes a "character" in
	 * these systems are similar in ideas with different implementations
	 * 
	 * For example, a character's name, it's background, it's attributes or stats,
	 * and the list goes on.
	 * 
	 */

	private String Name;
	private StatNode[] statNodeArray;
	private static int numberOfObjs = 0;//Module 2 homework's static variable.
	private int level = 0; //new characters are implied to have a level of zero.

	/*
	 * Constructor for GenericCharacter
	 */
	public GenericCharacter(int statNodeArraySize) {
		Name = "Empty Field";
		statNodeArray = new StatNode[statNodeArraySize];
		
		for(int i = 0; i < statNodeArray.length; i++) {
			statNodeArray[i] = new StatNode();
		}
		
		numberOfObjs++;
		
	}

	/*
	 * Getters and Setters
	 */

	public String getName() {
		return Name;
	}

	
	public StatNode[] getStatNodeArray () {
		return statNodeArray;
	}

	public StatNode getStatNode(int nodePosition) {
		if (nodePosition > -1 && nodePosition < statNodeArray.length) {
			return statNodeArray[nodePosition];
		} else {
			return null;
		}
	}

	public int getLevel() { //Generic Character only has a return level method because different tableTop role-playing systems have different means of doing character advancement.
		return level;
	}
	
	public void setName(String name) {
		Name = name;
	}

	public void setStatNodeName(int nodePosition, String statName) {
		if (nodePosition > -1 && nodePosition < statNodeArray.length) {	
			this.statNodeArray[nodePosition].setStatName(statName);
		} else {
			System.out.print("index out of bound");
		}
	}

	public void setStatNodeValue(int nodePosition, int statValue) {
		if (nodePosition > -1 && nodePosition < statNodeArray.length) {
			this.statNodeArray[nodePosition].setStatValue(statValue);
			;
		} else {
			System.out.print("index out of bound");
		}
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	/*
	 * Prints out the name of stat and value of the stat when the array position is
	 * valid.
	 */

	public void readStatNode(int nodePosition) {
		if (nodePosition > -1 && nodePosition < statNodeArray.length) {
			System.out.println(
					statNodeArray[nodePosition].getStatName() + ": " + statNodeArray[nodePosition].getStatValue());
		} else {
			System.out.print("Index out of Bounds");
		}
	}
	
	public static int getNumberOfObjs() {
		return numberOfObjs;
	}
	


	/*
	 * returns a name.. trying to think of reason why I would want this here
	 */

	@Override
	public String toString() {

		StringBuilder tempString = new StringBuilder("Character Name: " + this.Name);

		for (StatNode tempNode : this.statNodeArray) {
			String nodeString = String.format("%s: %d, ", tempNode.getStatName(), tempNode.getStatValue());
			tempString.append(nodeString);
		}

		return tempString.toString();
	}

	/*
	 * I'm leaving this here, but honestly the equals method should be implemented
	 * on the child class
	 */

	@Override
	public boolean equals(Object obj) {
		if ((GenericCharacter) obj instanceof GenericCharacter) {
			GenericCharacter temp = (GenericCharacter) obj;
			if (temp.Name.equals(this.Name)) {
				
				StatNode[] tempArray = temp.getStatNodeArray();
				
				for(int i = 0; i < statNodeArray.length; i++ ) {
					
					if(!statNodeArray[i].getStatName().equals(tempArray[i].getStatName())) {
						return false;
					}
					
					if(statNodeArray[i].getStatValue()!=(tempArray[i].getStatValue())) {
						return false;
					}
					
				}
				
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
