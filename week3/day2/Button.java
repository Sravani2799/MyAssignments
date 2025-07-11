package week3.day2;
	//Creating Button subclass and calling WebElement Baseclass into it
	public class Button extends WebElement {
		//method-01 in subclass(Button)
		public void submit() {
			System.out.println("Click submit button");
		}
		public static void main(String[] args) {
			//creating an object to call the methods in Button subclass and WebElement Baseclass
			Button b = new Button();
			b.submit();
			b.setText("Hai AJ");
			b.click();
		}

	}

