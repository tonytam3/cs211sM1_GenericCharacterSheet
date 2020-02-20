
public class PathfinderHalfOrcPurse implements Money{
	
	int platinum = 0, gold = 0, silver = 0, copper = 0;

	@Override
	public void purseNoise() {
		
		System.out.println("buzzz");
		
	}

	@Override
	public void addPlatinum(int value) {
		this.platinum = this.platinum + value;
		
	}

	@Override
	public void addGold(int value) {
		this.gold = this.gold + value;
		
	}

	@Override
	public void addSilver(int value) {
		this.silver = this.silver + value;
		
	}

	@Override
	public void addCopper(int value) {
		this.copper = this.copper + value;
		
	}

	@Override
	public void subtractPlatinum(int value) {
		this.platinum = this.platinum - value;
		
	}

	@Override
	public void subtractGold(int value) {
		this.gold = this.gold - value;
		
	}

	@Override
	public void subtractSilver(int value) {
		this.silver = this.silver - value;
		
	}

	@Override
	public void subtractCopper(int value) {
		this.copper = this.copper - value;
		
	}

	@Override
	public String moneyPrint() {
		
		String temp = "Platinum: " + this.platinum + ", Gold: " + this.gold + ", Silver: " + this.silver +", Copper: " + this.copper;
		
		return temp;
	}

	

}
