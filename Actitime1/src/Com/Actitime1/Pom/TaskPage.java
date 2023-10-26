package Com.Actitime1.Pom;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage 
{
	//declaration
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement addnwebtn;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newcustomer;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement customername;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement customerdisc;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement createcustbtn;
	
	//initialization
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getAddnwebtn() {
		return addnwebtn;
	}

	public WebElement getNewcustomer() {
		return newcustomer;
	}

	public WebElement getCustomername() {
		return customername;
	}

	public WebElement getCustomerdisc() {
		return customerdisc;
	}

	public WebElement getCreatecustbtn() {
		return createcustbtn;
	}
	
	
	
}
