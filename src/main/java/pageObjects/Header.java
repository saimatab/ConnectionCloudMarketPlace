package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
	
public WebDriver driver;

public Header(WebDriver driver ) 
{
	// TODO Auto-generated constructor stub
	this.driver=driver;

}

By Menu = By.xpath("//div[@class='account-menu']");

By Menu_List=By.xpath("//div[@class='account-menu']//li");

By Notification=By.xpath("//div[@class='shopping-cart']");	

By AccountMenu=By.xpath("(//span[@class='account-title' and text()='My Account '])[1]");

By Logout=By.xpath("(//a[text()='Logout'])[1]");

By MyProfile=By.xpath("//div[@class='account-menu']//a[text()='My Profile']");

By ChangePassword=By.xpath("//div[@class='account-menu']//a[text()='Change Password']");

By SetNotifications=By.xpath("//div[@class='account-menu']//a[text()='Set Notifications']");

By Address=By.xpath("//div[@class='account-menu']//a[text()='Address Of Use']");

By Users=By.xpath("//div[@class='account-menu']//a[text()='Users']");


public WebElement getMenu_List()
{
	return driver.findElement(Menu_List);
}

public WebElement getMenu()
{
	return driver.findElement(Menu);
}


public WebElement getUsers()
{
	return driver.findElement(Users);
}

public WebElement getAddress()
{
	return driver.findElement(Address);
}


public WebElement getSetNotifications()
{
	return driver.findElement(SetNotifications);
}

public WebElement getChangePassword()
{
	return driver.findElement(ChangePassword);
}


public WebElement getMyProfile()
{
	return driver.findElement(MyProfile);
}

public WebElement getLogout()
{
	return driver.findElement(Logout);
}

public WebElement getAccountMenu()
{
	return driver.findElement(AccountMenu);
}

public WebElement getNotification()
{
	return driver.findElement(Notification);
}

/*
public WebElement getReports()
{
	return driver.findElement(Reports);
}

public WebElement getCalendar()
{
	return driver.findElement(Calendar);
}

public WebElement getPAnalysisBtn()
{
	return driver.findElement(PAnalysisBtn);
}

public WebElement getOrderBtn()
{
	return driver.findElement(OrderBtn);
}
public WebElement getHeadLogo()
{
	return driver.findElement(HeadLogo);
}

public WebElement getlogoutLinkLink()
{
	return driver.findElement(logoutLink);
}


public WebElement getMyProfileLink()
{
	return driver.findElement(MyProfileLink);
}

public WebElement getMyAccountLink()
{
	return driver.findElement(MyAccountLink);
}

public WebElement getShippingAddressLink()
{
	return driver.findElement(ShippingAddressLink);
}
public WebElement getsearchbox()
{
	return driver.findElement(Searchbox);
}

public WebElement getCartIcon()
{
	return driver.findElement(CartIcon);
}

public WebElement getFavrtIcon()
{
	return driver.findElement(FavrtIcon);
}

public List<WebElement> getFavrtIconCount()
{
	return driver.findElements(FavrtIcon);
}



public WebElement getTrackBtn()
{
	return driver.findElement(TrackBtn);
}

public WebElement getLogo()
{
	return driver.findElement(Logo);
	
}

public WebElement getStanCatalogLink()
{
	return driver.findElement(StanCatalogLink);
	
}

public WebElement getAllProductLink()
{
	return driver.findElement(AllProductLink);
	
}


public WebElement getResources()
{
	return driver.findElement(Resources);
	
}

public WebElement getSpecialOffers()
{
	return driver.findElement(SpecialOffers);
	
}

public WebElement getBellIcon()
{
	return driver.findElement(BellIcon);
	
}


public WebElement getInternationalIcon()
{
	return driver.findElement(InternationalIcon);
	
}


public WebElement getCommunityIcon()
{
	return driver.findElement(CommunityIcon);
	
}


public WebElement getHelpIcon()
{
	return driver.findElement(HelpIcon);
	
}


public WebElement getLegacyLink()
{
	return driver.findElement(LegacyLink);
	
}

*/


}
