package shakti.winter.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.guessing.GuessEnv;
import shakti.winter.guessing.GuessTree;
import shakti.winter.guessing.GuessingBeing;
import shakti.winter.tools.Timer;
import shakti.winter.tree.Kiosk;
import shakti.winter.tree.Variable;
import shakti.winter.winter.WinterBeing;
import shakti.winter.winter.WinterEnv;
import shakti.winter.winter.WinterTree;

public class Driver {
	
	private static final Logger log = LogManager.getLogger(Driver.class);
	
	public static void main(String[] args) {
		Timer timer = new Timer();
	    Environment<?, ?> env = getWinterEnv();	
	    env.kalpa(new ConfigEnv());
	    log.info("time: "+timer.sinceLast());
	}
	
	private static Environment<?, ?> getWinterEnv() {
		Kiosk.addVar(new Variable<Integer>("turnsLeft", Integer.class));
		Kiosk.addVar(new Variable<Integer>("potatoes", Integer.class));
		Environment<WinterTree, WinterBeing> env = new WinterEnv(new WinterTree(), 10000);
		return env;
	}
	
	private static Environment<?, ?> getGuessEnv() {
		Kiosk.addVar(new Variable<Integer>("topBorder", Integer.class));
		Kiosk.addVar(new Variable<Integer>("bottomBorder", Integer.class));
	    Environment<GuessTree, GuessingBeing> env = new GuessEnv(new GuessTree(), 1000000);
		return env;
	}
}
