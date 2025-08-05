package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SalesForceDynamicParametrization extends BaseClass{
	
	@Parameters({"url", "username", "password"})
	
	@Test(dataProvider = "fD")
		public void runSalesForceDynamicParametrization(String name) throws InterruptedException {
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
			driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
			Thread.sleep(8000);
		
			WebElement legalEntityButton = driver.findElement(By.xpath("//p[normalize-space()='Legal Entities']"));
			Actions legal = new Actions(driver);
			legal.scrollToElement(legalEntityButton).perform();
			legalEntityButton.click();
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Salesforce Automation by " + name);
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		String text = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println("The entity name is: " + text);
		
		driver.close();
		
	}
	@DataProvider(name = "fD")
	
	public String[][] saveData() {
		
		String[][] data = new String[3][1];
		
		data[0][0] = "Sravani";
		data[1][0] = "Ramana";
		data[2][0] = "Satish";
		
		return data;
	}
		
}