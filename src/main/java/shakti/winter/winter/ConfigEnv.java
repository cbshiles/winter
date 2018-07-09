package shakti.winter.winter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.rand.Randomizer;

public class ConfigEnv {
	
	private static final Logger log = LogManager.getLogger(ConfigEnv.class);

    public int maxTurn = 20;
    public int maxBeings = 5000;
    
    public boolean turnFlag = false;
    
    private int last;

    public int getTurns(){
    	//turnFlag = !turnFlag;
    	int rand;
    	while ((rand = Randomizer.getInt(1, 25)) == last) {;}
    	log.info(rand);
    	return  last = rand;//turnFlag?5:40;
    }
}
