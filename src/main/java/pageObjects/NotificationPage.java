package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NotificationPage {
	
	public WebDriver driver ;
	
	
	public NotificationPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	By Notification_btn=By.xpath("//a[@class='btn' and text()='Notification Settings']");
	By Notification_heading=By.xpath("//h1[text()='Notifications']");
	By All_Notification=By.xpath("//span[text()='All Notifications']");
	By Flagged=By.xpath("//span[text()='Flagged']");
	By Logo = By.xpath("//img[@class='logo']");
	
	/*
	By Selectall = By.xpath("(//span[@class='control__indicator'])[2]");
	By DeleteAll = By.xpath("(//a[@class='btn'])[2]");
	By YesBtn=By.xpath("(//button[@class='btn btn-primary'])[2]");
	By RecentlyViewed = By.xpath("//a[text()='See all recently viewed']");
	By CompactViewCheck= By.xpath("\\span[@class='control__indicator']");
	By SelectAllCheck=By.xpath("//*[@id='shop-favorites']/div/section/section[1]/div[4]/div[2]/div/div[1]/label/span");
	By AddAllCartBtn=By.id("addAllToCart");
	By AddAllCartDisableBtn=By.xpath("//*[@id='shop-favorites']/div/section/section[1]/div[4]/div[2]/div/div[2]/a[1]");
	By DeleteBtn=By.linkText("Delete");
	By QtyBox = By.id("qty_3628118");
	//By AddCartBtn=By.id("3628118");
	By AddCartBtn=By.xpath("//a[@class='add_to_cart btn btn-primary']");
	By AddCartDisableBtn=By.xpath("//*[@id='shop-favorites']/div/section/section[2]/div[2]/ul/div/li/div[2]/div[2]/div/a[1]");
	By checkbox=By.xpath("//span[@class='control__indicator list-item-checkbox']");
	//Select se2 = new Select(driver.findElement(By.className("small native-drop native-drop-large")));
	
	*/
	public WebElement getNotification_btn()
	{
		return driver.findElement(Notification_btn);
		
	}
	
	
	public WebElement getNotification_heading()
	{
		return driver.findElement(Notification_heading);
		
	}
	
	
	
	public WebElement getAll_Notification()
	{
		return driver.findElement(All_Notification);
		
	}
	
	public WebElement getFlagged()
	{
		return driver.findElement(Flagged);
		
	}
	
	public WebElement getLogo()
	{
		return driver.findElement(Logo);
		
	}
	
	/*
public WebElement getFavoriteLink()
{
	return driver.findElement(CompactViewCheck);
	
}

public WebElement getSelectAllCheck()
{
	return driver.findElement(SelectAllCheck);
	
}

public WebElement getAddAllCartBtn()
{
	return driver.findElement(AddAllCartBtn);
	
}

public WebElement getDeleteBtn()
{
	return driver.findElement(DeleteBtn);
	
}

public WebElement getQtyBox()
{
	return driver.findElement(QtyBox);
	
}
	
public WebElement getAddCartBtn()
{
	return driver.findElement(AddCartBtn);
	}
	
public WebElement getcheckbox()
{
	return driver.findElement(checkbox);
	}

public WebElement getAddCartDisableBtn()
{
	return driver.findElement(AddCartDisableBtn);
	}

public WebElement getAddAllCartDisableBtn()
{
	return driver.findElement(AddAllCartDisableBtn);
	}
	
	*/
}
