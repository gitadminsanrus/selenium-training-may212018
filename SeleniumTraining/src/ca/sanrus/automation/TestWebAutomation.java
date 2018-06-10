package ca.sanrus.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWebAutomation {

	public static void main(String[] args) {
		
		//Firefox gecko driver must be set in the system's property, so that the web driver can recognize and launch the browser.
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");

		//the following statement will launch Firefox browser
		WebDriver webDriver = new FirefoxDriver();
		
		//loading a web page
		webDriver.get("https://www.google.ca/");
		
		//find search text web element on Google search web page
		WebElement webElementSearchText = webDriver.findElement(By.id("lst-ib"));
		
		//enter the search text "Google"
		webElementSearchText.sendKeys("Google");
		
		//after the search text is entered, do submit(), this will simulate pressing of "Enter" key
		webElementSearchText.submit();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//verification of the search page
		//1. Verify by the URL
		String url = webDriver.getCurrentUrl();
		
		//2. verify by title
		String pageTitle = webDriver.getTitle();
		
		System.out.println("Page URL = " + url);
		System.out.println("Page Title = " + pageTitle);
		
		
//		//closes only the current window
//		webDriver.close();
//		
//		//closes all windows and quits the browser
//		webDriver.quit();

	}

}
