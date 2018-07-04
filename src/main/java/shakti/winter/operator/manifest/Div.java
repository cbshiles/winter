package shakti.winter.operator.manifest;

import shakti.winter.operator.BinaryOperator;

public class Div extends BinaryOperator<Integer, Integer>{

	public Div() {
		super("/", Integer.class, Integer.class);
	}
	
	@Override
	public Integer act(Integer a, Integer b) {
		return a/(b == 0 ? 1:b);
	}
}
