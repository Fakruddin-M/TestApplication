package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import commonUtilities.Base;

public class LoginPage extends Base {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "input-email")
	private WebElement txt_email;

	@FindBy(how = How.ID, using = "input-password")
	private WebElement txt_password;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement btn_button;

	@FindBy(how = How.XPATH, using = "//h2[text()='My Account']")
	private WebElement lbl_myAccount;

	@FindBy(how = How.XPATH, using = "//*[@class='alert alert-danger alert-dismissible']")
	private WebElement lbl_errorMessage;

	public void verifyValidLogin(String email, String password) throws Exception {
		txt_email.sendKeys(email);
		txt_password.sendKeys(password);
		btn_button.click();
		Thread.sleep(2000);
		waitForPageLoad();
		if (lbl_myAccount.isDisplayed()) {
			System.out.println("Login is Success");
		} else {
			System.out.println("Login Failed");
		}

	}

	public void verifyInvalidLogin(String email, String password) throws Exception {
		txt_email.sendKeys(email);
		txt_password.sendKeys(password);
		btn_button.click();
		Thread.sleep(2000);
		waitForPageLoad();
		if (lbl_myAccount.isDisplayed()) {
			System.out.println("After enetring invalid login details, getting error message");
		} else {
			System.out.println("After enetring invalid login details, not getting error message");
		}

	}

}
