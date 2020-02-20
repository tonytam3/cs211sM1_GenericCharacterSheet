
public class StatNode {
	private String StatName = "Empty Field";
	private int StatValue = 0;
	private StatNode nextNode;
	
	public StatNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(StatNode nextNode) {
		this.nextNode = nextNode;
	}
	public String getStatName() {
		return StatName;
	}
	public void setStatName(String statName) {
		StatName = statName;
	}
	public int getStatValue() {
		return StatValue;
	}
	public void setStatValue(int statValue) {
		StatValue = statValue;
	}
	
	public void addStatValue (int newvalue) {
		StatValue = this.StatValue + newvalue;
	}
	
	public void copy(StatNode obj) {
		this.setStatName(obj.getStatName());
		this.setStatValue(obj.getStatValue());
	}
	
}
