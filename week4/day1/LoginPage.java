package week4.day1;

//Initialized a class to inherit BasePage class and show how Method Overriding in Java works
public class LoginPage extends BasePage{
	
	//Overrided method from BasePage
	public void performCommonTasks() {
		int a = 10;
		int b = 20;
		System.out.println(a+b);
	}
	//main method
	public static void main(String[] args) {
		
		//Object has been created to call the methods from BasePage and show the overrided method performCommonTasks
		LoginPage lp = new LoginPage();
		lp.findElement("Srav");
		lp.clickElement(true);
		lp.enterText("This is Sravani");
		lp.performCommonTasks();
	}

}
