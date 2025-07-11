package week3.day1;

public class RemoveDupsInString {

	public static void main(String[] args) {
		//To remove duplicates from a String
		String text = "We learn Java basics as part of java sessions in java week1"; 
		
		//initial variable to keep track of the number of duplicate words found
		int count = 0;
		
		//To Split the text into an array of words
		String[] words =text.split(" ");
		
		//Nested loop to compare each word with every other word in String array
		for (int i = 0; i < words.length; i++) {
			for (int j = i+1 ; j < words.length; j++) {
				
				//If a duplicate word is found, it is replaced with an empty string and the count is incremented
				if(words[i].equalsIgnoreCase(words[j])) {
					words[j]="";
					count++;
				}
			}
		}
		//this will print the modified words array where duplicates have been replaced
		if(count>1) {
			System.out.println("After removing dups");
			for (int i = 0; i < words.length; i++) {
				System.out.print(words[i] + " ");
			}
			}
		else {
			System.out.println("No duplicates found");
		}
	
	}
	}
