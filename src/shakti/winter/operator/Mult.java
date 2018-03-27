package shakti.winter.operator;

public class Mult extends BinaryOperator<Integer, Integer>{

	public Mult() {
		super("*", Integer.class, Integer.class);
	}
	
	@Override
	public Integer act(Integer a, Integer b) {
		return a*b;
	}
}
