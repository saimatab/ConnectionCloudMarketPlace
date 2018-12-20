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

	By tabs = By.xpath("//a[@data-toggle='tab']");

	By RequestTab = By.xpath("//a[text()='Requests ']");

	By InvitesTab = By.xpath("//a[text()='Invites ']");

	By RequestActive = By.xpath("//a[@href='#RequestUsers' and @class = 'active show']");

	By InvitesActive = By.xpath("//a[@href='#invites' and @class = 'active show']");

	By Roles = By.xpath("(//a[text()='Roles'])[2]");

	By CreateUser = By.xpath("(//a[text()='Create User'])[2]");

	By Users = By.xpath("(//a[text()='Users'])[3]");

	By DropDown = By.xpath("//select[@class='form-control ccp-txtbox pull-left col-lg-5 col-md-7 col-sm-8 col-xs-7']");

	By Edit = By.xpath("(//button[@class='btn-edit'])[1]");
	
	//By DropDown = By.tagName("select");
	
	public WebElement getEdit() {
		return driver.findElement(Edit);
	}
	
	public WebElement getDropDown() {
		return driver.findElement(DropDown);
	}
	
	
	public WebElement getUsers() {
		return driver.findElement(Users);
	}

	public WebElement getCreateUser() {
		return driver.findElement(CreateUser);
	}

	public WebElement getRoles() {
		return driver.findElement(Roles);
	}

	// By Heading = By.xpath("//span[text()='Address Of Use']");

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
