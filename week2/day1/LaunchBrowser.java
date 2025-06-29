package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com"); // To launch Facebook website
		System.out.println(driver.getTitle());
		driver.manage().window().maximize(); // To maximize the browser window
		// driver.close(); //To close the current browser window
	}
}
