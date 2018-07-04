package shakti.winter.operator.manifest;

import shakti.winter.operator.UnaryOperator;

public class Not extends UnaryOperator<Boolean, Boolean>{

	public Not() {
		super("!", Boolean.class, Boolean.class);
	}
	
	@Override
	public Boolean act(Boolean arg) {
		return !arg;
	}
	
}
