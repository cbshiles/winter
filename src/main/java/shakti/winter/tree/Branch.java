package shakti.winter.tree;

import java.util.ArrayList;
import java.util.List;

import shakti.winter.operator.Operator;

public class Branch<ARG, RET> implements Node<RET>{
	
	List<Node<ARG>> kids;
	Operator<ARG, RET> op;
	
	/**
	 * Constructor creates a Branch from the given Operator.
	 * Calls upon the Kiosk to populate the list of child nodes.
	 * @param op
	 */
	public Branch(Operator<ARG, RET> op) {
		this.op = op;
		kids = Kiosk.kidList(op);
	}
	
	/**
	 * Method that simplifies expressions that don't have variables.
	 * ex. Replacing 2+2 with 4 
	 */
	@Override
	public RET simplify() {
		if (!isVariable()) {
			return pull();
		}
		return null;
	}
	
	@Override
	public boolean isLeaf() {
		return false;
	}
	
	@Override
	public boolean isVariable() {
		for (Node<ARG> kid: kids) {
			if (kid.isVariable())
				return true;
		}
		return false;
	}
	
	@Override
	public RET pull() {
		List<ARG> argLzt = new ArrayList<>();
		for (Node<ARG> kid : kids) {
			argLzt.add(kid.pull());
		}
		op.load(argLzt);
		return op.go();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Node<ARG> kid: kids) {
			sb.append(kid.toString()).append(" ");
		}
		return "(" + op.symbol + " " + sb + ")";
	}
}
