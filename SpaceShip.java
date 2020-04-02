
public interface SpaceShip {

	
	//launch method that returns either true or false indicating if the launch was  succesfull 
	//or if the rocket has crash
	boolean launch();
	
	//land method that also return either true of false based on the success of of the landing
	boolean land();
	
	//canCarry method that takes an Item as an argument and return true if the rocket
	//can carry such item or false if it will exceed the weight limit
	boolean canCarry(Item item);
	
	//carry method that also takes an Item object and updates the current weight of the rocket. 
	double carry(Item weight);
	
}
