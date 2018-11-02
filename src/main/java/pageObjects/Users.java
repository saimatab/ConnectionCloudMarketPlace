package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Users {

	public WebDriver driver;

	public Users(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By tabs=By.xpath("//a[@data-toggle='tab']");
	
	By RequestTab = By.xpath("//a[text()='Requests ']");
	
	By InvitesTab = By.xpath("//a[text()='Invites ']");
	
	By RequestActive=By.xpath("//a[@href='#RequestUsers' and @class = 'active show']");
	
	By InvitesActive=By.xpath("//a[@href='#invites' and @class = 'active show']");
	
	//By Heading = By.xpath("//span[text()='Address Of Use']");

	public WebElement getInvitesActive() {
		return driver.findElement(InvitesActive);
	}
	
	public WebElement getRequestActive() {
		return driver.findElement(RequestActive);
	}
	
	public List<WebElement> gettabs() {
		return driver.findElements(tabs);
	}
	
	public WebElement getRequestTab() {
		return driver.findElement(RequestTab);
	}
	
	public WebElement getInvitesTab() {
		return driver.findElement(InvitesTab);
	}
	
	

	
}
