package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Customer {

	public WebDriver driver;
	
	public Customer(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By SelectFieldBtn = By.id("selectFields");
	
	By Apply = By.xpath("(//button[@class='btn btn-primary' and text()='Apply'])[2]");
	
	By CancelBtn = By.xpath("(//button[@class='btn btn-secondary' and text()='Cancel'])[6]");
	
	By ExportBtn = By.id("export");
	
	By ExportCancel = By.xpath("(//button[@type='button' and text()='Cancel'])[6]");
	
	By Subscription = By.xpath("//a[@class='top-link' and text()='Subscriptions']");
	
	By SubsHeading = By.xpath("(//h1[text()='Subscriptions'])[1]");
	
	By Arrow1 = By.xpath("(//td[@columnname='Arrow'])[1]");
	
	By EditSubs = By.xpath("//a[text()='Edit Subscription']");
	
	By EditSubCancel = By.xpath("(//button[@class='btn btn-secondary' and text()='Cancel'])[2]");
	
	By Account=By.xpath("//a[@class='top-link' and text()='Accounts']");
	
	By AssumeRole = By.xpath("//a[@data-key='Arrow0' and text()='Assume Role']");
	
	By AssumeRadio=By.xpath("//input[@id='Users']");
	
	By AssumeRoleBtn=By.xpath("//button[@class='btn btn-primary' and text()='Assume Role']");
	
	By EndSession=By.xpath("//a[@class='end-session-link']");
	
	By EditAccount=By.xpath("//a[text()='Edit Account']");
	
	By AccountCancel=By.xpath("//a[@class='btn' and text()='Cancel']");
	
	By SaveBtn=By.xpath("//a[@class='btn btn-primary' and text()='Save']");
	
	By SaveMessage=By.xpath("//div[@class='alert-wrapper']");
	
	By RequestTab=By.xpath("(//a[@class='top-link' and text()='Requests'])[1]");
	
	By RequestId=By.xpath("//td[@class='blue-medium']");
	
	By NetTerms=By.xpath("//a[text()='Net Terms']");
	
	By NetTermHeading=By.xpath("//label[text()='Net Terms ID']");
	
	By CRID=By.xpath("//label[text()='Change Request ID']");
	
	
	public WebElement getCRID() {
		return driver.findElement(CRID);
	}
	
	
	public WebElement getNetTermHeading() {
		return driver.findElement(NetTermHeading);
	}
	
	
	public WebElement getNetTerms() {
		return driver.findElement(NetTerms);
	}
	
	public WebElement getRequestId() {
		return driver.findElement(RequestId);
	}
	
	public WebElement getRequestTab() {
		return driver.findElement(RequestTab);
	}
	
	public WebElement getSaveMessage() {
		return driver.findElement(SaveMessage);
	}
	
	public WebElement getSaveBtn() {
		return driver.findElement(SaveBtn);
	}
	
	public WebElement getAccountCancel() {
		return driver.findElement(AccountCancel);
	}
	
	public WebElement getEditAccount() {
		return driver.findElement(EditAccount);
	}
	
	public WebElement getEndSession() {
		return driver.findElement(EndSession);
	}
	
	public WebElement getAssumeRoleBtn() {
		return driver.findElement(AssumeRoleBtn);
	}
	
	public WebElement getAssumeRadio() {
		return driver.findElement(AssumeRadio);
	}
	
	public WebElement getAssumeRole() {
		return driver.findElement(AssumeRole);
	}
	
	public WebElement getAccount() {
		return driver.findElement(Account);
	}
	
	public WebElement getEditSubCancel() {
		return driver.findElement(EditSubCancel);
	}
	
	
	public WebElement getEditSubs() {
		return driver.findElement(EditSubs);
	}
	
	public WebElement getArrow1() {
		return driver.findElement(Arrow1);
	}
	
	public WebElement getSubsHeading() {
		return driver.findElement(SubsHeading);
	}
	
	public WebElement getSubscription() {
		return driver.findElement(Subscription);
	}
	
	
	public WebElement getExportCancel() {
		return driver.findElement(ExportCancel);
	}
	
	public WebElement getExportBtn() {
		return driver.findElement(ExportBtn);
	}
	
	public WebElement getCancelBtn() {
		return driver.findElement(CancelBtn);
	}
	
	public WebElement getSelectFieldBtn() {
		return driver.findElement(SelectFieldBtn);
	}
	
	
	public WebElement getApply() {
		return driver.findElement(Apply);
	}
}
