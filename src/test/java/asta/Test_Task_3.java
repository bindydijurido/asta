package asta;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Task_3 extends MethodsFor3 {

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
		baseUrl = "https://testingcup.pgs-soft.com/task_3";
	}

	@Test
	public void WholeMenuFunctionality() throws InterruptedException {
		
		// setup directory path to image
		
		Path path = Paths.get("img/link.jpg");
		Path absolutePath = path.toAbsolutePath();

		String absolutePathString = absolutePath.toString();

		driver.get(baseUrl);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/div/div[2]/ul/li/a")));

		WebElement menu0 = findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li/a"));
		WebElement menu1 = findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li/ul/li[1]/a"));
		WebElement reset = findElement(By.xpath("html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/div[1]/label"));

		// go to edit form section

		Actions builder = new Actions(driver);
		builder.moveToElement(menu0).perform();
		builder.moveToElement(menu1).perform();

		findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li/ul/li[1]/ul/li[1]/a")).click();

		builder.moveToElement(reset).perform();

		Thread.sleep(3500);

		// go to filling form

		wait.until(ExpectedConditions.elementToBeClickable(getIntput(1)));

		findElement(getIntput(1)).clear();
		findElement(getIntput(1)).sendKeys("Jan");
		findElement(getIntput(2)).clear();
		findElement(getIntput(2)).sendKeys("Kowalski");
		findElement(getTextArea(3)).clear();
		findElement(getTextArea(3)).sendKeys("Pink Floyd's the best band in the world!");

		findElement(getIntput(4)).clear();
		findElement(getIntput(4)).sendKeys("513-513-513");

		// send file

		findElement(By.xpath("html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/div[5]/div[1]/span/input"))
				.sendKeys(absolutePathString);

		// button submit | alert check

		findElement(By.xpath("html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/button")).submit();

		driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/span"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		driver.close();
		driver.quit();
	}
}
