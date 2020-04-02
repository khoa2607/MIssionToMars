
class U2 extends Rocket {
	/*
	 * Cost = 120 millions
	 * Rocket weight = 18 tonnes
	 * Max weight = 29 tonnes
	 * Chance of launch explosion = 4% * (cargo carried / cargo limit)
	 * chance of landing crash = 8% * (cargo carried / cargo limit)
	 */
	
	//U2 field
	private double U2Cargo;
	
	public U2() {
		super(120,18000,29000);
		this.U2Cargo = 0;
	}	
	
	public void setU2Cargo(double d) {
		this.U2Cargo = d;
	}
	
	//extend to override the launch and land method
	public boolean launch() {
		// 4% * (cargo carried / cargo limit) sucess when ChOfExp < random
		double cargoLimit = getLimitWeight();
		double launchFail = 4 * (U2Cargo/cargoLimit);
		
		//generate a random number , if random > LaunchFail -> success
		return randNumberLaunch()>=launchFail;
	}
	public boolean land() {
		//8% * (cargo carried / cargo limit) sucess when ChOfExp < random
		double cargoLimit = getLimitWeight();
		double CrashFail = 8 * (U2Cargo/cargoLimit);
		
		//generate a random number , if random > CrashFail -> success
		return randNumberLand()>=CrashFail;
	}
	
	public double getCurrentWeightU2() {
		return U2Cargo+18000;	
	}
}
