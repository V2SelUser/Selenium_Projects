package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Log_Out {
	private static  WebElement element;
	
	public static WebElement LogOut_Button(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='mainlogo' and @href='logout' and contains(text(),'Log Out')]"));
		
		return element;
	}
	
}
