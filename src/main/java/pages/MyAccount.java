package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import commonUtilities.Base;

public class MyAccount extends Base {

	WebDriver driver;

	public MyAccount(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='My Account']")
	private WebElement lnk_myAccount;

	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu dropdown-menu-right']//li/a")
	private List<WebElement> lnk_myAccountOptions;

	@FindBy(how = How.XPATH, using = "//li/a[text()='Logout']")
	private WebElement lnk_logout;

	@FindBy(how = How.XPATH, using = "//h1[text()='Account Logout']")
	private WebElement lbl_logoutMessage;

	public void verifyMyAccountOptions() {
		lnk_myAccount.click();

		for (WebElement ele : lnk_myAccountOptions) {
			String text = ele.getText();
			System.out.println(text);

		}

		lnk_logout.click();

	}

	public void logOut() {
		lnk_myAccount.click();
		lnk_logout.click();
		waitUntilElementIsVisible(lbl_logoutMessage, 10);

		if (lbl_logoutMessage.isDisplayed()) {
			System.out.println("Logout is success");
		} else {
			System.out.println("Logout Failed");
		}

	}

}
