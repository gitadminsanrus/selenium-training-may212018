package ca.sanrus.automation.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.WebDriverUtil;

public class FramedWindowsDemo {

	public static void main(String[] args) {
		
		WebDriver webDriver = WebDriverUtil.getWebDriver(Browser.FIREFOX);
		webDriver.navigate().to("file:///Users/sanrustrainingcentre/Development/selenium-training-may212018/SeleniumTraining/src/ca/sanrus/automation/windows/framed_page.html");
		
		webDriver.switchTo().frame(0);
		
		WebElement headerEmailTextElement = webDriver.findElement(By.id("subscribe_header_email"));
		headerEmailTextElement.sendKeys("HEADER_EMAIL@DOMAIN.COM");
		
		webDriver.switchTo().parentFrame();
		webDriver.switchTo().frame(1);

		WebElement contentEmailTextElement = webDriver.findElement(By.id("subscribe_content_email"));
		contentEmailTextElement.sendKeys("CONTENT_EMAIL@DOMAIN.COM");
	}

}
