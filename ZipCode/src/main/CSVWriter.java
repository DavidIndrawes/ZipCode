package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class CSVWriter {

	private FileWriter writerFailed ,writerSucceeded;
	private Validator validator;
	
	public CSVWriter(String filePathFailed, String filePathSucceeded, Validator validator) {
		
		this.validator = validator;
		try {
			writerFailed = new FileWriter(filePathFailed);
			writerSucceeded = new FileWriter(filePathSucceeded);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeList(TreeMap<Integer, String> failed,TreeMap<Integer, String> succeeded) {
		// writing to failed_validation.csv
		for(Map.Entry<Integer, String> entry : failed.entrySet()){
			try {
				writerFailed.write(entry.getKey()+","+entry.getValue()+","+validator.getExpectedProblem(entry.getValue())+"\n");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		
		// writing to succeeded_validation.csv
				for(Map.Entry<Integer, String> entry : succeeded.entrySet()){
					try {
						writerSucceeded.write(entry.getKey()+","+entry.getValue()+"\n");
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
		
	}

}
