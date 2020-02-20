
public class PathfinderDwarfBuilder {

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
