package week3.day2;
//Creating a subclass CheckBoxButton and inheriting Button Class
public class CheckBoxButton extends Button {
	
	//Introducing a method named clickCheckButton in CheckBoxButton
	public void clickCheckButton() {
		System.out.println("Click on the check button");
	}
	
	public static void main(String[] args) {
		//Creating an object to call methods in both subclass CheckBoxButton and Button Class
		CheckBoxButton cb = new CheckBoxButton();
		cb.clickCheckButton();
		cb.submit();
	}

}
