package week6.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public ChromeDriver driver;
	
	@Parameters({"url", "username", "password"})

  @BeforeMethod
  public void preConditions(String url, String username, String password) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		options.addArguments("--diable-notifications");
	  	driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.clear();
		userName.sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password, Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @AfterMethod
  		public void postConditions() {
	  driver.close();
  }

}
