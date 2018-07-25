package shakti.winter.tools;

import shakti.winter.core.Environment;
import shakti.winter.winter.ConfigEnv;

public class Timer {
	
	long firstStart, lastStart;
	
	public Timer() {
		firstStart = lastStart = System.nanoTime();
	}
	
	private long since() {
		long newStart = System.nanoTime();
		long ans = newStart-lastStart;
		lastStart = newStart;
		return ans;
	}
	
	/**
	 * Seconds since last time. 
	 */
	public double sinceLast() {
		return since()/1000000000.0;
	}

}
