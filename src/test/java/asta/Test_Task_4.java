package asta;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class Test_Task_4 extends MethodsFor4 {

	static String baseUrl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.gecko.driver", "libs/geckodriver.exe");

		/**
		 * for MacOS systems:
		 * 
		 * System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
		 * 
		 */

		driver = new FirefoxDriver();
		baseUrl = "https://testingcup.pgs-soft.com/task_4";
	}

	@Test
	public void FormFunctionality() throws InterruptedException {

		driver.get(baseUrl);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/div/div[2]/div/div[2]/button")));

		findElement(By.xpath("html/body/div[1]/div/div[2]/div/div[2]/button")).click();

		Object[] windowHandle = driver.getWindowHandles().toArray();

		String latestWindow = (String) windowHandle[windowHandle.length - 1];
		driver.switchTo().window(latestWindow);

		WebElement a = findElement(By.xpath("html/body/iframe"));

		driver.switchTo().frame(a);

		// check if form input is limited to 50 signs
		findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/div[1]/div[1]/input"))
				.sendKeys("Jan Kowalski i jego piecdziesiat znakow - wystarczy?");

		String actualName = findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/div[1]/div[1]/input"))
				.getAttribute("value");

		String expectedName = "Jan Kowalski i jego piecdziesiat znakow - wystarcz";

		Assert.assertEquals(expectedName, actualName);

		findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/div[2]/div[1]/input")).sendKeys("test.com.pl");

		findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/div[3]/div[1]/input")).sendKeys("513513513");

		findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/button")).submit();

		// check if alert email is working properly

		String actualMail = findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/div[2]/div[1]/span"))
				.getText().toString();

		String expectedMail = "Nieprawidłowy email";

		Assert.assertEquals(expectedMail, actualMail);

		// check if alert telephone number is working properly

		String actualNumber = findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/div[3]/div[1]/span"))
				.getText().toString();

		String expectedNumber = "Zły format telefonu - prawidłowy: 600-100-200";

		Assert.assertEquals(expectedNumber, actualNumber);

		// correct whole form

		findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/div[1]/div[1]/input")).sendKeys("Jan Kowalski");

		findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/div[2]/div[1]/input"))
				.sendKeys("test@test.com.pl");

		findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/div[3]/div[1]/input")).clear();

		findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/div[3]/div[1]/input")).sendKeys("513-513-513");

		findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/button")).submit();

		findElement(By.xpath("html/body/div[1]/h1"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		driver.close();
		driver.quit();
	}
}
