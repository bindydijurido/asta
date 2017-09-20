package tests;

import java.nio.file.Paths;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import framework.pages.page3.Page3;

import org.junit.Assert;

public class Test_3 extends Page3 {

	@Test
	public void wholeMenuFunctionality() throws InterruptedException {

		driver.get("https://testingcup.pgs-soft.com/task_3");
		wait.until(ExpectedConditions.elementToBeClickable(getMenu()));
		
		log("I am checking action menu - enabling edition mode");
		Actions menuAction = new Actions(driver);
		menuAction.moveToElement(findElement(getMenu())).perform();
		menuAction.moveToElement(findElement(getForm())).perform();
		findElement(getEdit()).click();
		wait.until(ExpectedConditions.elementToBeClickable(getIntput(1)));
		
		log("I am filling forms with properly data");
		findElement(getIntput(1)).clear();
		findElement(getIntput(1)).sendKeys("Jan");
		findElement(getIntput(2)).clear();
		findElement(getIntput(2)).sendKeys("Kowalski");
		findElement(getTextArea(3)).clear();
		findElement(getTextArea(3)).sendKeys("Pink Floyd's the best band in the world! :)");
		findElement(getIntput(4)).clear();
		findElement(getIntput(4)).sendKeys("513-513-513");
		log("Forms filled properly");

		log("I am sending an image file via load form button");
		findElement(loadPhoto()).sendKeys(Paths.get("img/link.jpg").toAbsolutePath().toString());
		findElement(submitButton()).submit();

		Assert.assertEquals("Twoje dane zostały poprawnie zapisane",
				driver.findElement(getConfirmation()).getText().toString());
		log("Data was properly provided. Test passed");
	}
}