package shakti.winter.expression.operator;

import shakti.winter.expression.UnaryOperator;

public class Not extends UnaryOperator<Boolean, Boolean>{

	public Not() {
		super("!");
	}
	
	@Override
	public Boolean act(Boolean arg) {
		return !arg;
	}
	
}
