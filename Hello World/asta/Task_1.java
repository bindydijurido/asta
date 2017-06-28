package asta;

import static org.junit.Assert.*;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

public class Task_1 extends Root {

	static WebDriver driver;
	static String baseUrl;

	String Price_1_Basket;
	String Price_1_Product_String;

	double Price_Random_Product;
	static int random;
	static int min = 1;
	static int max = 10;
	int a;
	int sum;
	double Price_1_Product_Double;
	double Price_1_Double;

	static String random_string;

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:/Eclipse/plugins/geckodriver-v0.16.1-win64/geckodriver.exe");

		driver = new FirefoxDriver();
		baseUrl = "https://testingcup.pgs-soft.com/task_1";
	}

//	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void AddProductToBasket() throws Exception {
		
		System.out.println("I am starting the test: AddProductToBasket functionality");

		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div/input")));
		
		random = ThreadLocalRandom.current().nextInt(min, max);
		random_string = String.valueOf(random);

		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div/input")).sendKeys(random_string);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div/span/button")));

		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div/span/button")).click();

		Price_1_Basket = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/p[2]/span")).getText().toString().split(" ")[0];

		Price_1_Double = Double.parseDouble(Price_1_Basket);

		Price_1_Double = Math.round(Price_1_Double);

		System.out.println("Price before parsing: " + Price_1_Basket + " zl");

		Price_1_Product_String = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[1]/form/div[1]/div[1]/div/div/p[1]")).getText().toString()
				.split(" ")[1];

		Price_1_Product_Double = Double.parseDouble(Price_1_Product_String);

		Price_Random_Product = Math.round(Price_1_Product_Double * random);

		System.out.println("Product price is: " + Price_Random_Product + " zl");
		
		

		Assert.assertEquals(Price_1_Double, Price_Random_Product, random);
		
		System.out.println("Price assertion and data transformation succeeded");
	}

		
	@Test
	public void UpTo100() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		String static_one_value = "1";
		
		System.out.println("I am starting the test: UpTo100Products Alert Functionality");
		System.out.println("I am starting fulfilling the basket process with random data to cover all product types: ");

		do {

			for (a = 1; a < 5; a++) {
				
				driver.findElement(Root.getForm("1", a)).sendKeys(static_one_value);
				driver.findElement(Root.getButton("1", a)).click();
			}
			
			if (sum >= 100) {
				break;
			}

			for (a = 1; a < 5; a++) {

				jse.executeScript("scroll(0, 600);");

				driver.findElement(Root.getForm("2", a)).sendKeys(static_one_value);
				driver.findElement(Root.getButton("2", a)).click();
			}
			
			if (sum >= 100) {
				break;
			}

			for (a = 1; a < 5; a++) {

				driver.findElement(Root.getForm("3", a)).sendKeys(static_one_value);
				driver.findElement(Root.getButton("3", a)).click();
			}

			String ba = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/p[1]/span")).getText().toString();

			sum = Integer.parseInt(ba);
			
			System.out.print(sum + ", ");
			
		} while (sum <= 99);
		
				
		System.out.println(" - the maximum value has been reached");

		if (wait.until(ExpectedConditions.alertIsPresent()) == null)

			fail("Alert was not present - test failed");

		else

			System.out.println("Alert was present - test passed");
	}

}