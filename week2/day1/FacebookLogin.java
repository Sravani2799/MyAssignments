package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com"); // To launch Facebook website
		System.out.println(driver.getTitle());
		driver.manage().window().maximize(); // To maximize the browser window
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Tuna@321");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Find your account and log in.")).click();
		
		driver.getTitle();
		System.out.println(driver.getTitle());
		
		
		
		
		
		// driver.close(); //To close the current browser window
	}

}
