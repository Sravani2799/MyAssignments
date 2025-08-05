package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StaticParametrizationCucumber extends BaseClassStaticCucumber{
	public String phnogen;

	@When("Enter the username as {string}")
	public void enter_the_username_as(String uName) {
	driver.findElement(By.id("username")).sendKeys(uName);
	      
	}
	@When("Enter the password in as {string}")
	public void enter_the_password_in_as(String pwd) {
	driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("click on the login button")
	public void click_on_the_login_button() {
	driver.findElement(By.id("Login")).click();
	}

	@When("click on the App launcher")
	public void click_on_the_app_launcher() {
	driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
	}

	@When("click on View All")
	public void click_on_view_all() {
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	}

	@When("scroll to the Accounts and click it")
	public void scroll_to_the_accounts_and_click_it() throws InterruptedException {
	driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
	Thread.sleep(3000);
	
	WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
	driver.executeScript("arguments[0].click();", accounts);
	}

	@When("Search for the account name {string}")
	public void search_for_the_account_name(String Name) throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(Name+ Keys.ENTER);
		Thread.sleep(3000);
	}
	@When("Click on the dropdown of the first account")
	public void click_on_the_dropdown_of_the_first_account() {
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
	}

	@When("Click on the edit")
	public void click_on_the_edit() {
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
	}

	@When("select Technology Partner under Type")
	public void select_technology_partner_under_type() {
		WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
        driver.executeScript("arguments[0].click()",typeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Technology Partner']")).click();
	}

	@When("select Healthcare under Industry")
	public void select_industry_under_healthcare() {
		WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
        driver.executeScript("arguments[0].click()",industryDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']")).click();
	}
	
	@When("Enter the Billing Address as (.*)$")
	public void enter_the_billing_address(String billingAdd) {
		WebElement biilingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
        biilingStreet.clear();
        biilingStreet.sendKeys(billingAdd);
	}

	@When("Enter the Shipping Address as (.*)$")
	public void enter_the_shipping_address(String shippingAdd) {
		WebElement shippingStreet = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
        shippingStreet.clear();
        shippingStreet.sendKeys(shippingAdd);
	}

	@When("Set the Customer Priority to Low")
	public void set_the_customer_priority_to_low() {
		WebElement priorityDD = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
        driver.executeScript("arguments[0].click()",priorityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']")).click();
	}

	@When("Set SLA to Silver")
	public void set_sla_to_silver() {
		driver.findElement(By.xpath("//button[@aria-label='SLA']")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Silver']")).click();
	}

	@When("Set Active to No")
	public void set_active_to_no() {
		WebElement activeDD = driver.findElement(By.xpath("//button[@aria-label='Active']"));
        driver.executeScript("arguments[0].click()",activeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
	}

	@When("Entering a unique number in the Phone field")
	public void entering_a_unique_number_in_the_phone_field() {
		int randomNum1 = (int)(Math.random()*999999);
        int randomNum2 = (int)(Math.random()*999999);
        String phno = ""+randomNum1+randomNum2;
        phnogen = phno.substring(0,10);
        System.out.println("The phone number is: " + phnogen);
        WebElement phnoField = driver.findElement(By.xpath("//input[@name='Phone']"));
        phnoField.clear();
        phnoField.sendKeys(phnogen);
	}

	@When("Set Upsell Oportunity to No")
	public void set_upsell_oportunity_to_no() {
		WebElement upsellOpportunityDD = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
        driver.executeScript("arguments[0].click()",upsellOpportunityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
	}

	@When("Click Save")
	public void click_save() throws InterruptedException {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        
        Thread.sleep(3000);
	}

	@Then("Verify the Phone Number")
	public void verify_the_phone_number() {
		WebElement phnoStr = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]"));
        String text = phnoStr.getText();
        System.out.println("The updated phone number is " + text); 
        if (text.contains(phnogen)) {
				System.out.println("The Number is verified");
		} else {
			System.out.println("The number is not verified");
		}
	}
}
