package asta.root;

import org.openqa.selenium.By;

public class Task2 extends Constants {

	public static By getSearch() {

		return (By) By.xpath(Constants.getRoot(1) + SEARCH);
	}

	public static By getHeader(int element) {

		return (By) By.xpath(String.format(Constants.getRoot(3) + HEADER0,
				Integer.toString(element)));
	}

	public static By getWebElement(int element, int element1) {

		return (By) By.xpath(String.format(Constants.getRoot(3) + HEADER1,
				Integer.toString(element), Integer.toString(element1)));
	}

}
