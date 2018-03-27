package shakti.winter.tree;

import shakti.winter.tools.RunException;

public class Leaf<RET> implements Node<RET>{
	
	RET val; //return value
	boolean isVar;
	
	public Leaf(RET v) {
		val = v;
		isVar = false;
	}

	public Leaf() {
		isVar = true;
	}

	@Override
	public RET simplify() {
		if (isVar) return null;
		else return val;
	}
	
	public void update(RET v) {
		if (! isVar) {
			throw new RunException("Error: attempting to set constant leaf.");
		}
		val = v;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public boolean isVariable() {
		return isVar;
	}

	@Override
	public RET pull() {
		return val;
	}

}
