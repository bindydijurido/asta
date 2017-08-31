package asta;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import asta.methods.MethodsFor1;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTask1 extends MethodsFor1 {

	@Test
	public void test1AddProductToBasket() throws Exception {

		int randomValue = (ThreadLocalRandom.current().nextInt(1, 20));
		log("I am checking AddProductToBasket functionality");

		driver.get("https://testingcup.pgs-soft.com/task_1");
		wait.until(ExpectedConditions.elementToBeClickable(getForm("1", 1)));
		log("Random quantity for a single product: " + randomValue);

		findElement(getForm("1", 1)).sendKeys(String.valueOf(randomValue));
		wait.until(ExpectedConditions.elementToBeClickable(getButton("1", 1)));
		findElement(getButton("1", 1)).click();

		double productPrice = Math.round(Double.parseDouble(findElement(getProductQuantitySum("2"))
				.getText().toString()
				.split(" ")[0]));
		log("Price before parsing: " + String.valueOf(productPrice) + " zl");

		double roundProductPrice = Math.round(Double.parseDouble(findElement(getProductPrice())
				.getText().toString()
				.split(" ")[1]) * randomValue);
		log("Product price is: " + roundProductPrice + " zl");

		Assert.assertEquals(productPrice, roundProductPrice, randomValue);
		log("Price assertion and data transformation succeeded");
	}

	@Test
	public void test2BasketFilling() throws InterruptedException {

		String productInRow;
		int productInColumn;
		int totalProductsQuantity = 0;
		JavascriptExecutor executorJS = (JavascriptExecutor) driver;

		wait.until(ExpectedConditions.elementToBeClickable(getForm("1", 1)));
		log("I am checking Alert Functionality");
		log("I am fulfilling the basket with random data to cover all avaiable product types: ");

		do {
			for (productInColumn = 1; productInColumn < 5; productInColumn++) {
				productInRow = "1";

				findElement(getForm(productInRow, productInColumn)).sendKeys("1");
				findElement(getButton(productInRow, productInColumn)).click();
				totalProductsQuantity = Integer.parseInt(findElement(getProductQuantitySum("1")).getText().toString());
			}

			if (totalProductsQuantity >= 100) {
				break;
			}

			for (productInColumn = 1; productInColumn < 5; productInColumn++) {
				executorJS.executeScript("scroll(0, 600);");
				productInRow = "2";

				findElement(getForm(productInRow, productInColumn)).sendKeys("1");
				findElement(getButton(productInRow, productInColumn)).click();
				totalProductsQuantity = Integer.parseInt(findElement(getProductQuantitySum("1")).getText().toString());
			}

			if (totalProductsQuantity >= 100) {
				break;
			}

			for (productInColumn = 1; productInColumn < 5; productInColumn++) {
				productInRow = "3";

				findElement(getForm(productInRow, productInColumn)).sendKeys("1");
				findElement(getButton(productInRow, productInColumn)).click();
				totalProductsQuantity = Integer.parseInt(findElement(getProductQuantitySum("1")).getText().toString());
			}

			log(totalProductsQuantity + ", ");
		} while (totalProductsQuantity <= 100);

		log(totalProductsQuantity + " products or above - the maximum value has been reached");

		if (totalProductsQuantity == 100) {
			productInRow = "1";
			productInColumn = 1;

			findElement(getForm(productInRow, productInColumn)).sendKeys("1");
			findElement(getButton(productInRow, productInColumn)).click();
		}

		wait.until(ExpectedConditions.alertIsPresent());
		log("Alert message: '" + driver.switchTo().alert().getText().toString() + "'");
		driver.switchTo().alert().accept();
		log("Alert was present and closed - test passed");
	}
}