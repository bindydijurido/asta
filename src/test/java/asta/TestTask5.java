package asta;

import java.io.*;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import asta.methods.MethodsFor5;

public class TestTask5 extends MethodsFor5 {

	@SuppressWarnings("resource")
	@Test
	public void textFileCheck() throws IOException {

		BufferedReader textFile = new BufferedReader(new FileReader("txt/file.txt"));

		driver.get("https://testingcup.pgs-soft.com/task_5");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(getInput()));
		findElement(getInput()).sendKeys(Paths.get("txt/file.txt").toAbsolutePath().toString());
		wait.until(ExpectedConditions.elementToBeClickable(firstColumn()));
		log("I am comparing Text File with loaded table on web page");

		for (int Row = 1; Row <= 20; Row++) {
			Assert.assertEquals(textFile.readLine().toString(),
							findElement(getTableData(Row, 1)).getText().toString() + ","
							+ findElement(getTableData(Row, 2)).getText().toString() + ","
							+ findElement(getTableData(Row, 3)).getText().toString());
		}

		log("Test passed - text file was succesfully loaded and displayed properly in table form");
	}
}