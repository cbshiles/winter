package shakti.winter.expression.operator;

import shakti.winter.expression.BinaryOperator;
import shakti.winter.expression.UnaryOperator;

public class Neg extends UnaryOperator<Integer, Integer>{

	public Neg() {
		super("-");
	}
	
	@Override
	public Integer act(Integer n) {
		return -n;
	}
}
