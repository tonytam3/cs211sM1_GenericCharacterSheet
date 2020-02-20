
public class PathfinderCharacterBasicUtility {
	
	/*
	 * Every character is going to need some way to calculate total stat value. So totalBaseStat is moved here remove repeat code
	 */
	
	
	private StatNode[] totalBaseStatArray;
	private StatNode[] tempStatNodesArray;
	GenericCharacter temp;
	
	public PathfinderCharacterBasicUtility (GenericCharacter Object) {
		temp = Object;
		
		totalBaseStatArray = Object.getStatNodeArray().clone();
		tempStatNodesArray = new StatNode[Object.getStatNodeArray().length];
		
		for (int i = 0; i < totalBaseStatArray.length; i++) {
			totalBaseStatArray[i] = new StatNode();
			totalBaseStatArray[i].copy(Object.getStatNode(i));
		}
		
		saveTotalBaseStatArray();
	}
	
	/*
	 * This method parse through the tempStatNodesArray looking for anything 'not null' and then re-add all the statValue starting from
	 * original base value;
	 */
	
	public void saveTotalBaseStatArray() {
		//retrieving the original array, adding all stat Modifiers. So far just statBonus
		StatNode tempNode;
		
		for(int i = 0; i < tempStatNodesArray.length; i++) {
			if (tempStatNodesArray[i] != null) {
				tempNode = tempStatNodesArray[i];
				totalBaseStatArray[i].setStatValue(temp.getStatNode(i).getStatValue()); //setting the totalBaseStatArray[i] to the base stat value
				while(tempNode != null) {
					totalBaseStatArray[i].addStatValue(tempNode.getStatValue()); // parsing the linkedList and add stat value
					tempNode = tempNode.getNextNode();
				}
			}
		}
	}
	
	/*
	 * This method allows the classes to specify the statArray position and go through the statNode's linked list to add additional statNodes
	 */
	
	public void addTempStatNodeToLink (int nodeArrayPosition, StatNode object) {
		if(tempStatNodesArray[nodeArrayPosition] != null) {
			
			StatNode tempNode = tempStatNodesArray[nodeArrayPosition];
			
			while(tempNode.getNextNode() != null) {
				tempNode = tempNode.getNextNode();
			}
			
			tempNode.setNextNode(object);
			
		} else {
			tempStatNodesArray[nodeArrayPosition] = object;
		}

	}
	
	public StatNode[] getTotalBaseStatArray() {
		return totalBaseStatArray;
	}
	
	
}
