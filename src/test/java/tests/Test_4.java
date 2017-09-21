package tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.ExpectedConditions;

import framework.pages.page4.Page4;

import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_4 extends Page4 {

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
		findElement(getSubmit()).submit();
		Assert.assertEquals("Nieprawidłowy email", findElement(getAlert(2)).getText().toString());
		log("Wrong email format alert switched properly");
	}

	@Test
	public void test3WrongTelNumber() {

		findElement(getInput(3)).sendKeys("513513513");
		findElement(getSubmit()).submit();
		Assert.assertEquals("Zły format telefonu - prawidłowy: 600-100-200", findElement(getAlert(3)).getText().toString());
		log("Wrong phone number format alert switched properly");
	}

	@Test
	public void test4CorrectForm() {

		findElement(getInput(1)).sendKeys("Jan Kowalski");
		findElement(getInput(2)).sendKeys("test@test.com.pl");
		findElement(getInput(3)).clear();
		findElement(getInput(3)).sendKeys("513-513-513");
		findElement(getSubmit()).submit();
		wait.until(ExpectedConditions.visibilityOf(findElement(getConfirmation())));

		Assert.assertEquals("Wiadomość została wysłana", findElement(getConfirmation()).getText().toString());
		log("Forms accepted properly provided data witch success - test passed");
	}
}