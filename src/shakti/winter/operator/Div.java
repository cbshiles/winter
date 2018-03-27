package shakti.winter.operator;

public class Div extends BinaryOperator<Integer, Integer>{

	public Div() {
		super("/", Integer.class, Integer.class);
	}
	
	@Override
	public Integer act(Integer a, Integer b) {
		return a/b;
	}
}
