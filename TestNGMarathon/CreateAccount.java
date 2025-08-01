package TestNGMarathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccount extends BaseClass{
	
	//Created a variable String to pass the workbook name
	@BeforeTest
	public void setValues() {
		ExcelWorkBook = "CreateAccount"; 
	}
	
	//Data provider fetched data will be passed to the test
	@Test(dataProvider = "fetchData")
    public void runCreateAccount(String accName) throws InterruptedException {
		
		//Click 'New' to create a new account
        driver.findElement(By.xpath("//a[@title='New']")).click();
        
        //Passed the required details
        driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(accName);
        WebElement ownershipDD = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
        driver.executeScript("arguments[0].click()",ownershipDD);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@title='Public']")).click();
        
        //Saved 
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        
        //ToastMessage has been printed to confirm
        WebElement toastMessage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
        String text = toastMessage.getText();
        System.out.println(text);
        
        //Assertion to verify if the name passed is present in the ToastMessage
        Assert.assertTrue(text.contains(accName),"Verify the Account name");
    }

}
