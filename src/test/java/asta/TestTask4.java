package asta;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.ExpectedConditions;
import asta.methods.MethodsFor4;

import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTask4 extends MethodsFor4 {

	@Test
	public void test1WrongNameForm() throws InterruptedException {

		driver.get("https://testingcup.pgs-soft.com/task_4");
		wait.until(ExpectedConditions.elementToBeClickable(getButton()));
		findElement(getButton()).click();

		Object[] windowHandle = driver.getWindowHandles().toArray();
		driver.switchTo().window((String) windowHandle[windowHandle.length - 1]);
		driver.switchTo().frame(findElement(By.xpath("html/body/iframe")));

		findElement(getInput(1)).sendKeys("Jan Kowalski i jego piecdziesiat znakow - wystarczy?");

		Assert.assertEquals("Jan Kowalski i jego piecdziesiat znakow - wystarcz", findElement(getInput(1)).getAttribute("value"));
		log("Signs limit name form is working properly");
	}

	@Test
	public void test2WrongEmail() {

		findElement(getInput(2)).sendKeys("test.com.pl");
		findElement(getButton1()).submit();
		Assert.assertEquals("Nieprawidłowy email", findElement(getSpan(2)).getText().toString());
		log("Wrong email format alert switched properly");
	}

	@Test
	public void test3WrongTelNumber() {

		findElement(getInput(3)).sendKeys("513513513");
		findElement(getButton1()).submit();
		Assert.assertEquals("Zły format telefonu - prawidłowy: 600-100-200", findElement(getSpan(3)).getText().toString());
		log("Wrong phone number format alert switched properly");
	}

	@Test
	public void test4CorrectForm() {

		findElement(getInput(1)).sendKeys("Jan Kowalski");
		findElement(getInput(2)).sendKeys("test@test.com.pl");
		findElement(getInput(3)).clear();
		findElement(getInput(3)).sendKeys("513-513-513");
		findElement(getButton1()).submit();
		wait.until(ExpectedConditions.visibilityOf(findElement(getConfirmationMsg())));

		Assert.assertEquals("Wiadomość została wysłana", findElement(getConfirmationMsg()).getText().toString());
		log("Forms accepted properly provided data witch success - test passed");
	}
}