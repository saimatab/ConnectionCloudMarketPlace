package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Catalog {

	public WebDriver driver;
	
	public Catalog(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Heading = By.xpath("//span[text()='Catalog']");

	public WebElement getHeading() {
		return driver.findElement(Heading);
	}
}
