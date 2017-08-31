package asta.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodsFor5 extends Root {

	protected WebDriverWait wait = new WebDriverWait(driver, 10);

	public By getInput() {
		return By.xpath("html/body/div[1]/div/div[2]/div[1]/div[2]/span/input");
	}

	public WebElement findElement(By locator) {
		WebElement Element = driver.findElement(locator);
		return Element;
	}

	public By getTableData(int element1, int element2) {
		return By.xpath(String.format("html/body/div[1]/div/div[2]/div[2]/div/div/table/tbody/tr[%s]/td[%s]",
				Integer.toString(element1), Integer.toString(element2)));
	}

	public By firstColumn() {
		return (By) By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[1]");
	}

	public void log(String element) {
		System.out.println(element);
	}
}