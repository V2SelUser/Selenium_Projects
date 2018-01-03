package Test_Cases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import App_Generic_Modules.SingIn_Action;
import System_Utilities.Constant_Values;
import pageObjects.Log_Out;
import System_Utilities.ExcelUtil;
import pageObjects.My_Album_Create;

public class iCX_TestCases {

	private static WebDriver driver = null;
	public static String ProjectDir = System.getProperty("user.dir");

@Test()
	public static void MainScript() throws Exception{		
		try {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
			driver.get( Constant_Values.App_Url);
			
			int cnt = 0;
			Constant_Values.ExcelFilePath = System_Utilities.Constant_Values.ControlFile_ExcelFilePath;
			Constant_Values.ExcelFileName =  System_Utilities.Constant_Values.ControlFile_ExcelFileName;
			ExcelUtil.OpenExcelFile("Sheet1");
			int ControlFile_RowCount = System_Utilities.ExcelUtil.RowCount("Sheet1");
			
			for (cnt=1; cnt<=ControlFile_RowCount; cnt++) {

				String TestRunYN = System_Utilities.ExcelUtil.GetCellData(cnt, 3);
				String ScenarioName = System_Utilities.ExcelUtil.GetCellData(cnt, 2);
				if (TestRunYN.compareTo("Y") == 0)  {
					switch (ScenarioName){
						case "Login_To_App" :
							SingIn_Action.Login_To_App(driver, Constant_Values.UserId, Constant_Values.Password);	
							pageObjects.My_Album_Create.Select_Acc_Settings(driver).click();
							Log_Out.LogOut_Button(driver).click();
							
							break;
						case "Upload_New_Photo" :
							SingIn_Action.Login_To_App(driver, Constant_Values.UserId, Constant_Values.Password);
							Test_Cases.My_Album_Create.Upload_New_Photo(driver);
							My_Album_Create.Select_Acc_Settings(driver).click();
							Log_Out.LogOut_Button(driver).click();							
							break;
					}		
					
				}
				
			}
			
			
		}catch(Exception e) {
			throw(e);
		}finally {
			driver.quit();
		}
		
		
	}
	
	
}
