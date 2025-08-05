package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SalesForceStaticParametrization extends StaticParametrization{
	@Test
	public void runSalesForceStaticParametrization() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(8000);
		
		WebElement legalEntityButton = driver.findElement(By.xpath("//p[normalize-space()='Legal Entities']"));
		Actions legal = new Actions(driver);
		legal.scrollToElement(legalEntityButton).perform();
		legalEntityButton.click();
		
		 driver.findElement(By.xpath("//div[@title='New']")).click();
		 driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("Testleaf");
		 driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces"); 
		 
		 Thread.sleep(2000);
			WebElement status1 = driver.findElement(By.xpath("//button[@data-value='--None--']"));
			driver.executeScript("arguments[0].click();", status1);
			
			WebElement status=driver.findElement(By.xpath("//button[@data-value='--None--']"));
			driver.executeScript("arguments[0].click();", status);
			
			WebElement Active = driver.findElement(By.xpath("//span[text()='Active']"));
			Active.click();
			
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
			
			Thread.sleep(3000);
			
			String text = driver.findElement(By.xpath("//ul[@class='errorsList slds-list_dotted slds-m-left_medium']//a")).getText(); 
			System.out.println("Complete this field: " + text);
	}
}
