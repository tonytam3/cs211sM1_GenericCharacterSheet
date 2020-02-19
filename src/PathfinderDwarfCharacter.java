import java.lang.StringBuilder;

public class PathfinderDwarfCharacter {
	
	/*
	 * Dwarves has a +2 bonus to constituion and wisdom stats, but a -2 to charisma. The bonus allocation cannot be user defined.
	 */

	private int conStatBonus = 2;
	private int wisStatBonus = 2;
	private int chaStatBonus = -2;
	PathfinderCharacter dwarf;

	private StatNode[] totalBaseStatArray;

	public PathfinderDwarfCharacter(String name) {

		dwarf = new PathfinderCharacter.PathfinderCharacterBuilder("EmptyField")
				.str(0).dex(0).con(0).inte(0).wis(0).cha(0).build();

		totalBaseStatArray = dwarf.getStatNodeArray().clone();

		for (int i = 0; i < totalBaseStatArray.length; i++) {
			totalBaseStatArray[i] = new StatNode();
			totalBaseStatArray[i].copy(dwarf.getStatNode(i));
		}

		this.saveTotalBaseStatArray();

	}

	public int getConStatBonus() {
		return conStatBonus;
	}

	public void setConStatBonus(int conStatBonus) {
		this.conStatBonus = conStatBonus;
		totalBaseStatArray[2].setStatValue(dwarf.getStatNode(2).getStatValue() + conStatBonus);
	}

	public int getWisStatBonus() {
		return wisStatBonus;
	}

	public void setWisStatBonus(int wisStatBonus) {
		this.wisStatBonus = wisStatBonus;
		totalBaseStatArray[4].setStatValue(dwarf.getStatNode(4).getStatValue() + wisStatBonus);
	}

	public int getChaStatBonus() {
		return chaStatBonus;
	}

	public void setChaStatBonus(int chaStatBonus) {
		this.chaStatBonus = chaStatBonus;
		totalBaseStatArray[5].setStatValue(dwarf.getStatNode(4).getStatValue() + chaStatBonus);
	}

	public StatNode[] getTotalStatArray() {
		return totalBaseStatArray;
	}

	public void saveTotalBaseStatArray() {

		totalBaseStatArray[2].setStatValue(dwarf.getStatNode(2).getStatValue() + conStatBonus);
		totalBaseStatArray[4].setStatValue(dwarf.getStatNode(4).getStatValue() + wisStatBonus);
		totalBaseStatArray[5].setStatValue(dwarf.getStatNode(4).getStatValue() + chaStatBonus);

	}

	@Override
	public String toString() {

		StringBuilder tempString = new StringBuilder("Character Name: " + dwarf.getName() + ", ");

		for (StatNode tempNode : this.totalBaseStatArray) {
			String nodeString = String.format("%s: %d, ", tempNode.getStatName(), tempNode.getStatValue());
			tempString.append(nodeString);
		}

		return tempString.toString();

	}

	@Override
	public boolean equals(Object obj) {
		// checking if the obj is an instance of this class
		if (obj instanceof PathfinderDwarfCharacter) {

			PathfinderDwarfCharacter tempObject = (PathfinderDwarfCharacter) obj;
			// checking if the names of the object is the same.
			if (tempObject.dwarf.getName().equals(this.dwarf.getName())) {

				StatNode[] tempArray = tempObject.getTotalStatArray();
				// This loop goes through all the entire stat array of both objects for name and
				// value comparison.
				for (int i = 0; i < tempArray.length; i++) {

					if (tempArray[i].getStatName() != this.totalBaseStatArray[i].getStatName()) {
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
			// if the obj is not an instance of this class, then return false.
			return false;

		}
		return false;

	}

	public void meaninglessAction() {
		System.out.println("Drinks a lager");
	}

	public void moveDistance() {
		System.out.println("Moves 20 feet");
	}

}
