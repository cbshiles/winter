package shakti.winter.tree;

import shakti.winter.tools.RunException;

public class TernaryBranch<T> extends Branch<T, T> {
	
	Node<Boolean> fork;
	boolean forkVal;

	public TernaryBranch(Class<T> klass) {
		kids = Kiosk.kidList(2, klass);
		fork = Kiosk.kid(Boolean.class);
	}
	
	@Override 
	public T simplify(){
		Boolean simpleFork = fork.simplify();
		if (simpleFork != null) {
			fork = null;
			forkVal = simpleFork;
		}
		return super.simplify();
	}
	
	@Override
	public boolean isVariable() {
		if (fork == null) {
			return getKid().isVariable();
		}
		return super.isVariable() || fork.isVariable();
	}
	
	@Override
	public T pull() {
		return (fork == null ? forkVal : fork.pull()) ? kids.get(0).pull() : kids.get(1).pull();
	}
	
	private Node<T> getKid(){
		if (fork != null) 
			throw new RunException("Error - ambiguous get kid call");
		return kids.get(forkVal ? 0 : 1);
	}
	
	@Override
	public String toString() {
		if (fork == null) {
			return getKid().toString();
		} else 
			return "(" + fork + " ? " + kids.get(0) + " : "+kids.get(1)+ ")";
	}

}
