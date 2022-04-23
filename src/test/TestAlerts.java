package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAlerts extends BaseClass {

	@Test(description = "test to verify alerts")
	public void verifyAlerts() throws InterruptedException {
		// to navigate to the website
		System.out.println("Navigating to the website");
		driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");

		// to click the button to get demo alert
		System.out.println("Clicking launch alert button");
		driver.findElement(By.xpath("(//button[contains(text(),'Click Me')])[3]")).click();

		// wait to let the alert be visible
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());

		// to fetch the alert body content and verify it
		System.out.println("Fetching the alert body content and asserting it");
		String alertBodyText = driver.switchTo().alert().getText();
		Assert.assertEquals(alertBodyText, "Please enter your name", "Verify alert body content");

		// to enter data as required by the alert
		System.out.println("Entering date in the alert input box");
		driver.switchTo().alert().sendKeys("Lambdatest");

		// to accept the alert
		System.out.println("Accepting the alert");
		driver.switchTo().alert().accept();

	}
}
