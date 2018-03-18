package shakti.winter.expression.tree;

import java.util.ArrayList;
import java.util.List;

import shakti.winter.tools.*;
import shakti.winter.core.*;
import shakti.winter.expression.*;
import shakti.winter.expression.operator.*;
import shakti.winter.rand.*;

public class Tree implements Mind{
	
	public static double GENE = 0.52345;
	Boolville trunk;
	
	public Tree() {	
		if (GENE > Randomizer.getP()) {
			trunk = split();
		} else {
			trunk = new Boolville(new And());
			trunk.load(Tools.listIt(split(), split()));
		}
	}

    public Tree copy(){
	return new Tree();
    }
	
	public Boolville split(){
		return new Mixer<Bud<Boolean>>(Tools.listIt(
				new Pair<Boolville, Integer>(new Boolville(true),50),
				new Pair<Boolville, Integer>(new Boolville(false),50)
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
	
	public Tree mutate(){
	    return new Tree();
	}
	
	@Override
	public String toString() {
		return trunk.toString();
	}
}
