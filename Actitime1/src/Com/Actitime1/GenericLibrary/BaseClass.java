package Com.Actitime1.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Com.Actitime1.Pom.HomePage;
import Com.Actitime1.Pom.LoginPage;

public class BaseClass 
{
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static WebDriver driver;
	FileLibrary f=new FileLibrary();
	@BeforeSuite
	public void databaseconection() {
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.readDataFromProperty("url");
		driver.get(url);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String un = f.readDataFromProperty("username");
		String pwd = f.readDataFromProperty("password");
		lp.getUntbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pwd);
		lp.getLgnbtn().click();
		Reporter.log("logged successfully",true);
	}
	
	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLogoutlnk().click();
		Reporter.log("logged out successfully",true);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("browser close successfilly",true);
	}
	
	@AfterSuite
	public void databasedisconnected() {
		Reporter.log("database discinnected",true);

	}
}
