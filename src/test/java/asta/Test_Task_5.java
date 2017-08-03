package asta;

import java.io.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import asta.methods.MethodsFor5;

public class Test_Task_5 extends MethodsFor5 {

	int Row = 1;
	int Column = 1;

	String Cell1;
	String Cell2;
	String Cell3;
	String Table;
	String FileText;

	public String baseUrl = "https://testingcup.pgs-soft.com/task_5";

	@Test
	public void DataTransformationCheck() throws InterruptedException, IOException {

		@SuppressWarnings("resource")
		BufferedReader FILE = new BufferedReader(new FileReader(FilePath));

		driver.get(baseUrl);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(getInput()));

		findElement(getInput()).sendKeys(FileTextPath);

		Thread.sleep(1500);

		while (Row <= 20) {

			FileText = FILE.readLine().toString();

			Column = 1;

			Cell1 = findElement(getTableData(Row, Column)).getText().toString();

			Column++;

			Cell2 = findElement(getTableData(Row, Column)).getText().toString();

			Column++;

			Cell3 = findElement(getTableData(Row, Column)).getText().toString();

			Table = Cell1 + "," + Cell2 + "," + Cell3;

			Assert.assertEquals(FileText, Table);

			Row++;

			System.out.println("Data from File.txt: " + FileText + " / " + "Data from WebPage: " + Table);
		}
	}
}