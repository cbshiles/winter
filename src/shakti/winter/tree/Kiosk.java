package shakti.winter.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shakti.winter.tools.*;
import shakti.winter.operator.*;
import shakti.winter.operator.Add;
import shakti.winter.operator.And;
import shakti.winter.operator.Div;
import shakti.winter.operator.Equal;
import shakti.winter.operator.Greater;
import shakti.winter.operator.Less;
import shakti.winter.operator.Mult;
import shakti.winter.operator.Neg;
import shakti.winter.operator.Not;
import shakti.winter.operator.Or;
import shakti.winter.operator.Sub;

//Use this for info on operators and values
public class Kiosk {
	
	public static List<Class<? extends Operator<Boolean, Boolean>>> logical = 
			Tools.listIt(And.class, Or.class, Not.class);

	public static List<Class<? extends Operator<Integer, Boolean>>> equality = 
			Tools.listIt(Less.class, Greater.class, Equal.class);
	
	public static List<Class<? extends Operator<Integer, Integer>>> arithmetic = 
			Tools.listIt(Add.class, Div.class, Mult.class, Sub.class, Neg.class, Abs.class);
	
	//not including boolean constants (True, False) in the kiosk
	
	public static Leaf<Integer> turnsLeft = new Leaf<>();
	public static Leaf<Integer> potatoes = new Leaf<>();
	public static List<Integer> nums = new ArrayList<>();
	public static AccMap<String, Node<?>> nodeMap = new AccMap<>();
	
	static {
		for (int i=0; i<13; i++) {nums.add(i);}
		
		List<Class<? extends Operator<Integer, ?>>> intOps = new ArrayList<>();
		intOps.addAll(equality);
		intOps.addAll(arithmetic);
		
		for (Class<? extends Operator<Integer, ?>> klass: intOps) {
			nodeMap.put(Integer.class.getName(), )
		}
	}
	
	public static void updateVars(int turns, int pots) {
		turnsLeft.update(turns);
		potatoes.update(pots);
	}
	
	public static <ARG> List<Node<ARG>> kidList(Operator<ARG, ?> op) {
		System.out.println(op.argClass.getName());
		l
		return null;
	}
	
}
