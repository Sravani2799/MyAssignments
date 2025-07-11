package week3.day1;

public class FindIntersection {

	public static void main(String[] args)
	{
		//we take 2 arrays with int datatype to check for any intersection(same values) are present in the Arrays
		int a[]= {3,2,11,4,6,7}; 
        int b[]= {1,2,8,4,9,7}; 
        
        // (initialization with '0' ; condition to enter the loop if i< a.length ; iteration i++)
        //(we initialize a nested loop to check each element of a with each element of b)
        for (int i = 0; i < a.length; i++)
        {
        	for (int j = 0; j < b.length; j++)
        	{
        		//if we find any intersection of b with a then the value in 'a' will be printed
				if(a[i]==b[j]) 
				{
					System.out.println(a[i]);
				}
				}
        	}
        }
	}
