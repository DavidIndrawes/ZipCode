package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class CSVReader {
	
	private BufferedReader buffer;
	private TreeMap<Integer,String> notValid = new TreeMap<Integer,String>();
	private TreeMap<Integer,String> valid = new TreeMap<Integer,String>();
	
	

	public CSVReader(String filePath) {
		try{
			buffer = new BufferedReader(new FileReader(filePath));
		}	catch ( IOException e){
			e.printStackTrace();
		}
	}

	public void readAndValidate(Validator validator) {
		String [] entry;
		
		try {
			String line = buffer.readLine();	// skip the table heading
			line = buffer.readLine();			// start with the column after the table heading
			
			while (line!= null){
				entry = line.split(",");
				
				if(validator.validate(entry[1])){
					valid.put(Integer.valueOf(entry[0]), entry[1]);
				} else {
					notValid.put(Integer.valueOf(entry[0]), entry[1]);
				}
				
				line = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public TreeMap<Integer, String> getNotValidList() {
		return notValid;
	}
	public TreeMap<Integer, String> getValidList() {
		return valid;
	}

}
