package asta;

import java.io.BufferedReader;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import asta.methods.MethodsFor5;

public class Test_Task_5 extends MethodsFor5 {
	
	public String baseUrl = "https://testingcup.pgs-soft.com/task_5";

	
	@Test
	public void LoadDataToTheApp() throws InterruptedException {
		
		BufferedReader FILE = new BufferedReader(new FileReader(list));
		
		driver.get(baseUrl);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(getInput()));
		
		findElement(getInput()).sendKeys(FileTextPath);
		
		


	}
}

// i'll continue this one in next week i suppose : )
// seriously :) i am busy right now.
// F.