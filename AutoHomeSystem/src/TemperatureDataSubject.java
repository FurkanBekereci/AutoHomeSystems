import java.util.ArrayList;
import java.util.List;


public class TemperatureDataSubject implements ISubject<Float>{
	
	private List<IObserver> observers =new ArrayList<IObserver>();
	private Float lastData;
	public TemperatureDataSubject() {
		new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					lastData=(float)(Math.random()*40+10);
					notifyAllObservers();
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	public void register(IObserver obs) {
		// TODO Auto-generated method stub
		observers.add(obs);
	}

	public Float getData() {
		// TODO Auto-generated method stub
		return lastData;
	}
	public void notifyAllObservers() {
		// TODO Auto-generated method stub
		for(IObserver o:observers){
			o.update(this);
		}
	}
	
	
	
	
}
