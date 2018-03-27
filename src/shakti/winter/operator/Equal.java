package shakti.winter.operator;

public class Equal extends BinaryOperator<Integer, Boolean>{

	public Equal() {
		super("==", Integer.class, Boolean.class);
	}
	
	@Override
	public Boolean act(Integer a, Integer b) {
		return a==b;
	}
}
