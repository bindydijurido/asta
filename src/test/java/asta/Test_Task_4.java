package asta;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import asta.methods.MethodsFor4;

import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_Task_4 extends MethodsFor4 {

	static String baseUrl = "https://testingcup.pgs-soft.com/task_4";
	static String latestWindow;
	static String actualName;
	static String expectedName;
	static String actualMail;
	static String expectedMail;
	static String actualNumber;
	static String expectedNumber;

	static WebElement iframe;

	@Test
	public void test1AlertNameForm() throws InterruptedException {

		driver.get(baseUrl);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(getButton()));

		findElement(getButton()).click();

		Object[] windowHandle = driver.getWindowHandles().toArray();

		latestWindow = (String) windowHandle[windowHandle.length - 1];
		driver.switchTo().window(latestWindow);

		iframe = findElement(By.xpath("html/body/iframe"));

		driver.switchTo().frame(iframe);

		findElement(getInput(1)).sendKeys("Jan Kowalski i jego piecdziesiat znakow - wystarczy?");

		actualName = findElement(getInput(1)).getAttribute("value");

		expectedName = "Jan Kowalski i jego piecdziesiat znakow - wystarcz";

		Assert.assertEquals(expectedName, actualName);

		findElement(getInput(2)).sendKeys("test.com.pl");

		findElement(getInput(3)).sendKeys("513513513");

		findElement(getButton1()).submit();
	}

	@Test
	public void test2AlertEmail() {

		actualMail = findElement(getSpan(2)).getText().toString();

		expectedMail = "Nieprawidłowy email";

		Assert.assertEquals(expectedMail, actualMail);
	}

	@Test
	public void test3AlertTelephoneNumber() {

		actualNumber = findElement(getSpan(3)).getText().toString();

		expectedNumber = "Zły format telefonu - prawidłowy: 600-100-200";

		Assert.assertEquals(expectedNumber, actualNumber);
	}

	@Test
	public void test4CorrectFormFunctionality() {
		findElement(getInput(1)).sendKeys("Jan Kowalski");

		findElement(getInput(2)).sendKeys("test@test.com.pl");

		findElement(getInput(3)).clear();

		findElement(getInput(3)).sendKeys("513-513-513");

		findElement(getButton1()).submit();

		findElement(By.xpath("html/body/div[1]/h1"));
	}
}