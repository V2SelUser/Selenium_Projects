package System_Utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private static XSSFWorkbook xlWorkBook;
	private static XSSFSheet xlsSheet;
	private static XSSFCell xlsCell;
	private static XSSFRow xlsRow;
	
	private static int RowCount;
	
	public static void OpenExcelFile(String SheetName) throws Exception {		
		try {			
			FileInputStream ExcelFile = new FileInputStream (Constant_Values.ExcelFilePath +"\\"+ Constant_Values.ExcelFileName);
			xlWorkBook = new XSSFWorkbook(ExcelFile);
			xlsSheet =  xlWorkBook.getSheet(SheetName);			
		}catch (Exception e) {			
			throw(e);			
		}
	}
	
	public static int RowCount(String SheetName) throws Exception {
		try {			
			RowCount = xlsSheet.getLastRowNum();
			return RowCount;
		}catch (Exception e) {			
			throw(e);			
		}
		
	}
	
	public static String GetCellData(int RowNumber, int ColNumber) throws Exception{
		try {
			xlsCell = xlsSheet.getRow(RowNumber).getCell(ColNumber);			
			String CellData = xlsCell.getStringCellValue();
			return CellData;			
		}catch(Exception e) {			
			throw(e);
		}	
	}
	
	
	
	public static void SetCellData(int RowNumber, int ColNumber, String CellValue) throws Exception{
		try {
			xlsRow = xlsSheet.getRow(RowNumber);
			
			xlsCell = xlsRow.getCell(ColNumber);
			
			if(xlsCell == null) {				
				xlsCell = xlsRow.createCell(ColNumber);
				xlsCell.setCellValue(CellValue);
			}else {
				xlsCell.setCellValue(CellValue);				
			}			
			
			FileOutputStream fileout = new FileOutputStream(Constant_Values.ExcelFilePath +"\\"+ Constant_Values.ExcelFileName);
			xlWorkBook.write(fileout);
			fileout.flush();
			fileout.close();		
			
		}catch(Exception e) {
			throw(e);			
		}		
	}
	
	
	
}
