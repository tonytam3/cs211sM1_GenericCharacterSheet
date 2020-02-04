import java.lang.StringBuilder;

public class PathfinderCharacter extends GenericCharacter {

	// Pathfinder is a table top roleplayer system analogous to Dungeons and Dragon

	static final int statArraySize = 12;
	private int AbilityScorePointFormat = 0;
	private int AbilityScorePointAmount = 0;

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
		this.setStatNodeName(10, "Initiave");
		this.setStatNodeName(11, "Base Attack Bonus");
	}

	public void setAbilityScoreFormat(int number) {

		if (number < 5) {
			this.AbilityScorePointFormat = number;
		} else {
			System.out.print("Format number not allowed");
		}

		if (AbilityScorePointFormat < 4) {
			AbilityScorePointAmount = 5 * (2 + AbilityScorePointFormat);
		}
	}

	public void setStatValue(int nodePosition, int statValue) {
		
		if(nodePosition < this.statArraySize) {
			
			if(statValue )
			
			if(AbilityScorePointFormat < 4 ) {
				this.setStatNodeValue(nodePosition, statValue);
				AbilityScorePointAmount = AbilityScorePointAmount -
			}
		}
		
		
	}

}
