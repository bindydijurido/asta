package asta.methods;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodsFor5 extends Root {
		
	public static String INPUT = "html/body/div[1]/div/div[2]/div[1]/div[2]/span/input";
	
	public String list = "misc/file.txt";
	
	protected WebDriverWait wait = new WebDriverWait(driver, 10);
	
	Path path = Paths.get(list);
	Path absolutePath = path.toAbsolutePath();
	
	protected String FileTextPath = absolutePath.toString();
	
	public static By getInput() {
		return By.xpath(INPUT);
	}
	
	public static WebElement findElement(By locator) {

		WebElement Element = driver.findElement(locator);

		return Element;
	}
}
