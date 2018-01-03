/*package iConnectX_Auto_Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Driver_Script {

static WebDriver driver = null;

@Test
public void test () throws BiffException, IOException, InterruptedException 
{
	//Open MyDataSheet.xls file from given location. 
	FileInputStream fileinput = new FileInputStream("D:\\MyDataSheet.xls");
	//Access first data sheet. getSheet(0) describes first sheet.
	Workbook wbk = Workbook.getWorkbook(fileinput);
	Sheet sheet = wbk.getSheet(0);
	
	//Read data from the first data sheet of xls file and store it in array.
	String TestData[][] = new String[sheet.getRows()][sheet.getColumns()];
	
	//To enable Last Name text box.

	  
	//Type data in first name and last name text box from array.
	for(int i=0;i<sheet.getRows();i++)
	{
	 for (int j=0;j<sheet.getColumns();j++)
	 {
	  TestData[i][j] = sheet.getCell(j,i).getContents();
	  
	  System.out.println(TestData[i][j]);
	 }
	}
}
	
	
}
*/