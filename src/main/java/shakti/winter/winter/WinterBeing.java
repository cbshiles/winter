package shakti.winter.winter;

import java.util.ArrayList;
import java.util.List;

import shakti.winter.core.Being;
import shakti.winter.tree.Kiosk;

public class WinterBeing extends Being<WinterTree, WinterBeing> {

	public WinterBeing(WinterTree m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	private int potateTotal;
    public int prevPot, prevWarmth, warmth, potatoes; //automatically initialized to zero

    /**
     * Method for being to make a decision. Really just passes info to the Mind and then acts out the Mind's decision.
     */
    public void act(int turnsLeft) {
		Kiosk.updateWinterVars(turnsLeft, potatoes);
		warmth += mind.decide() ?
				(potatoes++ / 3) : // pick
				1 + (potatoes / 2); // huddle
    }

    /**
     * Method to create a new list of beings as spawn of this being. This method is called by the
     * environment after the loss of warmth due to Winter. If the being has negative warmth, an empty list will return.
     * If a warmth of 0, only the original being will be in the list. For each additional warmth,
     * the Mind will get a mutate call, and a new being will get added to the list with the mutated Mind. 
     */
    @Override
    public List<WinterBeing> mutate(){
	List<WinterBeing> mutants = new ArrayList<>();
	if (warmth > -1) {
	    mutants.add(this);
	    
//	    for (int x=0; x<warmth; x++){
//		mutants.add(new Being(mind.mutate()));
//	    }
	    prevWarmth = warmth;
	    warmth = 0;
	    potateTotal += prevPot = potatoes;
	    potatoes = 0;
	}
	return mutants;
    }
    
    public int getTotal() {
    	return potateTotal;
    }

	@Override
	public WinterBeing create(WinterTree m) {
		return new WinterBeing(m);
	}
}
