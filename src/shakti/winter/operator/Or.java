package shakti.winter.operator;

public class Or  extends BinaryOperator<Boolean, Boolean>{

	public Or() {
		super("||", Boolean.class, Boolean.class);
	}
	
	@Override
	public Boolean act(Boolean a, Boolean b) {
		return a||b;
	}

}
