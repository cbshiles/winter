package shakti.winter.core;

import java.util.*;

import shakti.winter.winter.Mind;

/**
 * Wrapper class for Minds. In Winter, all beings are the same, it is only the Mind inside that changes. Also stores data the minds shouldn't be able to directly modify, such as warmth and potatoes.
 */
public abstract class Being<BEING extends Being<BEING>> {

    protected Mind mind;

    /**
     * @param m The mind for this particular being.
     */
    public Being(Mind m){
	mind = m;
    }
    
    public abstract BEING create(Mind m);
    
    public abstract void act(int turnsLeft);
    
    public abstract  List<BEING> mutate();

    @Override
    public String toString(){
    	return mind.toString();
    }

}
