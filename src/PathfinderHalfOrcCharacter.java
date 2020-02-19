import java.lang.StringBuilder;

public class PathfinderHalfOrcCharacter{

	private int statBonusAmount = 2;

	/*
	 * statBonusChoice variable is for keeping track of where the statBonusAmount is
	 * applied to. Only Applicable to the first six stat Node.
	 * Half-Orcs get a +2 to a stat of their choice.
	 */
	private int statBonusChoice = 0;
	
	PathfinderCharacter halfOrc;
	
	/*
	 * Creating a copy of the statArray from the parent constructor class to keep track of any modifications to individual stats.
	 */
	private StatNode[] totalBaseStatArray;

	public PathfinderHalfOrcCharacter(String name) {

		halfOrc = new PathfinderCharacter.PathfinderCharacterBuilder("EmptyField")
				.str(0).dex(0).con(0).inte(0).wis(0).cha(0).build();
		halfOrc.setName(name);

		totalBaseStatArray = halfOrc.getStatNodeArray().clone();
		
		totalBaseStatArray[0].setStatName("test");		
	
		for (int i = 0; i < totalBaseStatArray.length; i++) {
			totalBaseStatArray[i] = new StatNode();
			totalBaseStatArray[i].copy(halfOrc.getStatNode(i));
		}

		saveTotalBaseStatArray();
		// TODO Auto-generated constructor stub
	}

	public void setStatBonusAmount(int amount) {
		statBonusAmount = amount;
		saveTotalBaseStatArray();
	}

	public void setStatBonusChoice(int choice) {
		statBonusChoice = choice;
		saveTotalBaseStatArray();
	}

	public int getStatBonusAmount() {
		return statBonusAmount;
	}

	public int getStatBonusChoice() {
		return statBonusChoice;
	}

	public StatNode[] getTotalStatArray() {
		return totalBaseStatArray;
	}

	public void saveTotalBaseStatArray() {
		//retrieving the original array, adding all stat Modifiers. So far just statBonus
		totalBaseStatArray[statBonusChoice].setStatValue(halfOrc.getStatNode(statBonusChoice).getStatValue() + statBonusAmount);

	}

	@Override
	public String toString() {

		StringBuilder tempString = new StringBuilder("Character Name: " + halfOrc.getName() + ", ");

		for (StatNode tempNode : this.totalBaseStatArray) {
			String nodeString = String.format("%s: %d, ", tempNode.getStatName(), tempNode.getStatValue());
			tempString.append(nodeString);
		}

		return tempString.toString();

	}

	@Override
	public boolean equals(Object obj) {
		//checking if the obj is an instance of this class
		if (obj instanceof PathfinderHalfOrcCharacter) {

			PathfinderHalfOrcCharacter tempObject = (PathfinderHalfOrcCharacter) obj;
			//checking if the names of the object is the same.
			if (tempObject.halfOrc.getName().equals(this.halfOrc.getName())) {

				StatNode[] tempArray = tempObject.getTotalStatArray();
				//This loop goes through all the entire stat array of both objects for name and value comparison.
				for (int i = 0; i < tempArray.length; i++) {

					if ( !tempArray[i].getStatName().equals( this.totalBaseStatArray[i].getStatName()) ) {
						return false;
					}

					if (tempArray[i].getStatValue() != this.totalBaseStatArray[i].getStatValue()) {
						return false;
					}

				}
				// this boolean condition is going change as more parts are going to added
				return true;

			}

		} else {
			//if the obj is not an instance of this class, then return false.
			return false;
			
		}
		return false;

	}
	
	public void meaninglessAction() {
		System.out.println("Drinks a martini");
	}
	
	public void moveDistance() {
		System.out.println("Moves 30 feet");
	}

}
