package TestNGMarathon;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public abstract class BaseClass {
	
	public String ExcelWorkBook;
 
	public RemoteWebDriver driver;
	
	//Data Provider Method has been initialized with the return type from the saveData class (Where excel integration has been performed)
	@DataProvider(name= "fetchData") 
	public String[][] getData() throws IOException {
	return ExcelIntegrationTestNGMarathon.saveData(ExcelWorkBook); 
	}
	
	//Static Parameters has been initialized with @Parameters Method
	@Parameters({"browser", "url", "username", "password"})
	
	//Before method is usually performed before the actual test case
	@BeforeMethod
	
	//String variables has been passed as arguments
	public void preConditions(String browser, String url, String username, String password) throws InterruptedException {
		
		//if parameter name="browser" value="Chrome" it opens Chrome Browser
		//if parameter name="browser" value="Edge" it opens Edge Browser
		//In the same way, URL, username, password has been parameterized in the xml file as they are static for our project
	  if (browser.equalsIgnoreCase("Chrome")) {
		  ChromeOptions options = new ChromeOptions();
	      options.addArguments("--disable-notifications");
	      driver = new ChromeDriver(options);
	} else if (browser.equalsIgnoreCase("Edge")) {
		  EdgeOptions options = new EdgeOptions();
	      options.addArguments("--disable-notifications");
	      driver = new EdgeDriver(options);
	}
	  
	  //Values has been passed
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.get(url);
      driver.findElement(By.id("username")).sendKeys(username);
      driver.findElement(By.id("password")).sendKeys(password);
      driver.findElement(By.id("Login")).click();
      Thread.sleep(3000);
      
      //Click on App launcher and click view All
      driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
      driver.findElement(By.xpath("//button[text()='View All']")).click();
      
      //Click on Sales and click Accounts tab
      driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
      Thread.sleep(5000);
      WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
      driver.executeScript("arguments[0].click();", accounts);
  }
	
	//After method is performed after the test case has been run
   @AfterMethod
   public void postConditions() {
	  driver.close();
  }

}
