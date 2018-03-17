package shakti.winter.expression.operator;

import shakti.winter.expression.BinaryOperator;
import shakti.winter.expression.UnaryOperator;

public class Abs extends UnaryOperator<Integer, Integer>{

	public Abs() {
		super("");
	}

	@Override
	public Integer act(Integer n) {
		return n<0?-n:n;
	}
	
	@Override
	public String display() {
		return " |"+argLzt.get(0)+"| ";
	}
}
