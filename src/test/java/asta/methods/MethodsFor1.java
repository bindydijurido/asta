package asta.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class MethodsFor1 extends Root {

	protected static final String FORM = "/form/div[%s]/div[%s]/div/div/div/input";
	protected static final String BUTTON = "/form/div[%s]/div[%s]/div/div/div/span/button";

	public static final String ROOT = "html/body/div[1]/div/div[2]/div[%s]";

	protected static String getRoot(int element) {

		return String.format(ROOT, Integer.toString(element));
	}

	public static By getForm(String element, int element1) {

		return (By) By.xpath(String.format(getRoot(1) + FORM, element, Integer.toString(element1)));
	}

	public static By getButton(String element, int element1) {

		return (By) By.xpath(String.format(getRoot(1) + BUTTON, element, Integer.toString(element1)));
	}

	public static WebElement findElement(By locator) {

		WebElement Element = driver.findElement(locator);

		return Element;
	}
}