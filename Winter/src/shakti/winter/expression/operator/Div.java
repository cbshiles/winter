package shakti.winter.expression.operator;

import shakti.winter.expression.BinaryOperator;

public class Div extends BinaryOperator<Integer, Integer>{

	public Div() {
		super("/");
	}
	
	@Override
	public Integer act(Integer a, Integer b) {
		return a/b;
	}
}
