package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ForgetPswdPage {
	
	public static WebDriver driver ;
	
	public ForgetPswdPage (WebDriver driver)
	{
		this.driver=driver;
	}
			
			By Email = By.name("email");
			By Sbmt_Btn=By.xpath("//button[text()='Submit']");
			By Validation_Message=By.xpath("//div[@role='alert']");
			
			
			public WebElement getValidation_Message()
			{
				return driver.findElement(Validation_Message);
			}
			
			public WebElement getemail()
			{
				return driver.findElement(Email);
			}
			
			public WebElement getSbmt_Btn()
			{
				return driver.findElement(Sbmt_Btn);
			}
		
		
	}
	


