package shakti.winter.operator.manifest;

import shakti.winter.operator.BinaryOperator;

public class Greater extends BinaryOperator<Integer, Boolean>{

	public Greater() {
		super(">", Integer.class, Boolean.class);
	}
	
	@Override
	public Boolean act(Integer a, Integer b) {
		return a>b;
	}
}
