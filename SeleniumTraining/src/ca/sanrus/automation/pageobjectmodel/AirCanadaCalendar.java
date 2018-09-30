package ca.sanrus.automation.pageobjectmodel;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

public class AirCanadaCalendar {
	
	private Calendar calendar = Calendar.getInstance(Locale.CANADA);
	
	private HashMap<Integer, WebElement> calendarMap = new HashMap<>();
	
	private WebElement backwardNavArrow;
	private WebElement forwardNavArrow;
	private WebDriver webDriver;
	
	public AirCanadaCalendar(WebDriver webDriver) {
		this.webDriver = webDriver;
		
		int currentMonth = calendar.get(Calendar.MONTH);
		loadElements(currentMonth);
		
		backwardNavArrow = webDriver.findElement(By.className("ui-datepicker-prev"));
		forwardNavArrow = webDriver.findElement(By.className("ui-datepicker-next"));
		
	}
	
	private void loadElements(int startMonth) {
		calendarMap.clear();
		
		List<WebElement> calendars = webDriver.findElements(By.className("ui-datepicker-calendar"));
		
		calendarMap.put(startMonth, calendars.get(0));
		calendarMap.put(startMonth + 1, calendars.get(1));
	}
	
	public void setDate(int year, int month, int day) {
		
		WebElement calendar = calendarMap.get(month - 1);
		if (calendar == null) {
			forwardCalendar(year, month);
		}
		
		List<WebElement> tdTags = webDriver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		
		for (WebElement tdTag : tdTags) {
			String dataMonth = tdTag.getAttribute("data-month");
			String dataYear = tdTag.getAttribute("data-year");
			String dataDay = tdTag.getText().trim();
			
			if (dataMonth.equals(String.valueOf(month - 1))
					&& dataYear.equals(String.valueOf(year))
					&& dataDay.equals(String.valueOf(day))) {
				tdTag.click();
				break;
			}
			
		}
		
	}
	
	private void forwardCalendar(int year, int month) {
		forwardNavArrow.click();
		
	}

}



















