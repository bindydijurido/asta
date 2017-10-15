package tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import actions.Functions;

import org.junit.runners.MethodSorters;
import pageObjects.Methods;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_4 extends Methods {

	@Test
	public void test1GetIframe() {

		driver.get("https://testingcup.pgs-soft.com/task_4");
		Functions.switchToIframe();
	}

	@Test
	public void test2WrongNameForm() throws InterruptedException {

		Functions.checkForms("Jan Kowalski i jego piecdziesiat znakow - wystarczy?",
				"Jan Kowalski i jego piecdziesiat znakow - wystarcz", 3, false);
		log("Signs limit name form functionality is working properly");
	}

	@Test
	public void test3WrongEmail() {

		Functions.checkForms("test.com.pl", "Nieprawidłowy email", 2, true);
		log("Wrong email format alert switched properly");
	}

	@Test
	public void test4WrongTelNumber() {

		Functions.checkForms("513513513", "Zły format telefonu - prawidłowy: 600-100-200", 3, true);
		log("Wrong phone number format alert switched properly");
	}

	@Test
	public void test5CorrectForm() {

		Functions.fulfillFormCorrect("Jan Kowalski", "test@test.com.pl", "513-513-513", "Wiadomość została wysłana");
		log("Forms accepted properly provided data witch success - test passed");
	}
}