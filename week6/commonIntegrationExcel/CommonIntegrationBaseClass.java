package week6.commonIntegrationExcel;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class CommonIntegrationBaseClass {
	public String excelFileName;
	
	public RemoteWebDriver driver;
	
	@DataProvider(name = "fetchData")
	public String[][] excelValues() throws IOException {
		return CommonIntegrationExcel.getDataFromExcel(excelFileName);
	}
 
  @Parameters({"browser", "url", "uName", "pwd"})
  
  @BeforeMethod
  public void preConditions(String browser, String url, String uName, String pwd) {
	  if (browser.equalsIgnoreCase("Chrome")) {
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("guest");
		  driver = new ChromeDriver();
	} else if (browser.equalsIgnoreCase("Edge")) {
		driver = new EdgeDriver();
	}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
  }

  @AfterMethod
  	  	public void postConditions() {
	  	driver.close();
  }

}
