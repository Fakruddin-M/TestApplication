package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import commonUtilities.Base;

public class HomePage extends Base {
WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li/a")
private List<WebElement> nav_link;

@FindBy(how = How.XPATH, using = "//span[text()='My Account']")
private WebElement lnk_myaccount;


@FindBy(how = How.XPATH, using = "//a[text()='Login']")
private WebElement lnk_login;

@FindBy(how = How.XPATH, using = "//a[text()='Register']")
private WebElement lnk_register;

public void verifyNavigationLinks() {
	for(WebElement ele : nav_link ) {
		
		String text = ele.getText();
		System.out.println(text);
	}
	
}

public void launchUrl(String url) {
	driver.get(url);
	waitForPageLoad();

	
}
public void navigateToLoginPage() {
	
	lnk_myaccount.click();
	clickUsingJavaScript(lnk_login);
	waitForPageLoad();
	
}
public void navigateToRegistrationPage() {
	lnk_myaccount.click();
	lnk_register.click();
	waitForPageLoad();
	

}
}

