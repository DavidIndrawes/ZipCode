package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AA9AState implements State {
	private static State me = new AA9AState();
	
	private AA9AState(){}
	
	@Override
	public String handle(String pCode) {
		Pattern pattern = Pattern.compile("[A-PR-UWYZ][A-HK-Y][0-9][ABEHMNPRVWXY]\\s...");
		Matcher matcher = pattern.matcher(pCode);
		if(matcher.matches()) return SuffixErrorState.getInctance().handle(pCode);
		else {
			pattern = pattern.compile("[A-PR-UWYZ][A-HK-Y]..\\s...");
			matcher = pattern.matcher(pCode);
			if (matcher.matches()) return pCode.charAt(3)+" in the Fourth position is illegal";
			else {
				pattern = pattern.compile("[A-PR-UWYZ]...\\s...");
				matcher = pattern.matcher(pCode);
				if(matcher.matches()) return pCode.charAt(1)+" in the Second position is illegal";
				else  return pCode.charAt(0)+" in the First position is illegal";
				}
		}
	}
	
	public static State getInctance() {
		return me;
	}
}
