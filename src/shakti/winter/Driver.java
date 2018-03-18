package shakti.winter;

import java.util.ArrayList;
import java.util.List;
import shakti.winter.core.*;
import shakti.winter.expression.tree.Tree;

public class Driver {
	
	public static void main(String[] args) {
	    Environment env = new Environment(new Tree(), 10);
	    ConfigEnv conf = new ConfigEnv();
	    System.out.println(env.kalpa(conf));
	}
}
