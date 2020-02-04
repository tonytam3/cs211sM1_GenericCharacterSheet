
public abstract class GenericCharacter {

	private String Name;
	private StatNode[] statNodeArray;

	public GenericCharacter( int statNodeArraySize) {
		statNodeArray = new StatNode[statNodeArraySize];
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public void readStatNode(int nodePosition) {
		if (nodePosition < statNodeArray.length) {
			System.out.println(statNodeArray[nodePosition]);
		} else {
			System.out.print("Index out of Bounds");
		}
	}

	@Override
	public String toString() {
		return Name ;
	}

}
