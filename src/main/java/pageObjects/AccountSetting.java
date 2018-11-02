package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountSetting {

	public WebDriver driver;
	
	public AccountSetting(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Heading = By.xpath("//span[text()='Account Settings']");

	public WebElement getHeading() {
		return driver.findElement(Heading);
	}
}
