package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		
		//setup browser driver
		ChromeDriver driver=new ChromeDriver();
		
		// To launch Facebook URL
		driver.get("https://www.facebook.com"); 
		
		// To maximize the browser window
		driver.manage().window().maximize(); 
		
		//to enter the id and password and click on the login button
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Tuna@321");
		driver.findElement(By.name("login")).click();
		
		//if the login is failed, to click on the find your account and login
		driver.findElement(By.linkText("Find your account and log in.")).click();
		
		//to get the title of the wedpage/window
		driver.getTitle();
		System.out.println(driver.getTitle());
		
		//To close the current browser window
		driver.close(); 
	}

}
