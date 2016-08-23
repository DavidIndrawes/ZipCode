package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AA99State implements State {
	private static State me = new AA99State();
	
	private AA99State(){}
	
	@Override
	public String handle(String pCode) {
		Pattern pattern = Pattern.compile("([A-PR-UWYZ][A-HK-Y][0-9](?<!(BR|FY|HA|HD|HG|HR|HS|HX|JE|LD|SM|SR|WC|WN|ZE)[0-9])[0-9])\\s...");
		Matcher matcher = pattern.matcher(pCode);
		if(matcher.matches()) return SuffixErrorState.getInctance().handle(pCode);
		else {
			pattern = pattern.compile("[A-PR-UWYZ][A-HK-Y]..\\s...");
			matcher = pattern.matcher(pCode);
			if (matcher.matches()) return pCode.charAt(0)+""+pCode.charAt(1)+" Area with only single digit districts";
			else {
				pattern = pattern.compile("[A-PR-UWYZ]...\\s...");
				matcher = pattern.matcher(pCode);
				if(matcher.matches()) return pCode.charAt(1)+" is illegal at the second position for AA99 structure";
				else  return pCode.charAt(0)+" is illegal at the First position for AA99 structure"; 			}
		}
		
	}
	
	public static State getInctance() {
		return me;
	}
}
