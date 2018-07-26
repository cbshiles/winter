package shakti.winter.winter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.core.Being;
import shakti.winter.core.ConfigEnv;
import shakti.winter.core.Environment;
import shakti.winter.guessing.GuessTree;
import shakti.winter.tools.Pair;

public class WinterEnv extends Environment<WinterTree, WinterBeing>{
	
	private static final Logger log = LogManager.getLogger(WinterEnv.class);
	
	public WinterEnv(List<Pair<WinterTree, Integer>> makeLzt) {
		super(makeLzt, new WinterBeing(null));
	}
	
	public WinterEnv(WinterTree m, int c) {
		super(m, c, new WinterBeing(null));
	}

	
	/**
	 * One complete aeon of the winter game.
	 * @param ce  ConfigEnv to set settings.
	 */
	@Override
	public String kalpa(ConfigEnv ce) {
		String msg = super.kalpa(ce);
		log.info(msg + "# of Beings Alive: " + beings.size());
		for (WinterBeing b : beings) {
			log.info(b.prevPot + " potates - " + b.prevWarmth + " warmth - Total: " + b.getTotal() + " " + b);
		}
		return msg;
	}
	
	@Override
	public void cycle(ConfigEnv ce) {
		cycle(ce.getTurns());
	}

	/**
	 * Do a cycle of the environment. Modifies the beings list.
	 * 
	 * @param turns
	 *            How many turns (rounds of pick/huddle) there are within this year.
	 */
	private void cycle(int turns) {

		for (int tl = turns - 1; tl >= 0; tl--) {
			for (WinterBeing ob : beings) {
				ob.act(tl);
			}
		}

		List<WinterBeing> newBeings = new ArrayList<>();
		for (WinterBeing ob : beings) {
			int cold = turns;
			if (turns > 10)
				cold++; // rate 1*turn -- added plus 1 for difficulty
			ob.warmth -= cold;
			newBeings.addAll(ob.mutate());
		}
		beings = newBeings;
	}

}
