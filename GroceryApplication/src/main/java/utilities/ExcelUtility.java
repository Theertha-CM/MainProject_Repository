package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {

static FileInputStream f; 
	
	// Its an inbuilt class in apache. Used to read data from the workbook 
	static XSSFWorkbook wb;
	
	// Its an inbuilt class in apache. Used to read data from the sheet 
	static XSSFSheet   sh;
	
	public static String getStringData(int a,int b, String sheet) throws IOException //a --> row value , b----> cell value, sheet----> sheetName 
	{
		f=new FileInputStream(Constant.TESTDATAFILE); //Accessing the TestData Excel sheet path from Constant Class.
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet); //method used to fetch data from the Excelsheet. Parameter passed is the sheetName.
		XSSFRow r =sh.getRow(a);  //XSSFRow is Class in apache used to read data from the row. And getRow() is a method used to read data from the row.
		XSSFCell c = r.getCell(b); //XSSFCell is Class in apache used to read data from the cell. And getCell() is a method used to read data from the cell.
		return c.getStringCellValue(); //getStringCellValue() is a method used to get string data from the cell.
		
		
	}
	
	public static String getIntData(int a,int b, String sheet) throws IOException //a --> row value , b----> cell value, sheet----> sheetName 
	{
		f=new FileInputStream(Constant.TESTDATAFILE);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		XSSFRow r =sh.getRow(a); 
		XSSFCell c = r.getCell(b); 
		int n = (int)c.getNumericCellValue(); // typecasting double value to an integer value. getNumericCellValue() is used to get double value from a cell.
		return String.valueOf(n); //String.valueOf() is a method used to convert integer type to string. Not typecasting. Its only for printing.
		
		
	}
}
