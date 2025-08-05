package week6.excelIntegration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CreateLeadIRealExcelIntegration extends BaseClassForRealExcelIntegration{
	
	@Test(dataProvider = "fetchData")
	public void runCreateLead(String cName, String fName, String lName) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
		WebElement fname = driver.findElement(By.id("viewLead_firstName_sp"));
		String text = fname.getText();
		System.out.println("The name of the Lead: " + text);
		if(fName.equals(text)) {
			System.out.println("The Form is Created Correctly");
		} else {
			System.out.println("The Form is not Created Correctly");
		}
	}
	@DataProvider(name="fetchData") 
	public String[][] sendData() throws IOException{
		
		return ReadExcelIntegration.readData();
		
	}
}






