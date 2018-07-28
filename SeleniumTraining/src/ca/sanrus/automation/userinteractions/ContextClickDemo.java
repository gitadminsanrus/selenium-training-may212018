package ca.sanrus.automation.userinteractions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.WebDriverUtil;

public class ContextClickDemo {

	public static void main(String[] args) {
		
		WebDriver webDriver = WebDriverUtil.getWebDriver(Browser.FIREFOX);
		webDriver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClickElement = webDriver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions sequenceOfActions = new Actions(webDriver);
		Action action = sequenceOfActions
							.contextClick(rightClickElement)
							.build();
		action.perform();
		
		WebElement editContextItem = webDriver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit']"));
		editContextItem.click();
		
		//click on 'ok' button from alert dialog
		Alert alertDialog = webDriver.switchTo().alert();
		System.out.println(alertDialog.getText());
		alertDialog.accept();
		

	}

}
