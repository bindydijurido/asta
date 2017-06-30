package asta;

import org.openqa.selenium.By;

public class Root {

	// For Task 1
	private static final String ROOT = "html/body/div[1]/div/div[2]/div[1]/form/";
	private static final String FORM = "div[%s]/div[%s]/div/div/div/input";
	private static final String BUTTON = "div[%s]/div[%s]/div/div/div/span/button";

	// For Task 2
	private static final String SEARCH = "html/body/div[1]/div/div[2]/div[1]/span/span[1]/span/span[1]";
	private static final String H4 = "html/body/div[1]/div/div[2]/div[3]/div/div[%s]/div/div/h4";
	private static final String WebElement = "html/body/div[1]/div/div[2]/div[3]/div[%s]/div[%s]/div/div/h4";

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
		
		return (By)	By.xpath(String.format(H4, Integer.toString(element)));
	}
	
	public static By getWebElement(int element, int element1) {
		
		return (By)	By.xpath(String.format(WebElement, Integer.toString(element), Integer.toString(element1)));
	}

}