package com.amazon.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtils {
	
	// here we will create global variables for the timeouts
	
	public static long Timeout_page_loadout= 20;
	
	public static long Implicit_wait= 10;
	
	// if you want to change the time just change the time in the TestUtil class and you are good to g0

	public static Workbook book;
	public static Sheet sheet;

		public static Object [][] getTestData(String SheetName){
			FileInputStream file= null;
			try {
				file= new FileInputStream("C:\\Users\\sunny\\eclipse-workspace\\MavenAutomation\\src\\test\\java\\com\\amazon\\testdata\\amazon.xlsx");
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			}
			try {
			book=	WorkbookFactory.create(file);
			} catch (EncryptedDocumentException a) {
				
				a.printStackTrace();
			} catch (IOException b) {
			
				b.printStackTrace();
			}
		sheet= book.getSheet(SheetName);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				
			}
		}
		
		return data;
	
	
	
}}











