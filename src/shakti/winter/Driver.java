package shakti.winter;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	public static List<Being> doYear(List<Being> oldBeings, int turns){
		List<Being> newBeings = new ArrayList<>();
		for (int tl=turns-1; tl>=0; tl--) {
			for (Being ob: oldBeings) {
				if (ob.decide(tl)) { //pick
					ob.life += (ob.potatoes++ / 3);
				} else { //huddle
					ob.life += 1 + (ob.potatoes / 2);
				}
			}
		}
		for (Being ob: oldBeings) {
			ob.life -= turns; //rate 1*turn
			newBeings.addAll(ob.mutate());
		}
		return newBeings;
	}
	
	public static List<Being> firstBeings(int count){
		List<Being> beings = new ArrayList<>();
		while (count-- > 0) {
			beings.add(new Being());
		}
		return beings;
	}
	
	public static void main(String[] args) {
		int tc = 0;
		List<Being> beings = firstBeings(20);
		while (tc++ < 20 && Tools.between(beings.size(), 0, 1000)) {
			System.out.println("Round "+tc+": "+beings.size()+" beings.");
			for (Being b: beings) {
				System.out.println(b.life+" ~ "+b.mind.toString());
			}
			beings = doYear(beings, 4);
		}
	}
}
