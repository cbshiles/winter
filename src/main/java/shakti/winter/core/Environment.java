package shakti.winter.core;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.tools.*;

public class Environment {
	
	private static final Logger log = LogManager.getLogger(Environment.class);

    /**
     * @param makeLzt This is the list of beings to create at the start of the environment. It is a list of pairs,
     * where the first element is a Mind, and the second is the number of beings that should have that type of Mind.
     * So you get 20 copies of this mind, 40 copies of that mind, etc
     */
    public Environment(List<Pair<Mind, Integer>> makeLzt){
	beings = new ArrayList<>();
	for (Pair<Mind, Integer> pear: makeLzt){
	    for (int i=0; i<pear.b; i++){
		beings.add(new Being(pear.a.mutate()));
	    }
	}
    }

    /**
     * Creates an Environment with a single Mind type. See other constructor for full detials.
     */
    public Environment(Mind m, int c){
	this(Tools.listIt(new Pair<Mind, Integer>(m, c)));
    }

    List<Being> beings;


    public void kalpa(ConfigEnv ce){
	int turn = 0;
	boolean over = false;
	String msg = "";
	while (!over){
	    log.info("Round "+turn+": "+beings.size()+" beings.");

	    cycle(ce.getTurns());
	    if (turn++ >= ce.maxTurn){
		msg = "Final turn reached";
		over = true;
	    }
	    if (beings.size() == 0){
		msg = "No beings left";
		over = true;
	    }
	    if (beings.size() > ce.maxBeings){
		msg = "Number of beings exceeds allowed limits";
		over = true;
	    }
	}
	log.info(msg+"\n Turn: "+turn+"\n # of Beings Alive: "+beings.size());
	for (Being b: beings) {
		log.info(b.potatoes+" - "+b);
	}
    }
    
        /**
     * Do a cycle of the environment. Modifies the beings list.
     * @param turns How many turns (rounds of pick/huddle) there are within this year.
     */
	private void cycle(int turns){
		
		for (int tl=turns-1; tl>=0; tl--) {
			for (Being ob: beings) {
			    ob.act(tl);
			}
		}
		
		List<Being> newBeings = new ArrayList<>();
		for (Being ob: beings) {
			int cold = turns;
			if (turns > 10) cold++; //rate 1*turn -- added plus 1 for difficulty
			ob.warmth -= cold; 
			newBeings.addAll(ob.mutate());
		}
		beings = newBeings;
	}


}
