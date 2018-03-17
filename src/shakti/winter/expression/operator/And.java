package shakti.winter.expression.operator;

import shakti.winter.expression.BinaryOperator;
import shakti.winter.expression.UnaryOperator;

public class And extends BinaryOperator<Boolean, Boolean>{

	public And() {
		super("&&");
	}

	@Override
	public Boolean act(Boolean a, Boolean b) {
		return a&&b;
	}
}
