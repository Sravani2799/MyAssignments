package week6.commonIntegrationExcel;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends CommonIntegrationBaseClass{
	
	@BeforeTest
	public void filename() {
		excelFileName = "CreateLead"; 
	}
	
	@Test(dataProvider = "fetchData")
	public void runCreateLead(String companyName, String firstName, String lastName, String phoneNum) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNum);
		driver.findElement(By.name("submitButton")).click();
	}
}






