package smokeTest;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.AccountSetting;
import pageObjects.Address;
import pageObjects.Catalog;
import pageObjects.ChangePassword;
import pageObjects.Customer;
import pageObjects.Domains;
import pageObjects.EditProfilePage;
import pageObjects.ForgetPswdPage;
import pageObjects.Header;
import pageObjects.HomePage;
import pageObjects.Insight;
import pageObjects.LoginPage;
import pageObjects.NotificationPage;
import pageObjects.Provider;
import pageObjects.RegisterationPage;
import pageObjects.Role;
import pageObjects.Users;
import pageObjects.Manage;
import pageObjects.MyProfilePage;
import resources.base;

public class ValidateSmokeTest extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	public HomePage hp;
	public WebDriver driver;
	private WebElement HeaderSection;

	@Test(priority = 0)
	public void ValidateLogin() throws IOException, InterruptedException {
	//	try
		//{
		driver = initializeDriver();
		String TitleHome = driver.getTitle();
		Log.info("The title of the home page is captured");
		Assert.assertEquals(TitleHome, "Marketplace - CCP", "User is not being able to Login to the application");
		Log.info("The title of the Shop page is Verified Successfully");
		
		//}
		//catch(NullPointerException e)
		//{
		//	Log.error("Login page is not appearing for the user");
		//	//Assert.assertEquals(driver.getTitle(), "Shop - CCP", "User is not being able to Login to the application");
		//	Assert.assertEquals(false, true,"User is not being able to Login to the application");
		//}
	}

	@Test(priority = 1, dependsOnMethods = { "ValidateLogin" })

	public void ValidateMarkITPlacePage() throws InterruptedException {
	
		HomePage hm = new HomePage(driver);
		boolean MarketPlace_present;
		try {
			hm.getMarketPlace_Link().click();
			Thread.sleep(2000);
			Log.info("From the Home Page User has Clicked on MarkITPlace tab");
			MarketPlace_present = true;

		} catch (NoSuchElementException e) {
			MarketPlace_present = false;
			Log.error("User not able to find MarkITPlace Link , hence not able to click it");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(MarketPlace_present, true, "MarketPlace Link is not Present in the Dashboard");
		Log.info("User has routed to the Shop Page after clicking on MarketPlace link");

		boolean Discover_present;
		try {
			hm.getDiscover().isEnabled();

			Discover_present = true;

		} catch (NoSuchElementException e) {
			Discover_present = false;
			Log.error("User not able to find Discover Link on the MarkITPlace Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Discover_present, true, "Discover Link is not Present in the MarkITPlace");
		
		boolean Applications_present;
		try {
			hm.getApplication_Link().isEnabled();

			Applications_present = true;

		} catch (NoSuchElementException e) {
			Applications_present = false;
			Log.error("User not able to find Applications Link on the MarkITPlace Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Applications_present, true, "User not able to find Applications Link on the MarkITPlace Page");

		boolean Infrastructure_present;
		try {
			hm.getInfrastructure_Link();
			Infrastructure_present = true;

		} catch (NoSuchElementException e) {
			Infrastructure_present = false;
			Log.error("User not able to find Infrastructure Link on the Shop Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Infrastructure_present, true, "Infrastructure Link is not Present in the Dashboard");

		boolean Platform_present;
		try {
			hm.getPlatform_Link();
			Platform_present = true;

		} catch (NoSuchElementException e) {
			Platform_present = false;
			Log.error("User not able to find Platform_present Link on the Shop Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Platform_present, true, "Platform Link is not Present in the Dashboard");

		
		boolean Consulting_present;
		try {
			hm.getConsulting();
			Consulting_present = true;
			Log.error("Consulting link is found on home page");

		} catch (NoSuchElementException e) {
			Consulting_present = false;
			Log.error("User not able to find Consulting Link on the Shop Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Consulting_present, true, "Consulting Link is not Present in the Dashboard");
	}
	
	@Test(priority = 2, dependsOnMethods = { "ValidateLogin" })

	public void ValidateDiscoverPage() throws InterruptedException {
		
		HomePage hm = new HomePage(driver);

		boolean Discover_present;
		try {
			hm.getDiscover().click();
			Thread.sleep(2000);
			Discover_present = true;
			Log.info("User has Clicked on the Discover tab from the MarketPlace Page");

		} catch (NoSuchElementException e) {
			Discover_present = false;
			Log.error("User not able to find Discover Link on the Marketplace Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Discover_present, true, "Discover link not present under Marketplace sections");
		
		Assert.assertEquals(driver.getTitle(), "Discover - CCP", "User not able to reach Discover page when clicking on discover link from the marketplace section");
	}
	
	
	
	@Test(priority = 3, dependsOnMethods = { "ValidateLogin" })

	public void ValidateApplicationPage() throws InterruptedException {
		
		HomePage hm = new HomePage(driver);

		boolean Application_present;
		try {
			hm.getApplication_Link().click();
			Thread.sleep(2000);
			Application_present = true;
			Log.info("User has Clicked on the Application tab from the MarketPlace Page");

		} catch (NoSuchElementException e) {
			Application_present = false;
			Log.error("User not able to find Application Link on the Marketplace Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Application_present, true, "Application link not present under Marketplace sections");
		
		Assert.assertEquals(driver.getTitle(), "Shop - CCP", "User not able to reach Shop page when clicking on Application link from the marketplace section");
	}
	
	
	
	@Test(priority = 4, dependsOnMethods = { "ValidateLogin" })

	public void ValidateInfrastructurePage() throws InterruptedException {
		
		HomePage hm = new HomePage(driver);

		boolean Infrastructure_present;
		try {
			hm.getInfrastructure_Link().click();
			Thread.sleep(2000);
			Infrastructure_present = true;
			Log.info("User has Clicked on the Infrastructure tab from the MarketPlace Page");

		} catch (NoSuchElementException e) {
			Infrastructure_present = false;
			Log.error("User not able to find Infrastructure Link on the Marketplace Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Infrastructure_present, true, "Infrastructure link not present under Marketplace sections");
		
		Assert.assertEquals(driver.getTitle(), "Shop - CCP", "User not able to reach Infrastructure page when clicking on Infrastructure link from the marketplace section");
	}
	
	
	@Test(priority = 5, dependsOnMethods = { "ValidateLogin" })

	public void ValidateManageTab() throws InterruptedException {
		
		HomePage hm = new HomePage(driver);

		boolean Manage_present;
		try {
			hm.getManage_Link().click();
			Thread.sleep(2000);
			Manage_present = true;
			Log.info("User has Clicked on the Manage tab from the Home Dashboard");

		} catch (NoSuchElementException e) {
			Manage_present = false;
			Log.error("User not able to find Manage Link on the Shop Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Manage_present, true, "Manage Link is not Present in the home Dashboard");
		Log.info("user has routed to the Manage Page after clicking on the manage Tab");

		String Manage_Titleact = driver.getTitle().trim();
		String Manage_Titlexp = "Manage - CCP";
		Assert.assertEquals(Manage_Titleact, Manage_Titlexp, "Manage Page is not getting open");
		Log.info("User has Successfully nevigated to the manage Page");

		Manage Mn = new Manage(driver);

		boolean Subs_present;
		try {
			Mn.getSubscription();
			Subs_present = true;
			Log.info("Subscription link is present on the Manage Page");

		} catch (NoSuchElementException e) {
			Subs_present = false;
			Log.error("Subscription link is not present on the Manage Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Subs_present, true, "Subscription Link is not present on the Manage Page");

		boolean Calendar_present;
		try {
			Mn.getCalendar();
			Calendar_present = true;
			Log.info("Calendar link is present on the Manage Page");

		} catch (NoSuchElementException e) {
			Calendar_present = false;
			Log.error("Calendar link is not present on the Manage Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Calendar_present, true, "Calendar Link is not present on the Manage Page");

	
		boolean Usage_present;
		try {
			Mn.getUsage_Link();
			Usage_present = true;
			Log.info("Usage link is present on the Manage Page");

		} catch (NoSuchElementException e) {
			Usage_present = false;
			Log.error("Usage link is not present on the Manage Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Usage_present, true, "Usage Link is not present on the Manage Page");
	}

	@Test(priority = 6, dependsOnMethods = { "ValidateLogin" })

	public void ValidateInsightTab() throws InterruptedException {

		HomePage hm = new HomePage(driver);
		boolean insight_present;
		try {
			hm.getInsight_Link().click();
			Thread.sleep(3000);
			insight_present = true;
			Log.info("User has clicked on the Insight tab from the Home Page");

		} catch (NoSuchElementException e) {
			insight_present = false;
			Log.error("User not able to find the Insight tab on the Home Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(insight_present, true, "Insight Link is not Present in the home Dashboard");
		String Insight_Titleact = driver.getTitle().trim();
		String Insight_Titlexp = "Insights - CCP";
		Assert.assertEquals(Insight_Titleact, Insight_Titlexp, "Insight Page is not getting open");
		Log.info(
				"After clicking on the Insight Tab from the Home page , User have successfully nevigate to the Insight Page");

	Insight in = new Insight(driver);
	
	Thread.sleep(5000);
	
	boolean SpendAnalysis_present;
	try {
		in.getSpendAnalysis();
		SpendAnalysis_present = true;
		Log.info("Spend Analysis link is present on the Insights Page");

	} catch (NoSuchElementException e) {
		SpendAnalysis_present = false;
		Log.error("Spend Analysis link is not present on the Insights Page");
		Log.error(e.getMessage());
	}
	Assert.assertEquals(SpendAnalysis_present, true, "Spend Analysis Link is not present on the Insights Page");
		
	boolean Recommendations_present;
	try {
		in.getRecommendation();
		Recommendations_present = true;
		Log.info("Recommendations link is present on the Insights Page");

	} catch (NoSuchElementException e) {
		Recommendations_present = false;
		Log.error("Recommendations link is not present on the Insights Page");
		Log.error(e.getMessage());
	}
	Assert.assertEquals(Recommendations_present, true, "Recommendation Link is not present on the Insights Page");
	
	boolean Reports_present;
	try {
		in.getReports();
		Reports_present = true;
		Log.info("Reports link is present on the Insights Page");

	} catch (NoSuchElementException e) {
		Reports_present = false;
		Log.error("Reports link is not present on the Insights Page");
		Log.error(e.getMessage());
	}
	Assert.assertEquals(Reports_present, true, "Reports Link is not present on the Insights Page");
		

	}

	@Test(priority = 7, dependsOnMethods = { "ValidateLogin" })

	public void ValidateFooterNotificationPage() throws InterruptedException {

		Header hd = new Header(driver);

		boolean Notification_present;
		try {
			hd.getNotification().click();
			Thread.sleep(5000);
			Notification_present = true;
			Log.info("User has clicked on the notification link from the Home Page");

		} catch (NoSuchElementException e) {
			Notification_present = false;
			Log.error("User not able to find the notification link on the Dashboard , hence not able to click it");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Notification_present, true, "Notification Link is not Present in the home Dashboard");
		Log.info("User has routed to the Notification page after clicking on the notification link");

		NotificationPage Np = new NotificationPage(driver);

		boolean Notificationheading_present;
		try {
			Np.getNotification_heading();
			Notificationheading_present = true;
			Log.info("Notification heading is present on the Notifications page");

		} catch (NoSuchElementException e) {
			Notificationheading_present = false;
			Log.error("Notification heading is present on the Notifications page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Notificationheading_present, true,
				"Notification heading is not Present in the Notification Page");

		boolean AllNotification_present;
		try {
			Np.getAll_Notification();
			AllNotification_present = true;
			Log.info("All Notification tab is present on the Notifications page");
		} catch (NoSuchElementException e) {
			AllNotification_present = false;
			Log.error("All Notification tab is not present on the Notifications page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AllNotification_present, true,
				"All notification tab is not Present in the Notification Page");

		boolean Falgged_present;
		try {
			Np.getFlagged();
			Falgged_present = true;
			Log.info("Flagged tab is present on the Notifications page");

		} catch (NoSuchElementException e) {
			Falgged_present = false;
			Log.error("Flagged tab is not present on the Notifications page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Falgged_present, true, "Flagged tab is not Present in the Notification Page");
	}

	@Test(priority = 8, dependsOnMethods = { "ValidateLogin" })

	public void ValidateLogo() throws InterruptedException {

		NotificationPage Np = new NotificationPage(driver);

		boolean Logo_present;
		try {
			Np.getLogo().click();
			Thread.sleep(2000);

			Logo_present = true;
			Log.info("User has clicked on the Logo from the Notification Page");

		} catch (NoSuchElementException e) {

			Log.error("User not able to click on the Logo");
			Log.error(e.getMessage());
			Logo_present = false;
		}
		Assert.assertEquals(Logo_present, true, "Logo is not Present in the home Dashboard");

		String Shop_Titleact = driver.getTitle().trim();
		String Shop_Titlexp = "Marketplace - CCP";
		Assert.assertEquals(Shop_Titleact, Shop_Titlexp, "Clicking on Logo is not redirecting to the Shop Page");
		Log.info("After clicking on logo, user has roue to the Homepage");
	}

	@Test(priority = 9, dependsOnMethods = { "ValidateLogin" })

	public void ValidateMyProfile() throws InterruptedException {

		Header hd = new Header(driver);

		boolean AccountMenu_present;
		try {
			hd.getAccountMenu().click();
			Thread.sleep(2000);
			AccountMenu_present = true;
			Log.info("User has clicked on the Account menu from the Shop Page");

		} catch (Exception e) {
			AccountMenu_present = false;

			Log.error("User not able to find the account menu on the Home Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountMenu_present, true, "Account Menu is not Present in the home Dashboard");

		boolean MyProfile_present;
		try {
			hd.getMyProfile().click();
			Thread.sleep(5000);
			MyProfile_present = true;
			Log.info("User has clicked on the My Profile Page from the Account Menu");

		} catch (Exception e) {
			MyProfile_present = false;
			Log.error("User not able to click on the My Profile Page from the Account Menu");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(MyProfile_present, true,
				"My Profile is not Present in the home Dashboard under My Account Menu");

		String MyProfile_Titleact = driver.getTitle().trim();
		String MyProfile_Titlexp = "My Profile - CCP";
		Assert.assertEquals(MyProfile_Titleact, MyProfile_Titlexp, "User is not being able to access MY Profile Page");

		MyProfilePage pp = new MyProfilePage(driver);

		boolean MyProfile_heading;
		try {
			pp.getHeading().isDisplayed();
			MyProfile_heading = true;
			Log.info("My Profile heading is present on My Profile Page");

		} catch (Exception e) {
			MyProfile_heading = false;
			Log.error("My Profile heading is not present on My Profile Page");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(MyProfile_heading, true, "My Profile heading is not present on My Profile Page");

	}

	@Test(priority = 10, dependsOnMethods = { "ValidateLogin" })

	public void ValidateEditProfile() throws InterruptedException {

		MyProfilePage pp = new MyProfilePage(driver);
		boolean EditProfile_present;
		try {
			pp.getEditProfile_btn().click();
			Thread.sleep(5000);
			EditProfile_present = true;
			Log.info("User has clicked on the Edit Profile button on My Profile Page");

		} catch (Exception e) {
			EditProfile_present = false;
			Log.error("User not able to click on the Edit Profile button on My Profile Page");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(EditProfile_present, true,
				"User not able to click on the Edit Profile button on My Profile Page");

		String EditProfile_Titleact = driver.getTitle().trim();
		String EditProfile_Titleexp = "Edit Profile - CCP";
		Assert.assertEquals(EditProfile_Titleact, EditProfile_Titleexp,
				"User is not being able to access Edit Profile page");

		EditProfilePage ep = new EditProfilePage(driver);
		boolean heading_present;
		try {
			ep.getHeading().isDisplayed();
			// Thread.sleep(5000);
			heading_present = true;
			Log.info("Edit profile heading is present on the Edit profile page");

		} catch (Exception e) {
			heading_present = false;
			Log.error("Edit profile heading is not present on the Edit profile page");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(heading_present, true, "Edit profile heading is not present on the Edit profile page");

	}

	@Test(priority = 11, dependsOnMethods = { "ValidateLogin" })

	public void ValidateChangePassword() throws InterruptedException {

		Header hd = new Header(driver);

		boolean AccountMenu_present;
		try {
			hd.getAccountMenu().click();
			Thread.sleep(2000);
			AccountMenu_present = true;
			Log.info("User has clicked on the Account menu from the Shop Page");

		} catch (Exception e) {
			AccountMenu_present = false;

			Log.error("User not able to find the account menu on the Home Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountMenu_present, true, "Account Menu is not Present in the home Dashboard");

		boolean ChangePswd_present;
		try {
			hd.getChangePassword().click();
			Thread.sleep(5000);
			ChangePswd_present = true;
			Log.info("User has clicked on the Change Password Link from the Account Menu");

		} catch (Exception e) {
			ChangePswd_present = false;
			Log.error("User not able to click on the Change Password Link from the Account Menu");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(ChangePswd_present, true,
				"User not able to click on the Change Password Link from the Account Menu");

		String ChangePswd_Titleact = driver.getTitle().trim();
		String ChangePswd_Titlexp = "Change Password - CCP";
		Assert.assertEquals(ChangePswd_Titleact, ChangePswd_Titlexp,
				"User is not being able to reach Change Password Page");

		ChangePassword cp = new ChangePassword(driver);

		boolean CP_heading;
		try {
			cp.getHeading().isDisplayed();
			CP_heading = true;
			Log.info("Change password heading is present on Change Password Page");

		} catch (Exception e) {
			CP_heading = false;
			Log.error("Change password heading is not present on Change Password Page");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(CP_heading, true, "Change password heading is not present on Change Password Page");

	}

	@Test(priority = 901, dependsOnMethods = { "ValidateLogin" },enabled=false)

	public void ValidateAccountSettings() throws InterruptedException {

		MyProfilePage mpp = new MyProfilePage(driver);

		boolean AccountMenu_present;
		Header hd = new Header(driver);
		try {
			hd.getAccountMenu().click();
			Thread.sleep(2000);
			AccountMenu_present = true;
			Log.info("User has clicked on the Account menu from the Shop Page");

		} catch (Exception e) {
			AccountMenu_present = false;

			Log.error("User not able to find the account menu on the Home Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountMenu_present, true, "Account Menu is not Present in the home Dashboard");
		
		boolean AccountSettings_present;
		try {
			mpp.getAccountSettings().click();
			Thread.sleep(2000);
			AccountSettings_present = true;
			Log.info("User has clicked on the Account Setting from the header");

		} catch (Exception e) {
			AccountSettings_present = false;

			Log.error("User not able to click on the Account Setting from the header");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountSettings_present, true,
				"User not able to click on the Account Setting from the header");

		String ActSetng_Titleact = driver.getTitle().trim();
		String ActSetng_Titlexp = "Account Settings - CCP";
		Assert.assertEquals(ActSetng_Titleact, ActSetng_Titlexp,
				"User is not being able to reach Change Password Page");

		AccountSetting as = new AccountSetting(driver);

		boolean AS_heading;
		try {
			as.getHeading().isDisplayed();
			AS_heading = true;
			Log.info("Account Settings heading is present on Account Settings Page");

		} catch (Exception e) {
			AS_heading = false;
			Log.error("Account Settings heading is not present on Account Settings Page");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(AS_heading, true, "Account Settings heading is not present on Account Settings Page");

	}

	@Test(priority = 12, dependsOnMethods = { "ValidateLogin" })

	public void ValidateCatalogRestriction() throws InterruptedException {

		MyProfilePage mpp = new MyProfilePage(driver);
		boolean AccountSettings_present;
		
		
		try {
			mpp.getCatalog().click();
			Thread.sleep(5000);
			AccountSettings_present = true;
			Log.info("User has clicked on the Catalog Restrictions link from the left navigation menu");

		} catch (Exception e) {
			AccountSettings_present = false;

			Log.error("User not able to click on the Catalog Restrictions link from the left navigation menu");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountSettings_present, true,
				"User not able to click on the Catalog Restrictions link from the left navigation menu");

		String Catalog_Titleact = driver.getTitle().trim();
		String Catalog_Titlexp = "Catalog Restrictions - CCP";
		Assert.assertEquals(Catalog_Titleact, Catalog_Titlexp,
				"User not able to click on the Catalog Restrictions link from the left navigation menu");

		Catalog Ca = new Catalog(driver);

		boolean Ca_heading;
		try {
			Ca.getHeading().isDisplayed();
			Ca_heading = true;
			Log.info("Catalog Restrictions heading is present on Catalog Page");

		} catch (Exception e) {
			Ca_heading = false;
			Log.error("Catalog Restrictions heading is not present on Catalog Page");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(Ca_heading, true, "Catalog Restrictions heading is not present on Catalog Page");

	}

	@Test(priority = 13, dependsOnMethods = { "ValidateLogin" })

	public void ValidateDomainLink() throws InterruptedException {

		MyProfilePage mpp = new MyProfilePage(driver);

		boolean DomainLink_present;
		try {
			mpp.getDomains().click();
			Thread.sleep(2000);
			DomainLink_present = true;
			Log.info("User has clicked on the Domain link from the left navigation menu");

		} catch (Exception e) {
			DomainLink_present = false;

			Log.error("User not able to click on the Domain Link link from the left navigation menu");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(DomainLink_present, true,
				"User not able to click on the Domain Link link from the left navigation menu");

		String Domain_Titleact = driver.getTitle().trim();
		String Domain_Titlexp = "Manage Domains - CCP";
		Assert.assertEquals(Domain_Titleact, Domain_Titlexp,
				"User not able to reach the Domain page  from the left navigation menu");

		Domains Do = new Domains(driver);

		boolean Do_heading;
		try {
			Do_heading = Do.getHeading().isDisplayed();
			Log.info("Manage Domains heading is present on Domain Page");

		} catch (Exception e) {
			Do_heading = false;
			Log.error("Manage Domains heading is not present on Domain Page");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(Do_heading, true, "Manage Domains heading is not present on Domain Page");

	}

	@Test(priority = 144, dependsOnMethods = { "ValidateLogin" },enabled=false)

	public void ValidateSetNotifications() throws InterruptedException {

		Header hd = new Header(driver);

		boolean AccountMenu_present;
		try {
			hd.getAccountMenu().click();
			Thread.sleep(2000);
			AccountMenu_present = true;
			Log.info("User has clicked on the Account menu from the Shop Page");

		} catch (Exception e) {
			AccountMenu_present = false;

			Log.error("User not able to find the account menu on the Home Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountMenu_present, true, "Account Menu is not Present in the home Dashboard");

		boolean SetNotification_present;
		try {
			hd.getSetNotifications().click();
			Thread.sleep(5000);
			SetNotification_present = true;
			Log.info("User has clicked on the Set Notification Link from the Account Menu");

		} catch (Exception e) {
			SetNotification_present = false;
			Log.error("User not able to click on the Set Notification Link from the Account Menu");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(SetNotification_present, true,
				"User not able to click on the Set Notification Link from the Account Menu");

		String Notification_Titleact = driver.getTitle().trim();
		String Notification_Titleexp = "Notifications - CCP";
		Assert.assertEquals(Notification_Titleact, Notification_Titleexp,
				"User not being able to reach Notification Page");
	}

	@Test(priority = 15, dependsOnMethods = { "ValidateLogin" })

	public void ValidateAddressPage() throws InterruptedException {

		Header hd = new Header(driver);

		boolean AccountMenu_present;
		try {
			hd.getAccountMenu().click();
			Thread.sleep(2000);
			AccountMenu_present = true;
			Log.info("User has clicked on the Account menu from the Shop Page");

		} catch (Exception e) {
			AccountMenu_present = false;

			Log.error("User not able to find the account menu on the Home Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountMenu_present, true, "Account Menu is not Present in the home Dashboard");

		boolean Address_present;
		try {
			hd.getAddress().click();
			Thread.sleep(5000);
			Address_present = true;
			Log.info("User has clicked on the Address of Use Link from the Account Menu");

		} catch (Exception e) {
			Address_present = false;
			Log.error("User not able to click on the Address of Use Link from the Account Menu");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(Address_present, true, "User not able to reach Address of Use Page");

		String Address_Titleact = driver.getTitle().trim();
		String Address_Titlexp = "Address of Use - CCP";
		Assert.assertEquals(Address_Titleact, Address_Titlexp, "User not being able to reach Address of Use Page");

		Address ad = new Address(driver);

		boolean Address_heading;
		try {
			ad.getHeading().isDisplayed();
			Thread.sleep(7000);
			Address_heading = true;
			Log.info("Address of Use heading is present on the Address Page");

		} catch (Exception e) {
			Address_heading = false;
			Log.error("Address of Use heading is not present on the Address Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Address_heading, true, "Address of Use heading is not present on the Address Page");
	}

	@Test(priority = 16, dependsOnMethods = { "ValidateLogin" })

	public void ValidateUsersPage() throws InterruptedException {

		Header hd = new Header(driver);

		boolean AccountMenu_present;
		try {
			hd.getAccountMenu().click();
			Thread.sleep(2000);
			AccountMenu_present = true;
			Log.info("User has clicked on the Account menu from the Shop Page");

		} catch (Exception e) {
			AccountMenu_present = false;

			Log.error("User not able to find the account menu on the Home Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountMenu_present, true, "Account Menu is not Present in the home Dashboard");

		boolean Users_present;
		try {
			hd.getUsers().click();
			Thread.sleep(5000);
			Users_present = true;
			Log.info("User has clicked on the users Link from the Account Menu");

		} catch (Exception e) {
			Users_present = false;
			Log.error("User not able to click on the users link from the Account Menu");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(Users_present, true, "User not able to reach users Page");

		String Users_Titleact = driver.getTitle().trim();
		String Users_Titlexp = "User Management - CCP";
		Assert.assertEquals(Users_Titleact, Users_Titlexp, "User not being able to reach Address of Use Page");

		Users us = new Users(driver);
		int a = 0;

		try {
			us.gettabs();
			Thread.sleep(5000);
			a = us.gettabs().size();
			Log.info("Tabs are appearing on the Users Page");

		} catch (Exception e) {

			Log.error("Tabs are not appearing on the Users Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(a, 3, "3 Tabs are not appearing on the Users Page");

	}

	@Test(priority = 17, dependsOnMethods = { "ValidateLogin" })

	public void ValidateRequestTab() throws InterruptedException {

		Users us = new Users(driver);

		boolean Request_present;
		try {
			us.getRequestTab().click();
			Thread.sleep(2000);
			Request_present = true;
			Log.info("User has clicked on the request tab on the users page");

		} catch (Exception e) {
			Request_present = false;

			Log.error("User not able to click on request tab on the users page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Request_present, true, "User not able to click on request tab on the users page");

		boolean RequestActive_present;
		try {
			RequestActive_present = us.getRequestActive().isEnabled();

			Log.info("After clicking on request tab, the request tab becomes active");

		} catch (Exception e) {
			RequestActive_present = false;

			Log.error("After clicking on request tab, the request tab has not become active");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(RequestActive_present, true,
				"After clicking on request tab, the request tab has not become active");
	}

	@Test(priority = 18, dependsOnMethods = { "ValidateLogin" })

	public void ValidateInviteTab() throws InterruptedException {

		Users us = new Users(driver);

		boolean Invite_present;
		try {
			us.getInvitesTab().click();
			Thread.sleep(2000);
			Invite_present = true;
			Log.info("User has clicked on the Invites tab on the users page");

		} catch (Exception e) {
			Invite_present = false;

			Log.error("User not able to click on Invites tab on the users page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Invite_present, true, "User not able to click on Invites tab on the users page");

		boolean InviteActive_present;
		try {
			InviteActive_present = us.getInvitesActive().isEnabled();

			Log.info("After clicking on Invites tab, the Invites tab becomes active");

		} catch (Exception e) {
			InviteActive_present = false;

			Log.error("After clicking on Invites tab, the Invites tab has not become active");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(InviteActive_present, true,
				"After clicking on Invites tab, the Invites tab has not become active");
	}
	
	@Test(priority = 19, dependsOnMethods = { "ValidateLogin" })

	public void ValidateSearching() throws InterruptedException {

		Header hd = new Header(driver);

		boolean SearchTab_present;
		try {
			hd.getSearchTab().sendKeys("Microsoft 365" + Keys.ENTER);
			Thread.sleep(2000);
			SearchTab_present = true;
			Log.info("On Search textbox user is typing Microsoft 365");

		} catch (Exception e) {
			SearchTab_present = false;

			Log.error("User not able to find the search textbox on the header");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(SearchTab_present, true, "User not able to find the search textbox on the header");

		boolean record_present;
		try {
			hd.getRecordList().isDisplayed();
			Thread.sleep(2000);
			record_present = true;
			Log.info("Records are getting searched using the search textbox");

		} catch (Exception e) {
			record_present = false;
			Log.error("Records are not getting searched using the search textbox");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(record_present, true, "Records are getting searched using the search textbox");

		
	}

	
	@Test(priority = 20, dependsOnMethods = { "ValidateLogin" })

	public void ValidateLogout() throws InterruptedException {

		Header hd = new Header(driver);

		boolean AccountMenu_present;
		try {
			hd.getAccountMenu().click();
			Thread.sleep(2000);
			AccountMenu_present = true;
			Log.info("User has clicked on the Account menu from the Shop Page");

		} catch (Exception e) {
			AccountMenu_present = false;

			Log.error("User not able to find the account menu on the Home Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountMenu_present, true, "Account Menu is not Present in the home Dashboard");

		boolean Logout_present;
		try {
			hd.getLogout().click();
			Thread.sleep(2000);
			Logout_present = true;
			Log.info("User has clicked on the Logout Page from the Account Menu");

		} catch (Exception e) {
			Logout_present = false;
			Log.error("User not able to click on the Logout Page from the Account Menu");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(Logout_present, true, "Logout is not Present in the home Dashboard under My Account Menu");

		String Shop_Titleact = driver.getTitle().trim();
		String Shop_Titlexp = "CCP Login";
		Assert.assertEquals(Shop_Titleact, Shop_Titlexp, "User is not being able to Signout from the application");
	}

	@Test(priority = 21, dependsOnMethods = { "ValidateLogin" },enabled=false)

	public void ValidateForgetPswd() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);

		boolean ForgetPswd_present;
		// String New_tab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		try {
			lp.getForget_Pswd().click();
			Log.info("User has clicked on the Forget Password Link from the Login Page");
			ForgetPswd_present = true;
			Thread.sleep(5000);

		} catch (Exception e) {
			ForgetPswd_present = false;
			Log.error("User not able to find the Forget Password Link on the Login Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(ForgetPswd_present, true, "Forget Password link is not Present on the Login Page");

		if (ForgetPswd_present == true) {
			String Forgetpswd_Titleact = driver.getTitle().trim();
			String Forgetpswd_Titlexp = "CCP Forgot Password";
			Assert.assertEquals(Forgetpswd_Titleact, Forgetpswd_Titlexp,
					"User is not being able to reach forget password page");
		}
		boolean email_present;
		// String New_tab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		ForgetPswdPage fp = new ForgetPswdPage(driver);

		try {
			fp.getemail();
			email_present = true;
			Log.info("Email textbox is present on the Forget password page");

		} catch (Exception e) {
			email_present = false;
			Log.error("Email textbox is not present on the Forget password page");
			Log.error(e.getMessage());

		}
		Assert.assertEquals(email_present, true, "Email Address textbox is not Present in the Forget password Page");

		boolean SbmtBtn_present;
		// String New_tab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		try {
			fp.getSbmt_Btn().click();
			Thread.sleep(3000);

			SbmtBtn_present = true;
			Log.info("User has clicked on the submit button on the forget password Page");

		} catch (Exception e) {
			SbmtBtn_present = false;

			Log.error("Submit button is not present on the forget password page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(SbmtBtn_present, true, "Submit button is not Present in the Forget password Page");
		boolean validation_present;
		// String New_tab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		try {
			fp.getValidation_Message();

			validation_present = true;
			Log.info("Once the User click on Submit button then the validation message is appearing");

		} catch (Exception e) {
			validation_present = false;
			Log.error(
					"Validation message are not appearing on the Forget password page once the User has click on submit button without providing the email address");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(validation_present, true,
				"Validation messages are not appearing in the Forget password Page");

	}

	@Test(priority = 22, dependsOnMethods = { "ValidateLogin" },enabled=false)

	public void ValidateRegPage() throws InterruptedException {
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		boolean CreateAcc_present;
		try {
			lp.getCreate_Account().click();
			Thread.sleep(3000);
			CreateAcc_present = true;
			Log.info("User Clicked on Create Account Link from the Login Page");

		} catch (Exception e) {
			CreateAcc_present = false;
			Log.error("User not able to find Create Account Link on the Login Page , hence not able to click it");
			Log.error(e.getMessage());

		}
		Assert.assertEquals(CreateAcc_present, true, "Create Account link is not Present in the Login Page");

		if (CreateAcc_present == true) {
			String Registeration_Titleact = driver.getTitle().trim();
			String Registeration_Titleexp = "Create Account - CCP";
			Log.info("Signup Page is opended and its title is being captured");
			Assert.assertEquals(Registeration_Titleact, Registeration_Titleexp,
					"User is not being able to reach Registeration page");

			RegisterationPage Rp = new RegisterationPage(driver);
			boolean email_present;
			try {
				Rp.getemail();
				Log.info("Email Text Box is present on the Signup Page");
				email_present = true;

			} catch (Exception e) {
				email_present = false;
				Log.error("Email Text Box is not present on the Signup Page");
				Log.error(e.getMessage());
			}
			Assert.assertEquals(email_present, true, "Email text box is not present on the Registeration Page");

			if (email_present == true) {
				boolean VerifyBtn_present;
				try {
					Rp.getVerify_btn().click();
					VerifyBtn_present = true;
					Log.info("Verify button is present on the Signup Page and user has clicked on it");

				} catch (Exception e) {
					VerifyBtn_present = false;
					Log.error("Verify button is not present on the Signup Page");
					Log.error(e.getMessage());
				}
				Assert.assertEquals(VerifyBtn_present, true, "Verify button is not present on the Registeration Page");

				if (VerifyBtn_present == true) {
					boolean ValidationMsg_present;
					try {
						Rp.getValidation_Msg();
						ValidationMsg_present = true;
						Log.info(
								"Once the User pressed the Verify button , Validation message is appearing on the Signup Page");

					} catch (Exception e) {
						ValidationMsg_present = false;

						Log.error(
								"Once the User pressed the Verify button , Validation message is not appearing on the Signup Page");
						Log.error(e.getMessage());

					}
					Assert.assertEquals(ValidationMsg_present, true,
							"Validation Message is not appearing on the registeration Page");
				}
			}

		}
	}

	@Test(priority = 201,enabled=false)

	public void ValidateLoginUser() throws InterruptedException {
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(3000);
		boolean Username_present;
		try {
			lp.getusername().sendKeys("user@grr.la");

			Username_present = true;
			Log.info("User enters the username in the username field on the login page");

		} catch (Exception e) {
			Username_present = false;
			Log.error("User not able to enter the username in the username field on the login page");
			Log.error(e.getMessage());

		}
		Assert.assertEquals(Username_present, true,
				"User not able to enter the username in the username field on the login page");

		boolean pswd_present;
		try {
			lp.getpassword().sendKeys("Arpatech12");
			pswd_present = true;
			Log.info("User enters the password in the password field on the login page");

		} catch (Exception e) {
			pswd_present = false;
			Log.error("User not able to enter the password in the password field on the login page");
			Log.error(e.getMessage());

		}
		Assert.assertEquals(pswd_present, true,
				"User not able to enter the password in the password field on the login page");
		boolean Login_present;
		try {
			lp.getloginbtn().click();
			Login_present = true;
			Log.info("User clicks on the login button in the login page");

		} catch (Exception e) {
			Login_present = false;
			Log.error("User not able to click on the login button in the login page");
			Log.error(e.getMessage());

		}
		Assert.assertEquals(Login_present, true, "User not able to click on the login button in the login page");

		Thread.sleep(5000);

		String TitleHome = driver.getTitle();
		Log.info("The title of the home page is captured");

		Assert.assertEquals(TitleHome, "Shop - CCP", "User is not being able to Login to the application");
		Log.info("The title of the Shop page is Verified Successfully");
	}

	@Test(priority = 202,enabled=false)

	public void ValidateMyAccountList() throws InterruptedException {

		Header hd = new Header(driver);

		String[] Menu_txt = new String[4];
		String Menu_txtexp[] = { "My Profile", "Change Password", "Set Notifications", "Logout" };

		boolean AccountMenu_present;
		try {
			hd.getAccountMenu().click();
			Thread.sleep(2000);
			AccountMenu_present = true;
			Log.info("User has clicked on the Account menu from the Shop Page");

		} catch (Exception e) {
			AccountMenu_present = false;

			Log.error("User not able to find the account menu on the Home Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountMenu_present, true, "Account Menu is not Present in the home Dashboard");

		int c = 1;
		for (int a = 0; a <= 3; a++) {

			Menu_txt[a] = driver.findElement(By.xpath("//div[@class='account-menu']//li[" + c + "]")).getText();
			a++;
			c++;
		}

		for (int b = 0; b <= 3; b++) {
			System.out.println(Menu_txt[b]);
			b++;
		}

	}
	
	@Test(priority = 23)

	public void ValidateManagementFPswd() throws InterruptedException, IOException 
	{
		//driver = initializeDriver();
		driver.get(url1);
		
		LoginPage lp = new LoginPage(driver);
		
		WebDriverWait wt = new WebDriverWait(driver, 20);
		
		boolean ForgerPswd_present;
		
		try {
			wt.until(ExpectedConditions.visibilityOf(lp.getForget_Pswd()));
			lp.getForget_Pswd().click();
			
			Log.info("User is clicking on forgot password link on the login page");
			
			ForgerPswd_present = true;
			
		} catch (NoSuchElementException e) {
			ForgerPswd_present = false;
			Log.error("Forget password link is not present on the login page");
			Log.error(e.getMessage());
		}
		
		Assert.assertEquals(ForgerPswd_present, true, "Forget password link is not present on the login page");
		Assert.assertEquals(driver.getTitle(), "CCP Forgot Password", "User not able to reach forgot password Page when clicking on forget password link on the login page");
	}
	
	@Test(priority = 24)

	public void ValidateManagementLogin() throws InterruptedException, IOException 
	{
		driver.navigate().back();
		
		LoginPage lp = new LoginPage(driver);
		
		//WebDriverWait wt = new WebDriverWait(driver, 20);
		
		Thread.sleep(5000);
		boolean Login_present;
		try {
			lp.getusername().sendKeys(username1);
			lp.getpassword().sendKeys(password1);
			lp.getloginbtn().click();
			Login_present = true;
			Log.info("User has provided credentials to the login screen of the management portal");
		} catch (Exception e) {
			Login_present = false;
			Log.error("User not able to provide credentials to the login page of the management portal");
			Log.error(e.getMessage());
		}
		
		Assert.assertEquals(Login_present, true, "User not able to provide credentials to the login page of the management portal");
		
		Thread.sleep(5000);
		String Shop_Titleact = driver.getTitle().trim();
		String Shop_Titlexp = "Dashboard - CCP";
		Assert.assertEquals(Shop_Titleact, Shop_Titlexp, "Login Page is not appearing on management portal");
		
		HomePage hp = new HomePage(driver);
		
		boolean CustomerTab_present;
		try {
			hp.getCustomersTab().isDisplayed();
			
			Log.info("Customer tab is present on the home page");
			CustomerTab_present = true;

		} catch (NoSuchElementException e) {

			CustomerTab_present = false;
			Log.error("Customer tab is not present on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(CustomerTab_present, true, "Customer tab is not present on the home page");
		
		boolean CatalogTab_present;
		try {
			hp.getCatalogTab().isDisplayed();
			
			Log.info("Catalog tab is present on the home page");
			CatalogTab_present = true;

		} catch (NoSuchElementException e) {

			CatalogTab_present = false;
			Log.error("Catalog tab is not present on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(CatalogTab_present, true, "Catalog tab is not present on the home page");
		
		
		boolean FulfillmentTab_present;
		try {
			hp.getFullfillmentTab().isDisplayed();
			
			Log.info("Fulfillment tab is present on the home page");
			FulfillmentTab_present = true;

		} catch (NoSuchElementException e) {

			FulfillmentTab_present = false;
			Log.error("Fulfillment tab is not present on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(FulfillmentTab_present, true, "Fulfillment tab is not present on the home page");
		
		
		boolean ReportsTab_present;
		try {
			hp.getReportsTab().isDisplayed();
			
			Log.info("Reports tab is present on the home page");
			ReportsTab_present = true;

		} catch (NoSuchElementException e) {

			ReportsTab_present = false;
			Log.error("Reports tab is not present on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(ReportsTab_present, true, "Reports tab is not present on the home page");
		
		
		boolean UsersTab_present;
		try {
			hp.getUsersTab().isDisplayed();
			
			Log.info("SETUP tab is present on the home page");
			UsersTab_present = true;

		} catch (NoSuchElementException e) {

			UsersTab_present = false;
			Log.error("SETUP tab is not present on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(UsersTab_present, true, "SETUP tab is not present on the home page");
		
		Header hd = new Header(driver);
		
		boolean AccMenu_present;
		try {
			hd.getAccountMenu().click();
			
			Log.info("User clicking on Account Menu on the Home Page");
			AccMenu_present = true;

		} catch (NoSuchElementException e) {

			AccMenu_present = false;
			Log.error("User not able to click on Account Menu on the Home Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccMenu_present, true, "User not able to click on Account Menu on the Home Page");
		
		
		boolean Logout_present;
		try {
			hd.getLogout().isDisplayed();
			
			Log.info("Logout appear while hovering on the account menu");
			Logout_present = true;

		} catch (NoSuchElementException e) {

			Logout_present = false;
			Log.error("Logout not appear while hovering on the account menu");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Logout_present, true, "Logout not appear while hovering on the account menu");	
	
		Actions an = new Actions(driver);
	an.moveToElement(hd.getNotification()).perform();
	Thread.sleep(1000);
		
	}
	
	@Test(priority = 25)

	public void ValidateMngmntSETUPTab() throws InterruptedException 
	{
		HomePage hp = new HomePage(driver);
		
		boolean user_present;
		try {
		
			hp.getUsersTab().click();
			Thread.sleep(5000);
			Log.info("User clicks on the SETUP tab on the home page");
			user_present = true;

		} catch (NoSuchElementException e) {
			user_present = false;
			Log.error("User not able to click on the SETUP tab on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(user_present, true, "User not able to click on the SETUP tab on the home page");
			String TitleHome = driver.getTitle();
		Log.info("The title of the home page is captured");
		Assert.assertEquals(TitleHome, "Users - CCP", "User is not being able to reach the SETUP page from the home page");
		Log.info("The title of the Users page is Verified Successfully");
		Users us = new Users(driver);
		boolean userstab_present ;
			
		try {
			us.getUsers().isDisplayed();
			us.getSettings().isDisplayed();
			us.getJobs().isDisplayed();
			userstab_present = true; 
		}
		catch(Exception e)
		{
			userstab_present = false;
			Log.error("2nd Nevigation Tab is not present on the Users Page");
			Log.error(e.getMessage());
		}
		
	Assert.assertEquals(userstab_present, true,"2nd nevigation option is not present on the users page");
	
	}
	
	
	@Test(priority = 26)

	public void ValidateUserHover() throws InterruptedException 
	{
		Users us = new Users(driver);
		
		Actions an = new Actions(driver);
		an.moveToElement(us.getUsers()).perform();
		Log.info("User is hovering on the users tab on setup page");
		
		
		boolean user_present;
		
		try {
			us.getUsers().isDisplayed();
		
			
			Log.info("Users dropdown option is present under user's tab on setup page");
			user_present = true;
		

		} catch (NoSuchElementException e) {
			user_present = false;
			Log.error("Users dropdown option is not present under user's tab on setup page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(user_present, true, "Users dropdown option is not present under user's tab on setup page");
		
		boolean Createuser_present;
	
		try {
			us.getCreateUser().isDisplayed();

			
			Log.info("Create User dropdown option is present under user's tab on setup page");
			Createuser_present = true;
			

		} catch (NoSuchElementException e) {
			Createuser_present = false;
			Log.error("Create User dropdown option is not present under user's tab on setup page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Createuser_present, true, "Create User dropdown option is not present under user's tab on setup page");		
		
		
		boolean Roles_present;
		
		try {
			us.getCreateUser().isDisplayed();
	
			
			Log.info("Create User dropdown option is present under user's tab on setup page");
			Roles_present = true;
			//RolesTitle = driver.getTitle();

		} catch (NoSuchElementException e) {
			Roles_present = false;
			Log.error("Create User dropdown option is not present under user's tab on setup page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Roles_present, true, "Create User dropdown option is not present under user's tab on setup page");		
		
		us.getRoles().click();
		
		WebDriverWait wt = new WebDriverWait(driver,30);
		
		wt.until(ExpectedConditions.visibilityOf(us.getRolesHeading()));
		
		Assert.assertEquals(driver.getTitle(), "Roles - CCP", "User not able to reach roles page when clicking on role button on the user's page");
	
		Assert.assertEquals(us.getAddRoleBtn().isDisplayed(), true,"Add New Role Button is not present on roles Page");
	}
	
	
	
	@Test(priority = 27)

	public void ValidateAddNewRole() throws InterruptedException 
	{
		Users us = new Users(driver);
		WebDriverWait wt = new WebDriverWait(driver,30);
		
		boolean AddBtn_present;
		
		try {
			us.getAddRoleBtn().click();
			wt.until(ExpectedConditions.visibilityOf(us.getAddRoleText()));
			Log.info("User is cliking on Add new Role button on the roles page");
			
			AddBtn_present = true;
			
		} catch (NoSuchElementException e) {
			AddBtn_present = false;
			Log.error("Add New Role button is not present on roles page");
			Log.error(e.getMessage());
		}
		
		Assert.assertEquals(AddBtn_present, true, "Add New Role button is not present on roles page");
		Assert.assertEquals(driver.getTitle(), "Add New Role - CCP", "User not able to reach Add new Role Page when clicking on Add New Role Button");
	
		}
	
	@Test(priority = 28)

	public void ValidateEditRole() throws InterruptedException 
	{
		Users us = new Users(driver);
		us.getCancelBtn().click();
		
		WebDriverWait wt = new WebDriverWait(driver,20);
		
		boolean EditBtn_present;
		
		try {
			
			wt.until(ExpectedConditions.visibilityOf(us.getEditBtn()));
			us.getEditBtn().click();
			Log.info("User is cliking on Edit button on the roles page");
			
			EditBtn_present = true;
			
		} catch (NoSuchElementException e) {
			EditBtn_present = false;
			Log.error("Edit is not present on roles page");
			Log.error(e.getMessage());
		}
		
		Assert.assertEquals(EditBtn_present, true, "Edit is not present on roles page");
		Assert.assertEquals(driver.getTitle(), "Edit Role - CCP", "User not able to reach Edit role Page when clicking on edit Button");
	
		}
	
	
	@Test(priority = 29)

	public void ValidateCreateUser() throws InterruptedException 
	{
		Users us = new Users(driver);
		us.getCancelBtn().click();
		
		WebDriverWait wt = new WebDriverWait(driver,20);
		
		boolean CreateUser_present;
		
		try {
			
			wt.until(ExpectedConditions.visibilityOf(us.getAddRoleBtn()));
			Actions an = new Actions(driver);
			an.moveToElement(us.getUsers()).perform();
			us.getCreateUser().click();
			Log.info("User is cliking on create user link on the roles page under user's tab");
			CreateUser_present = true;
			
		} catch (NoSuchElementException e) {
			CreateUser_present = false;
			Log.error("Create User is not present on roles page under user's tab");
			Log.error(e.getMessage());
		}
		
		Assert.assertEquals(CreateUser_present, true, "Create User is not present on roles page under user's tab");
		Assert.assertEquals(driver.getTitle(), "Create User - CCP", "User not able to reach create User Page when clicking on Create User link under user's tab");
	
		}
	
	
	@Test(priority = 30)

	public void ValidateAccountsPage() throws InterruptedException 
	{
		Users us = new Users(driver);
		us.getCancelBtn().click();
		
		WebDriverWait wt = new WebDriverWait(driver,20);
		
		boolean Customer_present;
		
		HomePage hp = new HomePage(driver);
		try {
			wt.until(ExpectedConditions.visibilityOf(hp.getCustomersTab()));
			hp.getCustomersTab().click();
			Log.info("User is cliking on customer's tab on the homepage of the management portal");
			Customer_present = true;
			
		} catch (NoSuchElementException e) {
			Customer_present = false;
			Log.error("Customer's tab is not present on management home page");
			Log.error(e.getMessage());
		}
		
		Assert.assertEquals(Customer_present, true, "Customer's tab is not present on management home page");
		Customer Cust = new Customer(driver);
		wt.until(ExpectedConditions.visibilityOf(Cust.getSelectFieldBtn()));
		Cust.getSelectFieldBtn();
		Assert.assertEquals(driver.getTitle(), "Accounts - CCP", "User not able to reach Account Page when clicking on customer's tab on the homepage of management portal");
		}

@Test(priority = 31)

public void ValidateSelectFields() throws InterruptedException 
{
	Customer Cust = new Customer(driver);
	boolean SelectField_present;
	
	try {
		Cust.getSelectFieldBtn().click();
		Log.info("User is cliking on select fields button on the account page");
		SelectField_present = true;
		
	} catch (NoSuchElementException e) {
		SelectField_present = false;
		Log.error("Select field not appearing on the account page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(SelectField_present, true, "Select field button not appearing on the account page");
	
boolean SelectFieldWindow_present;
WebDriverWait wt = new WebDriverWait(driver,20);

	
	try {
		wt.until(ExpectedConditions.visibilityOf(Cust.getCancelBtn()));
		Cust.getCancelBtn().click();
		Log.info("Select field popup window is appearing after clicking on Select field button");
		SelectFieldWindow_present = true;
		
	} catch (NoSuchElementException e) {
		SelectFieldWindow_present = false;
		Log.error("Select field popup window is not appearing after clicking on Select field button");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(SelectFieldWindow_present, true, "Select field Popup Window is not appearing after clicking on Select field button");
	
	}

@Test(priority = 32)

public void ValidateExportBtn() throws InterruptedException 
{
	Customer Cust = new Customer(driver);
	boolean ExportBtn_present;
	boolean ExportCancel_present = false;
	WebDriverWait wt = new WebDriverWait(driver,20);
	try {
		wt.until(ExpectedConditions.visibilityOf(Cust.getExportBtn()));
		Cust.getExportBtn().click();
		Log.info("User is cliking on export button on the account page");
		ExportBtn_present = true;
		wt.until(ExpectedConditions.visibilityOf(Cust.getExportCancel()));
		Cust.getExportCancel().click();
		Log.info("User is cliking on cancel button on export account popup window");
		ExportCancel_present = true;
		
		
	} catch (NoSuchElementException e) {
		ExportBtn_present = false;
		Log.error("Export button is not present on the account page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(ExportBtn_present, true, "Export button is not present on the account page");

	Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}



@Test(priority = 33)

public void ValidateSubscription() throws InterruptedException 
{
	Customer Cust = new Customer(driver);
	boolean SubscriptionBtn_present;
	//boolean ExportCancel_present = false;
	WebDriverWait wt = new WebDriverWait(driver,20);
	try {
		wt.until(ExpectedConditions.visibilityOf(Cust.getSubscription()));
		Cust.getSubscription().click();
		Log.info("User is cliking on Subscription tab on the Customer's page");
		SubscriptionBtn_present = true;
		//wt.until(ExpectedConditions.visibilityOf(Cust.getExportCancel()));
			
		
	} catch (NoSuchElementException e) {
		SubscriptionBtn_present = false;
		Log.error("Subscription button is not present on the Customer's page");
		Log.error(e.getMessage());
		driver.navigate().back();
	}
	wt.until(ExpectedConditions.visibilityOf(Cust.getSubsHeading()));
	Assert.assertEquals(SubscriptionBtn_present, true, "Subscription button is not present on the Customer's page");
	Assert.assertEquals(driver.getTitle(), "Subscriptions - CCP","User not reach Subscription page after clicking on Subscription tab on the customer's page");
	//

	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}

@Test(priority = 34,dependsOnMethods = { "ValidateSubscription" })

public void ValidateSubsSelectFields() throws InterruptedException 
{
	Customer Cust = new Customer(driver);
	boolean SelectField_present;
	
	try {
		Cust.getSelectFieldBtn().click();
		Log.info("User is cliking on select fields button on the Subscription page");
		SelectField_present = true;
		
	} catch (NoSuchElementException e) {
		SelectField_present = false;
		Log.error("Select field not appearing on the Subscription page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(SelectField_present, true, "Select field button not appearing on the Subscription page");
	
boolean SelectFieldWindow_present;
WebDriverWait wt = new WebDriverWait(driver,20);

	
	try {
		wt.until(ExpectedConditions.visibilityOf(Cust.getCancelBtn()));
		Cust.getCancelBtn().click();
		Log.info("Select field popup window is appearing after clicking on Select field button on Subscription page");
		SelectFieldWindow_present = true;
		
	} catch (NoSuchElementException e) {
		SelectFieldWindow_present = false;
		Log.error("Select field popup window is not appearing after clicking on Select field button on Subscription page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(SelectFieldWindow_present, true, "Select field Popup Window is not appearing after clicking on Select field button on Subscription page");
	
	}

@Test(priority = 35,dependsOnMethods = { "ValidateSubscription" })

public void ValidateSubsExport() throws InterruptedException 
{
	Customer Cust = new Customer(driver);
	boolean ExportBtn_present;
	boolean ExportCancel_present = false;
	WebDriverWait wt = new WebDriverWait(driver,20);
	try {
		wt.until(ExpectedConditions.visibilityOf(Cust.getExportBtn()));
		Cust.getExportBtn().click();
		Log.info("User is cliking on export button on the Subscription page");
		ExportBtn_present = true;
		wt.until(ExpectedConditions.visibilityOf(Cust.getExportCancel()));
		Cust.getExportCancel().click();
		Log.info("User is cliking on cancel button on export account popup window");
		ExportCancel_present = true;
		
		
	} catch (NoSuchElementException e) {
		ExportBtn_present = false;
		Log.error("Export button is not present on the Subscription page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(ExportBtn_present, true, "Export button is not present on the Subscription page");

	Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}



@Test(priority = 36,dependsOnMethods = { "ValidateSubscription" })

public void ValidateEditSubs() throws InterruptedException 
{
	Customer Cust = new Customer(driver);
	
	
	boolean EditSubs_present;
	//boolean ExportCancel_present = false;
	WebDriverWait wt = new WebDriverWait(driver,20);
	try {
		wt.until(ExpectedConditions.visibilityOf(Cust.getArrow1()));
		Cust.getArrow1().click();
		Log.info("User is cliking on dropdown icon of 1st record on subscription page");
		wt.until(ExpectedConditions.visibilityOf(Cust.getEditSubs()));
		Cust.getEditSubs().click();//
		Log.info("User is cliking on edit subscription of 1st record on subscription page");
		wt.until(ExpectedConditions.visibilityOf(Cust.getEditSubCancel()));
		Cust.getEditSubCancel().click();
		EditSubs_present=true;
		
		
	} catch (NoSuchElementException e) {
		EditSubs_present = false;
		Log.error("Edit subscription popup window is not appearing on the Subscription page when clicking on edit subscription option of a record");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(EditSubs_present, true, "Edit subscription popup window is not appearing on the Subscription page when clicking on edit subscription option of a record");

	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}

@Test(priority = 37)

public void ValidateAssumeRole() throws InterruptedException 
{
	Customer Cust = new Customer(driver);
	
	String title = null;
	String OldTab = null;
	//boolean Account_present;
	//boolean ExportCancel_present = false;
	WebDriverWait wt = new WebDriverWait(driver,20);
	try {
		wt.until(ExpectedConditions.visibilityOf(Cust.getAccount()));
		Cust.getAccount().click();
		Log.info("User is cliking on Account tab under Customer section");
		wt.until(ExpectedConditions.visibilityOf(Cust.getArrow1()));
		Cust.getArrow1().click();
		wt.until(ExpectedConditions.visibilityOf(Cust.getAssumeRole()));
		Cust.getAssumeRole().click();
		wt.until(ExpectedConditions.visibilityOf(Cust.getAssumeRadio()));
		Cust.getAssumeRadio().click();
		OldTab=driver.getWindowHandle();
		
		wt.until(ExpectedConditions.visibilityOf(Cust.getAssumeRoleBtn()));
		Cust.getAssumeRoleBtn().click();
		Thread.sleep(10000);
		Set<String> abc=driver.getWindowHandles();
		Iterator<String> it=abc.iterator();
	
		while(it.hasNext())
		{
		driver.switchTo().window(it.next());
		 title = driver.getTitle();
		//EditSubs_present=true;
		}	
		
		
	} catch (NoSuchElementException e) {
		//EditSubs_present = false;
		Log.error("Edit subscription popup window is not appearing on the Subscription page when clicking on edit subscription option of a record");
		Log.error(e.getMessage());
		driver.switchTo().window(OldTab);
	}
	
	
	Assert.assertEquals(driver.getTitle(), title,"User not able to reach markitplace page by clicking on assume role radio button");
	
	//wt.until(ExpectedConditions.visibilityOf(Cust.getEndSession()));
	//Cust.getEndSession().click();
	
	driver.switchTo().window(OldTab);
	//driver.switchTo().defaultContent();
	
	//driver.close();
	
	//Assert.assertEquals(EditSubs_present, true, "Edit subscription popup window is not appearing on the Subscription page when clicking on edit subscription option of a record");

	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}
@Test(priority = 38)

public void ValidateFooterSubscription() throws InterruptedException 
{
	HomePage hp = new HomePage(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean FSubs_present;
		
	try {
		wt.until(ExpectedConditions.visibilityOf(hp.getFSubs()));
		hp.getFSubs().click();
		Log.info("User is clicking on Subscriptions link from the footer section of the application");
		FSubs_present = true;
			
	} catch (NoSuchElementException e) {
		FSubs_present = false;
		Log.error("Subscription link is not appearing on the footer section");
		Log.error(e.getMessage());
		driver.navigate().back();
	}
	Customer cust = new Customer(driver);
	wt.until(ExpectedConditions.visibilityOf(cust.getSelectFieldBtn()));
	Assert.assertEquals(FSubs_present, true, "Subscription link is not appearing on the footer section");
Assert.assertEquals(driver.getTitle(),"Subscriptions - CCP","User not able to reach Subscription page by clicking on Subscription link from the footer of the application");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}

@Test(priority = 39)

public void ValidateFooterAccount() throws InterruptedException 
{
	HomePage hp = new HomePage(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean FAccount_present;
		
	try {
		
		wt.until(ExpectedConditions.visibilityOf(hp.getFAccount()));
		hp.getFAccount().click();
		Log.info("User is clicking on Account link from the footer section of the application");
		FAccount_present = true;
			
	} catch (NoSuchElementException e) {
		FAccount_present = false;
		Log.error("Account link is not appearing on the footer section");
		Log.error(e.getMessage());
	}
	Customer cust = new Customer(driver);
	wt.until(ExpectedConditions.visibilityOf(cust.getSelectFieldBtn()));
	
	Assert.assertEquals(FAccount_present, true, "Account link is not appearing on the footer section");
Assert.assertEquals(driver.getTitle(),"Accounts - CCP","User not able to reach account page by clicking on account link from the footer of the application");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}


@Test(priority = 40)

public void ValidateEditAccount() throws InterruptedException 
{
	Customer Cust = new Customer(driver);
	
	
	boolean EditAccount_present;
	String title1 = null;
	//boolean ExportCancel_present = false;
	WebDriverWait wt = new WebDriverWait(driver,20);
	try {
		wt.until(ExpectedConditions.visibilityOf(Cust.getArrow1()));
		Cust.getArrow1().click();
		Log.info("User is cliking on dropdown icon of 1st record on Account's page");
		wt.until(ExpectedConditions.visibilityOf(Cust.getEditAccount()));
		Cust.getEditAccount().click();//
		Log.info("User is cliking on edit Account of 1st record on Account's page");
		wt.until(ExpectedConditions.visibilityOf(Cust.getAccountCancel()));
		
		title1=driver.getTitle();
		//Cust.getEditSubCancel().click();
		EditAccount_present=true;
		
		
	} catch (NoSuchElementException e) {
		EditAccount_present = false;
		Log.error("Edit Account dropdown option is not appearing on the Account page when clicking on edit account option of a record");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(EditAccount_present, true, "Edit Account dropdown option is not appearing on the Account page when clicking on edit account option of a record");
Assert.assertEquals(title1, "Edit Account - CCP","When Clicking on Edit Account dropdown option on account screen then user not able to reach Edit account page");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
Thread.sleep(5000);
}



@Test(priority = 41)

public void ValidateEditSave() throws InterruptedException 
{
	Customer Cust = new Customer(driver);
	
	
	boolean SaveMessage_present;
	
	//boolean ExportCancel_present = false;
	WebDriverWait wt = new WebDriverWait(driver,20);
	try {
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOf(Cust.getSaveBtn()));
		Cust.getSaveBtn().click();
		Log.info("User is cliking on save button on the edit account screen");
		wt.until(ExpectedConditions.visibilityOf(Cust.getSaveMessage()));
		Cust.getSaveMessage().isDisplayed();
		SaveMessage_present=true;
				
	} catch (NoSuchElementException e) {
		SaveMessage_present = false;
		Log.error("When user is clicking on Save button on Edit account screen the save message is not appearing");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(SaveMessage_present, true, "When user is clicking on Save button on Edit account screen the save message is not appearing");
	
	boolean CancelBtn ;
	try {
		wt.until(ExpectedConditions.visibilityOf(Cust.getAccountCancel()));
		Cust.getAccountCancel().click();
		Log.info("User is cliking on cancel button on the edit account screen");
		
		CancelBtn=true;
				
	} catch (NoSuchElementException e) {
		CancelBtn = false;
		Log.error("Cancel Button is not present on Edit account screen");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(CancelBtn, true,"Cancel Button is not present on Edit account screen");
	
	wt.until(ExpectedConditions.visibilityOf(Cust.getSelectFieldBtn()));
	
	Assert.assertEquals(driver.getTitle(), "Accounts - CCP","When clicking on Cancel button on edit account page then user not reache account page");
}

@Test(priority = 42)

public void ValidateFooterLogo() throws InterruptedException 
{
	HomePage hp = new HomePage(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean FLogo_present;
		
	try {
		
		wt.until(ExpectedConditions.visibilityOf(hp.getFooterLogo()));
		hp.getFooterLogo().click();
		Log.info("User is clicking on Connection logo from the footer section of the application");
		FLogo_present = true;
			
	} catch (NoSuchElementException e) {
		FLogo_present = false;
		Log.error("Connection logo is not present on footer section");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(FLogo_present, true, "Connection logo is not present on footer section");
Assert.assertEquals(driver.getTitle(),"Dashboard - CCP","User not able to reach home page after clicking on logo from the footer of the application");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}


@Test(priority = 43)

public void ValidateCategories() throws InterruptedException 
{
	HomePage hp = new HomePage(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean Catalog_present;
		
	try {
		wt.until(ExpectedConditions.visibilityOf(hp.getCatalogTab()));
		hp.getCatalogTab().click();
		
		Log.info("User is clicking on Catalog tab from the header section of the application");
		Catalog_present = true;
			
	} catch (NoSuchElementException e) {
		Catalog_present = false;
		Log.error("Catalog tab is not present on the Home Page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(Catalog_present, true, "Catalog tab is not present on the Home Page");
	
	Catalog ct = new Catalog(driver);
	//wt.until(ExpectedConditions.visibilityOf(ct.getCategories()));
	boolean Categories_present;
	
	try {
		wt.until(ExpectedConditions.visibilityOf((ct.getCategories())));
		ct.getCategories().click();
		Log.info("User is clicking on Categories tab from the catalog section of the application");
		Categories_present = true;		
	} catch (NoSuchElementException e) {
		Categories_present = false;
		Log.error("Categories button is not present under catalog section");
		Log.error(e.getMessage());
	}
	Assert.assertEquals(Categories_present, true, "Categories button is not present under catalog section");
	wt.until(ExpectedConditions.visibilityOf((ct.getSelectFieldBtn())));
	Assert.assertEquals(driver.getTitle(),"Catalog Categories - CCP", "User not able to reach after clicking on categories tab on the catalog page");
	//Assert.assertEquals(driver.getTitle(),"Dashboard - CCP","User not able to reach home page after clicking on logo from the footer of the application");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}


@Test(priority = 44)

public void ValidateSyncBtn() throws InterruptedException 
{
	Catalog ct = new Catalog(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean sync_present;
		
	try {
		wt.until(ExpectedConditions.visibilityOf(ct.getSyncBtn()));
		ct.getSyncBtn().click();
		Log.info("User is clicking on sync button on caregories page");
		sync_present = true;
			
	} catch (NoSuchElementException e) {
		sync_present = false;
		Log.error("sync button is not present on categories page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(sync_present, true, "Sync button is not present on categories page");
	
	
	//Catalog ct = new Catalog(driver);
	//wt.until(ExpectedConditions.visibilityOf(ct.getCategories()));
	boolean SyncMsg_present;
	
	try {
		
		wt.until(ExpectedConditions.visibilityOf((ct.getSyncSuccess())));
		ct.getSyncSuccess().isDisplayed();
		
		Log.info("Sync Message is appearing when user is clicking on sync button on categories page");
		ct.getSyncClose().click();
		SyncMsg_present = true;		
		
	} catch (NoSuchElementException e) {
		SyncMsg_present = false;
		Log.error("Sync Message is not appearing when user is clicking on sync button on categories page");
		Log.error(e.getMessage());
	}
	Assert.assertEquals(SyncMsg_present, true, "Sync Message is not appearing when user is clicking on sync button on categories page");
	
}


@Test(priority = 45)

public void ValidateCategoryExport() throws InterruptedException 
{
	Catalog ct = new Catalog(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean Export_present;
		
	try {
		Thread.sleep(10000);
		wt.until(ExpectedConditions.elementToBeClickable(ct.getExportBtn()));
		ct.getExportBtn().click();
		Log.info("User is clicking on export button on caregories page");
		Export_present = true;
			
	} catch (NoSuchElementException e) {
		Export_present = false;
		Log.error("Export button is not present on categories page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(Export_present, true, "Export button is not present on categories page");
	
	
	//Catalog ct = new Catalog(driver);
	//wt.until(ExpectedConditions.visibilityOf(ct.getCategories()));
	boolean ExportPopup_present;
	
	try {
		
		wt.until(ExpectedConditions.visibilityOf((ct.getExportCancel())));
		ct.getExportCancel().click();
		
		Log.info("User is clicking on cancel button on export popup");
		ExportPopup_present = true;		
		
	} catch (NoSuchElementException e) {
		ExportPopup_present = false;
		Log.error("Export popup is not appearing when clicking on export button on categories page");
		Log.error(e.getMessage());
	}
	Assert.assertEquals(ExportPopup_present, true, "Export popup is not appearing when clicking on export button on categories page");
	
}



@Test(priority = 46)

public void ValidateSelectFieldCateg() throws InterruptedException 
{
	Catalog ct = new Catalog(driver);
	
	boolean SelectField_present;
	
	try {
		ct.getSelectFieldBtn().click();
		Log.info("User is cliking on select fields button on the Categories page");
		SelectField_present = true;
		
	} catch (NoSuchElementException e) {
		SelectField_present = false;
		Log.error("Select field not appearing on the Categories page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(SelectField_present, true, "Select field button not appearing on the Categories page");
	
boolean SelectFieldWindow_present;
WebDriverWait wt = new WebDriverWait(driver,20);

	
	try {
		wt.until(ExpectedConditions.visibilityOf(ct.getCancelBtn()));
		ct.getCancelBtn().click();
		Log.info("Select field popup window is appearing after clicking on Select field button on Categories page");
		SelectFieldWindow_present = true;
		
	} catch (NoSuchElementException e) {
		SelectFieldWindow_present = false;
		Log.error("Select field popup window is not appearing after clicking on Select field button on Categories page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(SelectFieldWindow_present, true, "Select field Popup Window is not appearing after clicking on Select field button on Categories page");	
}


@Test(priority = 47)

public void ValidateEditCategory() throws InterruptedException 
{
	Catalog Cat = new Catalog(driver);
	
	
	boolean editheading_present;
	
	//String title1 = null;
	//boolean ExportCancel_present = false;
	WebDriverWait wt = new WebDriverWait(driver,20);
	try {
		wt.until(ExpectedConditions.visibilityOf(Cat.getArrow1()));
		Cat.getArrow1().click();
		Log.info("User is cliking on edit category dropdown icon of 1st record on category's page");
		wt.until(ExpectedConditions.visibilityOf(Cat.getEditCategory()));
		Cat.getEditCategory().click();
		Log.info("User is cliking on edit Subscription of 1st record on Subscription's page");
		
		wt.until(ExpectedConditions.visibilityOf(Cat.getCatheading()));
		Cat.getCatheading().isDisplayed();
		Log.info("Edit subscription heading is appearing");
		editheading_present=true;
		wt.until(ExpectedConditions.visibilityOf(Cat.getApplyBtn()));
		Cat.getApplyBtn().click();
		//title1=driver.getTitle();
		//Cust.getEditSubCancel().click();		
	} catch (NoSuchElementException e) {
		editheading_present = false;
		Log.error("When clicking on edit subscription the edit subscription popup is not appearing");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(editheading_present, true, "When clicking on edit subscription the edit subscription popup is not appearing");
	Thread.sleep(10000);
//Assert.assertEquals(title1, "Edit Account - CCP","When Clicking on Edit Account dropdown option on account screen then user not able to reach Edit account page");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}


@Test(priority = 48)

public void ValidateDomainsPage() throws InterruptedException 
{
	HomePage hp = new HomePage(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean Customer_present = false ;
	boolean Domain_present ;
		
	try {
		wt.until(ExpectedConditions.visibilityOf(hp.getCustomersTab()));
		hp.getCustomersTab().click();
		Log.info("User is clicking on customer tab from the header section of the application");
		Customer_present = true;
		wt.until(ExpectedConditions.visibilityOf(hp.getDomain()));
		hp.getDomain().click();
		Log.info("User is clicking on Domain tab from the header section of the application under customer tab");
		Domain_present=true;
	} 
	
	catch (NoSuchElementException e) {
		if(Customer_present==true)
		{
			Customer_present=true;
		}
		else
		{
			Customer_present=false;
			Log.error("Customer tab is not appearing on the header section of the application");
		}
		Domain_present = false;
		Log.error("Domain tab is not appearing on the header section under customer");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(Customer_present, true, "Customer tab is not appearing on the header section of the application");
	Assert.assertEquals(Domain_present, true, "Domain tab is not appearing on the header section under customer");
Assert.assertEquals(driver.getTitle(),"Domains - CCP","When user is clicking on Domain tab then the user is not nevigating to the domain page");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}


@Test(priority = 49)

public void ValidateDomainExport() throws InterruptedException 
{
	Customer ct = new Customer(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean Export_present;
		
	try {
		//Thread.sleep(10000);
		//wt.until(ExpectedConditions.elementToBeClickable(ct.getExportBtn()));
		ct.getExportBtn().click();
		Log.info("User is clicking on export button on Domain page");
		Export_present = true;
			
	} catch (NoSuchElementException e) {
		Export_present = false;
		Log.error("Export button is not present on Domain page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(Export_present, true, "Export button is not present on Domain page");
	
	
	//Catalog ct = new Catalog(driver);
	//wt.until(ExpectedConditions.visibilityOf(ct.getCategories()));
	boolean ExportPopup_present;
	
	try {
		
		wt.until(ExpectedConditions.visibilityOf((ct.getExportCancel())));
		ct.getExportCancel().click();
		
		Log.info("User is clicking on cancel button on export popup");
		ExportPopup_present = true;		
		
	} catch (NoSuchElementException e) {
		ExportPopup_present = false;
		Log.error("Export popup is not appearing when clicking on export button on Domain page");
		Log.error(e.getMessage());
	}
	Assert.assertEquals(ExportPopup_present, true, "Export popup is not appearing when clicking on export button on Domain page");
}

@Test(priority = 50)

public void ValidateRequestPage() throws InterruptedException 
{
	Customer ct = new Customer(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean Request_present  ;
	//boolean Domain_present ;
		
	try {
		wt.until(ExpectedConditions.visibilityOf(ct.getRequestTab()));
		ct.getRequestTab().click();
		Log.info("User is clicking on request tab from the header section of the application");
		Request_present = true;
	} 
	
	catch (NoSuchElementException e) {
		
		Request_present = false;
		Log.error("request tab is not appearing on the header section under customer");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(Request_present, true, "request tab is not appearing on the header section under customer");
Assert.assertEquals(driver.getTitle(),"Requests - CCP","When user is clicking on Request tab then the user is not nevigating to the Request page");

boolean Requestid_present  ;
//boolean Domain_present ;
	
try {
	wt.until(ExpectedConditions.visibilityOf(ct.getRequestId()));
	ct.getCRID().isDisplayed();
	Log.info("Request id is appearing in address of use section under request tab");
	Requestid_present = true;
} 

catch (NoSuchElementException e) {
	
	Requestid_present = false;
	Log.error("Request id is appearing in address of use section under request tab");
	Log.error(e.getMessage());
}
Assert.assertEquals(Requestid_present, true, "Request id is appearing in address of use section under request tab");


boolean NetTerm_present= false;
boolean Nettermheading;
//boolean Domain_present ;
	
try {
	wt.until(ExpectedConditions.visibilityOf(ct.getNetTerms()));
	ct.getNetTerms().click();
	Log.info("User is clicking on net terms tab on the request page");
	NetTerm_present = true;
	wt.until(ExpectedConditions.visibilityOf(ct.getNetTermHeading()));
	ct.getNetTermHeading().isDisplayed();
	Nettermheading=true;
	
} 

catch (NoSuchElementException e) {
	
	
	Nettermheading=false;
	Log.error("Net term ID parameter is not present of Net terms tab on request page");
	Log.error(e.getMessage());
}

Assert.assertEquals(NetTerm_present, true, "Net terms tab is not appearing on request page");

Assert.assertEquals(Nettermheading, true, "Net term ID parameter is not present of Net terms tab on request page");
}


@Test(priority = 51)

public void ValidateRequestExport() throws InterruptedException 
{
	Customer ct = new Customer(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean Export_present;
		
	try {
		//Thread.sleep(10000);
		//wt.until(ExpectedConditions.elementToBeClickable(ct.getExportBtn()));
		ct.getExportBtn().click();
		Log.info("User is clicking on export button on request page");
		Export_present = true;
			
	} catch (NoSuchElementException e) {
		Export_present = false;
		Log.error("Export button is not present on request page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(Export_present, true, "Export button is not present on request page");
	
	
	//Catalog ct = new Catalog(driver);
	//wt.until(ExpectedConditions.visibilityOf(ct.getCategories()));
	boolean ExportPopup_present;
	
	try {
		
		wt.until(ExpectedConditions.visibilityOf((ct.getExportCancel())));
		ct.getExportCancel().click();
		
		Log.info("User is clicking on cancel button on export popup");
		ExportPopup_present = true;		
		
	} catch (NoSuchElementException e) {
		ExportPopup_present = false;
		Log.error("Export popup is not appearing when clicking on export button on request page");
		Log.error(e.getMessage());
	}
	Assert.assertEquals(ExportPopup_present, true, "Export popup is not appearing when clicking on export button on request page");
}



@Test(priority = 52)

public void ValidateNotifications() throws InterruptedException 
{
	Header hd = new Header(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean Notification_present;
		
	try {
		wt.until(ExpectedConditions.visibilityOf(hd.getCustNotification()));
		hd.getCustNotification().click();
		
		Log.info("User is clicking on notification from the header section of the application under customer section");
		Notification_present = true;
			
	} catch (NoSuchElementException e) {
		Notification_present = false;
		Log.error("Notification tab is not present under customer section");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(Notification_present, true, "Notification tab is not present under customer section");
	
	Assert.assertEquals(driver.getTitle(),"Notifications - CCP", "User not able to reach notification page after clicking on notification tab from customer section");
	//Assert.assertEquals(driver.getTitle(),"Dashboard - CCP","User not able to reach home page after clicking on logo from the footer of the application");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}

@Test(priority = 53)

public void NotificationExport() throws InterruptedException 
{
	NotificationPage np = new NotificationPage(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean ExportBtn_present;
		
	try {
		wt.until(ExpectedConditions.visibilityOf(np.getExportBtn()));
		np.getExportBtn().click();
		
		Log.info("User is clicking on export button from the notifications Page");
		ExportBtn_present = true;
			
	} catch (NoSuchElementException e) {
		ExportBtn_present = false;
		Log.error("export button is not present on the notification Page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(ExportBtn_present, true, "Send Notification button is not present on the notification Page");
	
	
	boolean ExportNotificationBtn_present;
	
	try {
		wt.until(ExpectedConditions.visibilityOf(np.getExportRptBtn()));
		np.getExportCancel().click();
		
		Log.info("User is clicking on cancel button from the export notifications popup");
		ExportNotificationBtn_present = true;
		Thread.sleep(5000);
			
	} catch (NoSuchElementException e) {
		ExportNotificationBtn_present = false;
		Log.error("cancel button is not present on the export notification Page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(ExportNotificationBtn_present, true, "cancel button is not present on the export notification Page");
	//Assert.assertEquals(np.getExportRptBtn().click(), true, "export report button is not present on the export notification Page");
}


@Test(priority = 54)

public void ValidateSendNotifications() throws InterruptedException 
{
	NotificationPage np = new NotificationPage(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean SendNotificationBtn_present;
		
	//try {
		Thread.sleep(5000);
		wt.until(ExpectedConditions.visibilityOf(np.getSendNotificationBtn()));
		np.getSendNotificationBtn().click();
		
		Log.info("User is clicking on Send notification button from the notifications Page");
		SendNotificationBtn_present = true;
			
	//} catch (NoSuchElementException e) {
	//	SendNotificationBtn_present = false;
	//	Log.error("Send Notification button is not present on the notification Page");
	//	Log.error(e.getMessage());
	//}
	
	Assert.assertEquals(SendNotificationBtn_present, true, "Send Notification button is not present on the notification Page");
	
	Assert.assertEquals(driver.getTitle(),"Send Notification - CCP", "User not able to reach send notification page after clicking on send notification button from notification page");
	//Assert.assertEquals(driver.getTitle(),"Dashboard - CCP","User not able to reach home page after clicking on logo from the footer of the application");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}


@Test(priority = 55)

public void ValidateProviderPage() throws InterruptedException 
{
	
	
	WebDriverWait wt = new WebDriverWait(driver,20);
	
	HomePage hp = new HomePage(driver);
	
		
	boolean Catalog_present;
		
	try {
		
		wt.until(ExpectedConditions.visibilityOf(hp.getCatalogTab()));
		hp.getCatalogTab().click();
		
		Log.info("User is clicking on catalog tab from the header of the Page");
		Catalog_present = true;
			
	} catch (NoSuchElementException e) {
		Catalog_present = false;
		Log.error("catalog tab is not present on the header of the page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(Catalog_present, true, "catalog tab is not present on the header of the page");
	
	Assert.assertEquals(driver.getTitle(),"Providers - CCP", "User not able to reach provider page after clicking on catalog tab from the header of the page");
	//Assert.assertEquals(driver.getTitle(),"Dashboard - CCP","User not able to reach home page after clicking on logo from the footer of the application");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}

@Test(priority = 56)

public void ValidateProviderExport() throws InterruptedException 
{
	Provider pr = new Provider(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean ExportBtn_present;
		
	try {
		wt.until(ExpectedConditions.visibilityOf(pr.getExportBtn()));
		pr.getExportBtn().click();
		
		Log.info("User is clicking on export button from the Provider Page");
		ExportBtn_present = true;
			
	} catch (NoSuchElementException e) {
		ExportBtn_present = false;
		Log.error("export button is not present on the Provider Page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(ExportBtn_present, true, "Export button is not present on the Provider Page");
	
	
	boolean ExportProviderBtn_present;
	
	try {
		wt.until(ExpectedConditions.visibilityOf(pr.getExportCancel()));
		pr.getExportCancel().click();
		
		Log.info("User is clicking on cancel button from the export provider popup");
		ExportProviderBtn_present = true;
		Thread.sleep(5000);
			
	} catch (NoSuchElementException e) {
		ExportProviderBtn_present = false;
		Log.error("cancel button is not present on the export provider Page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(ExportProviderBtn_present, true, "Export provider screen is not appearing");
	//Assert.assertEquals(np.getExportRptBtn().click(), true, "export report button is not present on the export notification Page");
}


@Test(priority = 57)

public void ValidateEditProvider() throws InterruptedException 
{
	
	Provider pr = new Provider(driver);


boolean editprovider_present;

WebDriverWait wt = new WebDriverWait(driver,20);

try {
	wt.until(ExpectedConditions.visibilityOf(pr.getArrow1()));
	pr.getArrow1().click();
	Log.info("User is cliking on edit provider dropdown icon of 1st record on Provider's page");
	wt.until(ExpectedConditions.visibilityOf(pr.getEditProvider()));
	pr.getEditProvider().click();
	Log.info("User is cliking on edit Provider of 1st record on provider's page");
	editprovider_present =true;
	
} catch (NoSuchElementException e) {
	editprovider_present = false;
	Log.error("Dropdown arrow or Edit providor dropdown option is not appearing on provider's page");
	Log.error(e.getMessage());
}

Assert.assertEquals(editprovider_present, true, "Dropdown arrow or Edit providor dropdown option is not appearing on provider's page");

Assert.assertEquals(driver.getTitle(), "Edit Provider - CCP","When clicking on edit provider link from dropdown on provider page then user is not nevigating to edit provider page");

}

@Test(priority = 58)

public void ValidateAddProvider() throws InterruptedException 
{	
	WebDriverWait wt = new WebDriverWait(driver,20);
	
	Provider PR = new Provider(driver);
			
	boolean Catalog_present;
		
	try {
		PR.getcancelBtn().click();
		
		wt.until(ExpectedConditions.visibilityOf(PR.getAddProvider_Btn()));
		PR.getAddProvider_Btn().click();
		
		Log.info("User is clicking on ADD PROVIDER button on the providers page");
		Catalog_present = true;
			
	} catch (NoSuchElementException e) {
		Catalog_present = false;
		Log.error("Add provider button is not present on the provider page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(Catalog_present, true, "Add provider button is not present on the provider page");
	
	Assert.assertEquals(driver.getTitle(),"Add a Provider - CCP", "User not able to reach provider page after clicking on catalog tab from the header of the page");
	//Assert.assertEquals(driver.getTitle(),"Dashboard - CCP","User not able to reach home page after clicking on logo from the footer of the application");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}

@Test(priority = 59)

public void ValidateServicesPage() throws InterruptedException 
{
	
	
	WebDriverWait wt = new WebDriverWait(driver,20);
	
	Provider pr = new Provider(driver);
	
		
	boolean Services_present;
		
	try {
		
		wt.until(ExpectedConditions.visibilityOf(pr.getServicesTab()));
		pr.getServicesTab().click();;
		
		Log.info("User is clicking on service tab from the catalog session");
		Services_present = true;
			
	} catch (NoSuchElementException e) {
		Services_present = false;
		Log.error("Service tab is not present under catalog section");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(Services_present, true, "Service tab is not present under catalog section");
	
	Assert.assertEquals(driver.getTitle(),"Catalog Services - CCP", "User not able to reach service page after clicking on service tab from the catalog session");
	//Assert.assertEquals(driver.getTitle(),"Dashboard - CCP","User not able to reach home page after clicking on logo from the footer of the application");
	//Assert.assertEquals(ExportCancel_present, true, "Cancel button is not present on export account popup window");
}


@Test(priority = 60)

public void ValidateServiceExport() throws InterruptedException 
{
	Provider pr = new Provider(driver);
	
	WebDriverWait wt = new WebDriverWait(driver,20);
		
	boolean ExportBtn_present;
		
	try {
		wt.until(ExpectedConditions.visibilityOf(pr.getExportBtn()));
		pr.getExportBtn().click();
		
		Log.info("User is clicking on export button from the service Page");
		ExportBtn_present = true;
			
	} catch (NoSuchElementException e) {
		ExportBtn_present = false;
		Log.error("export button is not present on the service Page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(ExportBtn_present, true, "Export button is not present on the Service Page");
	
	
	boolean ExportProviderBtn_present;
	
	try {
		wt.until(ExpectedConditions.visibilityOf(pr.getExportCancel()));
		pr.getExportCancel().click();
		
		Log.info("User is clicking on cancel button from the export provider popup");
		ExportProviderBtn_present = true;
		Thread.sleep(5000);
			
	} catch (NoSuchElementException e) {
		ExportProviderBtn_present = false;
		Log.error("cancel button is not present on the export provider Page");
		Log.error(e.getMessage());
	}
	
	Assert.assertEquals(ExportProviderBtn_present, true, "Export provider screen is not appearing");
	//Assert.assertEquals(np.getExportRptBtn().click(), true, "export report button is not present on the export notification Page");
}


@Test(priority = 61)

public void ValidateEditService() throws InterruptedException 
{
	
	Provider pr = new Provider(driver);


boolean editprovider_present;

WebDriverWait wt = new WebDriverWait(driver,20);

try {
	wt.until(ExpectedConditions.visibilityOf(pr.getArrow1()));
	pr.getArrow1().click();
	Log.info("User is cliking on edit Service dropdown icon of 1st record on Service's page");
	wt.until(ExpectedConditions.visibilityOf(pr.getEditService()));
	pr.getEditService().click();
	Log.info("User is cliking on edit Service of 1st record on Service's page");
	editprovider_present =true;
	
} catch (NoSuchElementException e) {
	editprovider_present = false;
	Log.error("Dropdown arrow or Edit Service dropdown option is not appearing on Service's page");
	Log.error(e.getMessage());
}

Assert.assertEquals(editprovider_present, true, "Dropdown arrow or Edit Service dropdown option is not appearing on Service's page");

Assert.assertEquals(driver.getTitle(), "Edit Services - CCP","When clicking on edit Service link from dropdown on service's page then user is not nevigating to edit service page");

}


 //@AfterTest()

 //public void closebrowser()

 //{
 //driver.close();
 //}
 }

