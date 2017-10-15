package pageObjects;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Root;

public class Methods extends Root {

	public WebElement findElement(By locator) {
		WebElement Element = driver.findElement(locator);
		return Element;
	}

	public static By getTableData(int element1, int element2) {
		return By.xpath(String.format("html/body/div[1]/div/div[2]/div[2]/div/div/table/tbody/tr[%s]/td[%s]",
				Integer.toString(element1), Integer.toString(element2)));
	}

	public By firstColumn() {
		return (By) By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[1]");
	}

	public static void log(String element) {
		System.out.println(element);
	}

	public void logInLine(String element) {
		System.out.print(element);
	}

	public static By getSubmit() {
		return By.xpath("html/body/div[1]/div/div[1]/div/div/form/button");
	}

	public static By getInput(int element) {
		return By.xpath(String.format("html/body/div[1]/div/div[1]/div/div/form/div[%s]/div[1]/input", Integer.toString(element)));
	}

	public static By getAlert(int element) {
		return By.xpath(String.format("html/body/div[1]/div/div[1]/div/div/form/div[%s]/div[1]/span", Integer.toString(element)));
	}

	public static By getIntput(int element) {
		return By.xpath(String.format("html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/div[%s]/div[1]/",
				Integer.toString(element)) + "input");
	}

	public static By getInfo() {
		return By.xpath("html/body/div[1]/h1");
	}

	public static By getMenu() {
		return By.xpath("html/body/div[1]/div/div[2]/ul/li/a");
	}

	public static By getSpan() {
		return By.xpath("html/body/span/span/span[2]/ul/li");
	}

	public static By getForm() {
		return By.xpath("html/body/div[1]/div/div[2]/ul/li/ul/li[1]/a");
	}

	public static By getConfirmation() {
		return By.xpath("html/body/div[2]/div/div[2]/div/span");
	}

	public static By getTextArea(int element) {
		return By.xpath(String.format("html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/div[%s]/div[1]/",
				Integer.toString(element)) + "textarea");
	}

	public static By getEdit() {
		return By.xpath("html/body/div[1]/div/div[2]/ul/li/ul/li[1]/ul/li[1]/a");
	}

	public static By loadPhoto() {
		return By.xpath("html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/div[5]/div[1]/span/input");
	}

	public static By submitButton() {
		return By.xpath("html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/button");
	}

	public static By getSearch() {
		return (By) By.xpath(getRoot(1) + "/span/span[1]/span/span[1]");
	}

	public int parseQuantity() {
		return Integer.parseInt(let(productsSum("1")).getText().toString());
	}

	public static By getHeader(int element) {
		return (By) By.xpath(String.format(getRoot(3) + "/div/div[%s]/div/div/h4", Integer.toString(element)));
	}

	public static By getWebElement(int element, int element1) {
		return (By) By
				.xpath(String.format(getRoot(3) + "/div[%s]/div[%s]/div/div/h4", Integer.toString(element), Integer.toString(element1)));
	}

	public static By getIntput() {
		return By.xpath("html/body/span/span/span[1]/input");
	}

	protected int randomQuantity = randomValue(1, 20);

	protected double getPrice() {
		return Math.round(Double.parseDouble(let(productsSum("2"))
				.getText().toString()
				.split(" ")[0]));
	}

	protected double getRoundPrice() {
		return Math.round(Double.parseDouble(let(getProductPrice())
				.getText().toString()
				.split(" ")[1]) * randomQuantity);
	}

	public void openPage(String element) {
		driver.get(element);
	}

	public static String getRoot(int element) {
		return String.format("html/body/div[1]/div/div[2]/div[%s]", Integer.toString(element));
	}

	public static By quantityField(String element, int element1) {
		return (By) By.xpath(String.format(getRoot(1) +
				"/form/div[%s]/div[%s]/div/div/div/input", element, Integer.toString(element1)));
	}

	public static By addButton(String element, int element1) {
		return (By) By.xpath(String.format(getRoot(1) +
				"/form/div[%s]/div[%s]/div/div/div/span/button", element, Integer.toString(element1)));
	}

	public By getProductPrice() {
		return (By) By.xpath(getRoot(1) + "/form/div[1]/div[1]/div/div/p[1]");
	}

	public int randomValue(int min, int max) {
		return (ThreadLocalRandom.current().nextInt(min, max));
	}

	public static WebElement let(By locator) {
		WebElement Element = driver.findElement(locator);
		return Element;
	}

	public static By productsSum(String element) {
		return (By) By.xpath(getRoot(2) + "/div/div[2]/div[2]/p[" + element + "]/span");
	}

	public static By getButton() {
		return By.xpath("html/body/div[1]/div/div[2]/div/div[2]/button");
	}

	public static By getInput() {
		return By.xpath("html/body/div[1]/div/div[2]/div[1]/div[2]/span/input");
	}
}
