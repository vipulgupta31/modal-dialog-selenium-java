package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {

	public RemoteWebDriver driver = null;
	String username = "<lambdatest_username>";
	String accessKey = "lambdatest_accesskey";

	@BeforeMethod
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("version", "92.0");
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("resolution", "1024x768");
		capabilities.setCapability("build", "DialogBoxes And Pop-ups Selenium JAVA");
		capabilities.setCapability("name", "DialogBoxes And Pop-ups Selenium JAVA");

		try {
			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		}

	}

	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
}
