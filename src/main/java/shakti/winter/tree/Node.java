package shakti.winter.tree;

public interface Node<RET> {
	
	public RET simplify();
	
	public boolean isLeaf();
	
	public boolean isVariable();
	
	public RET pull();

}
