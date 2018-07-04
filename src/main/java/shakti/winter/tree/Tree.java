package shakti.winter.tree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.core.Environment;
import shakti.winter.core.Mind;
import shakti.winter.operator.UnaryOperator;

public class Tree extends Branch<Boolean, Boolean> implements Mind{
	
	private static final Logger log = LogManager.getLogger(Tree.class);
	
	//TODO: move this first concept out of this class
	//if this is the first Tree, then mutations will be completely random
	boolean first; 
	
	public Tree(boolean first) {
		super(new UnaryOperator<Boolean, Boolean>("->", Boolean.class, Boolean.class) {
			@Override
			public Boolean act(Boolean b) {
				return b;
			}
		});		
		this.first = first;
	}
	
	public Tree() {
		this(true);
	}

	@Override
	public boolean decide(int turnsLeft, int potatoes) {
		Kiosk.updateVars(turnsLeft, potatoes);
		//log.info(this);
		return pull();
	}

	@Override
	public Mind mutate() {
		// Don't modify first - at least for now (the first one is mutated multiple times to start,
		// so just keep first as true and make all subsequent ones !first)
		if (first) {
			return new Tree(false);
		} else {
			return mutantCopy();
		}
	}
	
	private Tree mutantCopy() {
		return this;	
	}

}
