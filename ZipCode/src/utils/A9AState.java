package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A9AState implements State {
	private static State me = new A9AState();
	
	private A9AState(){}
	
	@Override
	public String handle(String pCode) {
		Pattern pattern = Pattern.compile("[A-PR-UWYZ][0-9][A-HJKPSTUW]\\s...");
		Matcher matcher = pattern.matcher(pCode);
		if(matcher.matches()) return SuffixErrorState.getInctance().handle(pCode);
			
		else {
			pattern = pattern.compile("[A-PR-UWYZ]..\\s...");
			matcher = pattern.matcher(pCode);
			if (!matcher.matches()) return pCode.charAt(0)+" in The First position is illegal";
			else return pCode.charAt(2)+" in the third position is illegal only :ABCDEFGHJKPSTUW allowed";
		}
	}
	
	public static State getInctance() {
		return me;
	}
}
