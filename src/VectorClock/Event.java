package VectorClock;

public class Event {
	private EventType eventtype;
	private VectorClock vClock;
	public Event(EventType et, VectorClock vc) {
		setEventtype(et);
		setvClock(vc);
	}
	public EventType getEventtype() {
		return eventtype;
	}
	public void setEventtype(EventType eventtype) {
		this.eventtype = eventtype;
	}
	public VectorClock getvClock() {
		return vClock;
	}
	public void setvClock(VectorClock vClock) {
		this.vClock = vClock;
	}

}
