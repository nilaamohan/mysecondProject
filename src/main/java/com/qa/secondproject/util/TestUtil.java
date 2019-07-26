package com.qa.secondproject.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {

public static long PAGE_LOAD_TIMEOUT=30;
public static long IMPLICIT_Wait=20;
public static String  TESTDATA_SHEET_PATH="C:/Users/Diya/workspace/maven-demo/src/main/java/com/project/qa/testdata/SeleniumEasy.xlsx";
static Workbook book;  
static Sheet sheet;

public static Object[][] getTestData(String SheetName){
	FileInputStream file=null;
	try{
		file=new FileInputStream(TESTDATA_SHEET_PATH);
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	try{
		book=WorkbookFactory.create(file);
	}catch(InvalidFormatException e){
		
	}	catch(IOException e){	
		e.printStackTrace();
	}
	sheet=book.getSheet(SheetName);
    Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    for(int i=0;i<sheet.getLastRowNum();i++){
    	for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
    		data[i][k]=sheet.getRow(i+1).getCell(k).toString();
    	}
    }
    return data;
}

}
