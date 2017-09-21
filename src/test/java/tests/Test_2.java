package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import framework.pages.page2.Page2;

public class Test_2 extends Page2 {

	String baseUrl = "https://testingcup.pgs-soft.com/task_2";

	List<String> arrayActual = new ArrayList<>();
	List<String> arrayExpected = new ArrayList<>();
	List<WebElement> listActual = new ArrayList<>();
	List<WebElement> listExpected = new ArrayList<>();

	@Test
	public void sportCategoryFunctionality() throws InterruptedException {

		driver.get(baseUrl);
		wait.until(ExpectedConditions.elementToBeClickable(getSearch()));
		log("I am getting text from main page");

		for (int productNr = 0; productNr < 6; productNr++) {
			listActual.add(findElement(getWebElement(1, productNr + 1)));
			arrayActual.add(findElement(getWebElement(1, productNr + 1)).getText());
		}

		for (WebElement listActual : listActual) {
			log(listActual.getText() + ", ");
		}

		log(" - OK");

		findElement(getSearch()).click();
		findElement(getIntput()).sendKeys("Sport");
		wait.until(ExpectedConditions.elementToBeClickable(getForm()));
		findElement(getForm()).click();
		log("I am getting text from product category");

		for (int productNr = 0; productNr < 6; productNr++) {
			WebElement productH = findElement(getHeader(productNr + 1));
			listExpected.add(productH);
			arrayExpected.add(productH.getText());
		}

		for (WebElement listExpected : listExpected) {
			log(listExpected.getText() + ", ");
		}

		log(" - OK");

		Assert.assertEquals(arrayActual, arrayExpected);
		log("Assertion Complete");
	}

	@Test
	public void elektronikaCategoryFunctionality() throws InterruptedException {

		JavascriptExecutor executorJS = (JavascriptExecutor) driver;

		driver.get(baseUrl);
		wait.until(ExpectedConditions.elementToBeClickable(getSearch()));
		log("I am getting text from main page");

		executorJS.executeScript("scroll(0, 600);");

		for (int productNr = 0; productNr < 6; productNr++) {
			WebElement webElement = findElement(getWebElement(2, productNr + 1));
			listActual.add(webElement);
			arrayActual.add(webElement.getText());
		}

		for (WebElement listActual : listActual) {
			log(listActual.getText() + ", ");
		}

		log(" - OK");

		findElement(getSearch()).click();
		findElement(getIntput()).sendKeys("Elektronika");
		wait.until(ExpectedConditions.elementToBeClickable(getForm()));
		findElement(getForm()).click();
		log("I am checking products category");

		for (int productNr = 0; productNr < 6; productNr++) {
			WebElement productH = findElement(getHeader(productNr + 1));
			listExpected.add(productH);
			arrayExpected.add(productH.getText());
		}

		for (WebElement listExpected : listExpected) {
			log(listExpected.getText() + ", ");
		}

		log(" - OK");

		Assert.assertEquals(arrayActual, arrayExpected);
		log("Assertion Complete");
	}

	@Test
	public void firmaCategoryFunctionality() throws InterruptedException {

		JavascriptExecutor executorJS = (JavascriptExecutor) driver;

		driver.get(baseUrl);
		wait.until(ExpectedConditions.elementToBeClickable(getSearch()));
		log("I am getting text from main page");

		executorJS.executeScript("scroll(0, 600);");

		for (int productNr = 0; productNr < 6; productNr++) {
			WebElement webElement = findElement(getWebElement(3, productNr + 1));
			listActual.add(webElement);
			arrayActual.add(webElement.getText());
		}

		for (WebElement listActual : listActual) {
			log(listActual.getText() + ", ");
		}

		log(" - OK");

		findElement((getSearch())).click();
		findElement(getIntput()).sendKeys("Firma i Uslugi");
		wait.until(ExpectedConditions.elementToBeClickable(getForm()));
		findElement(getForm()).click();

		log("I am checking products category");

		for (int productNr = 0; productNr < 6; productNr++) {
			WebElement productH = findElement(getHeader(productNr + 1));
			listExpected.add(productH);
			arrayExpected.add(productH.getText());
		}

		for (WebElement listExpected : listExpected) {
			log(listExpected.getText() + ", ");
		}

		log(" - OK");

		Assert.assertEquals(arrayActual, arrayExpected);
		log("Assertion Complete");
	}
}