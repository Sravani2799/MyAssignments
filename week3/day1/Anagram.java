package week3.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String text1 = "stops";  
	 	String text2 = "potss";
	 	
	 	//this will check if the length of two string are same and return the print text if not same
	 	if (text1.length()!=text2.length()) {
	 		System.out.println("Lengths of two string are not same"); 
	 	}
	 	//if length of both strings are same then it will enter else
	 	else {
	 		//both the string will be converted to array
	 		char[] charArray1 = text1.toCharArray();
	 		char[] charArray2 = text2.toCharArray();
	 		
	 		//arrays will be sorted
	 		Arrays.sort(charArray1);
	 		Arrays.sort(charArray2);
	 		
	 		//if will check if the arrays are equal and print the statement 
	 		if (Arrays.equals(charArray1, charArray2)) {
	 			System.out.println("The given strings are Anagram"); //if strings are anagram
	 		}
	 		else {
	 			System.out.println("The given strings are not an Anagram"); //if string are not anagram
	 		}
	 		
	 	}
 	}
}