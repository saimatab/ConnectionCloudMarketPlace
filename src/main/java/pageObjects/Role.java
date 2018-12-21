package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Role {

	public WebDriver driver;

	public Role(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By AddNewRole = By.xpath("//a[text()='Add New Role']");
	
	By CancelBtn=By.xpath("//button[text()='Cancel']");

	
	public WebElement getAddRoleBtn() {
		return driver.findElement(AddNewRole);
	}
	
	public WebElement getCancelBtnBtn() {
		return driver.findElement(CancelBtn);
	}
	

}
