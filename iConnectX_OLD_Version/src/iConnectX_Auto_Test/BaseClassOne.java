package iConnectX_Auto_Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClassOne {

public static WebDriver driver = null;

//@BeforeSuite annotation describes this method has to run before all suites

@BeforeSuite 
public void setup() throws Exception { 
     System.setProperty("webdriver.gecko.driver", "D:\\Selenium Files\\geckodriver.exe");
     driver = new FirefoxDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html"); 
} 


//@AfterSuite annotation describes this method has to run after execution of all suites
@AfterSuite
public void tearDown() throws Exception { 
     driver.quit(); 
} 

}
