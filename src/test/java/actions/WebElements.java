package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.PageObjects;

public class WebElements extends PageObjects {

	public WebElement let(By locator) {
		WebElement Element = driver.findElement(locator);
		return Element;
	}

	public void log(String element) {
		System.out.println(element);
	}
}
