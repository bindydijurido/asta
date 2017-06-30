package asta.root;

public class Constants {

	protected static final String ROOT = "html/body/div[1]/div/div[2]/div[%s]";

	public static String getRoot(int element) {

		return String.format(ROOT, Integer.toString(element));
	}

	// For Task 1
	protected static final String FORM = "/form/div[%s]/div[%s]/div/div/div/input";
	protected static final String BUTTON = "/form/div[%s]/div[%s]/div/div/div/span/button";

	// For Task 2
	protected static final String SEARCH = "/span/span[1]/span/span[1]";
	protected static final String HEADER0 = "/div/div[%s]/div/div/h4";
	protected static final String HEADER1 = "/div[%s]/div[%s]/div/div/h4";

}