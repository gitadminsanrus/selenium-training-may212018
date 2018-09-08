package ca.sanrus.automation.webdriver.junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.ScreenshotUtil;
import ca.sanrus.automation.util.WebDriverUtil;

public class BmoHomePageTestSuite {
	
	private static final String HOME_PAGE_URL = "https://www.bmo.com/main/personal";
	private static final String HEADER_TEXT_CLASS_NAME = "nav-mobile-copy";
	
	private static WebDriver webDriver;
	
	@BeforeClass
	public static void setUp() {
		webDriver = WebDriverUtil.getWebDriver(Browser.CHROME);
		webDriver.navigate().to(HOME_PAGE_URL);
	}
	
	@Test
	public void testHeaderText() {
		//find the header text element
		WebElement elementDivHeaderText = webDriver.findElement(By.className(HEADER_TEXT_CLASS_NAME));
		
		//asserting visibility of header text div element
		Assert.assertTrue("Test Failed!. Header text is not visible on the home page", 
				elementDivHeaderText.isDisplayed());
		
		
		//asserting if the header text is same as expected text value
		Assert.assertEquals("What would you like to do today?", 
								elementDivHeaderText.getText().trim());
		
		
//		Actions sequenceOfActions = new Actions(webDriver);
//		
//		Action action = sequenceOfActions.moveToElement(elementDivHeaderText).build();
//		action.perform();
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("document.getElementsByClassName('" + HEADER_TEXT_CLASS_NAME + "')[0].scrollIntoView()");
		ScreenshotUtil.saveScreenshotAs(webDriver, "BmoHomePageTestSuite_HeaderText_Passed.png");
	}
	
	@AfterClass
	public static void tearDown() {
		webDriver.close();
		webDriver.quit();
	}

}
