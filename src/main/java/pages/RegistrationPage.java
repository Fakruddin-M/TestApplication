package pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import commonUtilities.Base;

public class RegistrationPage extends Base {
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	@FindBy(how = How.ID, using = "input-firstname")
	private WebElement txt_firstName;

	@FindBy(how = How.ID, using = "input-lastname")
	private WebElement txt_lastName;

	@FindBy(how = How.ID, using = "input-email")
	private WebElement txt_email;

	@FindBy(how = How.ID, using = "input-telephone")
	private WebElement txt_phone;

	@FindBy(how = How.ID, using = "input-password")
	private WebElement txt_password;

	@FindBy(how = How.ID, using = "input-confirm")
	private WebElement txt_confirmPassword;

	@FindBy(how = How.NAME, using = "agree")
	private WebElement ckb_terms;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement btn_continue;

	@FindBy(how = How.XPATH, using = "//h1[text()='Your Account Has Been Created!']")
	private WebElement lbl_message;

	public void createNewUser(Map<String, String> userDetails) {
		txt_firstName.sendKeys(userDetails.get("firstname"));
		txt_lastName.sendKeys(userDetails.get("lastName"));
		txt_email.sendKeys(userDetails.get("email"));
		txt_phone.sendKeys(userDetails.get("phone"));
		txt_password.sendKeys(userDetails.get("password"));
		txt_confirmPassword.sendKeys(userDetails.get("password"));
		ckb_terms.click();
		btn_continue.click();
		waitForPageLoad();
		waitUntilElementVisibleByFluentWait(lbl_message, 20);
		takeSnapShot(path + "\\user.jpeg");
		if (lbl_message.isDisplayed()) {
			System.out.println("User is created");

		} else {
			System.out.println("Unable to create user");
		}
	}
}
