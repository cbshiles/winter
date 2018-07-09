package shakti.winter.core;

import java.time.LocalTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.core.*;
import shakti.winter.tree.Tree;
import shakti.winter.winter.WinterEnv;

public class Driver {
	
	private static final Logger log = LogManager.getLogger(Driver.class);
	
	public static void main(String[] args) {
		long start = System.nanoTime();
	    Environment env = new WinterEnv(new Tree(), 10000);
	    env.kalpa();
	    log.info("time: "+((System.nanoTime()-start)/1000000000.0));
	}
}
