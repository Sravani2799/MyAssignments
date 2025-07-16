package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Class room session note
public class LearnFrames {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/frame.xhtml");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click Me(Inside frame)
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		 
		//To swicth out of all the iframes
		driver.switchTo().defaultContent();
		
		//Click Me(Inside Nested frame) 
		WebElement nesframe = driver.findElement(By.xpath("//h5 [contains(text(),'Click Me (Inside Nested frame)')]/following-sibling::iframe")); 
		driver.switchTo().frame(nesframe); driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click")).click();
	}
}
