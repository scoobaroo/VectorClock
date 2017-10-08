package VectorClock;

import java.util.Arrays;

public class VectorClock {
	private int[] timestampArray;
	public VectorClock(int numberOfProcessors) {
		timestampArray = new int[numberOfProcessors];
		//initialize each processor's timestampArray element to 0
		for(int i = 0; i < numberOfProcessors ; i++) {
			timestampArray[i] = 0;
		}
	}
	public int[] getTimestampArray() {
		return this.timestampArray;
	}
	public void update(int index, int value) {
		timestampArray[index] = value;
	}
	
	@Override
	public String toString() {
		return "VectorClock [VC=" + Arrays.toString(this.getTimestampArray()) + "]";
	}
	
	public int happenBefore(int[] cut) {
		for(int i = 0; i < timestampArray.length; i ++) {
			if(timestampArray[i] > cut[i]) {
				System.out.println("element at" + i + " position in timestampArray is greater than cut["+i+"]");
				return i;
			}
		}
		return -1;
	}
}
