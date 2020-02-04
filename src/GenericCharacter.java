import java.lang.StringBuilder;
public abstract class GenericCharacter {
	
	/*
	 * Parent Class for a Generic Character Sheet. 
	 * Most table top role playing systems have numerous differences,
	 * but the what constitutes a "character" in these systems are
	 * similar in ideas with different implementations 
	 * 
	 * For example, a character's name, it's background,
	 * it's attributes or stats, and the list goes on.
	 * 
	 */

	private String Name;
	private StatNode[] statNodeArray;
	
	/*
	 * Constructor for GenericCharacter
	 */
	public GenericCharacter( int statNodeArraySize) {
		statNodeArray = new StatNode[statNodeArraySize];
	}
	
	/*
	 * Getters and Setters
	 */

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	public StatNode[] getStat() {
		return statNodeArray;
	}
	
	public void setStatNodeName (int nodePosition, String statName) {
		if (nodePosition < statNodeArray.length) {
			this.statNodeArray[nodePosition].setStatName(statName);
		} else {
			System.out.print("index out of bound");
		}
	}
	
	public void setStatNodeValue (int nodePosition, int statValue) {
		if (nodePosition < statNodeArray.length) {
			this.statNodeArray[nodePosition].setStatValue(statValue);;
		} else {
			System.out.print("index out of bound");
		}
	}
	
	/*
	 * Prints out the name of stat and value of the stat
	 * when the array position is valid.
	 */

	public void readStatNode(int nodePosition) {
		if (nodePosition < statNodeArray.length) {
			System.out.println(statNodeArray[nodePosition].getStatName() + ": "+
					statNodeArray[nodePosition].getStatValue());
		} else {
			System.out.print("Index out of Bounds");
		}
	}
	
	/*
	 * returns a name.. trying to think of reason why I would
	 * want this here
	 */

	@Override
	public String toString() {
		
		StringBuilder tempString = new StringBuilder("Character Name: " + this.Name);
		
		for( StatNode tempNode : this.statNodeArray ) {
			String nodeString = String.format("%s: %d, ", tempNode.getStatName(), tempNode.getStatValue() );
			tempString.append(nodeString);
		}
		
		return tempString.toString();
	}
	
	/*
	 *I'm leaving this here, but honestly the equals method should be
	 *implemented on the child class
	 */
	
	@Override
	public boolean equals(Object obj) {
		if((GenericCharacter) obj instanceof GenericCharacter) {
			GenericCharacter temp = (GenericCharacter) obj;
			if(temp.Name.equals(this.Name) &&  temp.statNodeArray.equals(this.statNodeArray)) {
				return true;
			}else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	

}
