package actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageObjects;

public class GoTo extends PageObjects {

	protected static WebDriverWait wait = new WebDriverWait(driver, 10);

	public void openPage(String element) {
		
		driver.get("https://testingcup.pgs-soft.com/" + element);
	}
}