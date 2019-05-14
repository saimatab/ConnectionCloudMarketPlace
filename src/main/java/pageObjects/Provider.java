package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Provider {

	public WebDriver driver;
	
	public Provider(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	
	
	By AddProvider_Btn=By.xpath("//a[text()='Add Provider']");

	
	
	By Arrow1 = By.xpath("(//td[@columnname='Arrow'])[1]");
	
	By EditProvider=By.xpath("//a[text()='Edit Provider']");
	
	By EditService=By.xpath("//a[text()='Edit Service']");
	
	By ExportBtn = By.id("export");
	
	By ExportCancel=By.xpath("(//button[@class='btn btn-secondary' and text()='Cancel'])[7]");
	
	By cancelBtn=By.xpath("//a[text()='Cancel']");
	
	By ServicesTab=By.xpath("//a[@class='top-link' and text()='Services']");
	
	
	
	public WebElement getEditService() {
		return driver.findElement(EditService);
	}
	
	
	public WebElement getServicesTab() {
		return driver.findElement(ServicesTab);
	}
	
	public WebElement getcancelBtn() {
		return driver.findElement(cancelBtn);
	}
	
	public WebElement getExportCancel() {
		return driver.findElement(ExportCancel);
	}
	
	public WebElement getExportBtn() {
		return driver.findElement(ExportBtn);
	}
	
	public WebElement getEditProvider() {
		return driver.findElement(EditProvider);
	}
	
	
	public WebElement getAddProvider_Btn() {
		return driver.findElement(AddProvider_Btn);
	}
	
	
	
	public WebElement getArrow1() {
		return driver.findElement(Arrow1);
	}
	
	
}
