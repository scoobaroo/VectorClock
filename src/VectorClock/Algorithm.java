package VectorClock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Algorithm {

	public Map<Processor, List<Event>> getExecutionPlan(String filepath) throws IOException {
		
		Map <Processor,List<Event>> executionPlan = new HashMap <Processor,List<Event>> ();
		
		
		
		Scanner fileScanner = new Scanner(filepath);
		//open file mentioned in filepath
		//fetch processor and and its list of events from text file
		//store that data in map executionPlan with key as a Processor and its value as a list of events
		String line = fileScanner.nextLine();
		
		return executionPlan; 
	}
	
	public void execute(Map <Processor,List<Event>> executionPlan) {
		
		Iterator<Entry<Processor, List<Event>>> iter = executionPlan.entrySet().iterator();
		while(iter.hasNext()) {
			Processor p = iter.next().getKey();
			p.start();
		}
	}
	
	public static void main(String[] args) {
		Algorithm algo = new Algorithm();
		
		//get execution plan from text file
		Map<Processor, List<Event>> executionPlan;
		try {
			executionPlan = algo.getExecutionPlan(args[1]);
			algo.execute(executionPlan);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//execute the execution plan and compute vector clocks for all processors
		
	}
}
