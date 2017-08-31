package asta.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MethodsFor3 extends Root {

	protected WebDriverWait wait = new WebDriverWait(driver, 10);

	public By getIntput(int element) {
		return By.xpath(String.format("html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/div[%s]/div[1]/",
				Integer.toString(element)) + "input");
	}

	public By getMenu() {
		return By.xpath("html/body/div[1]/div/div[2]/ul/li/a");
	}

	public By getForm() {
		return By.xpath("html/body/div[1]/div/div[2]/ul/li/ul/li[1]/a");
	}

	public By getConfirmation() {
		return By.xpath("html/body/div[2]/div/div[2]/div/span");
	}

	public By getTextArea(int element) {
		return By.xpath(String.format("html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/div[%s]/div[1]/",
				Integer.toString(element)) + "textarea");
	}

	public By getEdit() {
		return By.xpath("html/body/div[1]/div/div[2]/ul/li/ul/li[1]/ul/li[1]/a");
	}

	public By loadPhoto() {
		return By.xpath("html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/div[5]/div[1]/span/input");
	}

	public By submitButton() {
		return By.xpath("html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/button");
	}

	public WebElement findElement(By locator) {
		WebElement Element = driver.findElement(locator);
		return Element;
	}

	public void log(String element) {
		System.out.println(element);
	}
}