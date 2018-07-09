package shakti.winter.winter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.core.Environment;
import shakti.winter.tools.Pair;

public class WinterEnv extends Environment{
	
	public WinterEnv(List<Pair<Mind, Integer>> makeLzt) {
		super(makeLzt);
	}
	
	public WinterEnv(Mind m, int c) {
		super(m, c);
	}

	private static final Logger log = LogManager.getLogger(WinterEnv.class);
	
	@Override
	public void kalpa() {
		kalpa(new ConfigEnv());
	}
	
	/**
	 * One complete aeon of the winter game.
	 * @param ce  ConfigEnv to set settings.
	 */
	public void kalpa(ConfigEnv ce) {
		int turn = 0;
		boolean over = false;
		String msg = "";
		while (!over) {
			log.info("Round " + turn + ": " + beings.size() + " beings.");

			cycle(ce.getTurns());
			if (turn++ >= ce.maxTurn) {
				msg = "Final turn reached";
				over = true;
			}
			if (beings.size() == 0) {
				msg = "No beings left";
				over = true;
			}
			if (beings.size() > ce.maxBeings) {
				msg = "Number of beings exceeds allowed limits";
				over = true;
			}
		}
		log.info(msg + "\n Turn: " + turn + "\n # of Beings Alive: " + beings.size());
		for (Being b : beings) {
			log.info(b.prevPot + " potates - " + b.prevWarmth + " warmth - Total: " + b.getTotal() + " " + b);
		}
	}

	/**
	 * Do a cycle of the environment. Modifies the beings list.
	 * 
	 * @param turns
	 *            How many turns (rounds of pick/huddle) there are within this year.
	 */
	private void cycle(int turns) {

		for (int tl = turns - 1; tl >= 0; tl--) {
			for (Being ob : beings) {
				ob.act(tl);
			}
		}

		List<Being> newBeings = new ArrayList<>();
		for (Being ob : beings) {
			int cold = turns;
			if (turns > 10)
				cold++; // rate 1*turn -- added plus 1 for difficulty
			ob.warmth -= cold;
			newBeings.addAll(ob.mutate());
		}
		beings = newBeings;
	}

}
