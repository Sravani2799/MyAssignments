package TestNGMarathon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class EditAccount extends BaseClass{
		
		//Created a variable String to pass the workbook name
		@BeforeTest
		public void setValues() {
			ExcelWorkBook = "EditAccount"; 
		}
		
		//Data provider fetched data will be passed to the test
		@Test(dataProvider = "fetchData")
		
		//Creating a variable and passing as argument to pass data from ExcelWorkBook
		public void runEditAccount(String accName, String BillingStreet, String ShippingStreet) throws InterruptedException {
        
		//Passed the required details retrieved from the ExcelWorkBook
        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(accName+ Keys.ENTER);
        
        Thread.sleep(3000);
        
        //Click the dropdown and click Edit button
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
        driver.findElement(By.xpath("//a[@title='Edit']")).click();
        
        //Filling all the required details and passing the data from Excel WorkBook under BillingStreet and ShippingStreet
        WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
        driver.executeScript("arguments[0].click()",typeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Technology Partner']")).click();
        WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
        driver.executeScript("arguments[0].click()",industryDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']")).click();
        WebElement biilingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
        biilingStreet.clear();
        biilingStreet.sendKeys(BillingStreet);
        WebElement shippingStreet = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
        shippingStreet.clear();
        shippingStreet.sendKeys(ShippingStreet);
        WebElement priorityDD = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
        driver.executeScript("arguments[0].click()",priorityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']")).click();
        driver.findElement(By.xpath("//button[@aria-label='SLA']")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Silver']")).click();
        WebElement activeDD = driver.findElement(By.xpath("//button[@aria-label='Active']"));
        driver.executeScript("arguments[0].click()",activeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
        
        //creating a random number integer to pass as a phone number and printing it to verify
        int randomNum1 = (int)(Math.random()*999999);
        int randomNum2 = (int)(Math.random()*999999);
        String phno = ""+randomNum1+randomNum2;
        phno = phno.substring(0,10);
        System.out.println("The phone number is: " + phno);
        WebElement phnoField = driver.findElement(By.xpath("//input[@name='Phone']"));
        phnoField.clear();
        phnoField.sendKeys(phno);
        
        //selecing Opportunity and click Save button
        WebElement upsellOpportunityDD = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
        driver.executeScript("arguments[0].click()",upsellOpportunityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        
        Thread.sleep(3000);
        
        //Retrieving the phone number added while editing and printing it
        WebElement phnoStr = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]"));
        String text = phnoStr.getText();
        System.out.println("The updated phone number is " + text); 
        
        //Using assertion to verify the phone number 
        Assert.assertTrue(text.equals(phno), "verify the mobile Number"); 
    }

}
