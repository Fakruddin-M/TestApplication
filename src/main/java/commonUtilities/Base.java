package commonUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	 WebDriver driver;
	public Base(WebDriver driver) {
		this.driver=driver;
	}
	public static String path;
	
	/**
	 * Method to wait until page load
	 */
	public void waitForPageLoad() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (js.executeScript("return document.readyState").toString().equals("complete")) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to wait explicitly until element visible
	 * 
	 * @param element
	 * @param time
	 */
	public void waitUntilElementIsVisible(WebElement element, int time) {
		new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Method to wait until element visible by fluent wait
	 * 
	 * @param element
	 * @param time
	 */
	public void waitUntilElementVisibleByFluentWait(WebElement element, long time) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		fluentWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickUsingJavaScript(WebElement element ) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	/**
	 * Method to scroll to bottom of the page
	 */
	public void scrollToBottomOfPage() {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to scroll to top of the page
	 */
	public void scrollToTopOfPage() {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method to scroll to element by java script
	 * 
	 * @param locator
	 */
	public void scrollToElementUsingJsExecutor(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void takeSnapShot(String fileWithPath) {
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(fileWithPath);
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {

		}
	}
	
	
	/**
	 * Method to create folder
	 * 
	 * @param path
	 */
	public void CreateFolder(String path) {

		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		} else
			System.out.println("Folder already created");
	}

	/**
	 * Method to get time stamp
	 * 
	 * @return
	 */
	public String Timestamp() {
		Date now = new Date();
		String Timestamp = now.toString().replace(":", "-");
		return Timestamp;
	}

	/**
	 * Method to create reports folder
	 * 
	 * @return
	 */
	public String createReportFolder() {
		path = System.getProperty("user.dir") + "/Reports/" + Timestamp();
		CreateFolder(path);
		return path;

	}
}
