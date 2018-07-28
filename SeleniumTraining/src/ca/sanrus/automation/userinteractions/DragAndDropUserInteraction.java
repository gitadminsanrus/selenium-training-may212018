package ca.sanrus.automation.userinteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.WebDriverUtil;

public class DragAndDropUserInteraction {

	public static void main(String[] args) {
		
		WebDriver webDriver = WebDriverUtil.getWebDriver(Browser.FIREFOX);
		webDriver.navigate().to("https://google.github.io/closure-library/source/closure/goog/demos/drag.html");
		
		WebElement win1BarElement = webDriver.findElement(By.xpath("//div[@id='win1']//div[@class='bar']"));
		WebElement win2BarElement = webDriver.findElement(By.xpath("//div[@id='win2']//div[@class='bar']"));
		WebElement win3BarElement = webDriver.findElement(By.xpath("//div[@id='win3']//div[@class='bar']"));
		
		int x = win2BarElement.getLocation().x;
		int y = win3BarElement.getLocation().y;
		
		Actions sequenceOfActions = new Actions(webDriver);
		Action moveToAction = sequenceOfActions
									.clickAndHold(win1BarElement)
									.dragAndDropBy(win2BarElement, x, y)
									.release(win1BarElement)
									.build();
		
		moveToAction.perform();

	}

}
