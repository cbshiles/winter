package shakti.winter.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Accumulator map
public class AccMap<K, V> {

	public Map<K, List<V>> map = new HashMap<>();
	
	public void put(K k, V v) {
		List<V> prev = get(k);
		if (prev == null) {
			map.put(k, Tools.listIt(v));
		} else {
			prev.add(v);
		}
	}
	
	public List<V> get(K k){
		return map.get(k);
	}
}
