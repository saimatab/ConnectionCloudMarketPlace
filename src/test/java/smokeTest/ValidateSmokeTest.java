package smokeTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.Footer;
import pageObjects.ForgetPswdPage;
import pageObjects.Header;
import pageObjects.HomePage;
import pageObjects.Insight;
import pageObjects.LoginPage;
import pageObjects.MyProfilePage;
import pageObjects.NotificationPage;

import pageObjects.RegisterationPage;

import pageObjects.Manage;
import resources.base;

public class ValidateSmokeTest extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	public HomePage hp;

	public WebDriver driver;
	private WebElement HeaderSection;

	@Test(priority = 0)

	public void ValidateLogin() throws IOException, InterruptedException {
		driver = initializeDriver();

		String TitleHome = driver.getTitle();
		Log.info("The title of the home page is captured");

		Assert.assertEquals(TitleHome, "Shop - CCP", "User is not being able to Login to the application");
		Log.info("The title of the Shop page is Verified Successfully");
	}

	@Test(priority = 1, dependsOnMethods = { "ValidateLogin" })

	public void ValidateMarkITPlacePage() throws InterruptedException {
		// Header hd = new Header(driver);
		HomePage hm = new HomePage(driver);
		boolean MarketPlace_present;
		try {
			hm.getMarketPlace_Link().click();
			Log.info("From the Home Page User has Clicked on MarkITPlace tab");
			MarketPlace_present = true;

		} catch (NoSuchElementException e) {
			MarketPlace_present = false;
			Log.error("User not able to find MarkITPlace Link , hence not able to click it");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(MarketPlace_present, true, "MarketPlace Link is not Present in the Dashboard");

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
			Manage_present = true;

		} catch (NoSuchElementException e) {
			Manage_present = false;
		}
		Assert.assertEquals(Manage_present, true, "Manage Link is not Present in the home Dashboard");

		String Manage_Titleact = driver.getTitle().trim();
		String Manage_Titlexp = "Manage - CCP";
		Assert.assertEquals(Manage_Titleact, Manage_Titlexp, "Manage Page is not getting open");

		Manage Mn = new Manage(driver);

		boolean Billing_present;
		try {
			Mn.getBilling_Link();
			Billing_present = true;

		} catch (NoSuchElementException e) {
			Billing_present = false;
		}
		Assert.assertEquals(Billing_present, true, "Billing & Invoice Link is not present on the Manage Page");

		boolean Calendar_present;
		try {
			Mn.getCalendar();
			Calendar_present = true;

		} catch (NoSuchElementException e) {
			Calendar_present = false;
		}
		Assert.assertEquals(Calendar_present, true, "Calendar Link is not present on the Manage Page");

		boolean Subscription_present;
		try {
			Mn.getSubscription();
			Subscription_present = true;

		} catch (NoSuchElementException e) {
			Subscription_present = false;
		}
		Assert.assertEquals(Subscription_present, true, "Subscription Link is not present on the Manage Page");
	}

	@Test(priority = 3, dependsOnMethods = { "ValidateLogin" })

	public void ValidateInsightTab() throws InterruptedException {
		// Header hd = new Header(driver);
		HomePage hm = new HomePage(driver);

		// WebDriverWait wt = new WebDriverWait(driver, 20);

		// hm.getMarketPlace_Link().click();

		boolean insight_present;
		try {
			hm.getInsight_Link().click();
			insight_present = true;

		} catch (NoSuchElementException e) {
			insight_present = false;
		}
		Assert.assertEquals(insight_present, true, "Insight Link is not Present in the home Dashboard");

		String Insight_Titleact = driver.getTitle().trim();
		String Insight_Titlexp = "Insights - CCP";
		Assert.assertEquals(Insight_Titleact, Insight_Titlexp, "Insight Page is not getting open");

		Insight In = new Insight(driver);

		boolean Dashboard_present;
		try {
			In.getDashboard();
			Dashboard_present = true;

		} catch (NoSuchElementException e) {
			Dashboard_present = false;
		}
		Assert.assertEquals(Dashboard_present, true, "Dashboard Link is not present on the Insight Page");

		boolean Report_present;
		try {
			In.getReports();
			Report_present = true;

		} catch (NoSuchElementException e) {
			Report_present = false;
		}
		Assert.assertEquals(Report_present, true, "Report Link is not present on the Dashboard Page");
	}

	@Test(priority = 4, dependsOnMethods = { "ValidateLogin" })

	public void ValidateNotificationPage() throws InterruptedException {

		Header hd = new Header(driver);

		boolean Notification_present;
		try {
			hd.getNotification().click();
			Notification_present = true;

		} catch (NoSuchElementException e) {
			Notification_present = false;
		}
		Assert.assertEquals(Notification_present, true, "Notification Link is not Present in the home Dashboard");

		NotificationPage Np = new NotificationPage(driver);

		boolean Notificationbtn_present;
		try {
			Np.getNotification_btn();
			Notificationbtn_present = true;

		} catch (NoSuchElementException e) {
			Notificationbtn_present = false;
		}
		Assert.assertEquals(Notificationbtn_present, true, "Notification btn is not Present in the Notification Page");
		boolean Notificationheading_present;
		try {
			Np.getNotification_heading();
			Notificationheading_present = true;

		} catch (NoSuchElementException e) {
			Notificationheading_present = false;
		}
		Assert.assertEquals(Notificationheading_present, true,
				"Notification heading is not Present in the Notification Page");

		boolean AllNotification_present;
		try {
			Np.getAll_Notification();
			AllNotification_present = true;

		} catch (NoSuchElementException e) {
			AllNotification_present = false;
		}
		Assert.assertEquals(AllNotification_present, true,
				"All notification tab is not Present in the Notification Page");

		boolean Falgged_present;
		try {
			Np.getFlagged();
			Falgged_present = true;

		} catch (NoSuchElementException e) {
			Falgged_present = false;
		}
		Assert.assertEquals(Falgged_present, true, "Flagged tab is not Present in the Notification Page");
	}

	@Test(priority = 5, dependsOnMethods = { "ValidateLogin" })

	public void ValidateLogo() throws InterruptedException {

		NotificationPage Np = new NotificationPage(driver);

		boolean Logo_present;
		try {
			Np.getLogo().click();
			Logo_present = true;

		} catch (NoSuchElementException e) {
			Logo_present = false;
		}
		Assert.assertEquals(Logo_present, true, "Logo is not Present in the home Dashboard");

		String Shop_Titleact = driver.getTitle().trim();
		String Shop_Titlexp = "Shop - CCP";
		Assert.assertEquals(Shop_Titleact, Shop_Titlexp, "Clicking on Logo is not redirecting to the Shop Page");
	}

	@Test(priority = 6, dependsOnMethods = { "ValidateLogin" })

	public void ValidateLogout() throws InterruptedException {

		Header hd = new Header(driver);

		boolean AccountMenu_present;
		try {
			hd.getAccountMenu().click();
			AccountMenu_present = true;

		} catch (Exception e) {
			AccountMenu_present = false;
		}
		Assert.assertEquals(AccountMenu_present, true, "Account Menu is not Present in the home Dashboard");

		boolean Logout_present;
		try {
			hd.getLogout().click();
			Logout_present = true;

		} catch (Exception e) {
			Logout_present = false;
		}

		Assert.assertEquals(Logout_present, true, "Logout is not Present in the home Dashboard under My Account Menu");

		String Shop_Titleact = driver.getTitle().trim();
		String Shop_Titlexp = "CCP Login";
		Assert.assertEquals(Shop_Titleact, Shop_Titlexp, "User is not being able to Signout from the application");
	}

	@Test(priority = 7, dependsOnMethods = { "ValidateLogin" })

	public void ValidateForgetPswd() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);

		boolean ForgetPswd_present;
		// String New_tab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		try {
			lp.getForget_Pswd().click();
			ForgetPswd_present = true;
			Thread.sleep(5000);

		} catch (Exception e) {
			ForgetPswd_present = false;
		}
		Assert.assertEquals(ForgetPswd_present, true, "Forget Password link is not Present in the Login Page");

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

		} catch (Exception e) {
			email_present = false;
		}
		Assert.assertEquals(email_present, true, "Email Address textbox is not Present in the Forget password Page");

		boolean SbmtBtn_present;
		// String New_tab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		try {
			fp.getSbmt_Btn().click();

			SbmtBtn_present = true;

		} catch (Exception e) {
			SbmtBtn_present = false;
		}
		Assert.assertEquals(SbmtBtn_present, true, "Submit button is not Present in the Forget password Page");
		boolean validation_present;
		// String New_tab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		try {
			fp.getValidation_Message();

			validation_present = true;

		} catch (Exception e) {
			validation_present = false;
		}
		Assert.assertEquals(validation_present, true,
				"Validation messages are not appearing in the Forget password Page");
	}

	@Test(priority = 8, dependsOnMethods = { "ValidateLogin" })

	public void ValidateRegPage() throws InterruptedException {
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		boolean CreateAcc_present;
		try {
			lp.getCreate_Account().click();
			CreateAcc_present = true;

		} catch (Exception e) {
			CreateAcc_present = false;
		}
		Assert.assertEquals(CreateAcc_present, true, "Create Account link is not Present in the Login Page");

		if (CreateAcc_present == true) {
			String Registeration_Titleact = driver.getTitle().trim();
			String Registeration_Titleexp = "CCP Signup";
			Assert.assertEquals(Registeration_Titleact, Registeration_Titleexp,
					"User is not being able to reach Registeration page");

			RegisterationPage Rp = new RegisterationPage(driver);
			boolean email_present;
			try {
				Rp.getemail();
				email_present = true;

			} catch (Exception e) {
				email_present = false;
			}
			Assert.assertEquals(email_present, true, "Email text box is present on the Registeration Page");

			if (email_present == true) {
				boolean VerifyBtn_present;
				try {
					Rp.getVerify_btn().click();
					VerifyBtn_present = true;

				} catch (Exception e) {
					VerifyBtn_present = false;
				}
				Assert.assertEquals(VerifyBtn_present, true, "Email text box is present on the Registeration Page");

				if (VerifyBtn_present == true) {
					boolean ValidationMsg_present;
					try {
						Rp.getValidation_Msg();
						ValidationMsg_present = true;

					} catch (Exception e) {
						ValidationMsg_present = false;
					}
					Assert.assertEquals(ValidationMsg_present, true,
							"Validation Message is not appearing on the registeration Page");
				}
			}
		}
	}

	@AfterTest

	public void closebrowser()

	{
		driver.close();
	}
}
