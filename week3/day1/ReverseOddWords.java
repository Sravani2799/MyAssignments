package week3.day1;

public class ReverseOddWords {

	public static void main(String[] args) {
       //initializing variable with String test
		String test= "I am a software tester";
		
		//Split the words
		String[] words= test.split(" ");
		
		//Loop to traverse through each word
		for(int i=0;i<words.length;i++) {
			
			//to find the odd index within the loop
			if(i%2==0)
			{
				System.out.print(words[i] + " ");
			} 
			else {
				//This will Convert the String array into a character array
				char[] letters = words[i].toCharArray();
				
				//Another loop to Print the even position words
				for (int j = letters.length -1 ; j >= 0 ; j--)
				{
					System.out.print(letters[j]);
				}
				
			}
			}
		}
	}
	


