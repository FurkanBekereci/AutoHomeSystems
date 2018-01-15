public class HomeAirConditionerFacade {

	public AirCooler airCooler;
	public CombiBoiler combiBoiler;
	public FireExtinguisher fireExtinguisher;
	public EmergencyCaller emergencyCaller;
	
	public HomeAirConditionerFacade(){
		airCooler=new AirCooler();
		combiBoiler=new CombiBoiler();
		fireExtinguisher=new FireExtinguisher();
		emergencyCaller=new EmergencyCaller();
	}
	public void startHeating() {
		airCooler.stop();
		combiBoiler.startHeating();
	}

	public void startCooling() {
		combiBoiler.stop();
		airCooler.startCooling();
	}
	
	public void startExtinguishing() {
		airCooler.stop();
		combiBoiler.stop();
		fireExtinguisher.Extinguishe();
		emergencyCaller.Call911();
	}

}
