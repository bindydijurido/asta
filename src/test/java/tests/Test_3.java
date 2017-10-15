package tests;

import org.junit.Test;
import actions.Functions;
import pageObjects.Methods;

public class Test_3 extends Methods {

	@Test
	public void menuFunctionality() {

		driver.get("https://testingcup.pgs-soft.com/task_3");
		log("I am checking action menu - enabling edition mode");
		Functions.menuActions();

		log("I am filling forms with properly data");
		Functions.fulfillMenu("Jan", "Kowalski", "I love Pink Floyd", "513-455-123", "data/link.jpg");

		log("Data was properly provided. Test passed");
	}
}