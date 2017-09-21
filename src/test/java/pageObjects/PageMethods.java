package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Root;

public class PageMethods extends Root {

	protected WebDriverWait wait = new WebDriverWait(driver, 10);

	public WebElement let(By locator) {
		WebElement Element = driver.findElement(locator);
		return Element;
	}

	public void log(String element) {
		System.out.println(element);
	}

}
