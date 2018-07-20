package shakti.winter.guessing;

import java.util.List;

import shakti.winter.core.Environment;
import shakti.winter.rand.Randomizer;
import shakti.winter.tools.Pair;
import shakti.winter.winter.ConfigEnv;
import shakti.winter.winter.Mind;

public class GuessEnv extends Environment<GuessingBeing>{

	public GuessEnv(Mind m, int c) {
		super(m, c, new GuessingBeing(null));
	}
	
	public GuessEnv(List<Pair<Mind, Integer>> makeLzt) {
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
		
		for (int i=0; i<ce.getGuessingTurns(); i++) {
			
			for (GuessingBeing b: beings) {
				int guess = b.guess(x);
			}
			// for each being, guess a number
			// then, return to the guesser two numbers
			// 1) highest number guessed that is too low (starting @ 0)
			// 2) lowest number guessed that is too high (starting @ 100)
			// player guesses until the correct number, or time runs out
		}
	}

}
