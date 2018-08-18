package ca.sanrus.automation.cookies;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import ca.sanrus.automation.constant.Browser;
import ca.sanrus.automation.util.WebDriverUtil;

public class CookieHandlingDemo {

	public static void main(String[] args) {
		
		WebDriver webDriver = WebDriverUtil.getWebDriver(Browser.CHROME);
		webDriver.navigate().to("https://www.youtube.com");
		
		Cookie mycookie = new Cookie.Builder("my_cookie", "cookie1234567890")
									.build();
		
		Cookie gpsCookie = new Cookie("GPS", "123");
		
		webDriver.manage().deleteAllCookies();
		webDriver.manage().addCookie(mycookie);
		
		Set<Cookie> cookies = webDriver.manage().getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + "=" + cookie.getValue());
		}
		
		System.out.println("=================================");
		webDriver.findElement(By.id("video-title")).click();
		
		cookies = webDriver.manage().getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + "=" + cookie.getValue());
		}

	}

}
