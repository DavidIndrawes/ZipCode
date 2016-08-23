package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A99State implements State {
private static State me = new A99State();
	
	private A99State(){}
	
	@Override
	public String handle(String pCode) {
		Pattern pattern = Pattern.compile("[BEGLMNSW][0-9][0-9]\\s...");
		Matcher matcher = pattern.matcher(pCode);
		if(!matcher.matches()) return SuffixErrorState.getInctance().handle(pCode);
		else return  "the first letter is expected to be {B, E, G, L, M, N, S, W} for the A9 9AA format";
	}
	
	public static State getInctance() {
		return me;
	}
}
