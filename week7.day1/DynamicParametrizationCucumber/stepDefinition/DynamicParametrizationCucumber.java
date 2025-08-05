package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicParametrizationCucumber extends BaseClassDynamicCucumber{
	

	@When("The username is {string}")
	public void the_username_is(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);
	}

	@When("The password is {string}")
	public void the_password_is(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("Click on the login button")
	public void click_on_the_login_button() {
		driver.findElement(By.id("Login")).click();
	}

	@When("Click App Launcher")
	public void click_app_launcher() {
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
	}

	@When("Click View All")
	public void click_view_all() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}

	@When("Click Sales button")
	public void click_sales_button() {
		driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
	}

	@When("Click Accounts Tab")
	public void click_accounts_tab() {
		WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", accounts);
	}

	@When("Click New Account")
	public void click_new_account() {
		driver.findElement(By.xpath("//a[@title='New']")).click();
	}

	@When("Enter Account name as (.*)$")
	public void enter_account_name(String accountName) {
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(accountName);
	}

	@When("Select Public under ownership dropdown")
	public void select_public_under_ownership_dropdown() throws InterruptedException {
		WebElement ownershipDD = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
        driver.executeScript("arguments[0].click()",ownershipDD);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@title='Public']")).click();
	}
	@When("Click on the Save button")
	public void click_on_the_save_button() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}

	@Then("Verify the Account created and window")
	public void verify_the_account_created_and_window() {
		 WebElement toastMessage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
	     String text = toastMessage.getText();
	     System.out.println(text);
	}

}

