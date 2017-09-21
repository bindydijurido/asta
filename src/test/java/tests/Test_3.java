package tests;

import java.nio.file.Paths;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import actions.GoTo;
import pageObjects.PageObjects;

import org.junit.Assert;

public class Test_3 extends PageObjects {

	@Test
	public void wholeMenuFunctionality() throws InterruptedException {

		new GoTo().openPage("task_3");
		wait.until(ExpectedConditions.elementToBeClickable(getMenu()));

		log("I am checking action menu - enabling edition mode");
		Actions menuAction = new Actions(driver);
		menuAction.moveToElement(let(getMenu())).perform();
		menuAction.moveToElement(let(getUnderMenu())).perform();
		let(getEdit()).click();
		wait.until(ExpectedConditions.elementToBeClickable(getTextField(1)));

		log("I am filling forms with properly data");
		let(getTextField(1)).clear();
		let(getTextField(1)).sendKeys("Jan");
		let(getTextField(2)).clear();
		let(getTextField(2)).sendKeys("Kowalski");
		let(getTextArea(3)).clear();
		let(getTextArea(3)).sendKeys("Pink Floyd's the best band in the world! :)");
		let(getTextField(4)).clear();
		let(getTextField(4)).sendKeys("513-513-513");
		log("Forms filled properly");

		log("I am sending an image file via load form button");
		let(loadPhoto()).sendKeys(Paths.get("img/link.jpg").toAbsolutePath().toString());
		let(submitButton()).submit();

		Assert.assertEquals("Twoje dane zostały poprawnie zapisane",
				let(getConfirmation()).getText().toString());
		log("Data was properly provided. Test passed");
	}
}