
public class PathfinderFeats {
	
	private int id;
	private String name;
	private PathfinderFeatType type;
	private String description;
	private String prerequisite;
	private String prerequisiteFeats;
	private String benefits;
	private String normal;
	private String special;
	private PathfinderFeatSource source;
	
	private PathfinderFeats (PathfinderFeatBuilder object) {
		id = object.id;
		name = object.name;
		type = object.type;
		description = object.description;
		prerequisite = object.prerequisite;
		prerequisiteFeats = object.prerequisiteFeats;
		benefits = object.benefits;
		normal = object.normal;
		special = object.special;
		source = object.source;
	}
	
	public class buildFeat extends PathfinderFeatBuilder{
		public buildFeat (int id) {
			super (id);
		}
		
		@Override 
		public PathfinderFeats build() {
			return new PathfinderFeats(this);
		}
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o instanceof PathfinderFeats) {
			PathfinderFeats temp = (PathfinderFeats) o;
			
			if(temp.id!=this.id) return false;
			if(!temp.name.equals(this.name)) return false;
			if(temp.type!=this.type) return false;
			if(!temp.prerequisite.equals(this.prerequisite)) return false;
			if(!temp.prerequisiteFeats.equals(this.prerequisiteFeats)) return false;
			if(!temp.benefits.equals(this.benefits)) return false;
			if(!temp.normal.equals(this.normal)) return false;
			if(!temp.special.equals(this.special)) return false;
			if(temp.source!=this.source) return false;
			
			return true;
		}
		
		return false;
		
	}
	
	public int compareTo(Object o) {
		if(o instanceof PathfinderFeats) {
			PathfinderFeats temp = (PathfinderFeats) o;
			if (temp.id == this.id && temp.name.equals(this.name)) {
				return 0;
			} else if(this.id > 0) {
				return 1;
			} else {
				return -1;
			}
			
		} else {
			return -1;
		}

	}
	
	
	
	
	
	
	
	
}
