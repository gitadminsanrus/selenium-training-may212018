package ca.sanrus.automation.pageobjectmodel;

import java.util.Calendar;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import ca.sanrus.automation.pageobjectmodel.AirCanadaHomePage.Language;
import ca.sanrus.automation.pageobjectmodel.FlightsTab.TripType;

@RunWith(JUnit4.class)
public class FindFlightsTestSuite {
	
	@Test
	public void testRoundTripSearchFlights() {
		AirCanadaHomePage homePage = new AirCanadaHomePage(Language.ENGLISH);
		FlightsTab flightsTab = homePage.selectFlightsTab(TripType.ONE_WAY);
		flightsTab.setFromCity("YYZ");
		flightsTab.setToCity("YYC");
		flightsTab.setDepartureDate(2018, 10, 10);
		
//		homePage.closePage();
		
		
//		Calendar calendar = Calendar.getInstance(Locale.CANADA);
//		String dateAsString = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.HOUR);
//		System.out.println(dateAsString);
		
		
	}
	
//	@Test
//	public void testSingleTripSearchFlights() {
//		AirCanadaHomePage homePage = new AirCanadaHomePage(Language.FRENCH);
//		FlightsTab flightsTab = homePage.selectFlightsTab(TripType.ONE_WAY);
//	}

}
