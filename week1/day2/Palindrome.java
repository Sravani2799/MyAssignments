package week1.day2;


public class Palindrome {

	public static void main(String[] args) {

		int input = 141;
		
		int output = 0;
		
		int original = input; 
		
		if(input<0) {
		System.out.println("Not a valid input");
		return;
	}
		for(int i = input; i > 0 ; i = i / 10) {
			int j = i % 10;
			output = output * 10 + j ;
		}
		
		if(original==output) {
			System.out.println("Palindrome");
		} else { 
			System.out.println("Not Palindrome");
		}

}
}
