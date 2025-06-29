package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLeadInLeafTaps {

		public static void main(String[] args) {
		//setup browser driver
		ChromeDriver lead=new ChromeDriver();
		
		//load URL
		lead.get("http://leaftaps.com/opentaps/");
		//miximize the window
		lead.manage().window().maximize();
		
		//enter valid username and password and click on submit button
		lead.findElement(By.id("username")).sendKeys("demosalesmanager");
		WebElement pwd = lead.findElement(By.name("PASSWORD"));
		pwd.sendKeys("crmsfa");
		lead.findElement(By.className("decorativeSubmit")).click();
		
		//on the CRM/SFA
		lead.findElement(By.partialLinkText("CRM/SFA")).click();
		
		//click on the Leads tab
		WebElement leadsButton = lead.findElement(By.linkText("Leads"));
		leadsButton.click();
		
		//click on the Create Lead button
		lead.findElement(By.linkText("Create Lead")).click();
		
		//Enter the firstname, Lastname, Companyname and Title
		lead.findElement(By.id("createLeadForm_firstName")).sendKeys("Sravani");
		
		lead.findElement(By.id("createLeadForm_lastName")).sendKeys("Devi");
		
		lead.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeads");
		
		lead.findElement(By.name("generalProfTitle")).sendKeys("Test Project For Automation");
		
		//click on the create lead button to create a lead
		WebElement CreateleadButton=lead.findElement(By.className("smallSubmit"));
		CreateleadButton.click();
		
		//get the title of the window/page
		String printTitle = lead.getTitle();
		System.out.println(printTitle);
		
		//close the window
		lead.close();
	
	}

}
