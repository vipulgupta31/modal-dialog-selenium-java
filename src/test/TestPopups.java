package test;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPopups extends BaseTest
{
	@Test(description = "test to verify pop ups")
	public void verifyPopups() throws InterruptedException 
	{
		//navigate to the website
		System.out.println("Navigating to the website");
		driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");

		//fetch and save the handle of current window
		System.out.println("storing the main window handle");
		String mainWindowHandle = driver.getWindowHandle();

		//click the button to get a popup (new tab in this case)
		System.out.println("Clicking launch popup button");
		WebElement followButtonOnMainWindow = driver.findElement(By.xpath("//a[contains(@title,'Twitter')]"));
		followButtonOnMainWindow.click();

		//get the list of all window handles after the new tab
		//should have length 2 since 1 new tab opens up
		System.out.println("Fetching the list of all window handles and asserting them");
		Set<String> windowHandles = driver.getWindowHandles();
		Assert.assertEquals(windowHandles.size(), 2, "Verify the total number of handles");

		//switch to new opened tab
		System.out.println("Switching to the new window handle");
		Iterator<String> itr = windowHandles.iterator();
		while (itr.hasNext()) {
			String childWindowHandle = itr.next();
			// to skip the handle of our main window and switch to new one
			if (!mainWindowHandle.equalsIgnoreCase(childWindowHandle))
				driver.switchTo().window(childWindowHandle);
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Follow']")));
		
		// to verify that driver focus is shifted to popup window
		System.out.println("Asserting some element on the new popup window to confirm switch");
		WebElement twitterFollowButton = driver.findElement(By.xpath("//span[text()='Follow']"));
		Assert.assertTrue(twitterFollowButton.isDisplayed(), "Verify twitter follow button is displayed");

		// shift driver back to main window and verify
		System.out.println("Switching back to main window and asserting same");
		driver.switchTo().window(mainWindowHandle);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,'Twitter')]")));
		Assert.assertTrue(followButtonOnMainWindow.isDisplayed(), "Verify focus is shifted to main window");

	}
}
