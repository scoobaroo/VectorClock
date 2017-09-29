package VectorClock;

public class VectorClock {
	private boolean happenBefore;
	private int[] timestampArray;
	public VectorClock(int numberOfProcessors) {
		timestampArray = new int[numberOfProcessors];
		//initialize each processor's timestampArray element to 0
		for(int i = 0; i < numberOfProcessors ; i++) {
			timestampArray[i] = 0;
		}
	}
	public boolean isHappenBefore() {
		return happenBefore;
	}
	public void setHappenBefore(boolean happenBefore) {
		this.happenBefore = happenBefore;
	}
	public int[] getTimestampArray() {
		return this.timestampArray;
	}
	public void update(int index, int value) {
		timestampArray[index] = value;
	}
}
