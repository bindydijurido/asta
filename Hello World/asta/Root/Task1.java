package asta.root;

import org.openqa.selenium.By;

public abstract class Task1 extends Root {

	public static By getForm(String element, int element1) {

		return (By) By.xpath(ROOT + String.format(FORM, element, Integer.toString(element1)));
	}

	public static By getButton(String element, int element1) {

		return (By) By.xpath(ROOT + String.format(BUTTON, element, Integer.toString(element1)));
	}

}
