package week1.day2;

public class IsPrimeNumber {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int n = 510;
	
		if(n<=1) {
			System.out.println("Enter a number greater than 1");
		}
		for (int i =2; i <= Math.sqrt(n);i++) {
			if (n%2==0) {
				System.out.println("Not a Prime Number");
				break;
			} else {
				System.out.println("Prime Number");
				break;
			}
		}
	}

}
