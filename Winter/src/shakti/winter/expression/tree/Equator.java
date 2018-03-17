package shakti.winter.expression.tree;

import java.util.List;

import shakti.winter.Tools;
import shakti.winter.expression.Operator;
import shakti.winter.expression.operator.*;

public class Equator extends Branch<Integer, Boolean>{
	
	public Equator(Operator<Integer, Boolean> op, List<Branch<?, Integer>> subs) {
		super(op, subs, Tools.listIt(Less.class, Greater.class, Equal.class));
	}
}
