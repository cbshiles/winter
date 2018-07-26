package shakti.winter.guessing;

import java.util.List;

import shakti.winter.core.Being;
import shakti.winter.tree.Kiosk;

public class GuessingBeing extends Being<GuessTree, GuessingBeing>{
	
	int topBorder, bottomBorder;

	public GuessingBeing(GuessTree m) {
		super(m);
		topBorder = 100;
		bottomBorder = 0;
	}

	@Override
	public GuessingBeing create(GuessTree m) {
		GuessingBeing bean = null;
		while (bean == null || !bean.mind.isVariable()) {
			bean = new GuessingBeing(new GuessTree(false));
		}
		return bean;
	}

	@Override
	public List<GuessingBeing> mutate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int guess(int answer) {
		Kiosk.updateGuessingVars(topBorder, bottomBorder);
		int guess = mind.decide();
		if (answer > guess) {
			if (guess > bottomBorder) {
				bottomBorder = guess;
			}
		} else if (answer < guess) {
			if (guess < topBorder) {
				topBorder = guess;
			}			
		} else {
			
		}
		return guess;
	}
}
