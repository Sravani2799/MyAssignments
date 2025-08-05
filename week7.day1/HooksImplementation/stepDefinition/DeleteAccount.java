package stepDefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeleteAccount extends BaseClassForHooks{
	
	@Given("Click Deactivate Account")
	public void click_deactivate_account() {
	    driver.findElement(By.xpath("//a[text()='Deactivate Account']")).click();
	}

	@Given("Handle and Click OK in the Alert")
	public void handle_and_click_ok_in_the_alert() {
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	}

	@Then("Print and verify the Account status")
	public void print_and_verify_the_account_status() {
	    String text = driver.findElement(By.className("subSectionWarning")).getText();
	    System.out.println(text);
	    if (text.contains("deactivated")) {
			System.out.println("Account is deleted");
		} else {
			System.out.println("Account is not deleted");
		}
	}

}
