package shakti.winter.guessing;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.core.Driver;
import shakti.winter.core.Environment;
import shakti.winter.rand.Randomizer;
import shakti.winter.tools.Pair;
import shakti.winter.winter.ConfigEnv;
import shakti.winter.winter.Mind;

public class GuessEnv extends Environment<GuessTree, GuessingBeing>{
	
	private static final Logger log = LogManager.getLogger(GuessEnv.class);

	public GuessEnv(GuessTree m, int c) {
		super(m, c, new GuessingBeing(null));
	}
	
	public GuessEnv(List<Pair<GuessTree, Integer>> makeLzt) {
		super(makeLzt, new GuessingBeing(null));
	}
	

	@Override
	/**
	 * Do a cycle of the environment. Modifies the beings list.
	 * 
	 * @param turns
	 *            How many turns a player has to guess the number.
	 */
	public void cycle(ConfigEnv ce) {
		
		int x = Randomizer.getInt(0, 100);
		List<GuessingBeing> newBeings = new ArrayList<>();
		
		for (int i=0; i<ce.getGuessingTurns(); i++) {
			List<GuessingBeing> tmpBeings = new ArrayList<>();
			for (GuessingBeing b: beings) {
				int guess = b.guess(x);
				if (guess != x) {
					tmpBeings.add(b);	
				} else {
					newBeings.add(b);
				}
			}
			beings = tmpBeings;
		log.info(beings.size()+" beings - "+newBeings.size()+" new beings");	
		}
		beings = newBeings;
		for (GuessingBeing b: beings) {
			log.info(b);
		}
	}

}
