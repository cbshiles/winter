package shakti.winter;

import java.util.ArrayList;
import java.util.List;

public class Tools {
	
	@SafeVarargs
	public static <T> List<T> listIt(T... arr){
		List<T> lzt = new ArrayList<T>();
		for (T t: arr) {lzt.add(t);}
		return lzt;
	}
	
	//inclusive
	public static boolean between(int i, int a, int z) {
		return i>=a && i<=z;
	}

}
