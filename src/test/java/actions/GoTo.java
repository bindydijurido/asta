package actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.PageObjects;

public class GoTo extends PageObjects {

	protected static WebDriverWait wait = new WebDriverWait(driver, 10);

	private Object element;
	private ExpectedCondition <WebElement> condition;

	public GoTo openPage(String element) {
		this.element = element;
		return this;
	}

	public GoTo condition(ExpectedCondition <WebElement> condition) {

		this.condition = condition;
		return this;
	}

	public void execute() {

		driver.get("https://testingcup.pgs-soft.com/" + element);
		wait.until(condition);
	}
}
