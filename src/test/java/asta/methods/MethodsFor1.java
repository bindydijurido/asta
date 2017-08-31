package asta.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MethodsFor1 extends Root {

	protected WebDriverWait wait = new WebDriverWait(driver, 10);

	public static String getRoot(int element) {
		return String.format("html/body/div[1]/div/div[2]/div[%s]", Integer.toString(element));
	}

	public By getForm(String element, int element1) {
		return (By) By.xpath(String.format(getRoot(1) + 
				"/form/div[%s]/div[%s]/div/div/div/input", element, Integer.toString(element1)));
	}

	public By getButton(String element, int element1) {
		return (By) By.xpath(String.format(getRoot(1) + 
				"/form/div[%s]/div[%s]/div/div/div/span/button", element, Integer.toString(element1)));
	}

	public By getProductPrice() {
		return (By) By.xpath(getRoot(1) + "/form/div[1]/div[1]/div/div/p[1]");
	}

	public By getProductQuantitySum(String element) {
		return (By) By.xpath(getRoot(2) + "/div/div[2]/div[2]/p[" + element + "]/span");
	}

	public WebElement findElement(By locator) {
		WebElement Element = driver.findElement(locator);
		return Element;
	}

	public void log(String element) {
		System.out.println(element);
	}
}