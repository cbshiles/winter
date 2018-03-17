package shakti.winter.rand;

import java.util.ArrayList;
import java.util.List;

import shakti.winter.Pair;
import shakti.winter.expression.Operator;

public class Mixer<T>{

	List<T> lzt = new ArrayList<>();
	List<Double> pos = new ArrayList<>();
	
	public Mixer(List<Pair<T, Integer>> pairLzt) {
		for (Pair<T, Integer> pair: pairLzt) {
			lzt.add(pair.a);
			pos.add(pair.b+getLastPos());
		}
		int size = pos.size();
		double max = pos.get(size-1);
		for (int i=0; i<size; i++) {
			pos.set(i, pos.get(i)/max);
		}
	}
	
	public Mixer(List<T> lzt, boolean notUsed) {
		this(evenPair(lzt));
	}
	
	//makes pairs w/ even weights
	public  static <T> List<Pair<T, Integer>> evenPair(List<T> lzt) {
		List<Pair<T, Integer>> pairLzt = new ArrayList<>();
		for (T t : lzt) {
			pairLzt.add(new Pair<T, Integer>(t, 1));
		}	
		return pairLzt;
	}
	
	public T choose() {
		double d = Randomizer.getP();
		double sum = 0.0;
		int c = 0;
		while (sum < d) {
			sum += pos.get(c++);
		}
		return lzt.get(c-1);
	}
	
	private Double getLastPos() {
		int s = pos.size();
		if (s==0) return 0.0;
		return pos.get(s-1);
	}
}
