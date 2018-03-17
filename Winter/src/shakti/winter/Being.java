package shakti.winter;

import java.util.*;

import shakti.winter.expression.*;
import shakti.winter.expression.tree.Tree;

public class Being {
	
	int life, potatoes;
	public Tree mind = new Tree();
	
	public boolean decide(int turnsLeft) {
		return mind.decide(potatoes, turnsLeft);
	}
	
	public List<Being> mutate(){
		List<Being> mutants = new ArrayList<>();
		if (life > -1) {
			mutants.add(this);
		}
		if (life > 0) {
			mind.mutate(life);
		}
		return mutants;
	}

}
