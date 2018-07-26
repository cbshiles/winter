package shakti.winter.core;

import java.util.List;

import shakti.winter.tree.Mind;

/**
 * Wrapper class for Minds. In Winter, all beings are the same, it is only the Mind inside that changes. Also stores data the minds shouldn't be able to directly modify, such as warmth and potatoes.
 */
public abstract class Being<MIND extends Mind, BEING extends Being<MIND, BEING>> {

    protected MIND mind;

    /**
     * @param m The mind for this particular being.
     */
    public Being(MIND m){
	mind = m;
    }
    
    public abstract BEING create(MIND m);
    
    public abstract  List<BEING> mutate();

    @Override
    public String toString(){
    	return mind.toString();
    }

}
