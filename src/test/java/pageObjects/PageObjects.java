package pageObjects;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;

public class PageObjects extends PageMethods {

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

	protected double getPrice() {
		return Math.round(Double.parseDouble(let(productsSum("2"))
				.getText().toString()
				.split(" ")[0]));
	}

	protected double getRoundPrice(int value) {
		return Math.round(Double.parseDouble(let(getProductPrice())
				.getText().toString()
				.split(" ")[1]) * value);
	}

	public int randomValue(int min, int max) {
		return (ThreadLocalRandom.current().nextInt(min, max));
	}

}
