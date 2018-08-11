package ca.sanrus.automation.storage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.WebDriverUtil;

public class LocalStorageDemo {

	public static void main(String[] args) {
		ChromeDriver webDriver = (ChromeDriver) WebDriverUtil.getWebDriver(Browser.CHROME);
		webDriver.navigate().to("https://amazon.ca/");
		
		LocalStorage localStorage = webDriver.getLocalStorage();
		localStorage.setItem("key1", "VALUE123");
		
		String value = localStorage.getItem("csm-hit");
		System.out.println(value);
	}

}
