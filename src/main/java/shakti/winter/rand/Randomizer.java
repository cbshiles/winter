package shakti.winter.rand;

import java.util.List;
import java.util.Random;

public class Randomizer {

	private static Random r = new Random();
	
	//inclusive
	public static int getInt(int min, int max) {
		return min + r.nextInt(max-min+1);
	}
	
	public static double getP() {
		return r.nextDouble();
	}
	
	//has a X/Y probability of returning True
	public static boolean XOutOfY(int x, int y) {
		int n = r.nextInt(y);
		return n<x;
	}
	
	public static <T> T getItem(List<T> lzt) {
		return lzt.get(getInt(0, lzt.size()-1));
	}
}
