package VectorClock;

public class Event {
	private EventType eventtype;
	private Processor fromProcessor;
	private Processor toProcessor;
	private VectorClock vc;
	public Event(EventType et) {
		setEventType(et);
	}
	public Event(EventType et, VectorClock vc) {
		setEventType(et);
		setVectorClock(vc);
	}
	public Event(EventType et, VectorClock vc, Processor from,Processor to) {
		setEventType(et);
		setFromProcessor(from);
		setToProcessor(to);
		setVectorClock(vc);
	}
	public EventType getEventType() {
		return eventtype;
	}
	public void setEventType(EventType eventtype) {
		this.eventtype = eventtype;
	}
	public Processor getFromProcessor() {
		return fromProcessor;
	}
	public void setFromProcessor(Processor fromProcessor) {
		this.fromProcessor = fromProcessor;
	}
	public Processor getToProcessor() {
		return toProcessor;
	}
	public void setToProcessor(Processor toProcessor) {
		this.toProcessor = toProcessor;
	}
	public VectorClock getVectorClock() {
		return vc;
	}
	public void setVectorClock(VectorClock vc) {
		this.vc = vc;
	}
}