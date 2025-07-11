package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWait {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();

		//Load URL
		driver.get("http://leaftaps.com/opentaps/");
		//maximize the window
		driver.manage().window().maximize(); 
		
		// login to the leaftaps account by entering id, password and clicking on the login
		driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input")).sendKeys("demosalesmanager");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement pwd = driver.findElement(By.xpath("//input[@class='decorativeSubmit']/preceding::input[1]"));
		pwd.sendKeys("crmsfa");
		
		
		driver.findElement(By.className("decorativeSubmit")).click();
	}

}
