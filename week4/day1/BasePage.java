package week4.day1;
//Initialized a class to demonstrate Method Overriding
public class BasePage { //main class

	//Created methods to perform in LoginPage Subclass
	public void findElement(String element) {
		System.out.println("The element to be founded: " + element);
	}
	public void clickElement(boolean click) {
		System.out.println("The element has been clicked: " + click);
	}
	public void enterText(String text) {
		System.out.println("The text entered: " + text);
	}
	//This method is created to perform Method Overriding in the LoginPage Subclass
	public void performCommonTasks() {
				String a = "Sra";
				String b = "vani";
				System.out.println(a+b);
	}
	public static void main(String[] args) {
		//Object created to use the performCommonTasks method
		BasePage bp = new BasePage();
		bp.performCommonTasks();
	}
}

