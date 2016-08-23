package test;

import static org.junit.Assert.*;
import main.*;

import org.junit.Test;

import sun.security.tools.keytool.Main;

public class Test0 {

	
	
	@Test
	public void testCompilingValidator0(){
		
		String regex = "()";
		String pCode = "xxx";
		
		Validator validator = new Validator (regex);
		assertFalse(validator.validate(pCode));
	}
	
	@Test
	public void testUnValidRegex0(){
		
		String regex = null;
		String pCode = "xxx";
		
		Validator validator = new Validator (regex);
		assertFalse(validator.validate(pCode));
	}
	
	@Test
	public void testUnValidRegex1(){
		
		String regex = "CC";
		String pCode = "xxx";
		
		Validator validator = new Validator (regex);
		assertFalse(validator.validate(pCode));
	}
	
	@Test
	public void testValidatorCreatePatterns0(){
		
		String regex = ".*x.*";
		
		Validator validator = new Validator (regex);
		assertEquals(".*x.*", validator.getPattern());
	}
	
	@Test
	public void testValidatorMatchPatterns0(){
		
		String regex = ".*X.*";
		String pCode = "x";
		
		Validator validator = new Validator (regex);
		assertTrue(validator.validate(pCode));
	}
	
	@Test
	public void testMatching1(){
		
		String regex = "[0-9]{2}[A-Z]";
		String pCode = "34C";
		
		Validator validator = new Validator (regex);
		assertTrue(validator.validate(pCode));
	}
	
	@Test
	public void testMatching2SmallLetters(){
		
		String regex = "[0-9]{2}[A-Z]";
		String pCode = "34c";
		
		Validator validator = new Validator (regex);
		assertTrue(validator.validate(pCode));
	}
	
	@Test
	public void testMatching3(){
		
		String regex = "[A-DN-Y]\\s[0-9]{2}[A-Z]";
		String pCode = "D 34C";
		
		Validator validator = new Validator (regex);
		assertTrue(validator.validate(pCode));
	}
	
	@Test
	public void testMatching4Unmatching(){
		
		String regex = "[A-DN-Y]\\s[0-9]{2}[A-Z]";
		String pCode = "HD 34C";
		
		Validator validator = new Validator (regex);
		assertFalse(validator.validate(pCode));
	}
	
	@Test
	public void testMatching5(){
		
		// the full regex
		String regex = "(GIR\\s0AA)|((([A-PR-UWYZ][0-9][0-9]?)|([A-PR-UWYZ][A-HK-Y][0-9](?<!(BR|FY|HA|HD|HG|HR|HS|HX|JE|LD|SM|SR|WC|WN|ZE)[0-9])[0-9])|([A-PR-UWYZ][A-HK-Y](?<!AB|LL|SO)[0-9])|(WC[0-9][A-Z])|([A-PR-UWYZ][0-9][A-HJKPSTUW])|([A-PR-UWYZ][A-HK-Y][0-9][ABEHMNPRVWXY]))\\s[0-9][ABD-HJLNP-UW-Z]{2})";
		String pCode = "HD1 6NY";
		
		Validator validator = new Validator (regex);
		assertTrue(validator.validate(pCode));
	}
	
	// testing on the NHS Special Postcodes
	@Test
	public void testMatching6(){

		String regex = "(GIR\\s0AA) |((([A-PR-UWYZ][0-9][0-9]?)|([A-PR-UWYZ][A-HK-Y][0-9](?<!(BR|FY|HA|HD|HG|HR|HS|HX|JE|LD|SM|SR|WC|WN|ZE)[0-9])[0-9])|([A-PR-UWYZ][A-HK-Y](?<!AB|LL|SO)[0-9])|(WC[0-9][A-Z])|([A-PR-UWYZ][0-9][A-HJKPSTUW])|([A-PR-UWYZ][A-HK-Y][0-9][ABEHMNPRVWXY]))\\s[0-9][ABD-HJLNP-UW-Z]{2})";
		
		String pCode = "ZZ99 3CZ";	// ZZ99 3CZ a special postcode used by NHS in records if the patient stated he lives in England without further details
		
		Validator validator = new Validator (regex);
		assertTrue(validator.validate(pCode));
	}
	
	// the validate method is ready now
	
	// reading from CSV file
	@Test
	public void testOpeningTheDataFile(){

		String filePath = "import_data.csv";
		
		CSVReader reader = new CSVReader(filePath);
	}
	
	@Test
	public void testReadAndValidateEntriesMethod2(){	//check if the method running without problems and check the produced list size
		
		String regex = "(GIR\\s0AA) |((([A-PR-UWYZ][0-9][0-9]?)|([A-PR-UWYZ][A-HK-Y][0-9](?<!(BR|FY|HA|HD|HG|HR|HS|HX|JE|LD|SM|SR|WC|WN|ZE)[0-9])[0-9])|([A-PR-UWYZ][A-HK-Y](?<!AB|LL|SO)[0-9])|(WC[0-9][A-Z])|([A-PR-UWYZ][0-9][A-HJKPSTUW])|([A-PR-UWYZ][A-HK-Y][0-9][ABEHMNPRVWXY]))\\s[0-9][ABD-HJLNP-UW-Z]{2})";
		String filePath = "import_data.csv";
		
		Validator validator = new Validator (regex);
		CSVReader reader = new CSVReader(filePath);
		reader.readAndValidate(validator);
		assertNotEquals(0, reader.getNotValidList().size());
		System.out.println(reader.getNotValidList().size());
	}
	
	// print the result to failed_validation.csv
	@Test
	public void testopenFileForWriting(){

		String filePath = "failed_validation.csv";
		
		//CSVWriter writer = new CSVWriter(filePath);
		
	}
	
	@Test
	public void testOpeningTheFileToWriteIn(){
		
		String regex = "(GIR\\s0AA) |((([BEGLMNSW][0-9][0-9]?)|([A-PR-UWYZ][A-HK-Y][0-9](?<!(BR|FY|HA|HD|HG|HR|HS|HX|JE|LD|SM|SR|WC|WN|ZE)[0-9])[0-9])|([A-PR-UWYZ][A-HK-Y](?<!AB|LL|SO)[0-9])|(WC[0-9][A-Z])|([A-PR-UWYZ][0-9][A-HJKPSTUW])|([A-PR-UWYZ][A-HK-Y][0-9][ABEHMNPRVWXY]))\\s[0-9][ABD-HJLNP-UW-Z]{2})";
		String filePathRead = "import_data.csv";
		String filePathWriteFailed = "failed_validation.csv";
		String filePathWriteSucceeded = "succeeded_validation.csv";
		
		Validator validator = new Validator (regex);
		CSVReader reader = new CSVReader(filePathRead);
		CSVWriter writer = new CSVWriter(filePathWriteFailed,filePathWriteSucceeded,validator);
		
		reader.readAndValidate(validator);
		writer.writeList(reader.getNotValidList(),reader.getValidList());
			
	}
	
	
	
}
