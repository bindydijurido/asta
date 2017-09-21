package tests;

import java.io.*;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import actions.GoTo;
import pageObjects.PageObjects;

public class Test_5 extends PageObjects {

	@SuppressWarnings("resource")
	@Test
	public void textFileCheck() throws IOException {

		BufferedReader textFile = new BufferedReader(new FileReader("txt/file.txt"));

		new GoTo().openPage("task_5");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(getInput()));
		let(getInput()).sendKeys(Paths.get("txt/file.txt").toAbsolutePath().toString());
		wait.until(ExpectedConditions.elementToBeClickable(firstColumn()));
		log("I am comparing Text File with loaded table on web page");

		for (int Row = 1; Row <= 20; Row++) {
			Assert.assertEquals(textFile.readLine().toString(),
					let(getTableData(Row, 1)).getText().toString() + ","
							+ let(getTableData(Row, 2)).getText().toString() + ","
							+ let(getTableData(Row, 3)).getText().toString());
		}

		log("Test passed - text file was succesfully loaded and displayed properly in table form");
	}
}