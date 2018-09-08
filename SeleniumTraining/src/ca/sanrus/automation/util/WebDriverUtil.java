package ca.sanrus.automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ca.sanrus.automation.constant.Browser;

public class WebDriverUtil {
	
	public static WebDriver getWebDriver(Browser browser) {
		WebDriver webDriver = null;		
		if (browser != null) {

			String osName = System.getProperty("os.name").toLowerCase();
			String cpuArchitecture = System.getProperty("os.arch").toLowerCase();
			String driverPath = "drivers/";
			boolean is32Bit = cpuArchitecture.equalsIgnoreCase("x86");
			
			switch(browser) {
				case FIREFOX:
					if (osName.contains("win")) {
						if (is32Bit) {
							driverPath = driverPath + "geckodriver-32bit.exe";
						} else {
							driverPath = driverPath + "geckodriver-64bit.exe";							
						}
						
					} else if (osName.contains("mac")) {
						driverPath = driverPath + "geckodriver-macos";
					}
					
					System.setProperty("webdriver.gecko.driver", driverPath);
					
					webDriver = new FirefoxDriver();
					break;
					
				case IE:
					
					if (osName.contains("mac")) {
						throw new RuntimeException("Internet Explorer cannot be launched in Mac OS");
					}
					break;
					
				case SAFARI:
					break;
					
				case CHROME:
					if (osName.contains("mac")) {
						driverPath += "chromedriver";
					} else {
						throw new RuntimeException("Chrome driver is not set for OS = " + osName);
					}
					
					System.setProperty("webdriver.chrome.driver", driverPath);
					webDriver = new ChromeDriver();
					
					break;
			}
			
			
		}
		
		return webDriver;
	}

}
