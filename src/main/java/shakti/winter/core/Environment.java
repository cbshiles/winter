package shakti.winter.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.tools.Pair;
import shakti.winter.tools.Tools;
import shakti.winter.tree.Mind;

public abstract class Environment<MIND extends Mind<?>, BEING extends Being<MIND, BEING>> {

	private static final Logger log = LogManager.getLogger(Environment.class);

	protected List<BEING> beings;
	
	/**
	 * @param makeLzt
	 *            This is the list of beings to create at the start of the
	 *            environment. It is a list of pairs, where the first element is a
	 *            Mind, and the second is the number of beings that should have that
	 *            type of Mind. So you get 20 copies of this mind, 40 copies of that
	 *            mind, etc
	 */
	public Environment(List<Pair<MIND, Integer>> makeLzt, BEING being) {
		beings = new ArrayList<>();
		for (Pair<MIND, Integer> pear : makeLzt) {
			for (int i = 0; i < pear.b; i++) {
				beings.add(being.create((MIND) pear.a.mutate()));
			}
		}
	}

	/**
	 * Creates an Environment with a single Mind type. See other constructor for
	 * full details.
	 */
	public Environment(MIND m, int c, BEING being) {
		this(Tools.listIt(new Pair<MIND, Integer>(m, c)), being);
	}

	/**
	 * One aeon of a game. Returns a message.
	 */
	public String kalpa(ConfigEnv ce) {
		int turn = 0;
		boolean over = false;
		String msg = "";
		while (!over) {
			log.info("Round " + turn + ": " + beings.size() + " beings.");

			cycle(ce);
			if (turn++ >= ce.maxTurn) {
				msg = "Final turn reached";
				over = true;
			}
			if (beings.size() == 0) {
				msg = "No beings left";
				over = true;
			}
			if (beings.size() > ce.maxBeings) {
				msg = "Number of beings exceeds allowed limits";
				over = true;
			}
		}
		return msg + "\n Turn: " + turn + "\n";
	}
	
	/**
	 * One turn of a game.
	 */
	public abstract void cycle(ConfigEnv ce);
	
}
