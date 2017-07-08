package asta.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class MethodsFor3 {

	protected static WebDriver driver;
	
	public static final String ROOT = "html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/form/div[%s]/div[1]/";

	protected static final String INTPUT = "input";
	protected static final String TEXTAREA = "textarea";

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
