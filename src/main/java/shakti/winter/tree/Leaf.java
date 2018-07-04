package shakti.winter.tree;

import shakti.winter.tools.RunException;

public class Leaf<RET> implements Node<RET>{
	
	RET val; //return value
	boolean isVar;
	String name;
	
	public Leaf(RET v) {
		val = v;
		isVar = false;
		name = null;
	}

	public Leaf(String name) {
		isVar = true;
		this.name= name; 
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
	
	@Override
	public String toString() {
		if (isVar) {
			return name +":"+ (val == null ? "NIL" : val.toString());
		}
		return val.toString();
	}
}
