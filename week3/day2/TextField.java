package week3.day2;
//Creating TextField subclass and calling WebElement Baseclass into it
public class TextField extends WebElement {
	
	//included a getText() method in Textfield subclass
	public String getText() {
		return "Return Text value as output";
	}
	public static void main(String[] args)
	{
		//Creating an object to call the method in TextField subclass and WebElement Baseclass
		TextField Tf = new TextField();
		System.out.println(Tf.getText());
		Tf.click();
		Tf.setText("Welcome");
	}

}
