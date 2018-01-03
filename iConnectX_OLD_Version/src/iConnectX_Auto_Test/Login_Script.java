package iConnectX_Auto_Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Script {
static WebDriver driver=null;
  
@BeforeTest
@Parameters({"AppURL"})
public void OpenApplication(String appurl) throws IOException {
	System.setProperty("webdriver.gecko.driver", "D:\\Selenium Files\\geckodriver.exe");
	FirefoxProfile profile = new FirefoxProfile();	
	File f=new File("C:\\Users\\vinod\\Desktop\\firebug-2.0.19-fx.xpi");
	profile.addExtension(f);
	profile.setPreference("browser.startup.homepage",appurl);
	driver = new FirefoxDriver(profile);

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	driver.get(appurl);

}


@AfterTest
public void CloseApplication() {
	//driver.quit();	
}


@Test
public void Login_To() throws InterruptedException {
	
	ReadXmlData.xmlFileName = "D:\\Selenium Projects\\iConnectX\\src\\LoginCredentials.xml";
	driver.findElement(By.id("login-email")).sendKeys(ReadXmlData.FetchXmlValue("Userid"));
	driver.findElement(By.id("login-password")).sendKeys(ReadXmlData.FetchXmlValue("Passwd"));
	driver.findElement(By.id("login-submit")).click();	
	Thread.sleep(10000);
	driver.findElement(By.xpath("//a[span[@id='jobs-tab-icon']]")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("(//input[@class='artdeco-typeahead-input__ghost-text'])[1]")).sendKeys("QA Manager");
	driver.findElement(By.xpath("(//input[@class='artdeco-typeahead-input__ghost-text'])[2]")).sendKeys("Begaluru");
}

}



