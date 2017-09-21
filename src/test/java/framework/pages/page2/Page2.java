package framework.pages.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Root;

public abstract class Page2 extends Root {

	protected WebDriverWait wait = new WebDriverWait(driver, 10);

	public String getRoot(int element) {
		return String.format("html/body/div[1]/div/div[2]/div[%s]", Integer.toString(element));
	}

	public By getSearch() {
		return (By) By.xpath(getRoot(1) + "/span/span[1]/span/span[1]");
	}

	public By getHeader(int element) {
		return (By) By.xpath(String.format(getRoot(3) + "/div/div[%s]/div/div/h4", Integer.toString(element)));
	}

	public By getWebElement(int element, int element1) {
		return (By) By
				.xpath(String.format(getRoot(3) + "/div[%s]/div[%s]/div/div/h4", Integer.toString(element), Integer.toString(element1)));
	}
	
	public By getForm() {
		return By.xpath("html/body/span/span/span[2]/ul/li");
	}
	
	public By getIntput() {
		return By.xpath("html/body/span/span/span[1]/input");
	}

	public WebElement findElement(By locator) {
		WebElement Element = driver.findElement(locator);
		return Element;
	}

	public void log(String element) {
		System.out.println(element);
	}
}