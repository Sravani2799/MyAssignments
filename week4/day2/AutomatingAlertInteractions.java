package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

//Creating a class to interact with the Alerts (Home assignment)
public class AutomatingAlertInteractions {

	public static void main(String[] args) {
		
		//initializing the Chrome WebDriver
		ChromeDriver driver = new ChromeDriver();
		
		//Opening the URL
		driver.get("https://www.leafground.com/alert.xhtml");
		
		//Maximized the window and waited for 30 secs for the page to completely load
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//To click on the Show button under Alert (Prompt Dialog)
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		
		//To switch to the alert
		Alert alert = driver.switchTo().alert();
		
		//Initialized a String variable to s to save the text to be entered in the alert
		String s = "Sravani";
		
		//The String 's' has been passed to the alert
		alert.sendKeys(s);
		
		//Alert will be accepted
		alert.accept();
		
		//To get the text displayed after accepting the alert
		String text = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		
		//To verify the text displayed with the input String 's'
		if(text.contains(s)) {
			System.out.println("The input is verified");
		} else {
			System.out.println("The input is invalid");
		}
	}

}
