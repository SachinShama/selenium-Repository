package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream excelInput;
	public static FileOutputStream excelOutput;
	public static XSSFWorkbook wb;
	public static XSSFSheet xs;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile,String xlSheet) throws IOException {
		excelInput=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(excelInput);
		xs=wb.getSheet(xlSheet);
		int rowCount=xs.getLastRowNum();
		wb.close();
		excelInput.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlfile,String xlSheet, int rowNum) throws IOException {
		excelInput=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(excelInput);
		xs=wb.getSheet(xlSheet);
		row=xs.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		wb.close();
		excelInput.close();
		return cellCount;
	}
	
	public static String getCellData(String xlfile,String xlSheet, int rowNum, int colNum) throws IOException {
		excelInput=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(excelInput);
		xs=wb.getSheet(xlSheet);
		row=xs.getRow(rowNum);
		cell=row.getCell(colNum);
		String data;
		
		DataFormatter formatter=new DataFormatter();
		data=formatter.formatCellValue(cell);
		
		wb.close();
		excelInput.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlSheet, int rowNum, int colNum,String data) throws IOException {
		excelInput=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(excelInput);
		xs=wb.getSheet(xlSheet);
		row=xs.getRow(rowNum);
		cell=row.getCell(colNum);
		cell.setCellValue(data);
		wb.close();
		excelInput.close();
		
	}
	
	
	
	
	
	
	
}
