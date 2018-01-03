package iConnectX_Auto_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Class {
	
WebDriver driver = null;
		
@BeforeMethod
public void OpenBrower() {
	  System.setProperty("webdriver.gecko.driver", "D:\\Selenium Files\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
  }


@AfterMethod
public void CloseBrowser(){
	
	System.out.print("\nBrowser Closed");
	driver.quit();
}

@Test
public void sampletestmethod() {
	
	String url = driver.getCurrentUrl();
	String title = driver.getTitle();
	
	System.out.print("\nURL -> "+url+"  Title ->  "+ title +"has been executed successfully");

}

}


