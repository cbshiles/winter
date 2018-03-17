package shakti.winter.expression.operator;

import shakti.winter.expression.BinaryOperator;

public class Sub extends BinaryOperator<Integer, Integer>{

	public Sub() {
		super("-");
	}
	
	@Override
	public Integer act(Integer a, Integer b) {
		return a-b;
	}
	
}
