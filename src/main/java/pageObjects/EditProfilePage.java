package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage {
	
	public WebDriver driver ;
	
	
	public EditProfilePage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	//By EditProfile_btn=By.xpath("//a[@class='btn edit']");
	By Heading = By.xpath("//h1[text()='My Account']");
	//By Notification_heading=By.xpath("//h1[text()='Notifications']");

	public WebElement getHeading()
	{
		return driver.findElement(Heading);
	}
	
	

}
