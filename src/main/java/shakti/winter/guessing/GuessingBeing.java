package shakti.winter.guessing;

import java.util.List;

import shakti.winter.core.Being;
import shakti.winter.winter.Mind;
import shakti.winter.winter.WinterBeing;

public class GuessingBeing extends Being<GuessTree, GuessingBeing>{
	
	int topBorder, bottomBorder;

	public GuessingBeing(GuessTree m) {
		super(m);
		topBorder = 100;
		bottomBorder = 0;
	}

	@Override
	public GuessingBeing create(GuessTree m) {
		return new GuessingBeing(m);
	}

	@Override
	public void act(int turnsLeft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GuessingBeing> mutate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int guess(int answer) {
		int guess = mind.guess(topBorder, bottomBorder);
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
