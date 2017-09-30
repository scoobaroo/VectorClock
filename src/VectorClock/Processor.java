package VectorClock;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Processor extends Thread implements Observer {
	
    public void update(Observable observable, Object arg) {
		Buffer b = (Buffer) observable;
		Message msg = b.getMessage();
    }
    
    public void run(List<Event> listOfEvents) {
		// TODO Auto-generated method stub
		
	}
    
}
