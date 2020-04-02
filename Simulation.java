import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

class Simulation {

	/*
	 * LoadItems method loads all items from a text file and returns an ArrayList of items:
	 * LoadItems should read the text file line by line and create an item object for each and 
	 * then add it to an ArrayList of Items. The method should then return that ArrayList
	 */
	public ArrayList<Item> loadItem(String textName) throws Exception {
		
		//Create an ArrayList
		ArrayList<Item> myItemList = new ArrayList<>();
		
		//create File object
		File text = new File(textName);
		Scanner scanner = new Scanner(text);
		
		while(scanner.hasNextLine()) {
			
			String line = scanner.nextLine();
			//separate String and integer of the line and store into the ArrayList
			//Create Item object
			int indexOfequal = line.indexOf("=");
			String nameCargo = line.substring(0,indexOfequal);
			int weightCargo = Integer.parseInt(extractInteger(line));
			Item currentItem = new Item(nameCargo,weightCargo);
			
			//add to Array list
			myItemList.add(currentItem);
		}
		scanner.close();
		return myItemList;
	}
	
	public ArrayList<U1> loadU1(ArrayList<Item> item){
		ArrayList<U1> myU1List = new ArrayList<>(); //get the list of items
		//System.out.println("I'mhere");
		
		int itemCount = 0;
		boolean something = true;
		while(something) {//repeat until all items are loaded			
			//create rocket to fill cargo
			U1 U1Rocket = new U1(); //create first rocket and fill first cargo
			
			double currentWeight = U1Rocket.getCurrentWeightU1();
			
			while(itemCount <= item.size()-1) {
				//check to see the current weight exceeds the limit
				if(currentWeight + item.get(itemCount).getWeight() <= 18000) {
					currentWeight = currentWeight + item.get(itemCount).getWeight();
					itemCount++;
				}
				else {break;}	
			}

			U1Rocket.setU1Cargo((currentWeight-10000)); //set the carried cargo
			//System.out.println("THHE CURRENT WEIGHT IS: " + U1Rocket.getCurrentWeightU1());
			myU1List.add(U1Rocket); //add loaded U1 rocket to the list of U1 
			
			
			
			if(itemCount>=item.size()-1) {		
				something = false;
			}	
		}
		return myU1List;		
	}
	
	
	public ArrayList<U2> loadU2(ArrayList<Item> item){
		ArrayList<U2> myU2List = new ArrayList<>(); //get the list of items
		//System.out.println("I'mhere");
		
		int itemCount = 0;
		boolean something = true;
		
		while(something) {//repeat until all items are loaded			
			//create rocket to fill cargo
			U2 U2Rocket = new U2(); //create first rocket and fill first cargo
			
			double currentWeight = U2Rocket.getCurrentWeightU2();
			
			while(itemCount <= item.size()-1) {
				//check to see the current weight exceeds the limit
				if(currentWeight + item.get(itemCount).getWeight() <= 29000) {
					currentWeight = currentWeight + item.get(itemCount).getWeight();
					itemCount++;
				}
				else {break;}	
			}

			U2Rocket.setU2Cargo((currentWeight-18000)); //set the carried cargo
			
			myU2List.add(U2Rocket); //add loaded U1 rocket to the list of U1 
			
			if(itemCount>=item.size()-1) {		
				something = false;
			}	
		}
		return myU2List;		
	}
	
	int runSimulation(ArrayList<Rocket> rocket) {
		int totalCost = 0;
		boolean missionContinue = true;
		int rocketSuccess = 0;
		int rocketFail = 0;
		int i = 0;

		//sending loaded rockets, if the rocket exploded or crashed, sent the same one again.
			
		while( i < rocket.size()) { //rocketsize is at least 9 times, if fail i won't increase
			boolean successLaunch = rocket.get(i).launch();
			boolean successLand = rocket.get(i).land();
				if(successLaunch == true && successLand == true ) {
					//System.out.println("Chance of success of Rocket "+(i+1)+" is "+ successLaunch);
					System.out.println("Rocket number " + (i+1) + " has been sent to Mars");				
					rocketSuccess++;
					totalCost += rocket.get(i).getCost(); 
					i++;
				}
				else {
					System.out.println("The rocket is "+ (i+1) + " either crashed or exploded");
					rocketFail++;
					totalCost += rocket.get(i).getCost();
					//have to resend the i again
				}
				
		}
		System.out.println("There are " +rocketSuccess+" success and " +rocketFail +" rocket Fail");
		return totalCost;
	}
	
	//create a method to extract the Integer
	static String extractInteger(String str) {
		//replace all non-ditgi number
		str = str.replaceAll("[^\\d]", " ");
		
		//remove space from begining and ending
		str = str.trim();
		
		//remove all consecutive white spaces with a single space
		str = str.replaceAll(" +"," ");
		
		if(str.contentEquals(""))
			return "-1";
		
		return str;
	}
	
}
