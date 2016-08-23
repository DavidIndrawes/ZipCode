package main;

public class main {

	public static void main(String[] args) {
		String filePathRead;
		try{
			filePathRead = args[0];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("please submit the data file to be validated as an argument");
			return;
		}
		Long startTime = System.currentTimeMillis();
		String regex = "(GIR\\s0AA)|((([BEGLMNSW][0-9][0-9]?)|([A-PR-UWYZ][A-HK-Y][0-9](?<!(BR|FY|HA|HD|HG|HR|HS|HX|JE|LD|SM|SR|WC|WN|ZE)[0-9])[0-9])|([A-PR-UWYZ][A-HK-Y](?<!AB|LL|SO)[0-9])|(WC[0-9][A-Z])|([A-PR-UWYZ][0-9][A-HJKPSTUW])|([A-PR-UWYZ][A-HK-Y][0-9][ABEHMNPRVWXY]))\\s[0-9][ABD-HJLNP-UW-Z]{2})";
		
		String filePathWriteFailed = "failed_validation.csv";
		String filePathWriteSucceeded = "succeeded_validation.csv";
		
		Validator validator = new Validator (regex);
		CSVReader reader = new CSVReader(filePathRead);
		CSVWriter writer = new CSVWriter(filePathWriteFailed,filePathWriteSucceeded,validator);

		
		reader.readAndValidate(validator);
		writer.writeList(reader.getNotValidList(),reader.getValidList());

		
		Long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime+" ms"
				+ "");

	}

}
