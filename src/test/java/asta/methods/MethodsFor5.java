package asta.methods;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodsFor5 extends Root {

	Path path = Paths.get("misc/file.txt");
	Path absolutePath = path.toAbsolutePath();

	public static String INPUT = "html/body/div[1]/div/div[2]/div[1]/div[2]/span/input";
	public static String TABLEDATA = "html/body/div[1]/div/div[2]/div[2]/div/div/table/tbody/tr[%s]/td[%s]";
	public static String FilePath = "misc/file.txt";

	protected WebDriverWait wait = new WebDriverWait(driver, 10);

	protected String FileTextPath = absolutePath.toString();

	public static By getInput() {
		return By.xpath(INPUT);
	}

	public static WebElement findElement(By locator) {

		WebElement Element = driver.findElement(locator);
		return Element;
	}

	public static By getTableData(int element1, int element2) {
		return By.xpath(String.format(TABLEDATA, Integer.toString(element1), Integer.toString(element2)));
	}
}
