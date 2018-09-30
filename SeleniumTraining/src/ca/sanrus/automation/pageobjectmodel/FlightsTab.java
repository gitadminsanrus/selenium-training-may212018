package ca.sanrus.automation.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightsTab {
	
	public enum TripType {
		ROUND_TRIP,
		ONE_WAY,
		MULTI_CITY
	}
	
	public enum TravelType {
		ECONOMY,
		BUSINESS
	}
		
	private WebElement fromCity;
	private WebElement toCity;
	private WebElement departureDate;
	private WebElement arrivalDate;
	private WebElement passengerCount;
	private WebElement travelType;
	private TripType tripType;
	private WebElement roundTripRadioButton;
	private WebElement oneWayTripRadioButton;
	private WebElement multiCityTripRadioButton;
	
	private WebDriver webDriver;
	
	public FlightsTab(WebDriver webDriver, TripType tripType) {
		
		this.webDriver = webDriver;
	
		fromCity = webDriver.findElement(By.id("origin_R_0"));
		toCity = webDriver.findElement(By.id("destination_R_0"));
		roundTripRadioButton = webDriver.findElement(By.id("roundTrip"));
		oneWayTripRadioButton = webDriver.findElement(By.id("oneWay"));
		multiCityTripRadioButton = webDriver.findElement(By.id("multiCity"));
		departureDate = webDriver.findElement(By.className("sr-only-depart-date-0"));
		
		if (tripType == TripType.ROUND_TRIP) {
			roundTripRadioButton.click();
		} else if (tripType == TripType.MULTI_CITY) {
			multiCityTripRadioButton.click();
		} else if (tripType == TripType.ONE_WAY) {
			oneWayTripRadioButton.click();
		} else {
			throw new RuntimeException("Invalid trip type. [tripType=" + tripType + "]");
		}
		
		this.tripType= tripType;
	}
	
	public void setToCity(String cityCode) {
		toCity.sendKeys(cityCode);
	}
	
	public void setFromCity(String cityCode) {
		fromCity.sendKeys(cityCode);
	}
	
	public void setDepartureDate(int year, int month, int day) {
		departureDate.click();
		AirCanadaCalendar airCanadaCalendar = new AirCanadaCalendar(webDriver);
		airCanadaCalendar.setDate(year, month, day);
	}
	
	

}
