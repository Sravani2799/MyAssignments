package TestNGMarathon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteAccount extends BaseClass{

	//Created a variable String to pass the workbook name
	@BeforeTest
	public void setValues() {
		ExcelWorkBook = "DeleteAccount"; 
	}
	
	//Data provider fetched data will be passed to the test
	@Test(dataProvider = "fetchData")
	
	//Creating a variable and passing as argument to pass data from ExcelWorkBook
    public void runDeleteAccount(String accName) throws InterruptedException {
        
		//Filling all the required details and passing the data from Excel WorkBook under accName
        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(accName+ Keys.ENTER);
        Thread.sleep(2000);
        
        //Printing the number of items before deletion
        String noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
        System.out.println("No. of Items before Delete: " + noOfItems);
        String[] s = noOfItems.split(" ");
        int countBeforeDelete = Integer.parseInt(s[0]);
        
        //Clicking the dropdown, select delete and click delete
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
        Thread.sleep(3000);
        WebElement delete = driver.findElement(By.xpath("//div[@title='Delete']"));
        driver.executeScript("arguments[0].click();", delete);
        driver.findElement(By.xpath("//button[@title='Delete']")).click();
        Thread.sleep(2000);
        
        //Printing the number of items before deletion
        String noOfItems1 = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
        System.out.println("No. of Items after Delete: "+ noOfItems1);
        String[] s1 = noOfItems1.split(" ");
        int countAfterDelete = Integer.parseInt(s1[0]);
        
        //verifying using Assertion
        Assert.assertTrue(countBeforeDelete==(countAfterDelete+1),"Verify the account has deleted");
    }


}
