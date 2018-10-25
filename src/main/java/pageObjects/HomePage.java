package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
public WebDriver driver;
	
	//By Usernamefield=By.name("username");
	//By Searchbox=By.xpath("//input[@id='x_main-search']");
	By Application_Link=By.xpath("//a[@class='top-link' and text()='Application']");
	By Infrastructure_Link=By.xpath("//a[@class='top-link' and text()='Infrastructure']");
	By Platform_Link=By.xpath("//a[@class='top-link' and text()='Platform']");
	By Service_Link=By.xpath("//a[@class='top-link' and text()='Service Discovery']");
	By header=By.xpath("//div[@class='top-shadow-container']");
	By Manage_Link=By.xpath("//a[@class='track  ' and text()='Manage']");
	By Insight_Link=By.xpath("//a[@class='insights ' and text()='Insights']");
	
	
	By MarketPlace_Link=By.xpath("//a[text()='MarketPlace']");
	
	//By SearchboxFF=By.xpath("//input[@id='x_main-search' and @class='main-search']");
	//By SearchboxFF=By.id("x_main-search");
	
	//By SearchboxFF=By.xpath("//form[@id='predictiveSearchBarForm']");
	//By StandardCatalogBtn=By.linkText("Shop Standards Catalog");
	//By ShopAllProductBtn=By.linkText("Shop All Products");
	//By AllMyfavrtsLinks=By.linkText("See all my favorites");
	//By RecentlyViewedLink=By.linkText("See all recently viewed");
	//By FavrtsBckBtn=By.className("#slick-prev.slick-arrow");
	//By FavrtsBckBtn=By.xpath("//button[@class='slick-prev slick-arrow']");
	
	//By FavrtsFrwrdBtn=By.className("#slick-next.slick-arrow");
	//By FavrtsFrwrdBtn=By.xpath("//button[@class='slick-next slick-arrow']");
	//By Passwordfield=By.name("password");
	//By Loginbtn=By.xpath("//input[@value='Login']");
	
	//By FavoriteLink=By.xpath("//a[@class='my-lists']");
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
	
	
	
	/*
	public WebElement getShopAllProductBtn()
	{
		return driver.findElement(ShopAllProductBtn);
	}
	
	public WebElement getAllMyfavrtsLinks()
	{
		return driver.findElement(AllMyfavrtsLinks);
	}

	public WebElement getRecentlyViewedLink()
	{
		return driver.findElement(RecentlyViewedLink);
		
	}
	
	public WebElement getFavrtsFrwrdBtn()
	{
		return driver.findElement(FavrtsFrwrdBtn);
		
	}
	
	public WebElement getFavrtsBckBtn()
	{
		return driver.findElement(FavrtsBckBtn);
		
	*/
	

	

}
