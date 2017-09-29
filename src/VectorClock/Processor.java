package VectorClock;
import java.util.Observable;
import java.util.Observer;

import edu.dt.Buffer;
import edu.dt.Message;

public class Processor extends Thread implements Observer {
	
	
    public void update(Observable observable, Object arg) {
		Buffer b = (Buffer) observable;
		Message msg = b.getMessage();
    }
}
