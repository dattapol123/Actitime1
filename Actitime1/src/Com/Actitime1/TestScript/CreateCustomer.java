package Com.Actitime1.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com.Actitime1.GenericLibrary.BaseClass;
import Com.Actitime1.GenericLibrary.FileLibrary;
import Com.Actitime1.GenericLibrary.ListnerImplementation;
import Com.Actitime1.Pom.HomePage;
import Com.Actitime1.Pom.TaskPage;
@Listeners(ListnerImplementation.class)
public class CreateCustomer extends BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void CreateCust() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasklnk().click();
		TaskPage tp=new TaskPage(driver);
		tp.getAddnwebtn().click();
		tp.getNewcustomer().click();
		FileLibrary f=new FileLibrary();
		String Custname = f.readDataFromeExcelFile("Sheet1", 5, 1);
		String Custdesc = f.readDataFromeExcelFile("Sheet1", 5, 2);
		tp.getCustomername().sendKeys(Custname);
		tp.getCustomerdisc().sendKeys(Custdesc);
		tp.getCreatecustbtn().click();
		String expectedData = Custname;
		String actualData = driver.findElement(By.xpath("(//div[.='"+Custname+"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(expectedData, actualData);
		s.assertAll();
	}
}
