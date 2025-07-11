package week2.day2;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {

		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		// source dd
		
		WebElement sourceDD=driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select source=new Select(sourceDD);
		source.selectByIndex(4);
		
		WebElement marketingDD=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select marketing=new Select(marketingDD);
		marketing.selectByContainsVisibleText("Automobile");
		
		WebElement ownershipDD=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownership=new Select(ownershipDD);
		ownership.selectByValue("OWN_CCORP");
		
		//mandatory feilds
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("SR");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sravani");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Paramasivam");
		
		driver.findElement(By.name("submitButton")).click();
		
		//print title of current webpage
		System.out.println(driver.getTitle());
		
		driver.close();
		
		
	}

}
