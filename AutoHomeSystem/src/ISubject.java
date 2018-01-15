
public interface ISubject<T> {

	void register(IObserver obs);
	T getData();
	void notifyAllObservers();
	
}
