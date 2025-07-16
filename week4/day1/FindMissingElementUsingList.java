package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingElementUsingList {

	public static void main(String[] args) {
		
		Integer[] array = {1, 2, 3, 4, 10, 6, 8}; 
		
		List<Integer> list = new ArrayList<Integer>();
		for (int num : array) {
			list.add(num);
		}
		//print the list before sorting
		System.out.println(list);
		
		//sort the list
		 Collections.sort(list);
		 
		 //print the list after sorting
		 System.out.println(list);
		
		//initiating for loop to check the missing elements
		for (int i = 0; i < list.size()-1; i++) {
			
			//inside the loop, checking the current element + 1 is not equal to the next element
			if((list.get(i)+1)!=list.get(i+1)) {
				
			//Print the missing elements
		System.out.println(list.get(i)+1);
			}
		}
	}
}