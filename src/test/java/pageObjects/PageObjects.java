package pageObjects;

import org.openqa.selenium.By;

import utility.Root;

public class PageObjects extends Root {

	public static String getRoot(int element) {
		return String.format("html/body/div[1]/div/div[2]/div[%s]", Integer.toString(element));
	}

	public static By quantityField(String element, int element1) {
		return (By) By.xpath(String.format(getRoot(1) +
				"/form/div[%s]/div[%s]/div/div/div/input", element, Integer.toString(element1)));
	}

	public By addButton(String element, int element1) {
		return (By) By.xpath(String.format(getRoot(1) +
				"/form/div[%s]/div[%s]/div/div/div/span/button", element, Integer.toString(element1)));
	}

	public By getProductPrice() {
		return (By) By.xpath(getRoot(1) + "/form/div[1]/div[1]/div/div/p[1]");
	}

	public By productsSum(String element) {
		return (By) By.xpath(getRoot(2) + "/div/div[2]/div[2]/p[" + element + "]/span");
	}

	public static By getSearch() {
		return (By) By.xpath(getRoot(1) + "/span/span[1]/span/span[1]");
	}

	public static By getMenu() {
		return By.xpath("html/body/div[1]/div/div[2]/ul/li/a");
	}

	public static By getButton() {
		return By.xpath("html/body/div[1]/div/div[2]/div/div[2]/button");
	}

	public static By getInput() {
		return By.xpath("html/body/div[1]/div/div[2]/div[1]/div[2]/span/input");
	}
	
	
}
