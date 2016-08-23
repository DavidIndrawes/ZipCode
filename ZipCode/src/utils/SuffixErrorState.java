package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SuffixErrorState implements State {
	private static State me = new SuffixErrorState();
	
	private SuffixErrorState(){}
	
	@Override
	public String handle(String pCode) {
		String pCodeLastChars = pCode.substring(pCode.length()-4);
		Pattern pattern = Pattern.compile(".*\\s[^0-9][A-Z][A-Z]");
		Matcher matcher = pattern.matcher(pCodeLastChars);
		if(matcher.matches()) return "a digit from 0 to 9 must be at the first position after the space";
		else {
			pattern = pattern.compile(".*\\s[0-9][^A-Z][A-Z]");
			matcher = pattern.matcher(pCode);
			if (matcher.matches()) return "a letter from A to Z must be at the second position after the space";
			else {
				pattern = pattern.compile(".*\\s[0-9][A-Z][^A-Z]");
				matcher = pattern.matcher(pCode);
				if (matcher.matches()) return "a letter from A to Z must be at the Third position after the space";
				else return  "unexpected format please make sure to use only letters and digits for the part after the space and follow the 9AA format for it";
			}
		}
	}
	
	public static State getInctance() {
		return me;
	}
}
