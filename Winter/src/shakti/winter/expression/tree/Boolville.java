package shakti.winter.expression.tree;

import java.util.List;

import shakti.winter.Tools;
import shakti.winter.expression.Operator;
import shakti.winter.expression.operator.And;
import shakti.winter.expression.operator.Not;
import shakti.winter.expression.operator.Or;

public class Boolville extends Branch<Boolean, Boolean>{
	
	public Boolville(Operator<Boolean, Boolean> op, List<Branch<?, Boolean>> subs) {
		super(op, subs, Tools.listIt(And.class, Or.class, Not.class));
	}

}
