package ca.sanrus.automation.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.WebDriverUtil;

public class AlertDialogDemo {

	public static void main(String[] args) {
		
		WebDriver webDriver = WebDriverUtil.getWebDriver(Browser.CHROME);
		webDriver.navigate().to("https://amazon.ca/");
		
		//simulating an alert dialog using JavaScriptExecutor
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript("alert('Hello')");
		
		Alert alert = webDriver.switchTo().alert();
		System.out.println(alert.getText());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		alert.accept();

	}

}
