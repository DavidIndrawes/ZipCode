package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AA9State implements State {
	private static State me = new AA9State();
	
	private AA9State(){}
	
	@Override
	public String handle(String pCode) {
		Pattern pattern = Pattern.compile("[A-PR-UWYZ]..\\s...");
		Matcher matcher = pattern.matcher(pCode);
		if(!matcher.matches()) return pCode.charAt(0)+" in first position";
		else {
			pattern = pattern.compile("[A-PR-UWYZ][A-HK-Y].\\s...");
			matcher = pattern.matcher(pCode);
			if (!matcher.matches()) return pCode.charAt(1)+" in Second position";
			else {
				pattern = pattern.compile("(AB|LL|SO).\\s...");
				matcher = pattern.matcher(pCode);
				if(matcher.matches()) return "Area with only double digit districts";
				else  return SuffixErrorState.getInctance().handle(pCode); 			}
		}
		
	}
	
	public static State getInctance() {
		return me;
	}
}
