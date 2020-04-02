
class Item {

	private String name;
	private double weight;
	
	//default constructors
	public Item(String name,int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
		
}
