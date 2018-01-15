public class HomeTempControlSystem implements IObserver {

	ISubject mSubject;
	HomeAirConditionerFacade homeAirConditionerFacade;

	public HomeTempControlSystem() {
		homeAirConditionerFacade=new HomeAirConditionerFacade();
		mSubject = new TemperatureDataSubject();
		mSubject.register(this);
	}

	public void update(ISubject s) {
		// TODO Auto-generated method stub
		if (s == mSubject) {
			updateCommand();
		}
	}

	void updateCommand() {
		Float temp = ((TemperatureDataSubject) mSubject).getData();
		System.out.println("home temperature changed:" + temp + " C");
		if (temp > 20 && temp < 40)
			homeAirConditionerFacade.startCooling();
		if (temp < 20)
			homeAirConditionerFacade.startHeating();
		if (temp > 40)
			homeAirConditionerFacade.startExtinguishing();
	}

}
