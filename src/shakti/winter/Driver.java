package shakti.winter;

import shakti.winter.core.*;
import shakti.winter.tree.Tree;

public class Driver {
	
	public static void main(String[] args) {
	    Environment env = new Environment(new Tree(), 2);
	    ConfigEnv conf = new ConfigEnv();
	    System.out.println(env.kalpa(conf));
	}
}
