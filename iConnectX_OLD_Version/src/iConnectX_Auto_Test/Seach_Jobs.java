package iConnectX_Auto_Test;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Seach_Jobs {
static WebDriver driver = Login_Script.driver;
static XSSFWorkbook srcBook = null;
static JavascriptExecutor javascriptexe = null;

public static void readExcel() throws IOException, InterruptedException{
    	int rownum=0;
    	int TotalRowCount;
    	javascriptexe = (JavascriptExecutor) driver;
    try {
		@SuppressWarnings("resource")
		XSSFWorkbook srcBook = new XSSFWorkbook("D:\\Selenium Projects\\iConnectX\\src\\Search_Job_Criteria.xlsx");     
        XSSFSheet sourceSheet = srcBook.getSheetAt(0);
        TotalRowCount = sourceSheet.getLastRowNum()-1;
        System.out.println(TotalRowCount);
        driver.findElement(By.xpath("//a[span[@id='jobs-tab-icon']]")).click();
        Thread.sleep(6000);
        for (rownum=1; rownum <= TotalRowCount; rownum++) {
            XSSFRow sourceRow = sourceSheet.getRow(rownum);
            XSSFCell cell1=sourceRow.getCell(0);
            XSSFCell cell2=sourceRow.getCell(1);
            System.out.println(cell1);
            System.out.println(cell2);   
            
        	driver.findElement(By.xpath("//artdeco-typeahead-input[@id='ember3178']/descendant::input[1]")).sendKeys("QA Manager");
        	driver.findElement(By.xpath("//artdeco-typeahead-input[@id='ember3178']/descendant::input[2]")).sendKeys("Begaluru");
        	Thread.sleep(2000);
        }
    }catch (Exception e) {    	
    	System.out.print(e.getStackTrace());
        srcBook.close();
    }finally {
    	srcBook.close();
	}
}





}