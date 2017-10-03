package VectorClock;

public class Algorithm {	
	int noOfProcessors;
	Processor p0,p1,p2;
	public Algorithm(int noOfProcessors) {
		this.noOfProcessors = noOfProcessors;
		p0 = new Processor(0, noOfProcessors,"Thread"+Integer.toString(0));
		p1 = new Processor(1, noOfProcessors, "Thread"+Integer.toString(1));
		p2 = new Processor(2, noOfProcessors,"Thread"+Integer.toString(2));
	}
//	public void hardcodeExecutionPlan() {
//		List<Event> eventList0 = new ArrayList<Event>();
//		Event e1 = new Event(EventType.SEND,p0,p1);
//		eventList0.add(e1);
//		Event e2 = new Event(EventType.SEND,p0,p2);
//		eventList0.add(e2);
//		Event e3 = new Event(EventType.COMPUTE);
//		eventList0.add(e3);
//		Event e5 = new Event(EventType.COMPUTE);
//		eventList0.add(e5);
//		p0.setEvents(eventList0);
//		
//		List<Event> eventList1 = new ArrayList<Event>();
//		Event e8 = new Event(EventType.SEND,p1,p2);
//		eventList1.add(e8);
//		Event e17 = new Event(EventType.SEND,p1,p0);
//		eventList1.add(e17);
//		p1.setEvents(eventList1);
//		
//		
//		List<Event> eventList2 = new ArrayList<Event>();
//		Event e10 = new Event(EventType.COMPUTE);
//		eventList2.add(e10);
//		Event e11 = new Event(EventType.COMPUTE);
//		eventList2.add(e11);
//		Event e12 = new Event(EventType.SEND,p2,p1);
//		eventList2.add(e12);
//		Event e14 = new Event(EventType.SEND,p2,p1);
//		eventList2.add(e14);
//		Event e16 = new Event(EventType.COMPUTE);
//		eventList2.add(e16);
//		p2.setEvents(eventList2);
//	}
	
	@SuppressWarnings("static-access")
	public void hardcodeExecutionPlan() throws InterruptedException {
		
		Event compute = new Event(EventType.COMPUTE);
		p2.executeEvent(compute);
		p0.executeEvent(new Event(EventType.SEND, p0.getVc(),p0,p1));
		p0.yield();
		p2.executeEvent(compute);
//		Event receive1 = new Event(EventType.RECEIVE,p0.getVc());
//		p1.executeEvent(receive1);
		p2.executeEvent(new Event(EventType.SEND, p2.getVc(),p2,p1));
		p2.yield();
//		Event receive2 = new Event(EventType.RECEIVE,p2.getVc());
//		p1.executeEvent(receive2);
		p0.executeEvent(new Event(EventType.SEND, p0.getVc(),p0,p2));
		p0.yield();
//		Event receive3 = new Event(EventType.RECEIVE,p0.getVc());
//		p2.executeEvent(receive3);
		p2.executeEvent(new Event(EventType.SEND,p2.getVc(),p2,p1));
		p1.executeEvent(new Event(EventType.SEND,p1.getVc(),p1,p2));
		p2.yield();
		p1.yield();
		p0.executeEvent(compute);
//		Event receive4 = new Event(EventType.RECEIVE,p1.getVc());
//		p2.executeEvent(receive4);
//		Event receive5 = new Event(EventType.RECEIVE,p2.getVc());
//		p1.executeEvent(receive5);
		p1.executeEvent(new Event(EventType.SEND,p1.getVc(),p1,p0));
		p1.yield();
//		Event receive6 = new Event(EventType.RECEIVE,p1.getVc());
//		p0.executeEvent(receive6);
		p2.executeEvent(compute);
		p0.executeEvent(compute);
	}
	
	public static void main(String[] args) {
		Algorithm algo = new Algorithm(3);
		algo.init();
	}
	
	public void init() {
		try {
			hardcodeExecutionPlan();
			int [] vc0 = p0.getVc().getTimestampArray();
			System.out.println("Event count at p0: "+ p0.eventCount);
			System.out.print("\nVector Clock at Processor P0:\t[");
			for (int i = 0; i < noOfProcessors; i++) {
				System.out.print(vc0[i]+" ");
			}
			System.out.print("]");
			System.out.println();
			System.out.println("Event count at p1: "+ p1.eventCount);
			System.out.print("\nVector Clock at Processor P1:\t[");
			int [] vc1 = p1.getVc().getTimestampArray();
			for (int i = 0; i < noOfProcessors; i++) {
				System.out.print(vc1[i]+" ");
			}
			System.out.print("]");
			System.out.println();
			System.out.println("Event count at p2: "+ p2.eventCount);
			System.out.print("\nVector Clock at Processor P2:\t[");
			int [] vc2 = p2.getVc().getTimestampArray();
			for (int i = 0; i < noOfProcessors; i++) {
				System.out.print(vc2[i]+" ");
			}
			System.out.print("]");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}