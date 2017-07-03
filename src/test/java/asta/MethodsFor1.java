package asta;

import org.openqa.selenium.By;

public abstract class MethodsFor1 extends Root {

	protected static final String FORM = "/form/div[%s]/div[%s]/div/div/div/input";
	protected static final String BUTTON = "/form/div[%s]/div[%s]/div/div/div/span/button";

	public static By getForm(String element, int element1) {

		return (By) By.xpath(String.format(getRoot(1) +FORM, element, Integer.toString(element1)));
	}

	public static By getButton(String element, int element1) {

		return (By) By.xpath(String.format(getRoot(1) + BUTTON, element, Integer.toString(element1)));
	}
}
