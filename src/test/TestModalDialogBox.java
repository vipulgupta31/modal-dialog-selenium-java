package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestModalDialogBox extends BaseClass {

	@Test(description = "test to verify modal dialog box")
	public void verifyModalDialogBox() throws InterruptedException {
		// to navigate to the website
		System.out.println("Navigating to the website");
		driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo");

		// to click Launch model button - Trigger element
		System.out.println("Clicking launch modal button");
		driver.findElement(By.xpath("//button[@data-target='#myModal']")).click();

		// to let the modal box be visible
		Thread.sleep(2000);

		// to fetch the web element of the modal container
		System.out.println("Fetching the web element for modal container");
		WebElement modalContainer = driver.findElement(By.className("modal-dialog"));

		// to fetch the web elements of the modal content and interact with them
		// code to fetch content of modal body and verify it
		System.out.println("Fetching modal body content and asserting it");
		WebElement modalContentBody = modalContainer.findElement(By.xpath(".//div[@class='modal-body']"));
		Assert.assertEquals(modalContentBody.getText(),
				"This is the place where the content for the modal dialog displays", "Verify modal body message");

		// code to click on accept modal button
		System.out.println("Clicking modal accept button");
		WebElement modalAcceptButton = modalContainer
				.findElement(By.xpath(".//button[contains(text(),'Save Changes')]"));
		modalAcceptButton.click();

	}
}
