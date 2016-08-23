package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AA9AorAA99State implements State {
	
	private static State me = new AA9AorAA99State();
	
	private AA9AorAA99State(){}
	
	@Override
	public String handle(String pCode) {
		Pattern pattern = Pattern.compile("....\\s...");
		Matcher matcher = pattern.matcher(pCode);
		if(!matcher.matches()) return "expected xxxx xxx format didn't match, space not in the right position or an extra letter have been added by mistake";
		else {
			pattern = pattern.compile("WC[0-9][A-Z]\\s...");
			matcher = pattern.matcher(pCode);
			if (matcher.matches()) return SuffixErrorState.getInctance().handle(pCode);
			else {
				pattern = pattern.compile("[A-Z][A-Z][0-9][A-Z]\\s...");
				matcher = pattern.matcher(pCode);
				if (matcher.matches()) return AA9AState.getInctance().handle(pCode);
				else {
					pattern = pattern.compile("[A-Z][A-Z][0-9][0-9]\\s...");
					matcher = pattern.matcher(pCode);
					if (matcher.matches()) return AA99State.getInctance().handle(pCode);
					else return  "wrong format please to start the postcode with letter only and use the A9AA or AA99 formats, make sure to use only letters and digits no special characters"; // the user may have entered digit at the first position or so ...
				}
			}
		}
	}
	
	public static State getInctance() {
		return me;
	}

}
