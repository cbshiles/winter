package shakti.winter.tree;

public class Variable<T>{

	String name;
	Leaf<T> leaf;
	Class<T> typeClass;
	
	public Variable(String n, Class<T> tc) {
		name = n;
		leaf = new Leaf<>(n);
		typeClass = tc;
	}
	
	public String className() {
		return typeClass.getName();
	}
}
