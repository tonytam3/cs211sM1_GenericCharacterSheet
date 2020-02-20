import java.lang.StringBuilder;

public class PathfinderDwarfCharacter extends PathfinderCharacter {
	
	/*
	 * Dwarves has a +2 bonus to constituion and wisdom stats, but a -2 to charisma. The bonus allocation cannot be user defined.
	 */

	private int conStatBonus = 2;
	private int wisStatBonus = 2;
	private int chaStatBonus = -2;

	private StatNode[] totalBaseStatArray;

	private PathfinderDwarfCharacter(String name) {

		super();
		
		this.setName(name);

		totalBaseStatArray = this.getStatNodeArray().clone();

		for (int i = 0; i < totalBaseStatArray.length; i++) {
			totalBaseStatArray[i] = new StatNode();
			totalBaseStatArray[i].copy(this.getStatNode(i));
		}

		this.saveTotalBaseStatArray();

	}
	
	public static class PathfinderDwarfBuilder{
		String name;
		int str, dex, con, inte, wis, cha;

		public PathfinderDwarfBuilder(String name) {
			this.name = name;
		}

		public PathfinderDwarfBuilder str(int value) {
			this.str = value;
			return this;
		}

		public PathfinderDwarfBuilder dex(int value) {
			this.dex = value;
			return this;
		}

		public PathfinderDwarfBuilder con(int value) {
			this.con = value;
			return this;
		}

		public PathfinderDwarfBuilder inte(int value) {
			this.inte = value;
			return this;
		}

		public PathfinderDwarfBuilder wis(int value) {
			this.wis = value;
			return this;
		}

		public PathfinderDwarfBuilder cha(int value) {
			this.cha = value;
			return this;
		}

		public PathfinderDwarfBuilder build() {
			return this;
		}
	}


	public int getConStatBonus() {
		return conStatBonus;
	}

	public void setConStatBonus(int conStatBonus) {
		this.conStatBonus = conStatBonus;
		totalBaseStatArray[2].setStatValue(this.getStatNode(2).getStatValue() + conStatBonus);
	}

	public int getWisStatBonus() {
		return wisStatBonus;
	}

	public void setWisStatBonus(int wisStatBonus) {
		this.wisStatBonus = wisStatBonus;
		totalBaseStatArray[4].setStatValue(this.getStatNode(4).getStatValue() + wisStatBonus);
	}

	public int getChaStatBonus() {
		return chaStatBonus;
	}

	public void setChaStatBonus(int chaStatBonus) {
		this.chaStatBonus = chaStatBonus;
		totalBaseStatArray[5].setStatValue(this.getStatNode(4).getStatValue() + chaStatBonus);
	}

	public StatNode[] getTotalStatArray() {
		return totalBaseStatArray;
	}

	public void saveTotalBaseStatArray() {

		totalBaseStatArray[2].setStatValue(this.getStatNode(2).getStatValue() + conStatBonus);
		totalBaseStatArray[4].setStatValue(this.getStatNode(4).getStatValue() + wisStatBonus);
		totalBaseStatArray[5].setStatValue(this.getStatNode(4).getStatValue() + chaStatBonus);

	}

	@Override
	public String toString() {

		StringBuilder tempString = new StringBuilder("Character Name: " + this.getName() + ", ");

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
			if (tempObject.getName().equals(this.getName())) {

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
