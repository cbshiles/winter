package shakti.winter.operator;

public class Greater extends BinaryOperator<Integer, Boolean>{

	public Greater() {
		super(">", Integer.class, Boolean.class);
	}
	
	@Override
	public Boolean act(Integer a, Integer b) {
		return a>b;
	}
}
