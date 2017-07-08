package asta.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class MethodsFor4 {

	protected static WebDriver driver;

	public static String BUTTON = "html/body/div[1]/div/div[2]/div/div[2]/button";
	public static String INPUT = "html/body/div[1]/div/div[1]/div/div/form/div[%s]/div[1]/input";
	public static String SPAN = "html/body/div[1]/div/div[1]/div/div/form/div[%s]/div[1]/span";
	public static String BUTTON1 = "html/body/div[1]/div/div[1]/div/div/form/button";

	public static By getButton() {

		return By.xpath(BUTTON);
	}

	public static By getButton1() {

		return By.xpath(BUTTON1);
	}

	public static By getInput(int element) {

		return By.xpath(String.format(INPUT, Integer.toString(element)));
	}

	public static By getSpan(int element) {

		return By.xpath(String.format(SPAN, Integer.toString(element)));
	}

	public static WebElement findElement(By locator) {

		WebElement Element = driver.findElement(locator);

		return Element;
	}
}
