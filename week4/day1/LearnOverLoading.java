package week4.day1;

//Class room session code
public class LearnOverLoading {
	
	public void reportStep(String message, String status) {
		System.out.println("The message is: " + message + ". " + "The status of the message is: " + status);
	}
	public void reportStep(String message, String status, boolean snap) {
		System.out.println("The message is: " + message + ". " + "The status of the message is: " + status + " and it is " +snap);
	}

	public static void main(String[] args) {
		LearnOverLoading lo = new LearnOverLoading();
		lo.reportStep("Testleaf ", "Going on");
		lo.reportStep("Hello", "Sent", true);
	}

}
