package week3.day2;

//Creating a base class for Inheritance
  public class WebElement {
	  
	  //method-01 in base class
	  public void click() {
	System.out.println("CLick on the web element");
}
	//method-02 in base class
  public void setText(String text) {
	System.out.println(text);
}
  public static void main(String[] args) {
	  //creating an object to call the method in the base class
	WebElement we = new WebElement();
	we.click();
	we.setText("Hello Element");
}

}
