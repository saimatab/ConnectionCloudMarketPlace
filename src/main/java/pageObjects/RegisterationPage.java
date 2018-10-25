package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterationPage {
	public WebDriver driver;
	
	By email = By.xpath("//input[@id='name']");
	
	By Verify_email=By.xpath("//button[@class=' btn ccp-form-btn']");
	
	By Validation_Msg=By.xpath("//span[text()='Please provide your business email address']");
	
	
	public RegisterationPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	
	
	public WebElement getVerify_btn()
	{
		return driver.findElement(Verify_email);
	}
	
	public WebElement getValidation_Msg()
	{
		return driver.findElement(Validation_Msg);
	}

}
