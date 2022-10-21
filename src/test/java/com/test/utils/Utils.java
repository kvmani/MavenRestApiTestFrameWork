package com.test.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import com.test.constats.SourcePath;



public class Utils {
	public static FileInputStream stream=null;
	public static Properties loadFile(String filename){
		Properties propertiesObj=new Properties();
	
			
			System.out.println("PropertyFilePath is set to be :"+filename);
			
		
			try {
				stream=new FileInputStream(filename);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				propertiesObj.load(stream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return propertiesObj;
		
	}
public static String getApplicationProperty(String Key) {
	String PropertyFilePath=SourcePath.CONFIG_PROPERTIES_PATH;
	Properties propertiesObj=loadFile(PropertyFilePath);
	String value=propertiesObj.getProperty(Key);
	System.out.println("Property we got from the fileis :: "+value);
	
		return value;
		

}
 public HashMap getAllPropertiesAsSet(Properties propertyFile) {
	 return new HashMap(propertyFile);
 }
 }
	

