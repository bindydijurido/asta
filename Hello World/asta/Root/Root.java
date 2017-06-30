package asta.root;

import org.openqa.selenium.By;

public class Root extends RootTasks {

	public Root() {
	}

	public static By getForm(String element, int element1) {

		return (By) By.xpath(ROOT + String.format(FORM, element, Integer.toString(element1)));
	}

	public static By getButton(String element, int element1) {

		return (By) By.xpath(ROOT + String.format(BUTTON, element, Integer.toString(element1)));
	}

	// For Task 2

	public static By getSearch() {

		return (By) By.xpath(SEARCH);
	}

	public static By getHeader(int element) {

		return (By) By.xpath(String.format(HEADER0, Integer.toString(element)));
	}

	public static By getWebElement(int element, int element1) {

		return (By) By.xpath(String.format(HEADER1, Integer.toString(element), Integer.toString(element1)));
	}

}