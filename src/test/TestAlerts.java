package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAlerts extends BaseTest
{
	@Test(description = "test to verify alerts")
	public void verifyAlerts() throws InterruptedException 
	{
		//navigate to the website
		System.out.println("Navigating to the website");
		driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");

		//click the button to get demo alert
		System.out.println("Clicking alert button");
		driver.findElement(By.xpath("(//button[contains(text(),'Click Me')])[1]")).click();

		//wait for the alert be visible
		wait.until(ExpectedConditions.alertIsPresent());

		//fetch the alert body content and assert it
		System.out.println("Fetching the alert body content and asserting it");
		String alertBodyText = driver.switchTo().alert().getText();
		Assert.assertEquals(alertBodyText, "I am an alert box!", "Verify alert body content");

		//accept the alert
		System.out.println("Accepting the alert");
		driver.switchTo().alert().accept();
	}
}
