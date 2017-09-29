package VectorClock;

public class Message {
	private Event event;
	private Processor sender;
	private Processor receiver;
	public Message(Event e, Processor s, Processor r) {
		setEvent(e);
		setSender(s);
		setReceiver(r);
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Processor getSender() {
		return sender;
	}
	public void setSender(Processor sender) {
		this.sender = sender;
	}
	public Processor getReceiver() {
		return receiver;
	}
	public void setReceiver(Processor receiver) {
		this.receiver = receiver;
	}	
}
