import java.util.Comparator;
import java.util.Random;

public class PathfinderCharacter extends GenericCharacter implements Comparable<PathfinderCharacter> {

	// Pathfinder is a table top roleplayer system analogous to Dungeons and Dragon

	static final int str = 0, dex = 1, con = 2, inte = 3, wis = 4, cha = 5;

	static final int statArraySize = 12;
	private int AbilityScorePointFormat = 0;
	private int AbilityScorePointAmount = 0;
	private int experiencePoints = 0;
	private PathfinderLevelFormat levelFormat;
	private Money money;

	public final static Comparator<PathfinderCharacter> characterComparator = new PathfinderCharacterComparator();

	private int[] pointBuyChart = { -4, -2, -1, 0, 1, 2, 3, 5, 7, 10, 13, 17 };

	public PathfinderCharacter() {
		super(statArraySize);

		this.setStatNodeName(0, "Strength");
		this.setStatNodeName(1, "Dexterity");
		this.setStatNodeName(2, "Constitution");
		this.setStatNodeName(3, "Intelligence");
		this.setStatNodeName(4, "Wisdom");
		this.setStatNodeName(5, "Charisma");

		this.setStatNodeName(6, "Hit Points");
		this.setStatNodeName(7, "Armor Class");
		this.setStatNodeName(8, "Touch Armor Class");
		this.setStatNodeName(9, "Flat-Footed Armor Class");
		this.setStatNodeName(10, "Initiative");
		this.setStatNodeName(11, "Base Attack Bonus");

		this.setLevel(1);
		levelFormat = PathfinderLevelFormat.SLOW;
		setAbilityScoreFormat(0);
		
		randomPurse();

	}


	public static class PathfinderCharacterComparator implements Comparator<PathfinderCharacter> {

		@Override
		public int compare(PathfinderCharacter arg0, PathfinderCharacter arg1) {
			if (arg0.getLevel() == arg1.getLevel()) {
				return 0;
			} else if (arg0.getLevel() < arg1.getLevel()) {
				return -1;
			} else {
				return 1;
			}

		}

	}
	
	public void randomPurse() {
		Random t = new Random();
		int t1 = t.nextInt();
		int t2 = t.nextInt();
		
		if(t1<t2) {
			money = new PathfinderHalfOrcPurse();
		} else {
			money = new PathfinderDwarfPurse();
		}
		
	}

	public Money getMoney() {
		return money;
	}

	public int getAbilityScorePointAmount() {
		return AbilityScorePointAmount;
	}

	public int[] getPointBuyChart() {
		return pointBuyChart;
	}

	public PathfinderLevelFormat getLevelFormat() {
		return levelFormat;
	}

	public int getExperiencePoints() {
		return experiencePoints;
	}

	public String getStatNodeName(int nodePosition) {

		if (nodePosition > -1 && nodePosition < statArraySize) {

			return this.getStatNode(nodePosition).getStatName();

		} else {
			return "Node not found";
		}
	}

	public int getStatNodeValue(int nodePosition) {
		if (nodePosition > -1 && nodePosition < statArraySize) {

			return this.getStatNode(nodePosition).getStatValue();

		} else {
			return 0;
		}
	}

	/*
	 * This method is for setting the Ability Score Point Format. 0 = (Low Fantasy,
	 * 10) 1 = (Standard Fantasy, 15), 2 = (High Fantasy, 20), 3 = (Epic Fantasy,
	 * 25), 4 = Manual Entry from Random Dice Roll of 4d6
	 */

	public void setAbilityScoreFormat(int number) {

		if (number >= 0 && number < 5) {

			this.AbilityScorePointFormat = number;

			if (AbilityScorePointFormat < 4) {

				AbilityScorePointAmount = 5 * (2 + AbilityScorePointFormat);

			}

		} else {

			System.out.print("Format number not allowed");

		}

	}

	/*
	 * This method is for setting the ability score value of the character as
	 * modifying the AbilityScorePointAmount according to pointBuyChart.
	 * AbilityScorePointAmount modification only applies for AbilityScorePointFormat
	 * from 0 to 3. This method only applies to the first 6 in the statNode Array;
	 * Strength to Charisma.
	 */

	public void setBaseStatValue(int nodePosition, int statValue) {

		if (nodePosition > -1 && nodePosition < 6) {

			if (AbilityScorePointFormat < 4) {

				if (statValue > 6 && statValue < 19) {

					int statPointCost = pointBuyChart[(statValue - 7)];

					if (AbilityScorePointAmount >= 0) {

						this.setStatNodeValue(nodePosition, statValue);
						AbilityScorePointAmount = AbilityScorePointAmount - statPointCost;

					} else {
						System.out.println("Not enough Ability Score Point for the selected stat value");
					}

				} else {
					System.out.println("Stat Value out of range for base character creation");
				}

			} else {

				this.setStatNodeValue(nodePosition, statValue);

			}
		} else {
			System.out.println("No valid stat node found");
		}
	}

	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
		this.setLevel(levelFormat.returnLevelPosition(this.experiencePoints));
	}

	public void setLevelFormat(PathfinderLevelFormat levelFormat) {
		this.levelFormat = levelFormat;
		this.setLevel(levelFormat.returnLevelPosition(this.experiencePoints));
	}

	public void meaninglessAction() {
		System.out.println("Wave");
	}

	public void moveDistance() {
		System.out.println("Doesn't have legs");
	}

	@Override
	public int compareTo(PathfinderCharacter object) {

		if (this.getLevel() < object.getLevel()) {
			return this.getLevel() - object.getLevel();
		} else if (this.getLevel() == object.getLevel()) {
			return 0;
		} else {
			return this.getLevel() - object.getLevel();
		}
	}

}
