package shakti.winter.tree;

import shakti.winter.core.Mind;
import shakti.winter.operator.UnaryOperator;

public class Tree extends Branch<Boolean, Boolean> implements Mind{
	
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
	public boolean decide(int potatoes, int turnsLeft) {
		Kiosk.updateVars(turnsLeft, potatoes);
		return pull();
	}

	@Override
	public Mind mutate() {
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
