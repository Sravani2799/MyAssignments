package week4.day2;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Class room session note
public class LearnAlerts {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/alert.xhtml");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Simple Dialog(Alert)
		driver.findElement(By.xpath("(//span[text()='Show'])[1]")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		String text = driver.findElement(By.id("simple_result")).getText();
		System.out.println(text);
			
		//Alert(Confirm Dialog)
		driver.findElement(By.xpath(("(//span[@class='ui-button-text ui-c'])[2]"))).click();
		alert.dismiss();
		String text2 = driver.findElement(By.xpath("//span[@id='result']")).getText();
		System.out.println(text2);
			
		//Alert(prompt Dialog)
		WebElement promptDialog = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]"));
		promptDialog.click(); 
		driver.switchTo().alert();
		alert.sendKeys("Sravani");
		alert.accept();
			
		//sweet simple alert
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
			
		//sweet modal Dialog
		driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
		driver.findElement(By.xpath("(//a[@aria-label='Close'])[2]")).click();
		 
		//sweet alert(confirmation)
		driver.findElement(By.xpath("(//span[text()='Delete'])[6]")).click();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
			
			
	}

}
