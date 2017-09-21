package tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.ExpectedConditions;

import actions.GoTo;
import pageObjects.PageObjects;

import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_4 extends PageObjects {

	@Test
	public void test1WrongNameForm() throws InterruptedException {

		new GoTo().openPage("task_4");
		wait.until(ExpectedConditions.elementToBeClickable(getButton()));
		let(getButton()).click();

		Object[] windowHandle = driver.getWindowHandles().toArray();
		driver.switchTo().window((String) windowHandle[windowHandle.length - 1]);
		driver.switchTo().frame(let(By.xpath("html/body/iframe")));

		let(getInput(1)).sendKeys("Jan Kowalski i jego piecdziesiat znakow - wystarczy?");

		Assert.assertEquals("Jan Kowalski i jego piecdziesiat znakow - wystarcz", let(getInput(1)).getAttribute(
				"value"));
		log("Signs limit name form is working properly");
	}

	@Test
	public void test2WrongEmail() {

		let(getInput(2)).sendKeys("test.com.pl");
		let(getSubmit()).submit();
		Assert.assertEquals("Nieprawidłowy email", let(getAlert(2)).getText().toString());
		log("Wrong email format alert switched properly");
	}

	@Test
	public void test3WrongTelNumber() {

		let(getInput(3)).sendKeys("513513513");
		let(getSubmit()).submit();
		Assert.assertEquals("Zły format telefonu - prawidłowy: 600-100-200", let(getAlert(3)).getText().toString());
		log("Wrong phone number format alert switched properly");
	}

	@Test
	public void test4CorrectForm() {

		let(getInput(1)).sendKeys("Jan Kowalski");
		let(getInput(2)).sendKeys("test@test.com.pl");
		let(getInput(3)).clear();
		let(getInput(3)).sendKeys("513-513-513");
		let(getSubmit()).submit();
		wait.until(ExpectedConditions.visibilityOf(let(getPopup())));

		Assert.assertEquals("Wiadomość została wysłana", let(getPopup()).getText().toString());
		log("Forms accepted properly provided data witch success - test passed");
	}
}