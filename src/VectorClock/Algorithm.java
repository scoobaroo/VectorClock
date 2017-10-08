package VectorClock;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {	
	int noOfProcessors;
	Processor p0,p1,p2;
	public Algorithm(int noOfProcessors) {
		this.noOfProcessors = noOfProcessors;
		p0 = new Processor(0, noOfProcessors,"Thread"+Integer.toString(0));
		p1 = new Processor(1, noOfProcessors, "Thread"+Integer.toString(1));
		p2 = new Processor(2, noOfProcessors,"Thread"+Integer.toString(2));
	}
	public void hardcodeExecutionPlan() {
		List<Event> eventList0 = new ArrayList<Event>();
		Event e1 = new Event(EventType.SEND,p0,p1);
		eventList0.add(e1);
		Event e2 = new Event(EventType.SEND,p0,p2);
		eventList0.add(e2);
		Event e3 = new Event(EventType.COMPUTE);
		eventList0.add(e3);
		Event e5 = new Event(EventType.COMPUTE);
		eventList0.add(e5);
		p0.setEvents(eventList0);
		List<Event> eventList1 = new ArrayList<Event>();
		Event e8 = new Event(EventType.SEND,p1,p2);
		eventList1.add(e8);
		Event e17 = new Event(EventType.SEND,p1,p0);
		eventList1.add(e17);
		p1.setEvents(eventList1);
		List<Event> eventList2 = new ArrayList<Event>();
		Event e10 = new Event(EventType.COMPUTE);
		eventList2.add(e10);
		Event e11 = new Event(EventType.COMPUTE);
		eventList2.add(e11);
		Event e12 = new Event(EventType.SEND,p2,p1);
		eventList2.add(e12);
		Event e14 = new Event(EventType.SEND,p2,p1);
		eventList2.add(e14);
		Event e16 = new Event(EventType.COMPUTE);
		eventList2.add(e16);
		p2.setEvents(eventList2);
	}
	
	public void hardcodeExecutionPlanNoThread() throws InterruptedException {
		Event compute = new Event(EventType.COMPUTE);
		p2.executeEvent(compute);
		p0.executeEvent(new Event(EventType.SEND,p0,p1));
		p2.executeEvent(compute);
		Event receive1 = new Event(EventType.RECEIVE,p0);
		p1.executeEvent(receive1);
		p2.executeEvent(new Event(EventType.SEND,p2,p1));
		Event receive2 = new Event(EventType.RECEIVE,p2 );
		p1.executeEvent(receive2);
		p0.executeEvent(new Event(EventType.SEND,p0,p2));
		Event receive3 = new Event(EventType.RECEIVE,p0);
		p2.executeEvent(receive3);
		p2.executeEvent(new Event(EventType.SEND,p2,p1));
		p1.executeEvent(new Event(EventType.SEND,p1,p2));
		p0.executeEvent(compute);
		Event receive4 = new Event(EventType.RECEIVE,p1);
		p2.executeEvent(receive4);
		Event receive5 = new Event(EventType.RECEIVE,p2);
		p1.executeEvent(receive5);
		p1.executeEvent(new Event(EventType.SEND,p1,p0));
		Event receive6 = new Event(EventType.RECEIVE,p1);
		p0.executeEvent(receive6);
		p2.executeEvent(compute);
		p0.executeEvent(compute);
	}
	
	public static void main(String[] args) {
		Algorithm algo = new Algorithm(3);
		algo.init();
	}
	
	public void init() {
		try {
			hardcodeExecutionPlanNoThread();
//			p0.start();
//			p1.start();
//			p2.start();
//			p0.join();
//			p1.join();
//			p2.join();
			int [] vc0 = p0.getVc().getTimestampArray();
			System.out.println("Event count at p0: "+ p0.getEventCount());
			System.out.print("Vector Clock at Processor P0:\t[");
			for (int i = 0; i < noOfProcessors; i++) {
				System.out.print(vc0[i]+" ");
			}
			System.out.print("]");
			System.out.println();
			System.out.println("Event count at p1: "+ p1.getEventCount());
			System.out.print("Vector Clock at Processor P1:\t[");
			int [] vc1 = p1.getVc().getTimestampArray();
			for (int i = 0; i < noOfProcessors; i++) {
				System.out.print(vc1[i]+" ");
			}
			System.out.print("]");
			System.out.println();
			System.out.println("Event count at p2: "+ p2.getEventCount());
			System.out.print("Vector Clock at Processor P2:\t[");
			int [] vc2 = p2.getVc().getTimestampArray();
			for (int i = 0; i < noOfProcessors; i++) {
				System.out.print(vc2[i]+" ");
			}
			System.out.print("]");
			computeMaximumConsistentCut(new int[]{2,3,4});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int[] computeMaximumConsistentCut(int[] inputcut) {
		int[] result = new int[noOfProcessors];
		ArrayList<VectorClock> p0store = p0.getStore();
		ArrayList<VectorClock> p1store = p1.getStore();
		ArrayList<VectorClock> p2store = p2.getStore();
		VectorClock p0vc = p0store.get(inputcut[0]);
		VectorClock p1vc = p1store.get(inputcut[1]);
		VectorClock p2vc = p2store.get(inputcut[2]);
		int[] p0TimestampArray = p0vc.getTimestampArray();
		int[] p1TimestampArray = p1vc.getTimestampArray();
		int[] p2TimestampArray = p2vc.getTimestampArray();
		List<Event> p0events = p0.getEventsThatHappened();
		List<Event> p1events = p1.getEventsThatHappened();
		List<Event> p2events = p2.getEventsThatHappened();
		if(p0events.get(inputcut[0]).getEventType() == EventType.COMPUTE
		&& p1events.get(inputcut[1]).getEventType() == EventType.COMPUTE 
		&& p2events.get(inputcut[2]).getEventType() == EventType.COMPUTE){
			return inputcut;
		}
		return result;
	}
}