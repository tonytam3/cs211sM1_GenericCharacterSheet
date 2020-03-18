
 public abstract class PathfinderFeatBuilder {
	
	public int id = 0;
	public String name = "";
	public PathfinderFeatType type = PathfinderFeatType.GENERAL;
	public String description = "";
	public String prerequisite = "";
	public String prerequisiteFeats = "";
	public String benefits = "";
	public String normal = "";
	public String special = "";
	public PathfinderFeatSource source = PathfinderFeatSource.Advanced_Players_Guide;//complete this when class file is corrected
	
	public PathfinderFeatBuilder (int id) {
		this.id = id;
	}
	
	public PathfinderFeatBuilder id(int id) {
		this.id = id;
		return this;
	}
	
	public PathfinderFeatBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public PathfinderFeatBuilder type (PathfinderFeatType type) {
		this.type = type;
		return this;
	}
	
	public PathfinderFeatBuilder description(String description) {
		this.description = description;
		return this;
	}
	
	public PathfinderFeatBuilder prerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
		return this;
	}
	
	public PathfinderFeatBuilder prerequisiteFeats(String prerequisiteFeats) {
		this.prerequisiteFeats = prerequisiteFeats;
		return this;
	}
	
	public PathfinderFeatBuilder benefits(String benefits) {
		this.benefits = benefits;
		return this;
	}
	
	public PathfinderFeatBuilder normal(String normal) {
		this.normal = normal;
		return this;
	}
	
	public PathfinderFeatBuilder special(String special) {
		this.special = special;
		return this;
	}
	
	public PathfinderFeatBuilder source(PathfinderFeatSource source) {
		this.source = source;
		return this;
	}


	public <T> Object build() {
		return this;
	}
	
	
}
