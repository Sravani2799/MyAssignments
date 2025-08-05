package week6.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class StaticParametrization {
	
	public RemoteWebDriver driver;
	
	@Parameters({"browser", "url", "username", "password"})
	
  @BeforeMethod
  public void preConditions(String browser, String url, String username, String password) {
		
		if (browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("guest");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("Edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("guest");
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.clear();
		userName.sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password, Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  }

