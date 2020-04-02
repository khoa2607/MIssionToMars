

class U1 extends Rocket {

	/*
	*private int cost; 100
	*private int rocketWeight; 10000
	*private int maxWeight; 18000
	*private double ChofExp; = 5% * (cargo carried/cargo limit)
	*private double ChofCra; = 1% * (cargo carried/cargo limit)
	*private int currentWeight;
	*private int limitWeight; 
	 */
	//new field for U1 only, stuff put in the U1 rocket
	private double U1Cargo;
	
	public U1() {
		super(100,10000,18000);
		this.U1Cargo = 0; 
	}
	
	public void setU1Cargo(double CarriedCargo) {
		this.U1Cargo = CarriedCargo;
	}
	
	public double getU1Cargo() {
		return U1Cargo;
	}
	
	//extend to override the launch and land method
	public boolean launch() {
		//5% * (cargo carried/cargo limit) success when ChOfExp < random
		double cargoLimit = getLimitWeight();
		double launchFail = (5 * (U1Cargo/cargoLimit));
		//generate a random number , if random > LaunchFail -> success
		return randNumberLaunch()>=launchFail;
	}
	public boolean land() {
		//1% * (cargo carried/cargo limit) success when ChOfExp < random
		double cargoLimit = getLimitWeight();
		double CrashFail = 1 * (U1Cargo/cargoLimit);
		//generate a random number , if random > CrashFail -> success
		return randNumberLand()>=CrashFail;
	}	
	
	
	public double getCurrentWeightU1() {
		return U1Cargo+10000;
	}
	
	
}
