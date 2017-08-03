package asta.methods;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class MethodsFor3 extends Root {
	
	Path path = Paths.get("img/link.jpg");
	Path absolutePath = path.toAbsolutePath();

	public static final String ROOT = "html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/div[%s]/div[1]/";

	protected static final String INTPUT = "input";
	protected static final String TEXTAREA = "textarea";
	protected String ImagePath = absolutePath.toString();

	public static By getIntput(int element) {

		return By.xpath(String.format(ROOT, Integer.toString(element)) + INTPUT);
	}

	public static By getTextArea(int element) {

		return By.xpath(String.format(ROOT, Integer.toString(element)) + TEXTAREA);
	}

	public static WebElement findElement(By locator) {

		WebElement Element = driver.findElement(locator);

		return Element;
	}
}