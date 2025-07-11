package week3.day2;

//Creating a subclass RadioButton and inheriting Button class
public class RadioButton extends Button
{
	//Adding a method into subclass RadioButton
	public void selectRadioButton()
	{
		System.out.println("Select the radio button");
	}
	public static void main(String[] args)
	{
		//Creating a object to call methods from subclass RadioButton and Button class
		RadioButton Rb = new RadioButton();
		Rb.selectRadioButton();
		Rb.submit();
	}


}
