package actions;

import pageObjects.PageObjects;

public class GoTo extends PageObjects {

	public void openPage(String element) {

		driver.get("https://testingcup.pgs-soft.com/" + element);
	}
}
