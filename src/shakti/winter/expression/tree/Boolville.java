package shakti.winter.expression.tree;

import java.util.List;

import shakti.winter.tools.*;
import shakti.winter.expression.Operator;
import shakti.winter.expression.operator.*;

public class Boolville extends Branch<Boolean, Boolean>{

    public static opLzt List<Class<? extends Operator<Boolean, Boolean>>> = Tools.listIt(And.class, Or.class, Not.class);
    
	public Boolville(Operator<Boolean, Boolean> op, List<Branch<?, Boolean>> subs) {
		super(op, subs, opLzt);
	}

    public Boolville(boolean b){
	
    }
    
}
