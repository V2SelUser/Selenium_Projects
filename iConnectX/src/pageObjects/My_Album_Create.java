package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class My_Album_Create {
	private static WebElement element;
	
	public static WebElement Select_Acc_Settings(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Setting') and @data-toggle='dropdown']"));
		return element;
	}	
	
	public static WebElement Select_My_Album(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'My Albums') and @href='albums/manage']"));
		return element;
	}	
	
	public static WebElement Add_New_Album(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Add New Photos') and contains(@class,'menu_album_main')]"));
		return element;
	}	
	
	public static WebElement Choose_Album(WebDriver driver) {		
		element = driver.findElement(By.id("album"));
		return element;		
	}
	
	public static WebElement Album_Title(WebDriver driver) {
		element = driver.findElement(By.id("title"));
		return element;
	}
	
	public static WebElement Category(WebDriver driver) {
		element = driver.findElement(By.id("category_id"));
		return element;
	}

	public static WebElement Album_Description(WebDriver driver) {
		element = driver.findElement(By.id("description"));
		return element;
	}

	public static WebElement Show_Album_Search(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='search']"));
		return element;
	}
	
	public static WebElement Privacy(WebDriver driver) {
		element = driver.findElement(By.id("auth_view"));
		return element;
	}	
	
	public static WebElement Comment_Privacy(WebDriver driver) {
		element = driver.findElement(By.id("auth_comment"));
		return element;
	}	
	
	public static WebElement Tagging(WebDriver driver) {
		element = driver.findElement(By.id("auth_tag"));
		return element;
	}	
	
	public static WebElement Browse_File_Upload(WebDriver driver) {		
		element = driver.findElement(By.id("fallback"));
		return element;
		
	}
	
	public static WebElement Save_Photo(WebDriver driver) {
		element = driver.findElement(By.id("submit"));
		return element;
		
	}
	
	
}
