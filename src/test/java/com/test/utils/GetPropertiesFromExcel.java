package com.test.utils;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.test.constats.SourcePath;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Iterator;


public class GetPropertiesFromExcel {
	
	

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * String value = getValueBasedOnKey("AccountNo"); value =
	 * getValueBasedOnKey("DepartmentNo"); }
	 */

	
	public static String getValueBasedOnKey(String sourceKey) {
		
		String targetKey =sourceKey;
        String value ="";
        System.out.println("Serching for key:"+sourceKey);
		try
	        {
			   
			   
	            FileInputStream file = new FileInputStream(new File(SourcePath.USER_DATA_PATH));
	 
	            //Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	 
	            //Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
	 
	            //Iterate through each rows one by one
	            Iterator<Row> rowIterator = sheet.iterator();
	            
	            while (rowIterator.hasNext()) 
	            {
	                Row row = rowIterator.next();	                
	               
	                    Cell cell = row.getCell(0);
	                   
	                    String key = cell.getStringCellValue();
	                    if (key.equalsIgnoreCase(targetKey)){
	                    	System.out.println("Found key :"+key);
	                    	Cell cell2 = row.getCell(1);
	                    	switch (cell2.getCellType()) 
	    					{
	    						case NUMERIC:
	    							value = String.valueOf(cell2.getNumericCellValue());
	    							break;
	    						case STRING:
	    							value = cell2.getStringCellValue();
	    							break;
	    						default:
	    							throw new IllegalStateException("Unexpected value: " + cell.getCellType());
	                    	
	                    	//value =row.getCell(1).getStringCellValue();
	                    	
	    					}
	                    	System.out.println("Found value  :"+value);	
	                }
	                    
	            }
	            file.close();
	            //return value; 
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
		return value;
		
	}

}
