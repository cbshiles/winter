package shakti.winter.operator.manifest;

import shakti.winter.operator.UnaryOperator;

public class Neg extends UnaryOperator<Integer, Integer>{

	public Neg() {
		super("-", Integer.class, Integer.class);
	}
	
	@Override
	public Integer act(Integer n) {
		return -n;
	}
}
