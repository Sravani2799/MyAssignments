package week3.day2;

public class Chrome extends Browser{
	
	public void openIncognito() {
		System.out.println("open Incognito window");
	}
	public void clearCache() {
		System.out.println("Cache is cleared");
	}
	public static void main(String[] args) {
		
		Chrome c= new Chrome();
		System.out.println(c.browserName("Chrome"));
		System.out.println(c.browserVersion("7.1"));
		c.openIncognito();
		c.openURL();
		c.closeBrowser();
		c.navigateBack();
		c.clearCache();	
	}
}