package shakti.winter.operator.manifest;

import shakti.winter.operator.BinaryOperator;

public class And extends BinaryOperator<Boolean, Boolean>{

	public And() {
		super("&&", Boolean.class, Boolean.class);
	}

	@Override
	public Boolean act(Boolean a, Boolean b) {
		return a&&b;
	}
}
