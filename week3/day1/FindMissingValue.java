package week3.day1;

import java.util.Arrays;

public class FindMissingValue {

	public static void main(String[] args) {
		
		int Input[] = {1,4,3,2,8,6,7};  
		
		int missingvalue=1;
		
		Arrays.sort(Input);
		
		for (int i = 0; i < Input.length; i++)
		{
			if(Input[i]!=missingvalue)
			{
				System.out.println(missingvalue);
				break;
			}
			missingvalue++;
		}
	}

}
