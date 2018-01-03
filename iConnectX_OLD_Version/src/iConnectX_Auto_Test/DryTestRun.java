package iConnectX_Auto_Test;

import java.io.IOException;

import org.testng.annotations.Test;

public class DryTestRun {

@Test

/*public static void createReportFile() {

	TestReport.FileNameWithPath = "D:\\Selenium Projects\\iConnectX\\src\\TestReports\\Report_One.txt";
	TestReport.WriteReport("Sample Report Line one");
	TestReport.WriteReport("Sample Report Line two");
	TestReport.WriteReport("Sample Report Line three");
	TestReport.WriteReport("Sample Report Line four");
	
}*/

public static void createExcelFile() throws IOException {
	
	WriteToExcelFile.ExcelFileWithPath ="D:\\Selenium Projects\\iConnectX\\src\\TestReports\\SampleFile.xlsx";
	WriteToExcelFile.SheetName = "Sheet1";
	
	WriteToExcelFile.WriteCellValue(0,0, "String One");	
	WriteToExcelFile.WriteCellValue(1,1, "String two");
	WriteToExcelFile.WriteCellValue(2,2, "String three");
	WriteToExcelFile.WriteCellValue(0,1, "String four");
	WriteToExcelFile.WriteCellValue(1,2, "String five");
	WriteToExcelFile.WriteCellValue(2,3, "String six");
	WriteToExcelFile.WriteCellValue(4,1, "String seven");
	
}



}
