package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public static WebDriver driver;
	
	By Usernamefield=By.id("email");
	//By Usernamefieldie=By.xpath("//input[@class='form-control' and @name='username' and @type='text']");
	By Passwordfield=By.name("password");
	//By Passwordfieldie=By.xpath("//input[@class='form-control' and @name='password' and @type='password']");
	By Loginbtn=By.xpath("//button[@type='submit']");
	//By Loginbtnie=By.xpath("//input[@class='login-btn btn-primary' and @type='submit' and @value='Login']");
	
	By Forget_Pswd=By.xpath("//a[@id='forgetUrl']");
	
	By Create_Account=By.xpath("//a[text()='Create Account']");
	
	public LoginPage(WebDriver driver ) {
		// TODO Auto-generated constructor stub
		LoginPage.driver=driver;
	}

	//public WebElement getusernameie()
	//{
	//	return driver.findElement(Usernamefieldie);
		
	//}
	
	public WebElement getCreate_Account()
	{
		return driver.findElement(Create_Account);
	}
	
	
	public WebElement getForget_Pswd()
	{
		return driver.findElement(Forget_Pswd);
	}
	
	public WebElement getusername()
	{
		return driver.findElement(Usernamefield);
		
	}
	
	//public WebElement getpasswordie()
	//{
	//	return driver.findElement(Passwordfieldie);
	//}

	public WebElement getpassword()
	{
		return driver.findElement(Passwordfield);
	}
	
	public WebElement getloginbtn()
	{
		return driver.findElement(Loginbtn);
	}
	
	}
