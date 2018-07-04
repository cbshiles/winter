package shakti.winter.core;

import java.util.*;

/**
 * Wrapper class for Minds. In Winter, all beings are the same, it is only the Mind inside that changes. Also stores data the minds shouldn't be able to directly modify, such as warmth and potatoes.
 */
public class Being {
	
    public int warmth, potatoes; //automatically initialized to zero
    private Mind mind;

    /**
     * @param m The mind for this particular being.
     */
    public Being(Mind m){
	mind = m;
    }

    /**
     * Method for being to make a decision. Really just passes info to the Mind and then acts out the Mind's decision.
     */
    public void act(int turnsLeft) {
	warmth += mind.decide(turnsLeft, potatoes) ?
	    (potatoes++ / 3) : //pick
	    1 + (potatoes / 2); //huddle
    }

    /**
     * Method to create a new list of beings as spawn of this being. This method is called by the
     * environment after the loss of warmth due to Winter. If the being has negative warmth, an empty list will return.
     * If a warmth of 0, only the original being will be in the list. For each additional warmth,
     * the Mind will get a mutate call, and a new being will get added to the list with the mutated Mind. 
     */
    public List<Being> mutate(){
	List<Being> mutants = new ArrayList<>();
	if (warmth > -1) {
	    mutants.add(this);
	    
	    //TODO: add mutate functionaity
//	    for (int x=0; x<warmth; x++){
//		mutants.add(new Being(mind.mutate()));
//	    }
	    warmth = 0;
	}
	return mutants;
    }

    @Override
    public String toString(){
    	return mind.toString();
    }

}
