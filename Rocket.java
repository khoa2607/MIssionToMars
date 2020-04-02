import java.util.Random;

class Rocket implements SpaceShip { //implements all the methods 

	//fields cost, weight, max weight, chance of launch explosion, chance of landing crash
	private int cost;
	private double rocketWeight;
	private double maxWeight;
	private double currentWeight;
	private double limitWeight;
	
	//Default constructors
	public Rocket(int cost, double rocketWeight,double maxWeight) {
		this.cost = cost;
		this.rocketWeight = rocketWeight;
		this.maxWeight = maxWeight;
		this.currentWeight = 0; //including the rocket and stuff
		this.limitWeight = maxWeight - rocketWeight;
	}
	
	/*
	launch & land method in the Rocket class should always return true. 
	When U1 and U2 classes extend the Rocket class they will override these methods and return true
	or false based on the actual probability of each type
	*/
	public boolean launch() {
		return true;
	}
	
	public boolean land() {
		return true;
	}
	
	/*
	carry and canCarry should be implemented here and will not need to be overriden in the U1 and U2 classes
	*/
	public boolean canCarry(Item item) {
		return (this.currentWeight + item.getWeight()+this.rocketWeight)<=this.maxWeight;
	}
	
	public double carry(Item item) {
		currentWeight += item.getWeight();
		return currentWeight;
	}
	
	//set up some get method to access fields
	public double getLimitWeight() {
		return limitWeight;
	}
	
	//random method within this class only
	public double randNumberLaunch() {
		Random rd = new Random();//creating Random object		
		return rd.nextDouble()*100;
	}
	
	public double randNumberLand() {
		Random rd = new Random();//creating Random object		
		return rd.nextDouble()*100;
	}
	
	public int getCost() {
		return this.cost;
	}
}
