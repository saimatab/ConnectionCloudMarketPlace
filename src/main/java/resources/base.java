package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import pageObjects.LoginPage;

	public class base {
		public static Logger Log = LogManager.getLogger(base.class.getName());
	public static WebDriver driver;
	public static String url;
	public static Properties prop;
	public static FileInputStream fis;
	public LoginPage lp;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\bilaw\\.jenkins\\workspace\\SmokeTestChromeCCP\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		url = prop.getProperty("url");
		
		System.out.println("Browser selected is "+browserName);
		
		
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("ie"))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty("webdriver.ie.driver", "C:\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\\\driver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
				
		LoginPage lp = new LoginPage(driver);
		
		if(driver.getTitle().contains("Shop - CCP"))
		{
			
		Assert.assertEquals(driver.getTitle(), "CCP Login","The User is already Login into the application");
		Log.error("User is already Login to the application");
		}
		
		boolean Email_present;
		try {
			lp.getusername().sendKeys(prop.getProperty("username"));
		   Email_present = true;
		   
		} catch (Exception e) {
			Email_present = false;
		}
		
		Assert.assertEquals(Email_present, true,"Email textbox is not appearing in the login page");
		
		boolean pswd_present;
		try {
			lp.getpassword().sendKeys(prop.getProperty("pswd"));
			pswd_present = true;
		   
		} catch (Exception e) {
			pswd_present = false;
		}
		
		Assert.assertEquals(pswd_present, true,"Password textbox is not appearing in the login page");
		
		
		String Shop_Titleact=driver.getTitle().trim();
		String Shop_Titlexp="CCP Login";
		Assert.assertEquals(Shop_Titleact, Shop_Titlexp,"Login Page is not appearing");
		
		
		boolean Login_present;
		try {
			lp.getloginbtn().click();
			Login_present = true;
		   
		} catch (Exception e) {
			Login_present = false;
		}
		
		Assert.assertEquals(Login_present, true,"Login button is not appearing in the login page");

		
		
		
		/*
		lp.getusername().sendKeys(prop.getProperty("username"));
		lp.getpassword().sendKeys(prop.getProperty("pswd"));
		lp.getloginbtn().click();	
		
		*/
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	/*
	public WebDriver initiali 	zeDriverWithoutCredentials() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Program Files (x86)\\Jenkins\\workspace\\SmokeTestJobChrome\\TestEcommerce1\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		url = prop.getProperty("url");
		
		System.out.println("Browser selected is "+browserName);
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "C:\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	*/
	
	
	
	
	
	
	
	
	public void getScreenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("C:\\Automation-Snapshots\\"+result+" screenshot.png"));
	}

}
