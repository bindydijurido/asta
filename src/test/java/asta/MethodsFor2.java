package asta;

import org.openqa.selenium.By;

public abstract class MethodsFor2 extends Root {

	protected static final String SEARCH = "/span/span[1]/span/span[1]";
	protected static final String HEADER0 = "/div/div[%s]/div/div/h4";
	protected static final String HEADER1 = "/div[%s]/div[%s]/div/div/h4";
	protected static final String INTPUT = "html/body/span/span/span[1]/input";
	protected static final String LITYPE = "html/body/span/span/span[2]/ul/li";

	public static By getSearch() {

		return (By) By.xpath(Root.getRoot(1) + SEARCH);
	}

	public static By getHeader(int element) {

		return (By) By.xpath(String.format(Root.getRoot(3) + HEADER0, Integer.toString(element)));
	}

	public static By getWebElement(int element, int element1) {

		return (By) By
				.xpath(String.format(Root.getRoot(3) + HEADER1, Integer.toString(element), Integer.toString(element1)));
	}

}
