package asta;

import org.openqa.selenium.By;

public class Heart {

	private static final String ROOT = "html/body/div[1]/div/div[2]/div[1]/form/";
	private static final String FORM = "div[%s]/div[%s]/div/div/div/input";
	private static final String BUTTON = "div[%s]/div[%s]/div/div/div/span/button";

	public Heart() {
	}

	public static By getForm(String element, int element1) {

		return (By) By.xpath(ROOT + String.format(FORM, element, Integer.toString(element1)));
	}

	public static By getButton(String element, int element1) {

		return (By) By.xpath(ROOT + String.format(BUTTON, element, Integer.toString(element1)));
	}

}