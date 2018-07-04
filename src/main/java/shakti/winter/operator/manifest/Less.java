package shakti.winter.operator.manifest;

import shakti.winter.operator.BinaryOperator;

public class Less extends BinaryOperator<Integer, Boolean>{

	public Less() {
		super("<", Integer.class, Boolean.class);
	}
	
	@Override
	public Boolean act(Integer a, Integer b) {
		return a<b;
	}
}
