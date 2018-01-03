package iConnectX_Auto_Test;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class Main_Script {
	static WebDriver driver = Login_Script.driver;
	static XSSFWorkbook srcBook = null;
@Test
	public void readExcel() throws IOException, InterruptedException{	
	int rownum=0;
	int TotalRowCount = 0;
	String TestRunYN = null, TempClassName = null; 
	try {
		@SuppressWarnings("resource")
		XSSFWorkbook srcBook = new XSSFWorkbook("D:\\Selenium Projects\\iConnectX\\src\\Control_Data.xlsx");     
	    XSSFSheet sourceSheet = srcBook.getSheetAt(0);
	    TotalRowCount = sourceSheet.getLastRowNum()-1;
	    System.out.println(TotalRowCount);

	    for (rownum=1; rownum <= TotalRowCount; rownum++) {
	        XSSFRow sourceRow = sourceSheet.getRow(rownum);
	        XSSFCell cell1=sourceRow.getCell(0);
	        XSSFCell cell2=sourceRow.getCell(1);

	        TempClassName = cell1.getStringCellValue().trim();
	        TestRunYN = cell2.getStringCellValue().trim();

	        if (TestRunYN.compareTo("Yes") == 0) {
	        	
//	        	
//	        	ClassOne clsone = new ClassOne();
//	        	clsone.testmethodone();    
	        	System.out.println(cell2.toString());
	        }
	        


	    }
	}catch (Exception e) {    	
		System.out.print(e.getStackTrace());
	    srcBook.close();
	}finally {
		srcBook.close();
	}	
	
}
	
}
