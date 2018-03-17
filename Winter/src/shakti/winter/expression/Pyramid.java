package shakti.winter.expression;

import java.util.List;
import java.util.Map;

import shakti.winter.Pair;

/**
 * Data pyramid, has hierachy of data types, that define the dimensionality 
 * of a certain system.
 * 
 * Not used, at least atm
 * @author brenan
 *
 */
public class Pyramid {
	
	//pyramids have x classes, and 2x-1 layers
	//this is because there is a transition layer between each class

	private List<Class<?>> classLzt;
	private Map<String, Integer> indexMap;
	
	//classLzt is an, in order, top first list of data types for the pyramid
	public Pyramid(List<Class<?>> classLzt) {
		this.classLzt = classLzt;
		for (int i=0; i<classLzt.size(); i++) {
			indexMap.put(classLzt.get(i).getName(), i);
		}
	}
	
//	public void addOperators(List<Operator<A,R>> ops, int layer) {
//		
//	}
	
	public Pair<Class<?>, Class<?>> getClassesForLayer(int layer){
		if (layer%2 == 0) {
			Class<?> c = classLzt.get(layer/2);
			return new Pair<>(c, c);
		} else {
			int i = (layer+1)/2;
			return new Pair<>(classLzt.get(i), classLzt.get(i-1));
		}
	}
	
	//returns null if not found
	public Class<?> getClassByName(String name){
		Integer i = indexMap.get(name);
		if (i == null) return null;
		return classLzt.get(i);
	}
	
}
