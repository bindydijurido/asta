package asta.Root;

public abstract class Root {

	public static final String ROOT = "html/body/div[1]/div/div[2]/div[%s]";

	protected static String getRoot(int element) {

		return String.format(ROOT, Integer.toString(element));
	}
}