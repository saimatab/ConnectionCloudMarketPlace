package smokeTest;
import java.io.IOException;
import java.lang.reflect.Array;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.AccountSetting;
import pageObjects.Address;
import pageObjects.Catalog;
import pageObjects.ChangePassword;
import pageObjects.Domains;
import pageObjects.EditProfilePage;
import pageObjects.ForgetPswdPage;
import pageObjects.Header;
import pageObjects.HomePage;
import pageObjects.Insight;
import pageObjects.LoginPage;
import pageObjects.NotificationPage;
import pageObjects.RegisterationPage;
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

		boolean Application_present;
		try {
			hm.getApplication_Link();

			Application_present = true;

		} catch (NoSuchElementException e) {
			Application_present = false;
			Log.error("User not able to find Application Link on the Shop Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Application_present, true, "Application Link is not Present in the Dashboard");

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

		boolean Service_present;
		try {
			hm.getService_Link();
			Service_present = true;

		} catch (NoSuchElementException e) {
			Service_present = false;
			Log.error("User not able to find Service_present Link on the Shop Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Service_present, true, "Service Directory Link is not Present in the Dashboard");

	}

	@Test(priority = 2, dependsOnMethods = { "ValidateLogin" })

	public void ValidateManageTab() throws InterruptedException {
		// Header hd = new Header(driver);
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

		boolean Billing_present;
		try {
			Mn.getBilling_Link();
			Billing_present = true;
			Log.info("Billing & invoice link is present on the Manage Page");

		} catch (NoSuchElementException e) {
			Billing_present = false;
			Log.error("Billing & invoice link is not present on the Manage Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Billing_present, true, "Billing & Invoice Link is not present on the Manage Page");

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

		boolean Subscription_present;
		try {
			Mn.getSubscription();
			Subscription_present = true;
			Log.info("Subscription link is present on the Manage Page");

		} catch (NoSuchElementException e) {
			Subscription_present = false;
			Log.error("Subscription link is not present on the Manage Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Subscription_present, true, "Subscription Link is not present on the Manage Page");
	}

	@Test(priority = 3, dependsOnMethods = { "ValidateLogin" })

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

		Insight In = new Insight(driver);

		boolean Dashboard_present;
		try {
			In.getDashboard();
			Dashboard_present = true;
			Log.info("Dashboard Link is present on the Insight Page");

		} catch (NoSuchElementException e) {
			Dashboard_present = false;
			Log.error("Dashboard Link is not present on the Insight Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Dashboard_present, true, "Dashboard Link is not present on the Insight Page");

		boolean Report_present;
		try {
			In.getReports();
			Log.info("Report Link is present on the Insight Page");
			Report_present = true;

		} catch (NoSuchElementException e) {

			Report_present = false;
			Log.error("Report Link is not present on the Insight Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Report_present, true, "Report Link is not present on the Dashboard Page");
	}

	@Test(priority = 4, dependsOnMethods = { "ValidateLogin" })

	public void ValidateNotificationPage() throws InterruptedException {

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
/*
		boolean Notificationbtn_present;
		try {
			Np.getNotification_btn();
			Log.info("Notification Settings button is present on the Notifications page");
			Notificationbtn_present = true;

		} catch (NoSuchElementException e) {
			Notificationbtn_present = false;
			Log.error("Notification Settings button is not present on the Notifications page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Notificationbtn_present, true, "Notification btn is not Present in the Notification Page");
		
		
		*/
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

	@Test(priority = 5, dependsOnMethods = { "ValidateLogin" })

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

	@Test(priority = 6, dependsOnMethods = { "ValidateLogin" })

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

	@Test(priority = 7, dependsOnMethods = { "ValidateLogin" })

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

	@Test(priority = 8, dependsOnMethods = { "ValidateLogin" })

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

	@Test(priority = 9, dependsOnMethods = { "ValidateLogin" },enabled=false)

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

	@Test(priority = 10, dependsOnMethods = { "ValidateLogin" })

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

	@Test(priority = 11, dependsOnMethods = { "ValidateLogin" })

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

	@Test(priority = 12, dependsOnMethods = { "ValidateLogin" },enabled=false)

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

	@Test(priority = 13, dependsOnMethods = { "ValidateLogin" })

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
			Thread.sleep(5000);
			Address_heading = true;
			Log.info("Address of Use heading is present on the Address Page");

		} catch (Exception e) {
			Address_heading = false;
			Log.error("Address of Use heading is present on the Address Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Address_heading, true, "Address of Use heading is present on the Address Page");
	}

	@Test(priority = 14, dependsOnMethods = { "ValidateLogin" })

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
		// Assert.assertEquals(us.gettabs().size(), 3, "Address of Use heading is
		// present on the Address Page");
		Assert.assertEquals(a, 3, "3 Tabs are not appearing on the Users Page");

	}

	@Test(priority = 15, dependsOnMethods = { "ValidateLogin" })

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

	@Test(priority = 16, dependsOnMethods = { "ValidateLogin" })

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

	@Test(priority = 17, dependsOnMethods = { "ValidateLogin" })

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

	@Test(priority = 18, dependsOnMethods = { "ValidateLogin" })

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

	@Test(priority = 19, dependsOnMethods = { "ValidateLogin" })

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
			Assert.assertEquals(email_present, true, "Email text box is present on the Registeration Page");

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
				Assert.assertEquals(VerifyBtn_present, true, "Email text box is present on the Registeration Page");

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

	@Test(priority = 20,enabled=false)

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

	@Test(priority = 21,enabled=false)

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

		// }
		// MenuList_present = true;
		// Log.info("User has clicked on Account menu and validating the options
		// appearing underneath it");
		// } catch (Exception e) {
		// MenuList_present = false;
		// Log.error("User not able to click on the My Account link on the dashboard");
		// Log.error(e.getMessage());
		// }

		// Assert.assertEquals(MenuList_present, true,"User not able to pick list of
		// values from My account list");

		// for(int b = 0 ; b<4;b++)
		// {
		// Assert.assertEquals(Menu_txt[b].equals(Menu_txtexp[b]), true,"The Options
		// appearing in the menu is different from the expected result");
		// }

	}




 @AfterTest()

 public void closebrowser()

 {
 driver.close();
 }

}