package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowhandle {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://leafground.com/window.xhtml");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		
		Set<String> windowhandles = driver.getWindowHandles();
		
		List<String> listwindows = new ArrayList<String>(windowhandles);
		
		 driver.switchTo().window(listwindows.get(1));
		 System.out.println(driver.getWindowHandle());
		 System.out.println(driver.getTitle());
		 
		 driver.close();
		 
		 driver.switchTo().window(listwindows.get(0));
		 
		 String windowHandle = driver.getWindowHandle();
		  System.out.println(windowHandle);
		  System.out.println(driver.getTitle());
		 driver.close();
	}
}
	
