package shakti.winter.core;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.tools.*;
import shakti.winter.winter.Being;
import shakti.winter.winter.ConfigEnv;
import shakti.winter.winter.Mind;

public abstract class Environment {

	private static final Logger log = LogManager.getLogger(Environment.class);

	protected List<Being> beings;
	
	/**
	 * @param makeLzt
	 *            This is the list of beings to create at the start of the
	 *            environment. It is a list of pairs, where the first element is a
	 *            Mind, and the second is the number of beings that should have that
	 *            type of Mind. So you get 20 copies of this mind, 40 copies of that
	 *            mind, etc
	 */
	public Environment(List<Pair<Mind, Integer>> makeLzt) {
		beings = new ArrayList<>();
		for (Pair<Mind, Integer> pear : makeLzt) {
			for (int i = 0; i < pear.b; i++) {
				beings.add(new Being(pear.a.mutate()));
			}
		}
	}

	/**
	 * Creates an Environment with a single Mind type. See other constructor for
	 * full details.
	 */
	public Environment(Mind m, int c) {
		this(Tools.listIt(new Pair<Mind, Integer>(m, c)));
	}

	/**
	 * One aeon of a game.
	 */
	public abstract void kalpa();
	
}
