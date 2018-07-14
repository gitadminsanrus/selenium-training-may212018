package ca.sanrus.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.WebDriverUtil;

public class XpathDemo {

	public static void main(String[] args) {
		
		WebDriver chromeWebDriver = WebDriverUtil.getWebDriver(Browser.CHROME);
		chromeWebDriver.navigate().to("https://www.bmo.com/main/personal");
		
		
		//locate web element by XPath ID
		WebElement findACreditCardWebElement 
					= chromeWebDriver.findElement(By.xpath("//div[@id='homepage-homenav-creditcard-wrapper']"));
		
//		findACreditCardWebElement.click();
		
		//locate web element using XPath contains(), (OR and AND) combination
		WebElement exploreMortgagesWebElement 
					= chromeWebDriver.findElement(By.xpath("//*[@class='icon-wrapper'][@id='homepage-homenav-mortgage-wrapper']"));
		
		//Example XPaths:
		/*
		 * child: (//div[@class='iconnav iconnav-home']//child::a)[4] => This selects 4th hyper link
		 * 
		 */
		
		exploreMortgagesWebElement.click();
	}

}
