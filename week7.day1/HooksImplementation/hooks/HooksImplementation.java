package hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import stepDefinition.BaseClassForHooks;

public class HooksImplementation extends BaseClassForHooks{

	@Before
	public void preConditions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

	}
	@After
	public void postConditions() {
		driver.close();
	}
}
