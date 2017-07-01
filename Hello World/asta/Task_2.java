package asta;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import asta.Root.Task2;

public class Task_2 extends Task2 {

	static WebDriver driver;
	static String baseUrl;
	public List<String> AllElementsTextBefore = new ArrayList<>();
	public List<String> AllElementsTextAfter = new ArrayList<>();
	public List<WebElement> myList = new ArrayList<>();
	public List<WebElement> myListAfter = new ArrayList<>();

	@Before
	public void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.gecko.driver",
				"./lib/geckodriver.exe");

		driver = new FirefoxDriver();
		baseUrl = "https://testingcup.pgs-soft.com/task_2";
	}

	@After
	public void tearDownAfterClass() throws Exception {

		driver.close();
		driver.quit();
	}

	@Test
	public void ListOfSportProducts() throws InterruptedException {

		System.out.println("I am starting the test: ListOfSportProducts");

		driver.get(baseUrl);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Task2.getSearch()));

		System.out.println("I am getting text from main page: Sport");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(Task2.getWebElement(1, i + 1));
			myList.add(x);

			AllElementsTextBefore.add(x.getText());
		}

		for (WebElement model : myList) {
			System.out.print(model.getText() + ", ");
		}

		System.out.println(" - OK");

		driver.findElement(Task2.getSearch()).click();
		driver.findElement(By.xpath(Task2.INTPUT)).sendKeys("Sport");

		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(Task2.LITYPE)));
		driver.findElement(By.xpath(Task2.LITYPE)).click();

		System.out.println("I am getting text from product category: Sport");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(Task2.getHeader(i + 1));
			myListAfter.add(x);

			AllElementsTextAfter.add(x.getText());
		}

		for (WebElement model : myListAfter) {
			System.out.print(model.getText() + ", ");
		}

		System.out.println(" - OK");

		Assert.assertEquals(AllElementsTextBefore, AllElementsTextAfter);

		System.out.println("Assertion Complete");
	}

	@Test
	public void ListOfElektronikaProducts() throws InterruptedException {

		System.out.println("I am starting the test: ListOfElektronikaProducts");

		driver.get(baseUrl);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Task2.getSearch()));

		System.out.println("I am getting text from main page: Elektronika");

		jse.executeScript("scroll(0, 600);");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(Task2.getWebElement(2, i + 1));
			myList.add(x);

			AllElementsTextBefore.add(x.getText());
		}

		for (WebElement model : myList) {
			System.out.print(model.getText() + ", ");
		}

		System.out.println(" - OK");

		driver.findElement(Task2.getSearch()).click();
		driver.findElement(By.xpath(Task2.INTPUT)).sendKeys("Elektronika");

		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(Task2.LITYPE)));
		driver.findElement(By.xpath(Task2.LITYPE)).click();

		System.out
				.println("I am getting text from product category: Elektronika");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(Task2.getHeader(i + 1));
			myListAfter.add(x);

			AllElementsTextAfter.add(x.getText());
		}

		for (WebElement model : myListAfter) {
			System.out.print(model.getText() + ", ");
		}

		System.out.println(" - OK");

		Assert.assertEquals(AllElementsTextBefore, AllElementsTextAfter);

		System.out.println("Assertion Complete");
	}

	@Test
	public void ListOfFirmaIUslugiProducts() throws InterruptedException {

		System.out.println("I am starting the test: ListOfElektronikaProducts");

		driver.get(baseUrl);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Task2.getSearch()));

		System.out.println("I am getting text from main page: Firma i Uslugi");

		jse.executeScript("scroll(0, 600);");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(Task2.getWebElement(3, i + 1));
			myList.add(x);

			AllElementsTextBefore.add(x.getText());
		}

		for (WebElement model : myList) {
			System.out.print(model.getText() + ", ");
		}

		System.out.println(" - OK");

		driver.findElement((Task2.getSearch())).click();
		driver.findElement(By.xpath(Task2.INTPUT)).sendKeys("Firma i Uslugi");

		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(Task2.LITYPE)));
		driver.findElement(By.xpath(Task2.LITYPE)).click();

		System.out
				.println("I am getting text from product category: Firma i Uslugi");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(Task2.getHeader(i + 1));
			myListAfter.add(x);

			AllElementsTextAfter.add(x.getText());
		}

		for (WebElement model : myListAfter) {
			System.out.print(model.getText() + ", ");
		}

		System.out.println(" - OK");

		Assert.assertEquals(AllElementsTextBefore, AllElementsTextAfter);

		System.out.println("Assertion Complete");
	}

}
