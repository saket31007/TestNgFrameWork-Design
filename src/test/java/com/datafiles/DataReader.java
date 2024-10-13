package com.datafiles;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	
//	public List<HashMap<String, String>> getJasonDataToMap() throws IOException {
//		
//	 
//	String jsonContant= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src\\test\\java\\com\\datafiles\\LandingPage.json"), StandardCharsets.UTF_8);
//	ObjectMapper mapper = new ObjectMapper();
//	
//	//String to HashMap Jackson Databind--dependecy for maven add to maven
//	
//	 List<HashMap<String, String>> data = mapper.readValue(
//			 jsonContant,
//	            new TypeReference<List<HashMap<String, String>>>() {}
//	        );
//	 return data;
//	}
	//the above method I have moved it to base test to access it globally
}
