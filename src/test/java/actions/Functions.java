package actions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObjects.Methods;

public class Functions extends Methods {

	static JavascriptExecutor executorJS = (JavascriptExecutor) driver;

	public static void fillBasketFunction(boolean doJS, String valueInRow) throws InterruptedException {

		String productInRow;
		int productInColumn;

		for (productInColumn = 1; productInColumn < 5; productInColumn++) {
			if (doJS == true) {
				executorJS.executeScript("scroll(0, 600);");
			}
			productInRow = valueInRow;

			let(quantityField(productInRow, productInColumn)).sendKeys("1");
			let(addButton(productInRow, productInColumn)).click();
		}
	}

	public static void productsCategory(boolean doJS, boolean getCategoryList, int categoryTypeValue, String categoryName) {

		List<WebElement> listActual = new ArrayList<>();
		List<WebElement> listExpected = new ArrayList<>();
		List<String> arrayActual = new ArrayList<>();
		List<String> arrayExpected = new ArrayList<>();

		if (doJS == true) {
			executorJS.executeScript("scroll(0, 600);");
		}

		for (int productNr = 0; productNr < 6; productNr++) {

			if (getCategoryList == true) {
				WebElement categoryType = let(getWebElement(categoryTypeValue, productNr + 1));
				listActual.add(categoryType);
				arrayActual.add(categoryType.getText());
			}

			listActual.add(let(getWebElement(1, productNr + 1)));
			arrayActual.add(let(getWebElement(1, productNr + 1)).getText());
		}

		for (WebElement Actual1 : listActual) {
			log(Actual1.getText() + ", ");
		}

		log(" - OK");

		let(getSearch()).click();
		let(getIntput()).sendKeys(categoryName);
		let(getSpan()).click();
		log("I am getting text from product category");

		for (int productNr = 0; productNr < 6; productNr++) {
			WebElement productH = let(getHeader(productNr + 1));
			listExpected.add(productH);
			arrayExpected.add(productH.getText());
		}

		for (WebElement Expected1 : listExpected) {
			log(Expected1.getText() + ", ");
		}

		log(" - OK");
	}

	public static void menuActions() {

		Actions menuAction = new Actions(driver);
		menuAction.moveToElement(let(getMenu())).perform();
		menuAction.moveToElement(let(getForm())).perform();
		let(getEdit()).click();
	}

	public static void fulfillMenu(String name, String lastName, String text, String phoneNr, String photoPath) {

		let(getIntput(1)).clear();
		let(getIntput(1)).sendKeys(name);
		let(getIntput(2)).clear();
		let(getIntput(2)).sendKeys(lastName);
		let(getTextArea(3)).clear();
		let(getTextArea(3)).sendKeys(text);
		let(getIntput(4)).clear();
		let(getIntput(4)).sendKeys(phoneNr);
		log("Forms filled properly");

		log("I am sending an image file via load form button");
		let(loadPhoto()).sendKeys(Paths.get(photoPath).toAbsolutePath().toString());
		let(submitButton()).submit();

		Assert.assertEquals("Twoje dane zostały poprawnie zapisane",
				let(getConfirmation()).getText().toString());
	}

	public static void switchToIframe() {

		let(getButton()).click();

		Object[] windowHandle = driver.getWindowHandles().toArray();
		driver.switchTo().window((String) windowHandle[windowHandle.length - 1]);
		driver.switchTo().frame(let(By.xpath("html/body/iframe")));
	}

	public static void checkForms(String formMssg, String expectedMssg, int position, boolean getAlert) {

		String ActualMssg;

		let(getInput(position)).sendKeys(formMssg);
		let(getSubmit()).submit();

		if (getAlert == true) {
			ActualMssg = let(getAlert(position)).getText().toString();
			if (getAlert == false) {
				ActualMssg = let(getInput(1)).getAttribute("value");
			}

			Assert.assertEquals(expectedMssg, ActualMssg);
		}
	}

	public static void fulfillFormCorrect(String name, String email, String phoneNr, String expectedMssg) {

		let(getInput(1)).sendKeys(name);
		let(getInput(2)).sendKeys(email);
		let(getInput(3)).clear();
		let(getInput(3)).sendKeys(phoneNr);
		let(getSubmit()).submit();

		Assert.assertEquals(expectedMssg, let(getInfo()).getText().toString());
	}

	public static void loadFile(String element) {
		let(getInput()).sendKeys(Paths.get(element).toAbsolutePath().toString());
	}

	public static void assertLines() throws IOException {

		@SuppressWarnings("resource")
		BufferedReader textFile = new BufferedReader(new FileReader("data/file.txt"));

		for (int Row = 1; Row <= 20; Row++) {
			Assert.assertEquals(textFile.readLine().toString(),
					let(getTableData(Row, 1)).getText().toString() + ","
							+ let(getTableData(Row, 2)).getText().toString() + ","
							+ let(getTableData(Row, 3)).getText().toString());
		}
	}
}
