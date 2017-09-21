package tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import actions.GoTo;
import pageObjects.PageObjects;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_1 extends PageObjects {

	@Test
	public void test1AddProductToBasket() {

		int randomValue = randomValue(1, 20);

		log("I am checking AddProductToBasket functionality");

		new GoTo().openPage("task_1");

		let(quantityField("1", 1)).sendKeys(String.valueOf(randomValue));
		let(addButton("1", 1)).click();

		Assert.assertEquals(getPrice(), getRoundPrice(randomValue), randomValue(1, 20));
		log("Price assertion and data transformation succeeded");
	}

	@Test
	public void test2FillBasket() throws InterruptedException {

		String productInRow;
		int productInColumn;
		int totalProductsQuantity = 0;
		JavascriptExecutor executorJS = (JavascriptExecutor) driver;

		wait.until(ExpectedConditions.elementToBeClickable(quantityField("1", 1)));
		log("I am checking Alert Functionality");
		log("I am fulfilling the basket with random data to cover all avaiable product types: ");

		do {
			for (productInColumn = 1; productInColumn < 5; productInColumn++) {
				productInRow = "1";

				let(quantityField(productInRow, productInColumn)).sendKeys("1");
				let(addButton(productInRow, productInColumn)).click();
				totalProductsQuantity = Integer.parseInt(let(productsSum("1")).getText().toString());
			}

			if (totalProductsQuantity >= 100) {
				break;
			}

			for (productInColumn = 1; productInColumn < 5; productInColumn++) {
				executorJS.executeScript("scroll(0, 600);");
				productInRow = "2";

				let(quantityField(productInRow, productInColumn)).sendKeys("1");
				let(addButton(productInRow, productInColumn)).click();
				totalProductsQuantity = Integer.parseInt(let(productsSum("1")).getText().toString());
			}

			if (totalProductsQuantity >= 100) {
				break;
			}

			for (productInColumn = 1; productInColumn < 5; productInColumn++) {
				productInRow = "3";

				let(quantityField(productInRow, productInColumn)).sendKeys("1");
				let(addButton(productInRow, productInColumn)).click();
				totalProductsQuantity = Integer.parseInt(let(productsSum("1")).getText().toString());
			}

			log(totalProductsQuantity + ", ");
		} while (totalProductsQuantity <= 100);

		log(totalProductsQuantity + " products or above - the maximum value has been reached");

		if (totalProductsQuantity <= 100) {
			productInRow = "1";
			productInColumn = 1;

			let(quantityField(productInRow, productInColumn)).sendKeys("1");
			let(addButton(productInRow, productInColumn)).click();
		}

		log("Alert message: '" + driver.switchTo().alert().getText().toString() + "'");
		driver.switchTo().alert().accept();
		log("Alert was present and closed - test passed");
	}
}