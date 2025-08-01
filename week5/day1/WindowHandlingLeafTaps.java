package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//Home Assignment
public class WindowHandlingLeafTaps {

	public static void main(String[] args) {
		
		//Launch browser, URL and wait for 30 secs
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Entering credentials to login
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click contacts and then merge contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//click on the From Contact and get them into a set to switch between windows
		driver.findElement(By.xpath("(//a/img)[4]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> childWindow = new ArrayList<String>(windowHandles);
		
		//switch to child window and click on the first element and switch the driver focus back to parent window
		driver.switchTo().window(childWindow.get(1));
		driver.findElement(By.xpath("//table/tbody/tr/td/div/a")).click();
		driver.switchTo().window(childWindow.get(0));
		
		//click on the To Contact and get them into a set to switch between windows
		driver.findElement(By.xpath("(//a/img)[5]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> childWindow1 = new ArrayList<String>(windowHandles1);
		
		//switch to child window and click on the second element and switch the driver focus back to parent window
		driver.switchTo().window(childWindow1.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(childWindow1.get(0));
		
		//hit merge
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//get the title of the page
		System.out.println(driver.getTitle());
	}
}
