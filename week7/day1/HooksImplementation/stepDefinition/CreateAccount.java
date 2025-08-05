package stepDefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateAccount extends BaseClassForHooks{

	@Given("Click Accounts")
	public void click_accounts() {
	    driver.findElement(By.xpath("//a[text()='Accounts']")).click();
	}

	@Given("Click Create Account")
	public void click_create_account() {
	   driver.findElement(By.xpath("//a[text()='Create Account']")).click();
	}

	@Given("Enter Account Name as {string}")
	public void enter_account_name_as(String accName) {
		driver.findElement(By.id("accountName")).sendKeys(accName);
	}

	@Given("Enter Phone Number as {string}")
	public void enter_phone_number_as(String phNum) {
	   driver.findElement(By.id("primaryPhoneNumber")).sendKeys(phNum);
	}

	@Then("Click Submit at Create Account")
	public void click_submit_at_create_account() throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		Thread.sleep(3000);
	}
	
	@Then("Account Details page should be Loaded")
	public void account_details_page_should_be_loaded() {
	    String title = driver.getTitle();
	    System.out.println("Title of the page is: "+title);
	    if (title.contains("Account Details")) {
			System.out.println("Verified");
		} else {
			System.out.println("Not Verified");
		}
	}
}
