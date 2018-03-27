package shakti.winter.operator;

public class Neg extends UnaryOperator<Integer, Integer>{

	public Neg() {
		super("-", Integer.class, Integer.class);
	}
	
	@Override
	public Integer act(Integer n) {
		return -n;
	}
}
