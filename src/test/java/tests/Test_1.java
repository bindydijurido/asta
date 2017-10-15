package tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import actions.Functions;
import pageObjects.Methods;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_1 extends Methods {

	@Test
	public void test1AddProductToBasket() {

		log("I am checking AddProductToBasket functionality");

		driver.get("https://testingcup.pgs-soft.com/task_1");
		let(quantityField("1", 1)).sendKeys(String.valueOf(randomQuantity));
		let(addButton("1", 1)).click();

		Assert.assertEquals(getPrice(), getRoundPrice(), randomQuantity);
		log("Price assertion and data transformation succeeded");
	}

	@Test
	public void test2FillBasket() throws InterruptedException {

		int totalProductsQuantity;

		log("I am checking Alert Functionality");
		log("I am fulfilling the basket with random data to cover all avaiable product types: ");

		for (totalProductsQuantity = parseQuantity(); totalProductsQuantity < 101; totalProductsQuantity++) {

			Functions.fillBasketFunction(false, "1");
			totalProductsQuantity = parseQuantity();
			Functions.fillBasketFunction(true, "2");
			totalProductsQuantity = parseQuantity();
			Functions.fillBasketFunction(false, "3");
			totalProductsQuantity = parseQuantity();

			logInLine(totalProductsQuantity + ", ");
		}

		log(totalProductsQuantity + " products or above - the maximum value has been reached");
		driver.switchTo().alert().accept();
		log("Alert was present and closed - test passed");
	}
}