package shakti.winter.expression.tree;

import shakti.winter.tools.*;

//class for either storing a constant value or a variable
public class Value<T> {

	T t;
	String name;
	
	//constant constructor
	public Value(T t) {
		this.t= t;
		name = null;
	}
	
	//variable constructor
	public Value(String name) {
		this.name = name;
		t = null;
	}
	
	public boolean isVariable() {
		return name != null;
	}
	
	//set value (only for variables)
	public void set(T gnu) {
		if (! isVariable()) {
			throw new RunException("Trying to set constant value");
		}
		t = gnu;
	}
	
	//get value
	public T get() {
		if (t == null) {
			throw new RunException("Trying to get an unset variable value.");
		}
		return t;
	}
}
