package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Address {

	public WebDriver driver;
	
	public Address(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Heading = By.xpath("//span[text()='Address Of Use']");

	public WebElement getHeading() {
		return driver.findElement(Heading);
	}
}
