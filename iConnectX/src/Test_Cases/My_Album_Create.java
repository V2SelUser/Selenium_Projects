package Test_Cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class My_Album_Create {

	public static void Upload_New_Photo(WebDriver driver) throws Exception  {
	try {
		
		pageObjects.My_Album_Create.Select_Acc_Settings(driver).click();
		pageObjects.My_Album_Create.Select_My_Album(driver).click();
		pageObjects.My_Album_Create.Add_New_Album(driver).click();

		System_Utilities.Constant_Values.ExcelFilePath = System_Utilities.Constant_Values.AlbumData_ExcelFilePath;
		System_Utilities.Constant_Values.ExcelFileName =  System_Utilities.Constant_Values.AlbumData_ExcelFileName;
		System_Utilities.ExcelUtil.OpenExcelFile("Sheet1");
		int rcnt = System_Utilities.ExcelUtil.RowCount("Sheet1");
		
		for (int cnt=1; cnt<= rcnt ; cnt++ ) {
			String ChooseAlbum = System_Utilities.ExcelUtil.GetCellData(1,0);	
			Select SelectAlbumName = new Select(pageObjects.My_Album_Create.Choose_Album(driver));		
			SelectAlbumName.selectByVisibleText(ChooseAlbum);
			
			String AlbumTitle = System_Utilities.ExcelUtil.GetCellData(1,1);
			pageObjects.My_Album_Create.Album_Title(driver).sendKeys(AlbumTitle);
			
			String Category = System_Utilities.ExcelUtil.GetCellData(1,2);
			Select SelectCategory = new Select(pageObjects.My_Album_Create.Category(driver));
			SelectCategory.selectByVisibleText(Category);			
				
			String Album_Des = System_Utilities.ExcelUtil.GetCellData(1,3);
			pageObjects.My_Album_Create.Album_Description(driver).sendKeys(Album_Des);		
			
			String Show_Album_Srch = System_Utilities.ExcelUtil.GetCellData(1,4);
			if (Show_Album_Srch.compareTo("No") == 0){
				pageObjects.My_Album_Create.Show_Album_Search(driver).click();
			}
	
			String Privacy = System_Utilities.ExcelUtil.GetCellData(1,5);
			Select SelectPrivacy = new Select(pageObjects.My_Album_Create.Privacy(driver));
			SelectPrivacy.selectByVisibleText(Privacy);
			
			String Cmt_Privacy = System_Utilities.ExcelUtil.GetCellData(1,6);
			Select SelectCmt_Privacy = new Select(pageObjects.My_Album_Create.Comment_Privacy(driver));
			SelectCmt_Privacy.selectByVisibleText(Cmt_Privacy);
			
			String Tagging = System_Utilities.ExcelUtil.GetCellData(1,7);
			Select SelectTag = new Select(pageObjects.My_Album_Create.Tagging(driver));
			SelectTag.selectByVisibleText(Tagging);
			
			pageObjects.My_Album_Create.Browse_File_Upload(driver).click();
			Runtime.getRuntime().exec("D:\\Upload_File.exe D:\\Sample.png");
			
			pageObjects.My_Album_Create.Save_Photo(driver).click();
		}
		
		}catch(Exception e) {
			throw(e);
		}
		
	}
	

}
