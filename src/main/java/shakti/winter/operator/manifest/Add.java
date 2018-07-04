package shakti.winter.operator.manifest;

import shakti.winter.operator.BinaryOperator;

public class Add extends BinaryOperator<Integer, Integer>{

	public Add() {
		super("+", Integer.class, Integer.class);
	}

	@Override
	public Integer act(Integer a, Integer b) {
		return a+b;
	}
}
