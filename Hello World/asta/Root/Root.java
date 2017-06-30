package asta.root;

public class Root  {
	
	// For Task 1
	protected static final String ROOT = "html/body/div[1]/div/div[2]/div[1]/form/";
	protected static final String FORM = "div[%s]/div[%s]/div/div/div/input";
	protected static final String BUTTON = "div[%s]/div[%s]/div/div/div/span/button";

	// For Task 2
	protected static final String SEARCH = "html/body/div[1]/div/div[2]/div[1]/span/span[1]/span/span[1]";
	protected static final String HEADER0 = "html/body/div[1]/div/div[2]/div[3]/div/div[%s]/div/div/h4";
	protected static final String HEADER1 = "html/body/div[1]/div/div[2]/div[3]/div[%s]/div[%s]/div/div/h4";

//	public Root() {
//	}
//
//	public static By getForm(String element, int element1) {
//
//		return (By) By.xpath(ROOT + String.format(FORM, element, Integer.toString(element1)));
//	}
//
//	public static By getButton(String element, int element1) {
//
//		return (By) By.xpath(ROOT + String.format(BUTTON, element, Integer.toString(element1)));
//	}

	// For Task 2

//	public static By getSearch() {
//
//		return (By) By.xpath(SEARCH);
//	}
//
//	public static By getHeader(int element) {
//
//		return (By) By.xpath(String.format(HEADER0, Integer.toString(element)));
//	}
//
//	public static By getWebElement(int element, int element1) {
//
//		return (By) By.xpath(String.format(HEADER1, Integer.toString(element), Integer.toString(element1)));
//	}

}