package shakti.winter.expression.operator;

import shakti.winter.expression.BinaryOperator;

public class Or  extends BinaryOperator<Boolean, Boolean>{

	public Or() {
		super("||");
	}
	
	@Override
	public Boolean act(Boolean a, Boolean b) {
		return a||b;
	}

}
