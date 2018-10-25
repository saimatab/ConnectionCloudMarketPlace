package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Manage {
	public WebDriver driver ;
	//public Select Se1;
	
	
	public Manage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	By Billing_Link = By.xpath("//a[@class='top-link' and text()='Billing & Invoice']");
	By Calendar= By.xpath("//a[@class='top-link' and text()='Calendar']");
	By Subscription=By.xpath("//a[@class='top-link' and text()='Subscriptions']");
/*
	
	By ReportsBtn=By.linkText("Reports");
	By OrdersBtn=By.linkText("Orders");
	By Purchase_Analysis_Btn=By.linkText("Purchase Analysis");
	By SavedReports=By.xpath("//a[@class='my-reports']");
	By View_Full_Calendar=By.linkText("View full calendar");
	//By RecentOrdersDropDown=
	//Select Se2 = new Select(driver.findElement(By.xpath("//select[@class='grid-item-control-select']")));
	//Select Se3 = new Select(driver.findElement(By.xpath("//select[@class='grid-item-control-select']")));
	By AllOrdersLink=By.linkText("See all orders");
	By SeeAllQuotes=By.linkText("See all quotes");
	*/
	public WebElement getBilling_Link()
	{
		return driver.findElement(Billing_Link);
	}
	
	public WebElement getCalendar()
	{
		return driver.findElement(Calendar);
	}
	public WebElement getSubscription()
	{
		return driver.findElement(Subscription);
	}
	
	/*
	
	public WebElement getOrdersBtnBtn()
	{
		return driver.findElement(OrdersBtn);
	}
	
	public WebElement get_Purchase_Analysis_BtnBtn()
	{
		return driver.findElement(Purchase_Analysis_Btn);
	}
	
	public WebElement getSavedReports()
	{
		return driver.findElement(SavedReports);
	}
	
	public WebElement getView_Full_Calendar()
	{
		return driver.findElement(View_Full_Calendar);
	}
	
	public WebElement getAllOrdersLink()
	{
		return driver.findElement(AllOrdersLink);
	}
	
	public WebElement getSeeAllQuotes()
	{
		return driver.findElement(SeeAllQuotes);
	}
	
	//public WebElement getCalendarDiv()
	//{
		//return driver.findElement(CalendarDiv);
	
	
	*/
	
}
