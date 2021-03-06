package com.qa.utility;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream fileLoc;
	public static XSSFWorkbook wbook;
	public static XSSFSheet wSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowConut(String xFile, String xSheet) throws IOException
	{
		fileLoc = new FileInputStream(xFile);
		wbook= new XSSFWorkbook(fileLoc);
		wSheet= wbook.getSheet(xSheet);
		int rowCount=wSheet.getLastRowNum();		
		return rowCount;
	}
	public static int getCellCount(String xFile,String xSheet, int rowNum) throws IOException
	{
		fileLoc = new FileInputStream(xFile);
		wbook= new XSSFWorkbook(fileLoc);
		wSheet= wbook.getSheet(xSheet);
		
	    row =wSheet.getRow(rowNum);
	    int cellCount= row.getLastCellNum();		
		return cellCount;
	}
	public static String getCellData(String xFile, String xSheet, int rowNum, int colNum) throws IOException
	{
		fileLoc = new FileInputStream(xFile);
		wbook= new XSSFWorkbook(fileLoc);
		wSheet= wbook.getSheet(xSheet);
		row=wSheet.getRow(rowNum);
		cell = row.getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		String cellData=formatter.formatCellValue(cell);
		wbook.close();
		fileLoc.close();											
		return cellData;
		
		
	}

}