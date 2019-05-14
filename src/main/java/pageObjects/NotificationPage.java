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
	By ExportBtn=By.id("export");
	By ExportRptBtn=By.xpath("//button[@class='btn btn-primary' and text()='Export Report']");
	By SendNotificationBtn=By.xpath("//a[@class='btn auto-width' and text()='Send Notification']");
	By ExportCancel=By.xpath("(//button[@class='btn btn-secondary' and text()='Cancel'])[7]");
	
	public WebElement getExportCancel()
	{
		return driver.findElement(ExportCancel);
		
	}
	
	public WebElement getExportRptBtn()
	{
		return driver.findElement(ExportRptBtn);
		
	}
	public WebElement getExportBtn()
	{
		return driver.findElement(ExportBtn);
		
	}
	
	public WebElement getSendNotificationBtn()
	{
		return driver.findElement(SendNotificationBtn);
		
	}
	
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
