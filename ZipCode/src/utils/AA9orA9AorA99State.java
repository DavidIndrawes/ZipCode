package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AA9orA9AorA99State implements State {
	
	private static State me = new AA9orA9AorA99State();
	
	private AA9orA9AorA99State(){}
	
	@Override
	public String handle(String pCode) {
		Pattern pattern = Pattern.compile("...\\s...");
		Matcher matcher = pattern.matcher(pCode);
		if(!matcher.matches()) return "expected xxx xxx format didn't match, space not in the right position or missing a letter";
		else {
			pattern = pattern.compile("[A-Z][0-9][0-9]\\s...");
			matcher = pattern.matcher(pCode);
			if (matcher.matches()) return A99State.getInctance().handle(pCode);
			else {
				pattern = pattern.compile("[A-Z][A-Z][0-9]\\s...");
				matcher = pattern.matcher(pCode);
				if (matcher.matches()) return AA9State.getInctance().handle(pCode);
				else {
					pattern = pattern.compile("[A-Z][0-9][A-Z]\\s...");
					matcher = pattern.matcher(pCode);
					if (matcher.matches()) return A9AState.getInctance().handle(pCode);
					else return  "Wrong Format make sure to use only letters and digits and start with a letter pllease follow the A99 - A9A - A99 formats";
				}
			}
		}
	}
	
	public static State getInctance() {
		return me;
	}
}
