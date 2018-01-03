package App_Generic_Modules;

import org.openqa.selenium.WebDriver;

import org.apache.log4j.PropertyConfigurator;

import System_Utilities.Logs;
import pageObjects.Login_Page;
import System_Utilities.Constant_Values;

public class SingIn_Action {

	public static void Login_To_App(WebDriver driver, String UserId, String PassWrd) throws Exception {
		PropertyConfigurator.configure(Constant_Values.Project_CurDir + "\\bin\\System_Utilities\\Log4j.properties");
		try {
			
//			File dir = new File("ICX_Logs");
//			dir.mkdirs();
//			System.setProperty("tempfoler", dir.getAbsolutePath());
//			String Classname = "";
//			
//			FileAppender FileAppender = new FileAppender();
//			FileAppender.setFile(System.getProperty("tempfolder") +"\\"+ Classname.getClass() + ".log" );
			if (Login_Page.Btn_Signin(driver).isDisplayed()){
			
				Login_Page.Btn_Signin(driver).click();
			}else {
				Logs.Error("Signin button does not exist");
				
			}
			if (Login_Page.Txtbx_LoginUserId(driver).isDisplayed()){
			
				Login_Page.Txtbx_LoginUserId(driver).sendKeys(UserId);
				Logs.Info("Login Page User Id Entered - "+UserId);
			}else {
				Logs.Info("Login Page User Id does not exist");
			}
			if(Login_Page.Txtbx_LoginPassword(driver).isDisplayed()){
				Login_Page.Txtbx_LoginPassword(driver).sendKeys(PassWrd);
				Logs.Info("Login Page Password Entered - "+PassWrd);
			}else {
				Logs.Info("Login Page Password does not exist");
			}
			if(Login_Page.Btn_LoginSubmit(driver).isDisplayed()) {
				Login_Page.Btn_LoginSubmit(driver).click();	
				Logs.Info("Login Page Submit Button Clicked");
			}else {
				Logs.Info("Login Page Submit Button does not exist");
			}
			
		}catch(Exception e) {
			throw(e);
		}
		
	}
	
}
