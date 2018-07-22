package shakti.winter.guessing;

import shakti.winter.operator.UnaryOperator;
import shakti.winter.tools.Tools;
import shakti.winter.tree.Branch;
import shakti.winter.tree.Kiosk;
import shakti.winter.tree.Leaf;
import shakti.winter.tree.WinterTree;
import shakti.winter.winter.Mind;

public class GuessTree  extends Branch<Integer, Integer> implements Mind{
	
	public boolean first;
	
	public GuessTree(boolean first) {
		super(new UnaryOperator<Integer, Integer>("->", Integer.class, Integer.class) {
			@Override
			public Integer act(Integer b) {
				return b;
			}
		});		
		this.first = first;
		Integer simp = this.simplify();
		if (simp != null) {
			kids = Tools.listIt(new Leaf<>(simp));
		}
		
	}
	
	public GuessTree() {
		this(true);
	}

	@Override
	public boolean decide(int potatoes, int turnsLeft) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Mind mutate() {
		// Don't modify first - at least for now (the first one is mutated multiple times to start,
		// so just keep first as true and make all subsequent ones !first)
		if (first) {
			return new GuessTree(false);
		} else {
			return mutantCopy();
		}
	}
	
	int guess(int topBorder, int bottomBorder){
		Kiosk.updateVars(topBorder, bottomBorder);
		//log.info(this);
		return pull();
	}
	
	private GuessTree mutantCopy() {
		//TODO: fix it
		return this;	
	}

}
