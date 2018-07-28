package ca.sanrus.automation.userinteractions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.WebDriverUtil;

public class MultipleSelectMenuSelectionsDemo {

	public static void main(String[] args) {

		WebDriver webDriver = WebDriverUtil.getWebDriver(Browser.FIREFOX);
		webDriver.navigate().to("file:///Users/santhoshgutta/Desktop/index.html");
		
		WebElement selectMenuElement = webDriver.findElement(By.id("selectMenu"));
		List<WebElement> optionTags = selectMenuElement.findElements(By.tagName("option"));
		
		Actions sequenceOfActions = new Actions(webDriver);
		
		Action action = sequenceOfActions.keyDown(Keys.COMMAND)
		.click(optionTags.get(0))
		.click(optionTags.get(2))
		.keyUp(Keys.COMMAND)
		.build();
		
		action.perform();
	}

}
