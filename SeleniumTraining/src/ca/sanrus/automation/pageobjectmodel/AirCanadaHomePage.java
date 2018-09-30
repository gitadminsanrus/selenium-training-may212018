package ca.sanrus.automation.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.pageobjectmodel.FlightsTab.TripType;
import ca.sanrus.automation.util.WebDriverUtil;

public class AirCanadaHomePage {
	
	public static final String HOME_PAGE_URL = "https://www.aircanada.com/ca/en/aco/home.html";
	
	private WebDriver webDriver;
	
	public enum Language {
		ENGLISH,
		FRENCH
	}
	
	public AirCanadaHomePage(Language language) {
		webDriver = WebDriverUtil.getWebDriver(Browser.CHROME);
		webDriver.navigate().to(HOME_PAGE_URL);
		
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
		WebElement elementLanguageButton = null;
		if (language == Language.ENGLISH) {
			webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("enCAEdition")));
			elementLanguageButton = webDriver.findElement(By.id("enCAEdition"));
		} else if (language == Language.FRENCH) {
			webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("frCAEdition")));
			elementLanguageButton = webDriver.findElement(By.id("frCAEdition"));
		}
		elementLanguageButton.click();
	
	}
	
	public FlightsTab selectFlightsTab(TripType tripType) {
		return new FlightsTab(webDriver, tripType);		
	}
	
	public VacationsTab selectVacationsTab() {
		return new VacationsTab();
	}
	
	public void closePage() {
		webDriver.close();
		webDriver.quit();
	}

}
