package utility;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class Root {

	public static WebDriver driver;

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() throws Exception {

		driver.close();
		driver.quit();
	}
}