package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A9State implements State {
	
	private static State me = new A9State();
	
	private A9State (){}
	
	@Override
	public String handle(String pCode) {
		Pattern pattern = Pattern.compile("..\\s...");
		Matcher matcher = pattern.matcher(pCode);
		if(!matcher.matches()) return "expected A9 9AA format didn't match, space not in the right position or missing a letter";
		else {
			pattern = pattern.compile("[BEGLMNSW][0-9]\\s...");
			matcher = pattern.matcher(pCode);
			if (matcher.matches()) return SuffixErrorState.getInctance().handle(pCode);
			else {
				pattern = pattern.compile("[BEGLMNSW].\\s...");
				matcher = pattern.matcher(pCode);
				if (matcher.matches()) return "error in the second letter, a digit was expected";
				else return  "the first letter is expected to be {B- E- G- L- M- N-S- W} for the A9 9AA format";
			}
		}
	}
	
	public static State getInctance() {
		return me;
	}
}
