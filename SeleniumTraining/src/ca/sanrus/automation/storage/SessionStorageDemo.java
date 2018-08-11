package ca.sanrus.automation.storage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.SessionStorage;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.ScreenshotUtil;
import ca.sanrus.automation.util.WebDriverUtil;

public class SessionStorageDemo {

	public static void main(String[] args) {
		
		ChromeDriver chromeDriver = (ChromeDriver) WebDriverUtil.getWebDriver(Browser.CHROME);
		chromeDriver.navigate().to("https://amazon.ca/");
		
		SessionStorage sessionStorage = chromeDriver.getSessionStorage();
		String previousUrl = sessionStorage.getItem("CSM_previousURL");
		System.out.println(previousUrl);
		
		ScreenshotUtil.saveScreenshotAs(chromeDriver, "file_123.png");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) chromeDriver;
		jsExecutor.executeScript("window.scrollBy(0, 500)");
		
		ScreenshotUtil.saveScreenshotAs(chromeDriver, "file_456.png");

	}

}
