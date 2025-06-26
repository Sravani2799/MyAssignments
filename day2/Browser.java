package week1.day2;


public class Browser {
	
	String launchbrowser(String browserName) {
	System.out.println("Browser launched successfully");
	return(browserName);
	}
	
	void loadUrl()
	{
	System.out.println("Application URL loaded successfully");
	}


	public static void main(String[] args) {
	Browser obj= new Browser();
	System.out.println(obj.launchbrowser("chrome"));
	obj.loadUrl();
	}

}
