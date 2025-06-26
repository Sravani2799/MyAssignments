package week1.day2;

public class IsPrimeNumber {

	public static void main(String[] args) {
		
		int n = 15;
	
		if(n<=1) {
			System.out.println("Enter a number greater than 1");
		}
		for (int i =2; i <= Math.sqrt(n);i++) {
			if (n%i==0) {
				System.out.println("Not a Prime Number");
				return;
			} 
			}
			System.out.println("Prime Number");
		}
	}
