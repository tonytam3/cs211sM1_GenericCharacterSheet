
public abstract class GenericCharacter {
	
	protected String Name;
	protected Object Stat;
	
	public GenericCharacter(String NewName) {
		Name = NewName;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Object getStat() {
		return Stat;
	}
	public void setStat(Object stat) {
		Stat = stat;
	}
	
	@Override
	public String toString() {
		return Name;
	}
	
	
	
}
