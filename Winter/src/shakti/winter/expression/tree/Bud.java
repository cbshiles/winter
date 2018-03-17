package shakti.winter.expression.tree;

import shakti.winter.Tools;
import shakti.winter.expression.PassOp;

public class Bud<R> extends Branch<R, R>{
	
	boolean isVar;
	
	public Bud(R r) {
		super(new PassOp<R>(r), null, null);
		isVar = false;
	}

	public Bud() {
		super(new PassOp<R>(), null, null);
		isVar = true;
	}
	
	public void setVar(R r) {
		op.load(Tools.listIt(r));
	}
	
	@Override
	public boolean isVariable() {
		return isVar;
	}
	
	@Override
	public boolean isBud() {
		return true;
	}

}
