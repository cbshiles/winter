package shakti.winter.operator;

public class And extends BinaryOperator<Boolean, Boolean>{

	public And() {
		super("&&", Boolean.class, Boolean.class);
	}

	@Override
	public Boolean act(Boolean a, Boolean b) {
		return a&&b;
	}
}
