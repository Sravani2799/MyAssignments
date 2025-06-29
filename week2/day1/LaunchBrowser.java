package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		//to launch the browser
		ChromeDriver driver=new ChromeDriver();
		
		// To launch Facebook website
		driver.get("https://www.facebook.com"); 
		
		//to get the title of the webpage
		System.out.println(driver.getTitle());
		
		// To maximize the browser window
		driver.manage().window().maximize(); 
		
		//To close the current browser window
		driver.close();  
	}
}
