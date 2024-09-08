package smokeTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonUtilities.Base;
import commonUtilities.DriverManager;
import pages.HomePage;

public class HomePageTestCases {
	@Test
	public void verifyHomePageNavigationLinks() {
		DriverManager d = new DriverManager();
		WebDriver driver = d.launchDriver();
		
		Base base = new Base(driver);
		base.createReportFolder();
		
//		HomePage homepage = new HomePage(driver);
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.launchUrl("https://tutorialsninja.com/demo/index.php?route=common/home");
		homepage.scrollToBottomOfPage();
		homepage.scrollToTopOfPage();
		
		homepage.verifyNavigationLinks();
		homepage.navigateToRegistrationPage();
		driver.quit();
		
	}

}
