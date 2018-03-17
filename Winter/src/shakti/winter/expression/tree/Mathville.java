package shakti.winter.expression.tree;

import java.util.List;

import shakti.winter.Tools;
import shakti.winter.expression.Operator;
import shakti.winter.expression.operator.*;

public class Mathville extends Branch<Integer, Integer>{
	public Mathville(Operator<Integer, Integer> op, List<Branch<?, Integer>> subs) {
		super(op, subs, Tools.listIt(Add.class, Div.class, Mult.class, Sub.class, Neg.class, Abs.class));
	}
}
