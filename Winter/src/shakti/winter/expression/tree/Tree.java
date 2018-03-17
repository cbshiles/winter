package shakti.winter.expression.tree;

import java.util.ArrayList;
import java.util.List;

import shakti.winter.Pair;
import shakti.winter.Tools;
import shakti.winter.expression.PassOp;
import shakti.winter.expression.UnaryOperator;
import shakti.winter.expression.operator.And;
import shakti.winter.rand.Mixer;
import shakti.winter.rand.Randomizer;

public class Tree {
	
	public static double GENE = 0.52345;
	Branch<Boolean, Boolean> trunk;
	
	public Tree() {	
		if (GENE > Randomizer.getP()) {
			trunk = split();
		} else {
			trunk = new Branch<Boolean, Boolean>(new And());
			trunk.load(Tools.listIt(split(), split()));
		}
	}
	
	public Bud<Boolean> split(){
		return new Mixer<Bud<Boolean>>(Tools.listIt(
				new Pair<Bud<Boolean>, Integer>(new Bud<>(true),50),
				new Pair<Bud<Boolean>, Integer>(new Bud<>(false),50)
				)).choose();
	}
	
	UnaryOperator<Integer, Integer> potOp, turnOp; //to keep track of vars
	
	
	private void setVars(int potatoes, int turnsLeft) {
		if (potOp != null) {
			potOp.load(potatoes);
		}
		if (turnOp != null) {
			turnOp.load(turnsLeft);
		}
	}

	public boolean decide(int potatoes, int turnsLeft) {
		setVars(potatoes, turnsLeft);
		return trunk.pull();
	}
	
	public List<Tree> mutate(int n){
		List<Tree> treeLzt = new ArrayList<>();
		for (int i=0; i<n; i++) {
			treeLzt.add(new Tree());
		}
		return treeLzt;
	}
	
	@Override
	public String toString() {
		return trunk.toString();
	}
}
