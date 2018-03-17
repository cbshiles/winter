package shakti.winter.expression;

//an operator that does nothing. important as an end cap operator for buds though
public class PassOp<T> extends UnaryOperator<T, T> {
	
	public PassOp(T t) {
		super(t.toString());
		load(t);
	}

	public PassOp() {
		super("");
	}
	
	@Override
	public T act(T arg) {
		return arg;
	}
	
	@Override
	public String display() {
		return argLzt.get(0).toString();
	}

}
