package asta;

import org.openqa.selenium.By;

public class xpath {

    private static final String ROOT = "html/body/div[1]/div/div[2]/div[1]/form/div[1]/";
    private static final String FORM = "div[%s]/div/div/div/input";
    private static final String BUTTON = "div[%s]/div/div/div/span/button";

    public xpath() {
    }

    public static By getForm(String element) {
      return (By) By.xpath(ROOT + String.format(FORM, element));
    }
    public static By getButton(String element) {
        return (By) By.xpath(ROOT + String.format(BUTTON, element));
    }

}