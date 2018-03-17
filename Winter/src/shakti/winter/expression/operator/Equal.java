package shakti.winter.expression.operator;

import shakti.winter.expression.BinaryOperator;

public class Equal extends BinaryOperator<Integer, Boolean>{

	public Equal() {
		super("==");
	}
	
	@Override
	public Boolean act(Integer a, Integer b) {
		return a==b;
	}
}
