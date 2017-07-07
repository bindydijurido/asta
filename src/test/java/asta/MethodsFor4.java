package asta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MethodsFor4 {

	protected static WebDriver driver;
	
	public static WebElement findElement(By locator) {

		WebElement Element = driver.findElement(locator);

		return Element;
	}
}



/**
 * 4 tommorow methods
*html/body/div[1]/div/div[2]/div/div[2]/button 48
*html/body/div[1]/div/div[2]/div/div[2]/button 50
*
*html/body/div[1]/div/div[1]/div/div/form/div[1]/div[1]/input 62
*html/body/div[1]/div/div[1]/div/div/form/div[1]/div[1]/input 65
*
*html/body/div[1]/div/div[1]/div/div/form/div[2]/div[1]/input 72
*html/body/div[1]/div/div[1]/div/div/form/div[3]/div[1]/input 74
*
*html/body/div[1]/div/div[1]/div/div/form/button 76
*
*
*html/body/div[1]/div/div[1]/div/div/form/div[2]/div[1]/span 80
*html/body/div[1]/div/div[1]/div/div/form/div[3]/div[1]/span 89
*
*html/body/div[1]/div/div[1]/div/div/form/div[1]/div[1]/input" 98
*html/body/div[1]/div/div[1]/div/div/form/div[2]/div[1]/input 100
*
*html/body/div[1]/div/div[1]/div/div/form/div[3]/div[1]/input 103
*html/body/div[1]/div/div[1]/div/div/form/div[3]/div[1]/input 105
*
*html/body/div[1]/div/div[1]/div/div/form/button 107
*
*html/body/div[1]/h1 109
*
*/
