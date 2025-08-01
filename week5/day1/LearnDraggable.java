package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnDraggable {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/draggable/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement frame0 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(frame0);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		Actions act = new Actions(driver);
		
		//Drag to a particular location 
		act.dragAndDropBy(drag, 30, 80).perform(); 
		
		//drag to a point on the webpage when we dont have proper location to drop.
		Point location = drag.getLocation();
		int x = location.getX();
		int y = location.getY();
		act.dragAndDropBy(drag, x, y).perform();
		
		
	}

}
