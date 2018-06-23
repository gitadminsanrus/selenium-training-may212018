package ca.sanrus.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.ScreenshotUtil;
import ca.sanrus.automation.util.WebDriverUtil;

public class TestWebAutomation {

	public static void main(String[] args) {
		
		WebDriver webDriver = WebDriverUtil.getWebDriver(Browser.FIREFOX);
		webDriver.navigate().to("https://google.com/");
		
		WebElement searchText = webDriver.findElement(By.id("lst-ib"));
		
		//Typing characters onto a text web element
		searchText.sendKeys("Google search");
		
		//submit the entered text
		searchText.submit();
		
		ScreenshotUtil.saveScreenshotAs(webDriver, "test.png");
		
		searchText = webDriver.findElement(By.id("lst-ib"));
		searchText.clear();
		searchText.sendKeys("Microsoft");
		searchText.submit();
		
		ScreenshotUtil.saveScreenshotAs(webDriver, "test_1.png");
		
		
	}

}
