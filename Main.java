import java.util.ArrayList;

class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Simulation simulation = new Simulation();
		
		ArrayList<Item> phase1 = simulation.loadItem("phase1.txt");
		
		//System.out.println(phase1.get(0).getName());
	
		ArrayList<U1> u1 = simulation.loadU1(phase1);
		ArrayList<U2> u2 = simulation.loadU2(phase1);
		
		//System.out.println(u2);
		//System.out.println(u1.get(0).getU1Cargo());
		
		ArrayList<Rocket> rocketU1 = new ArrayList<>();
		ArrayList<Rocket> rocketU2 = new ArrayList<>();
		
		rocketU1.addAll(u1);
		int costU1 = simulation.runSimulation(rocketU1);
		System.out.println("The total cost Phase 1 for Rocket 1: " +costU1);
		System.out.println("");

		rocketU2.addAll(u2);
		int costU2 = simulation.runSimulation(rocketU2);
		System.out.println("The total cost Phase 1 for Rocket 2: " +costU2);
		System.out.println("");
		
		ArrayList<Item> phase2 = simulation.loadItem("phase-2.txt");
		
		ArrayList<U1> u1phase2 = simulation.loadU1(phase2);
		

		
		ArrayList<U2> u2phase2 = simulation.loadU2(phase2);
		
		ArrayList<Rocket> rocketU1phase2 = new ArrayList<>();
		ArrayList<Rocket> rocketU2phase2 = new ArrayList<>();
		
		rocketU1phase2.addAll(u1phase2);
		//System.out.println("List of U1 phase 2: " + rocketU1phase2);
		
		int costU1phase2 = simulation.runSimulation(rocketU1phase2);
		System.out.println("The total cost Phase 2 for Rocket 1: " +costU1phase2);
		System.out.println("");
		
		
		rocketU2phase2.addAll(u2phase2);
		int costU2phase2 = simulation.runSimulation(rocketU2phase2);
		System.out.println("The total cost Phase 1 for Rocket 2: " +costU2phase2);
		System.out.println("");
		
		
		System.out.println("TOTAL BUDGE FOR ROCKET 1 IS " + (costU1phase2+costU1));
		System.out.println("TOTAL BUDGE FOR ROCKET 2 IS " + (costU2phase2+costU2));
	}

}
