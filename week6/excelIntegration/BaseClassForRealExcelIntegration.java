package week6.excelIntegration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClassForRealExcelIntegration{
	
	public RemoteWebDriver driver;
  
	@Parameters({"browser", "url","username","password"})
	
  @BeforeMethod
  public void preConditions(String Browser, String URL, String UNAME, String PWD) {
		
		if (Browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("guest");
			driver = new ChromeDriver(options);
		} else if (Browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(UNAME);
		driver.findElement(By.id("password")).sendKeys(PWD);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
  }

  @AfterMethod
  public void postConditions() {
	  driver.close();
  }

}
