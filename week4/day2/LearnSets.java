package week4.day2;

import java.util.LinkedHashSet;
import java.util.Set;

//class room activity for sets
public class LearnSets {

	public static void main(String[] args) {
		
		String companyName = "google";
		
		char[] charArray = companyName.toCharArray();
		
		Set<Character> uniquechar = new LinkedHashSet <Character>();
		
		for (int i = 0; i < charArray.length; i++) {
			uniquechar.add(charArray[i]);
		}
		System.out.println(uniquechar);
	}

}
