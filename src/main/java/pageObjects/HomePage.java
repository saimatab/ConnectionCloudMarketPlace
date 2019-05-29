package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
public WebDriver driver;
	

	By Application_Link=By.xpath("//a[@class='top-link' and text()='Applications']");
	By Infrastructure_Link=By.xpath("//a[@class='top-link' and text()='Infrastructure']");
	By Platform_Link=By.xpath("//a[@class='top-link' and text()='Platforms']");
	By Service_Link=By.xpath("//a[@class='top-link' and text()='Service Discovery']");
	By header=By.xpath("//div[@class='top-shadow-container']");
	By Manage_Link=By.xpath("//a[@class='track   ' and text()='Manage']");
	By Insight_Link=By.xpath("//a[@class='insights ' and text()=' Insights']");
	By MarketPlace_Link=By.xpath("//a[text()='MarketPlace']");
	By CustomersTab=By.xpath("//a[@class='shop ' and text()='Customers']");
	By CatalogTab=By.xpath("//a[text()='Catalog']");
	By FullfillmentTab=By.xpath("//a[@class='insights ' and text()='FULFILLMENT']");
	By ReportsTab=By.xpath("//a[@class='reports ' and text()='Reports']");
	By UsersTab=By.xpath("//a[@class='users ' and text()='SETUP']");
	By Main_Search=By.xpath("//input[@id='main-search']");
	By Consulting=By.xpath("//a[@class='top-link' and text()='Consulting']");
	By Discover=By.xpath("//a[@class='top-link' and text()='Discover']");
	By FAccount = By.xpath("(//a[text()='Accounts'])[3]");
	By FSubs = By.xpath("(//a[text()='Subscriptions'])[3]");
	By FooterLogo = By.xpath("//img[@class='footer-logo']");
	
	
	By Domain = By.xpath("(//a[@class='top-link' and text()='Domains'])[1]");
	
	public WebElement getDomain()
	{
		return driver.findElement(Domain);
	}
	
	public WebElement getFooterLogo()
	{
		return driver.findElement(FooterLogo);
	}
	public WebElement getFSubs()
	{
		return driver.findElement(FSubs);
	}
	
	public WebElement getFAccount()
	{
		return driver.findElement(FAccount);
	}
	
	public WebElement getDiscover()
	{
		return driver.findElement(Discover);
	}
	
	public WebElement getConsulting()
	{
		return driver.findElement(Consulting);
	}
	
	public WebElement getMain_Search()
	{
		return driver.findElement(Main_Search);
	}
	
	public WebElement getUsersTab()
	{
		return driver.findElement(UsersTab);
	}
	
	public WebElement getReportsTab()
	{
		return driver.findElement(ReportsTab);
	}
	
	public WebElement getFullfillmentTab()
	{
		return driver.findElement(FullfillmentTab);
	}
	
	public WebElement getCatalogTab()
	{
		return driver.findElement(CatalogTab);
	}
	
	public WebElement getCustomersTab()
	{
		return driver.findElement(CustomersTab);
	}
	
	
	public WebElement getInsight_Link()
	{
		return driver.findElement(Insight_Link);
	}
	
	public WebElement getManage_Link()
	{
		return driver.findElement(Manage_Link);
		
	}

	
	public WebElement getMarketPlace_Link()
	{
		return driver.findElement(MarketPlace_Link);
		
	}

	
	public WebElement getheader()
	{
		return driver.findElement(header);
		
	}

	
	
	public WebElement getApplication_Link()
	{
		return driver.findElement(Application_Link);
		
	}

	public HomePage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getInfrastructure_Link()
	{
		return driver.findElement(Infrastructure_Link);
	}
	
	public WebElement getPlatform_Link()
	{
		return driver.findElement(Platform_Link);
	}
	
	public WebElement getService_Link()
	{
		return driver.findElement(Service_Link);
	}


}
