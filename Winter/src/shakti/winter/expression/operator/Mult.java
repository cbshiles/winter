package shakti.winter.expression.operator;

import shakti.winter.expression.BinaryOperator;

public class Mult extends BinaryOperator<Integer, Integer>{

	public Mult() {
		super("*");
	}
	
	@Override
	public Integer act(Integer a, Integer b) {
		return a*b;
	}
}
