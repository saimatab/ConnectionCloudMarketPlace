package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {
	
	
	public WebDriver driver;

	public Footer(WebDriver driver ) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;

	}

		By FootLogo = By.xpath("html/body/footer/section[1]/a/div/img[1]");
	By FShop=By.xpath("//html/body/footer/section[1]/div[2]/ul[1]/li[1]/h3/a");

	//By FTrack=By.xpath("//html/body/footer/section[1]/div[2]/ul[2]/li[1]/h3/a");
	//By FStandCatalog=By.xpath("//html/body/footer/section[1]/div[2]/ul[1]/li[2]/a");
	
	By FStandCatalog=By.linkText("Standards Catalog");
	
	By FStandCatalogFF=By.xpath("(//a[text()='Standards Catalog'])[3]");
	
	
	//By FAllPrdct=By.xpath("//html/body/footer/section[1]/div[2]/ul[1]/li[3]/a");
	
	By FAllPrdct=By.linkText("All Products");
	By FAllPrdctFF=By.xpath("(//a[text()='All Products'])[3]");
	
	//By FResources=By.xpath("//html/body/footer/section[1]/div[2]/ul[1]/li[4]/a");
	
	By FResources=By.linkText("Resources");
	
	By FResourcesFF=By.xpath("(//a[text()='Resources'])[3]");
	//By FSpecialOffers=By.xpath("//html/body/footer/section[1]/div[2]/ul[1]/li[5]/a");
	
	By FSpecialOffers=By.linkText("Special Offers");
	
	By FSpecialOffersFF=By.xpath("(//a[text()='Special Offers'])[2]");
	
	
	//By FFavorites=By.xpath("//html/body/footer/section[1]/div[2]/ul[1]/li[6]/a");
	
	By FFavorites=By.linkText("Favorites");
	
	By FFavoritesFF=By.xpath("(//a[text()='Favorites'])[3]");
	
	
	By FTrack=By.xpath("//html/body/footer/section[1]/div[2]/ul[2]/li[1]/h3/a");
	By FCalendar=By.xpath("//html/body/footer/section[1]/div[2]/ul[2]/li[2]/a");
	By FOrder=By.xpath("//html/body/footer/section[1]/div[2]/ul[2]/li[3]/a']");
	By FPurchaseAnalysis=By.xpath("//html/body/footer/section[1]/div[2]/ul[2]/li[4]/a");
	By FSavedReports=By.xpath("//html/body/footer/section[1]/div[2]/ul[2]/li[5]/a");
	By FAboutus=By.xpath("//html/body/footer/section[1]/div[2]/ul[3]/li[1]/a");
	By FContactUs=By.xpath("//html/body/footer/section[1]/div[2]/ul[3]/li[2]/a");
	By FCustomerSupport= By.xpath("//html/body/footer/section[1]/div[2]/ul[3]/li[3]/a");
	By FTerms=By.xpath("//html/body/footer/section[1]/div[2]/ul[3]/li[4]/a");
	By FPrivacyP=By.xpath("//html/body/footer/section[1]/div[2]/ul[3]/li[5]/a");
	By FHelp=By.xpath("html/body/footer/section[1]/div[2]/ul[3]/li[6]/a");
	
	public WebElement getFStandCatalogFF()
	{
		return driver.findElement(FStandCatalogFF);
	}
	
	public WebElement getFAllPrdctFF()
	{
		return driver.findElement(FAllPrdctFF);
	}
	
	public WebElement getFResourcesFF()
	{
		return driver.findElement(FResourcesFF);
	}
	
	public WebElement getFSpecialOffersFF()
	{
		return driver.findElement(FSpecialOffersFF);
	}
	
	public WebElement getFFavoritesFF()
	{
		return driver.findElement(FFavoritesFF);
	}
	

	public WebElement getFootLogo()
	{
		return driver.findElement(FootLogo);
	}


	public WebElement getFStandCatalog()
	{
		return driver.findElement(FStandCatalog);
	}

	public WebElement getFAllPrdct()
	{
		return driver.findElement(FAllPrdct);
	}

	public WebElement getFResources()
	{
		return driver.findElement(FResources);
	}

	public WebElement getFSpecialOffers()
	{
		return driver.findElement(FSpecialOffers);
	}

	public WebElement getFFavorites()
	{
		return driver.findElement(FFavorites);
		
	}

	public WebElement getFTrack()
	{
		return driver.findElement(FTrack);
		
	}

	public WebElement getFCalendar()
	{
		return driver.findElement(FCalendar);
		
	}


	public WebElement getFOrder()
	{
		return driver.findElement(FOrder);
		
	}

	public WebElement getFPurchaseAnalysis()
	{
		return driver.findElement(FPurchaseAnalysis);
		
	}

	public WebElement getFSavedReports()
	{
		return driver.findElement(FSavedReports);
		
	}


	public WebElement getFAboutus()
	{
		return driver.findElement(FAboutus);
		
	}


	public WebElement getFContactUs()
	{
		return driver.findElement(FContactUs);
		
	}


	public WebElement getFCustomerSupport()
	{
		return driver.findElement(FCustomerSupport);
		
	}


	public WebElement getFTerms()
	{
		return driver.findElement(FTerms);
		
	}

	
	public WebElement getFPrivacyP()
	{
		return driver.findElement(FPrivacyP);
		
	}
	
	
	
	
	public WebElement getFHelp()
	{
		return driver.findElement(FHelp);
	}

}
