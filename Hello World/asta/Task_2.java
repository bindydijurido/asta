package asta;

import java.util.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

public class Task_2 {

	static WebDriver driver;
	static String baseUrl;
	public List<String> AllElementsTextBefore = new ArrayList<>();
	public List<String> AllElementsTextAfter = new ArrayList<>();
	public List<WebElement> myList = new ArrayList<>();
	public List<WebElement> myListAfter = new ArrayList<>();

	@Before
	public void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.gecko.driver", "C:/Eclipse/plugins/geckodriver-v0.16.1-win64/geckodriver.exe");

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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/div/div[2]/div[1]/span/span[1]/span/span[1]")));

		System.out.println("I am getting text from main page: Sport");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/div[1]/div[" + (i + 1) + "]/div/div/h4"));
			myList.add(x);

			AllElementsTextBefore.add(x.getText());
		}

		for (WebElement model : myList) {
			System.out.print(model.getText() + ", ");
		}

		System.out.println(" - OK");

		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[1]/span/span[1]/span/span[1]")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys("Sport");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/span/span/span[2]/ul/li")));
		driver.findElement(By.xpath("html/body/span/span/span[2]/ul/li")).click();

		System.out.println("I am getting text from product category: Sport");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/div/div[" + (i + 1) + "]/div/div/h4"));
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/div/div[2]/div[1]/span/span[1]/span/span[1]")));

		System.out.println("I am getting text from main page: Elektronika");

		System.setProperty("webdriver.gecko.driver", "C:/Eclipse/plugins/geckodriver-v0.16.1-win64/geckodriver.exe");

		jse.executeScript("scroll(0, 600);");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/div[2]/div[" + (i + 1) + "]/div/div/h4"));
			myList.add(x);

			AllElementsTextBefore.add(x.getText());
		}

		for (WebElement model : myList) {
			System.out.print(model.getText() + ", ");
		}

		System.out.println(" - OK");

		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[1]/span/span[1]/span/span[1]")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys("Elektronika");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/span/span/span[2]/ul/li")));
		driver.findElement(By.xpath("html/body/span/span/span[2]/ul/li")).click();

		System.out.println("I am getting text from product category: Elektronika");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/div/div[" + (i + 1) + "]/div/div/h4"));
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/div/div[2]/div[1]/span/span[1]/span/span[1]")));

		System.out.println("I am getting text from main page: Firma i Uslugi");

		System.setProperty("webdriver.gecko.driver", "C:/Eclipse/plugins/geckodriver-v0.16.1-win64/geckodriver.exe");

		jse.executeScript("scroll(0, 600);");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/div[3]/div[" + (i + 1) + "]/div/div/h4"));
			myList.add(x);

			AllElementsTextBefore.add(x.getText());
		}

		for (WebElement model : myList) {
			System.out.print(model.getText() + ", ");
		}

		System.out.println(" - OK");

		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[1]/span/span[1]/span/span[1]")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys("Firma i Uslugi");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/span/span/span[2]/ul/li")));
		driver.findElement(By.xpath("html/body/span/span/span[2]/ul/li")).click();

		System.out.println("I am getting text from product category: Firma i Uslugi");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/div/div[" + (i + 1) + "]/div/div/h4"));
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
