package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Home Assignment
public class WindowHandlingandInteractionAutomation {

	public static void main(String[] args) {
		//Launch browser, URL and wait for 30 secs
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//click on the 'OK' of the notification/Alert
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on flights from the menu
		driver.findElement(By.partialLinkText("FLIGHTS")).click();
		
		//Getting window handles to switch between windows
		Set<String> windowHandles = driver.getWindowHandles();
		
		//Creating a list string for windowHandles to perform get to switch
		List<String> windows = new ArrayList<String>(windowHandles);
		
		//Switch to child window
		String flightwindow = windows.get(1);
		System.out.println(flightwindow); //print the window handle
		driver.switchTo().window(flightwindow);
		System.out.println(driver.getTitle()); //print the title of the child page
		
		//Switch back to parent window and close it
		driver.switchTo().window(windows.get(0));
		driver.close();
	}

}
