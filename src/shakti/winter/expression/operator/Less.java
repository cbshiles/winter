package shakti.winter.expression.operator;

import shakti.winter.expression.BinaryOperator;

public class Less extends BinaryOperator<Integer, Boolean>{

	public Less() {
		super("<");
	}
	
	@Override
	public Boolean act(Integer a, Integer b) {
		return a<b;
	}
}
