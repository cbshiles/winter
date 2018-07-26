package shakti.winter.winter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shakti.winter.core.Environment;
import shakti.winter.tree.Branch;
import shakti.winter.tree.Kiosk;
import shakti.winter.tree.Leaf;
import shakti.winter.tree.Mind;
import shakti.winter.operator.UnaryOperator;
import shakti.winter.tools.Tools;

public class WinterTree extends Branch<Boolean, Boolean> implements Mind<Boolean>{
	
	private static final Logger log = LogManager.getLogger(WinterTree.class);
	
	//TODO: move this first concept out of this class
	//if this is the first Tree, then mutations will be completely random
	boolean first; 
	
	public WinterTree(boolean first) {
		super(new UnaryOperator<Boolean, Boolean>("->", Boolean.class, Boolean.class) {
			@Override
			public Boolean act(Boolean b) {
				return b;
			}
		});		
		this.first = first;
		Boolean simp = this.simplify();
		if (simp != null) {
			kids = Tools.listIt(new Leaf<>(simp));
		}
		
	}
	
	public WinterTree() {
		this(true);
	}
	
    /**
     * The method called each turn on each Mind in a living Being to see what action the Being will take. The question that is being
     * decided is 'Am I going to pick up a hot potato this turn? So if this method returns true, the Being will pick up a potato, otherwise the Being will huddle.
     * @param potatoes The number of potatoes this being has before the decision.
     * @param turnsLeft The number of turns before Winter, not including the current one.
     * @return True for pick up potatoe, false for huddle.
     */
	@Override
	public Boolean decide() {
		return pull();
	}

	@Override
	public Mind<Boolean> mutate() {
		// Don't modify first - at least for now (the first one is mutated multiple times to start,
		// so just keep first as true and make all subsequent ones !first)
		if (first) {
			return new WinterTree(false);
		} else {
			return mutantCopy();
		}
	}
	
	private WinterTree mutantCopy() {
		//TODO: fix it
		return this;	
	}

}
