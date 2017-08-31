package asta.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MethodsFor1 extends Root {

	protected WebDriverWait wait = new WebDriverWait(driver, 10);

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

	public static By getProductPrice() {
		return (By) By.xpath(getRoot(1) + "/form/div[1]/div[1]/div/div/p[1]");
	}

	public static By getProductQuantitySum(String element) {
		return (By) By.xpath(getRoot(2) + "/div/div[2]/div[2]/p[" + element + "]/span");
	}

	public static WebElement findElement(By locator) {
		WebElement Element = driver.findElement(locator);
		return Element;
	}

	public void log(String element) {
		System.out.println(element);
	}
}