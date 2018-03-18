package shakti.winter.expression.tree;

import java.util.ArrayList;
import java.util.List;

import shakti.winter.tools.*;
import shakti.winter.expression.Operator;
import shakti.winter.expression.PassOp;
import shakti.winter.rand.Mixer;

public class Branch<A, R> {

	Operator<A, R> op;
	List<Branch<?, A>> subs;
	List<Class<? extends Operator<A, R>>> opLzt;
	List<Value<A>> values;
	
	public Branch(Operator<A, R> op, List<Branch<?, A>> subs, List<Class<? extends Operator<A, R>>> opLzt, List<Value<A>> values) {
		this.op = op;
		this.subs = subs;
		opLzt.add(null); //for null ops
		this.opLzt = opLzt;
		this.values = values;
	}
	
	//public static 
	
	public void load() {
		List<A> argLzt = new ArrayList<>();
		for (Branch<?, A> sub: subs) {
			argLzt.add(sub.pull());
		}
		op.load(argLzt);
	}
	
	//simplifies expressions that don't have variables
	//ex. replacing 2+2 with 4
	public R simplify() {
		if (!isVariable()) {
			load();
			return pull();
		}
		return null;
	}
	
	public boolean isBud() {
		return false;
	}
	
	public boolean isVariable() {
		for (Branch<?, A> sub: subs) {
			if (!sub.isVariable())
				return false;
		}
		return true;
	}
	
	public R pull() {
		return op.go();
	}
	
	@Override
	public String toString() {
		return op.display();
	}
	
	//a is # of args op must have
	//warning has potential of infinite loop
	public Operator<?, R> getRandomOp(Integer a) {
		Mixer<Class<? extends Operator<A, R>>> mixer = new Mixer<>(opLzt, false);
		while (true) {
			Class<? extends Operator<A, R>> opc = mixer.choose();
			try {
				Operator<A, R> op = opc.newInstance();
				if (a == null || a == op.nargs) {
					if (op == null) return new PassOp<R>();
					return op; 
				}
			} catch (Exception e) {
				throw new RunException("Error instantiating operator " + opc.getName(), e);
			}
		}
	}

}
