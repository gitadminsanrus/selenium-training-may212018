package ca.sanrus.automation.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.WebDriverUtil;

public class PromptDialogDemo {

	public static void main(String[] args) {
		WebDriver webDriver = WebDriverUtil.getWebDriver(Browser.CHROME);
		webDriver.navigate().to("https://amazon.ca/");
		
		//simulating an alert dialog using JavaScriptExecutor
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("prompt('Enter number from 1 to 10')");
		
		Alert alert = webDriver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.sendKeys("1");
//		alert.dismiss();//for cancel button
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		alert.accept();//for OK button

	}

}
