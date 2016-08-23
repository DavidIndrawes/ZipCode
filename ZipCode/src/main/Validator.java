package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import utils.StartState;


public class Validator {
	
	private String regex;
	private Pattern pattern;
	private Matcher matcher;
	private String[] specialPostcodes = {"ZZ99 3CZ","ZZ99 3VZ","ZZ99 3WZ","ZZ99 2WZ", "ZZ99 1WZ", "ZZ99 3GZ", "ZZ99 NNN"};	// NHS list of Special postcodes

	public Validator(String regex) {
		this.regex = regex;
		try{
			pattern = Pattern.compile(regex);
		} catch (NullPointerException e){
			System.out.println("the regular expression format is not valid, null string was provided");
		} catch (PatternSyntaxException e){
			System.out.println("the regular expression format is not valid, wrong format was provided");
		}
	}

	public boolean validate(String pCode) {
		String pCodeCapital = pCode.toUpperCase();
		try{
			matcher = pattern.matcher(pCodeCapital);
		} catch (NullPointerException e){
			return false;
		}
		if(!matcher.matches()) return checkIfSpecialPostcodes(pCodeCapital); 	// if didn't match check in the list of special codes
		else return true;
	}
	
	public String getExpectedProblem(String pCode){
		String pCodeCapital = pCode.toUpperCase();
		return StartState.getInctance().handle(pCodeCapital);
	}

	private boolean checkIfSpecialPostcodes(String pCodeCapital) {
		for (String postcode : specialPostcodes){
			if(pCodeCapital == postcode) return true;
		}
		return false;
	}

	public String getPattern() {
		
		return pattern.pattern();
	}
	
	
}
