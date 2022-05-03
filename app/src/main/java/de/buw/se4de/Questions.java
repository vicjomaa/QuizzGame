package de.buw.se4de;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;


 class Questions {
	public  Multimap<String, String> getQuestions()	{

		Multimap<String, String> myMultimap = ArrayListMultimap.create();
		try (Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/Dataset_Questions.csv"));
				@SuppressWarnings("deprecation")
				CSVParser csvParser = new CSVParser(reader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			for (CSVRecord csvRecord : csvParser) {
				// Adding some key/value
				String id = csvRecord.get("id");
				myMultimap.put(id, csvRecord.get("type"));
				myMultimap.put(id, csvRecord.get("quiz_number"));
				myMultimap.put(id, csvRecord.get("question"));
				myMultimap.put(id, csvRecord.get("option_1"));
				myMultimap.put(id, csvRecord.get("option_2"));
				myMultimap.put(id, csvRecord.get("option_3"));
				myMultimap.put(id, csvRecord.get("option_4"));
				myMultimap.put(id, csvRecord.get("answer"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return myMultimap ;
	}



}
 

