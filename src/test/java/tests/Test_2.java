package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import actions.Functions;
import pageObjects.Methods;

public class Test_2 extends Methods {

	List<String> arrayActual = new ArrayList<>();
	List<String> arrayExpected = new ArrayList<>();

	@Test
	public void sportCategoryFunctionality() {

		driver.get("https://testingcup.pgs-soft.com/task_2");
		log("I am getting text from main page");

		Functions.productsCategory(false, false, 0, "Sport");

		Assert.assertEquals(arrayActual, arrayExpected);
		log("Assertion Complete");
	}

	@Test
	public void elektronikaCategoryFunctionality() throws InterruptedException {

		driver.get("https://testingcup.pgs-soft.com/task_2");
		log("I am getting text from main page");

		Functions.productsCategory(true, true, 2, "Elektronika");

		Assert.assertEquals(arrayActual, arrayExpected);
		log("Assertion Complete");
	}

	@Test
	public void firmaCategoryFunctionality() throws InterruptedException {

		driver.get("https://testingcup.pgs-soft.com/task_2");
		log("I am getting text from main page");

		Functions.productsCategory(true, true, 3, "Firma i Uslugi");

		Assert.assertEquals(arrayActual, arrayExpected);
		log("Assertion Complete");
	}
}