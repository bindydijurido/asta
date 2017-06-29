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
	public List<WebElement> mySportList = new ArrayList<>();
	public List<WebElement> mySportListAfter = new ArrayList<>();

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.gecko.driver", "C:/Eclipse/plugins/geckodriver-v0.16.1-win64/geckodriver.exe");

		driver = new FirefoxDriver();
		baseUrl = "https://testingcup.pgs-soft.com/task_2";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		driver.quit();
	}

	@Test
	public void ListOfSportProducts() throws InterruptedException {

		System.out.println("I am starting the test: ChooseProductFunctionality");

		driver.get(baseUrl);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/div/div[2]/div[1]/span/span[1]/span/span[1]")));

		System.out.println("I am getting text from main page: Sport");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/div[1]/div[" + (i + 1) + "]/div/div/h4"));
			mySportList.add(x);

			AllElementsTextBefore.add(x.getText());
		}

		for (WebElement model : mySportList) {
			System.out.println(model.getText());
		}

		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[1]/span/span[1]/span/span[1]")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys("Sport");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/span/span/span[2]/ul/li")));
		driver.findElement(By.xpath("html/body/span/span/span[2]/ul/li")).click();
		

		System.out.println("I am getting text from product category: Sport");

		for (int i = 0; i < 6; i++) {

			WebElement x = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[3]/div/div[" + (i + 1) + "]/div/div/h4"));
			mySportListAfter.add(x);

			AllElementsTextAfter.add(x.getText());
		}

		for (WebElement model : mySportListAfter) {
			System.out.println(model.getText());
		}

		Assert.assertEquals(AllElementsTextBefore, AllElementsTextAfter);

		System.out.println("Assertion Complete");

	}

}
