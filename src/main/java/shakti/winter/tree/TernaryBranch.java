package shakti.winter.tree;

public class TernaryBranch<T> extends Branch<T, T> {
	
	Node<Boolean> fork;

	public TernaryBranch(Class<T> klass) {
		kids = Kiosk.kidList(2, klass);
		fork = Kiosk.kid(Boolean.class);
	}
	
	@Override 
	public T simplify(){
		Boolean simpleFork = fork.simplify();
		if (simpleFork != null) {
			fork = new Leaf<Boolean>(simpleFork);
		}
		return super.simplify();
	}
	
	@Override
	public boolean isVariable() {
		return super.isVariable() || fork.isVariable();
	}
	
	@Override
	public T pull() {
		return fork.pull() ? kids.get(0).pull() : kids.get(1).pull();
	}
	
	@Override
	public String toString() {
		return "(" + fork + " ? " + kids.get(0) + " : "+kids.get(1)+ ")";
	}

}
