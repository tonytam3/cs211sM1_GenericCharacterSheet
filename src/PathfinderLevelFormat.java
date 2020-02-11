
public enum PathfinderLevelFormat {

	SLOW(1), MEDIUM(2), FAST(3);

	/*
	 * This Enum is for determining the experience requirement for leveling up in
	 * Pathfinder There's no "0" level in Pathfinder and every character starts at
	 * level 1.
	 * 
	 * So the array position corresponds to the level position of the character.
	 * This size of the arrays should be a size of 21 because there's 20 level in
	 * Pathfinder.
	 */

	private int choice;
	private int[] arrayToUse = new int[21];

	private int[] slow = { 0, 0, 3000, 7500, 14000, 23000, 35000, 53000, 77000, 115000, 160000, 235000,
			330000, 475000, 665000, 955000, 1350000, 1900000, 2700000, 3850000, 5350000 };
	private int[] medium = { 0, 0, 2000, 5000, 9000, 15000, 23000, 35000, 51000, 75000, 105000, 155000,
			220000, 315000, 445000, 635000, 890000, 1300000, 1800000, 2550000, 3600000 };
	private int[] fast = { 0, 0, 1300, 3300, 6000, 10000, 15000, 23000, 34000, 50000, 71000, 105000,
			145000, 210000, 295000, 425000, 600000, 850000, 1200000, 1700000, 2400000 };

	private PathfinderLevelFormat(int speed) {
		this.choice = speed;
		this.setArrayToUse();
	}

	private void setArrayToUse() {
		switch (choice) {
		case 1:
			arrayToUse = slow;
			break;
		case 2:
			arrayToUse = medium;
			break;
		case 3:
			arrayToUse = fast;
			break;
		}
	}

	public int[] getLevelFormat() {
		return arrayToUse;
	}

	public int returnLevelPosition(int experiencePoints) {

		if (experiencePoints >= arrayToUse[20]) { // If the character's level has already past the level 20 threshold then just return 20;
			return 20;
		} else if (experiencePoints < arrayToUse[2]) { // If the character has no experience points or less than minRequirement for level 2, then return 1;
			return 1;
		}

		for (int level = 2; level < arrayToUse.length; level++) { // Otherwise determine
			if (arrayToUse[level] > experiencePoints) {
				return level - 1;
			}
		}

		return 0;
	}

	public int returnBaseExperiencePoint(int level) {
		if (level > 0 && level < 21) {
			return arrayToUse[level];
		} else {
			return 0;
		}
	}

}
