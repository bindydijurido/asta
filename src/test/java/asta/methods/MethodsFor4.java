package asta.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MethodsFor4 extends Root {

	protected WebDriverWait wait = new WebDriverWait(driver, 10);

	public By getButton() {
		return By.xpath("html/body/div[1]/div/div[2]/div/div[2]/button");
	}

	public By getButton1() {
		return By.xpath("html/body/div[1]/div/div[1]/div/div/form/button");
	}

	public By getInput(int element) {
		return By.xpath(String.format("html/body/div[1]/div/div[1]/div/div/form/div[%s]/div[1]/input", Integer.toString(element)));
	}

	public By getAlert(int element) {
		return By.xpath(String.format("html/body/div[1]/div/div[1]/div/div/form/div[%s]/div[1]/span", Integer.toString(element)));
	}

	public By getConfirmation() {
		return By.xpath("html/body/div[1]/h1");
	}

	public WebElement findElement(By locator) {
		WebElement Element = driver.findElement(locator);
		return Element;
	}

	public void log(String element) {
		System.out.println(element);
	}
}