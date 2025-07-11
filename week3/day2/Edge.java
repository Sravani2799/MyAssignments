package week3.day2;

public class Edge extends Browser{
	
	public void takeSnap() {
		System.out.println("Took a Snap");
	}
	public void clearCookies() {
		System.out.println("Cookies cleared");
	}

	public static void main(String[] args) {

		Edge e = new Edge();	
		System.out.println(e.browserName("edge"));
		System.out.println(e.browserVersion("7.1"));
		e.takeSnap();
		e.clearCookies();
		e.openURL();
		e.closeBrowser();
		e.navigateBack();
	
	}

}
