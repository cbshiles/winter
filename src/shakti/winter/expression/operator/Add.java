package shakti.winter.expression.operator;

import shakti.winter.expression.BinaryOperator;

public class Add extends BinaryOperator<Integer, Integer>{

	public Add() {
		super("+");
	}

	@Override
	public Integer act(Integer a, Integer b) {
		return a+b;
	}
}
