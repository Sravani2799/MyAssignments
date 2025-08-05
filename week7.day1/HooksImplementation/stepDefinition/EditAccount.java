package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EditAccount extends BaseClassForHooks{
	
	@Given("Click Find Account")
	public void click_find_account() {
	    driver.findElement(By.xpath("//a[text()='Find Accounts']")).click();
	}

	@Given("Click Find by Phone")
	public void click_find_by_phone() {
	    driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	
	@Given("Enter Phone Number to search as {string}")
	public void enter_phone_number_to_search_as(String phNo) throws InterruptedException {
		driver.findElement(By.name("phoneNumber")).sendKeys(phNo);
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
		Thread.sleep(1000);
	}

	@Given("Click on the first resulting account")
	public void click_on_the_first_resulting_account() {
	    driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@Given("Click Edit")
	public void click_edit() {
	    driver.findElement(By.xpath("(//a[text()='Edit'])[1]")).click();
	}

	@Given("Enter {string} in Local Name")
	public void enter_in_local_name(String localName) {
	    WebElement localName1 = driver.findElement(By.id("groupNameLocal"));
	    localName1.clear();
	    localName1.sendKeys(localName);
	}
	
	@Given("Click Save in Edit Account Page")
	public void click_save_in_edit_account_page() throws InterruptedException {
	  driver.findElement(By.className("smallSubmit")).click();
	  Thread.sleep(3000);
	}
	@Then("Account Details page should be loaded")
	public void account_details_page_should_be_loaded() {
	    String title = driver.getTitle();
	    System.out.println("Title of the page after Edit is: "+title);
	    if (title.contains("Account Details")) {
			System.out.println("Verified");
		} else {
			System.out.println("Not Verified");
		}
	}

	@Then("print and verify the Local Name")
	public void print_and_verify_the_local_name() {
	   String localName = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/span")).getText();
	   if (localName.equalsIgnoreCase("SraRam")) {
		System.out.println("Edits Verified");
	} else {
		System.out.println("Edits not Verified");
		}
	}
}
