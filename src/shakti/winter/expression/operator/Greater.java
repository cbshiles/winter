package shakti.winter.expression.operator;

import shakti.winter.expression.BinaryOperator;

public class Greater extends BinaryOperator<Integer, Boolean>{

	public Greater() {
		super(">");
	}
	
	@Override
	public Boolean act(Integer a, Integer b) {
		return a>b;
	}
}
