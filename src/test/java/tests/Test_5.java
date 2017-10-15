package tests;

import java.io.IOException;

import org.junit.Test;

import actions.Functions;
import pageObjects.Methods;

public class Test_5 extends Methods {

	@Test
	public void textFileCheck() throws IOException {

		driver.get("https://testingcup.pgs-soft.com/task_5");
		Functions.loadFile("data/file.txt");
		log("I am comparing Text File with loaded table on web page");

		Functions.assertLines();
		log("Test passed - text file was succesfully loaded and displayed properly in table form");
	}
}