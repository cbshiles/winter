package shakti.winter.core;

import java.time.LocalTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.core.*;
import shakti.winter.guessing.GuessEnv;
import shakti.winter.guessing.GuessTree;
import shakti.winter.guessing.GuessingBeing;
import shakti.winter.tree.WinterTree;
import shakti.winter.winter.ConfigEnv;
import shakti.winter.winter.WinterBeing;
import shakti.winter.winter.WinterEnv;

public class Driver {
	
	private static final Logger log = LogManager.getLogger(Driver.class);
	
	public static void main(String[] args) {
		long start = System.nanoTime();
	    //Environment<WinterTree, WinterBeing> env = new WinterEnv(new WinterTree(), 10000);
	    Environment<GuessTree, GuessingBeing> env = new GuessEnv(new GuessTree(), 10000);
	    env.kalpa(new ConfigEnv());
	    log.info("time: "+((System.nanoTime()-start)/1000000000.0));
	}
}
