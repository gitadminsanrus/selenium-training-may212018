package ca.sanrus.automation.windows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.WebDriverUtil;

public class HandlingWindowsDemo {

	public static void main(String[] args) {
		
		WebDriver driver = WebDriverUtil.getWebDriver(Browser.FIREFOX);
		driver.navigate().to("file:///Users/sanrustrainingcentre/Development/selenium-training-may212018/SeleniumTraining/src/ca/sanrus/automation/windows/test_windows.html");
		
		//maximizes the browser window to maximum resolution
		driver.manage().window().maximize();
		
		WebElement paymentPageLink = driver.findElement(By.linkText("Payment Page"));
		paymentPageLink.click();
		
		//switching to newly opened browser tab/window
		String currentWindowId = driver.getWindowHandle();
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {
			if (currentWindowId.equals(windowId)) {
				continue;
			}
			driver.switchTo().window(windowId);
			break;
		}
		
		
		WebElement creditCardNumber = driver.findElement(By.id("credit_card_number"));
		creditCardNumber.sendKeys("1234567890");
		driver.close();

	}

}
