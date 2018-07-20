package shakti.winter.guessing;

import java.util.List;

import shakti.winter.core.Being;
import shakti.winter.winter.Mind;
import shakti.winter.winter.WinterBeing;

public class GuessingBeing extends Being<GuessingBeing>{

	public GuessingBeing(Mind m) {
		super(m);
	}

	@Override
	public GuessingBeing create(Mind m) {
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
		return 7;
	}
}
