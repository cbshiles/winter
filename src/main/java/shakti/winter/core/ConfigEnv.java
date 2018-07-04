package shakti.winter.core;

public class ConfigEnv {

    public int maxTurn = 10;
    public int maxBeings = 5000;
    
    public boolean turnFlag = false;

    public int getTurns(){
    	turnFlag = !turnFlag;
    	return turnFlag?4:40;
    }
}
