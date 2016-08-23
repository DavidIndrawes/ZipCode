package test;

import static org.junit.Assert.*;
import main.Validator;

import org.junit.Test;

public class TestingExpectedProplem {

	@Test
	public void testingMissingSpace() {
		Validator validator = new Validator("Don't care");	// the method of expecting problem is not generic for any regex
		
		System.out.println(validator.getExpectedProblem("xx"));
	} 
	
	@Test
	public void testingLengthProblem() {
		Validator validator = new Validator("Don't care");	// the method of expecting problem is not generic for any regex
		
		System.out.println(validator.getExpectedProblem("xx x0"));
	}
	
	@Test
	public void testingXXSXXX() {
		Validator validator = new Validator("Don't care");	// the method of expecting problem is not generic for any regex
		
		System.out.println(validator.getExpectedProblem("xxx x0"));
	}
	
	@Test
	public void testingA99s9AA() {
		Validator validator = new Validator("Don't care");	// the method of expecting problem is not generic for any regex
		
		System.out.println("test 4 " +validator.getExpectedProblem("C1 3DH"));
	}
	
	@Test
	public void testingAA9s9AA() {
		Validator validator = new Validator("Don't care");	// the method of expecting problem is not generic for any regex
		
		System.out.println("test 5 " +validator.getExpectedProblem("SO1 4QQ"));
	}
	
	@Test
	public void testingA9As9AA() {
		Validator validator = new Validator("Don't care");	// the method of expecting problem is not generic for any regex
		
		System.out.println("test 6 " +validator.getExpectedProblem("X1A 9BB"));
	}
	
	@Test
	public void testingAA9As9AA() {
		Validator validator = new Validator("Don't care");			
		System.out.println("test 7 " +validator.getExpectedProblem("AA9C 9AA"));
	}
	
	@Test
	public void testingAA99s9AA() {
		Validator validator = new Validator("Don't care");			
		System.out.println("test 8 " +validator.getExpectedProblem("FY10 4PL"));
	}
	
	// now that the expected error method is ready lets add it to the failed CSV file
}
