public abstract class PathfinderCharacterBuilder {
	String name;
	int str = 10, dex = 10, con = 10, inte = 10, wis = 10, cha = 10;

	public PathfinderCharacterBuilder(String name) {
		this.name = name;
	}

	public PathfinderCharacterBuilder str(int value) {
		this.str = value;
		return this;
	}

	public PathfinderCharacterBuilder dex(int value) {
		this.dex = value;
		return this;
	}

	public PathfinderCharacterBuilder con(int value) {
		this.con = value;
		return this;
	}

	public PathfinderCharacterBuilder inte(int value) {
		this.inte = value;
		return this;
	}

	public PathfinderCharacterBuilder wis(int value) {
		this.wis = value;
		return this;
	}

	public PathfinderCharacterBuilder cha(int value) {
		this.cha = value;
		return this;
	}

	public <T> Object build() {
		return this;
	}
}
