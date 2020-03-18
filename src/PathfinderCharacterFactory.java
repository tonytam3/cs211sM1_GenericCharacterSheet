
public class PathfinderCharacterFactory {
	public static PathfinderCharacter newCharacter(String type, String Name) {
		
		switch(type.toLowerCase()) {
		case "dwarf": return new PathfinderDwarfCharacter.PathfinderDwarfBuilder(Name).str(10)
				.dex(10).con(10).inte(10).wis(10).cha(10).build();
		case "halforc": return new PathfinderHalfOrcCharacter.buildCharacter(Name).build();
		default: System.out.println("No Such Race"); return null;
		}
	}
}
