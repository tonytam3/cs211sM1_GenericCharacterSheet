
public enum PathfinderFeatType {
	GENERAL("general"), COMBAT("combat"), ITEMCREATION("item creation"), METAMAGIC("meta magic"), 
	ACHIEVEMENT("achievement"), BLOODHEX("blood hex"), GRITANDPANACHE("grit and panache"), 
	HEROPOINT("hero point"), ITEMMASTERY("item mastery"), MEDITATION("meditation"), MYTHIC("mythic"),
	PERFORMANCE("performance"), RACIAL("racial"), STORY("story"), STYLE("story"), TARGETING("targeting"), 
	TEAMWORK("teamwork");
	
	String type;
	
	private PathfinderFeatType(String type) {
		this.type = type;
	}
	
	private PathfinderFeatType () {
		this.type = "general";
	}

	public String getType() {
		return type;
	}
	
}
