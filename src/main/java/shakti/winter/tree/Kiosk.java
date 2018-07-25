package shakti.winter.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shakti.winter.tools.*;
import shakti.winter.operator.*;
import shakti.winter.operator.manifest.Abs;
import shakti.winter.operator.manifest.Add;
import shakti.winter.operator.manifest.And;
import shakti.winter.operator.manifest.Div;
import shakti.winter.operator.manifest.Equal;
import shakti.winter.operator.manifest.Greater;
import shakti.winter.operator.manifest.Less;
import shakti.winter.operator.manifest.Mult;
import shakti.winter.operator.manifest.Neg;
import shakti.winter.operator.manifest.Not;
import shakti.winter.operator.manifest.Or;
import shakti.winter.rand.Randomizer;

//Use this for info on operators and values
public class Kiosk {
	
	public static List<? extends Operator<Boolean, Boolean>> logical = 
			Tools.listIt(new And(), new Or(), new Not());

	public static List<? extends Operator<Integer, Boolean>> equality = 
			Tools.listIt(new Less(), new Greater(), new Equal());
	
	public static List<? extends Operator<Integer, Integer>> arithmetic = 
			Tools.listIt(new Add(), new Div(), new Mult(), new Sub(), new Neg(), new Abs());
	
	//not including boolean constants (True, False) in the kiosk
	
	public static Map<String, Variable<?>> variableMap = new HashMap<>();
	
	public static AccMap<String, Operator<?, ?>> argMap = new AccMap<>();
	public static AccMap<String, Operator<?, ?>> retMap = new AccMap<>();
	public static AccMap<String, Leaf<?>> constantMap = new AccMap<>();
	
	//add operators & constants to the maps
	static {
		for (int i=0; i<13; i++) {
			constantMap.put(Integer.class.getName(), new Leaf<Integer>(i));
		}
		
		constantMap.put(Boolean.class.getName(), new Leaf<Boolean>(true));
		constantMap.put(Boolean.class.getName(), new Leaf<Boolean>(false));
		
		//huh, looks like lambdas are good for something
		List<Operator<?, ?>> opLzt = new ArrayList<>();
		logical.forEach(op -> opLzt.add(op));
		equality.forEach(op -> opLzt.add(op));
		arithmetic.forEach(op -> opLzt.add(op));		
		for (Operator<?, ?> op: opLzt) {
			argMap.put(op.argClass.getName(), op);
			retMap.put(op.retClass.getName(), op);
		}
	}
	
	public static <T> void addVar(Variable<T> var) {
		constantMap.put(var.className(), var.leaf);
		variableMap.put(var.name, var);
	}
	
	public static <T> void updateVar(String name, T value) {
		((Leaf<T>) variableMap.get(name).leaf).update(value);
	}
	
	public static void updateWinterVars(int turns, int pots) {
		updateVar("turnsLeft", turns);
		updateVar("potatoes", pots);
	}

	public static void updateGuessingVars(int topBorder, int bottomBorder) {
		updateVar("topBorder", topBorder);
		updateVar("bottomBorder", bottomBorder);
	}
	
	public static <ARG> Node<ARG> kid(Class<ARG> argClass) {
		String argClassName = argClass.getName();
		return Randomizer.getP() < .5 ? (Leaf<ARG>) constantMap.getRandom(argClassName)
				: (Randomizer.getP() < .9 ? new Branch((Operator<?, ARG>) retMap.getRandom(argClassName)) 
						: new TernaryBranch<>(argClass));
		
	}
	
	public static <ARG> List<Node<ARG>> kidList(int n, Class<ARG> argClass) {
		List<Node<ARG>> kids = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			kids.add(kid(argClass));
		}
		return kids;
	}
	
	public static <ARG> List<Node<ARG>> kidList(Operator<ARG, ?> op) {
		return kidList(op.nargs, op.argClass);
	}
	
}
