package smokeTesting;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonUtilities.Base;
import commonUtilities.DriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccount;
import pages.RegistrationPage;

public class RegistrationTestCases {
	@Test
	public void createNewUser() throws Exception {
		DriverManager d = new DriverManager();
		WebDriver driver = d.launchDriver();

		Base base = new Base(driver);
		base.createReportFolder();

		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.launchUrl("https://tutorialsninja.com/demo/index.php?route=common/home");
		homepage.navigateToRegistrationPage();

		RegistrationPage regPage = PageFactory.initElements(driver, RegistrationPage.class);

		Map<String, String> details = new HashMap<String, String>();
		details.put("firstname", "FN_" + RandomStringUtils.random(5, true,true));
		details.put("lastName", "LN_" + RandomStringUtils.random(4, true, true));
		details.put("email", "testemail" + RandomStringUtils.random(4, true, true) + "@gmail.com");
		details.put("phone", "1234567");
		details.put("password", "Test@1234");

		regPage.createNewUser(details);
		
		MyAccount myAcc = PageFactory.initElements(driver, MyAccount.class);
		myAcc.logOut();
		
		homepage.navigateToLoginPage();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.verifyValidLogin(details.get("email"), details.get("password"));
		
		driver.quit();
		

	}
}
