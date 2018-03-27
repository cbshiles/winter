package shakti.winter.operator;

public class Sub extends BinaryOperator<Integer, Integer>{

	public Sub() {
		super("-", Integer.class, Integer.class);
	}
	
	@Override
	public Integer act(Integer a, Integer b) {
		return a-b;
	}
	
}
