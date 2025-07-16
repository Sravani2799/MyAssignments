package week4.day1;

//Classroom session code
public class LearnOverRiding extends LearnOverLoading{

	public void reportStep(String message, String status) {
		System.out.println("The message: " + message + ". " + " The staus is: " + status);
	}
	public static void main(String[] args) {
		LearnOverRiding or = new LearnOverRiding();
		or.reportStep("Good morning", "Sent");
	}

}
