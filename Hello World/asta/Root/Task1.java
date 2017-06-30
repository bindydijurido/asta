package asta.root;

import org.openqa.selenium.By;

public abstract class Task1 extends Constants {

	public static By getForm(String element, int element1) {

		return (By) By.xpath(getRoot(1) + String.format(FORM, element, Integer.toString(element1)));
	}

	public static By getButton(String element, int element1) {

		return (By) By.xpath(getRoot(1) + String.format(BUTTON, element, Integer.toString(element1)));
	}

}
