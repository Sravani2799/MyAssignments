package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccountInLeafTaps {

		public static void main(String[] args) {
		
		//setup browser driver
		ChromeDriver driver= new ChromeDriver();
		
		//Load URL
		driver.get("http://leaftaps.com/opentaps/");
		//maximize the window
		driver.manage().window().maximize(); 
		
		// login to the leaftaps account by entering id, password and clicking on the login
		driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input")).sendKeys("demosalesmanager");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		WebElement pwd = driver.findElement(By.name("PASSWORD"));
		pwd.sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//click on the CRM/SFA
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		//click on the accounts tab
		driver.findElement(By.linkText("Accounts")).click();
		
		//click on the create account button
		driver.findElement(By.linkText("Create Account")).click();
		
		//Enter the accountname, description, no.of emplotees and the Site Name
		driver.findElement(By.id("accountName")).sendKeys("Sravani Devi");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.id("numberEmployees")).sendKeys("10");
		WebElement sitename = driver.findElement(By.id("officeSiteName"));
		sitename.sendKeys("LeafTaps");
		
		//click on the submit button to create an account
		driver.findElement(By.className("smallSubmit")).click();
		
		//to get the title of the page 
		String title = driver.getTitle();
		System.out.println(title);
		
		//close the window
		driver.close();
	}

}
