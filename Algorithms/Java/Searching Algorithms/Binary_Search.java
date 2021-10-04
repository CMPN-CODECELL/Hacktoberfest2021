/*
Space Complexity For The Binary Search is O(1).
Time Complexity For The Binary Search is O(logN) ( For the two cases i.e. Worst and Average)
Time Complexity for the Best Case would be O(1).

Test Case 1: 
Input: n = 4; arr[] = 1,2,6, 9 search = 2
Output: The number 2 is present in the given array
Explanation: The element 2 is present in the array.

Test Case 2: 
Input: n = 5; arr[] = -9,-7,-1,2,3, search = -2
Output: The number -2 is not present in the given array.
Explanation: The element -2 is not present in the array.
*/

import java.io.*;
public class Binary_Search
{
	static int n;
	public static void main(String args[])throws IOException
	{
		int i,n,search;
		InputStreamReader read = new InputStreamReader(System.in);
      		BufferedReader in = new BufferedReader(read);
		System.out.println("Enter The Length Of Integers to be added : "); // Enter the length of how many integers will be added.
		n = Integer.parseInt(in.readLine());
		int arr[] = new int[n]; //Making an array of length n to store all the integers.
		System.out.println("Enter the Integers: "); //Enter all the integers in the array, in an ascending order.
		for(i = 0; i < n; i++) 
		{
			arr[i] = Integer.parseInt(in.readLine());	
		}	
		System.out.println("Enter the Integer To Be Searched: ");
		search = Integer.parseInt(in.readLine());
		int flag = binarysearch(arr, search); // Performs binary search
		if(flag != (-1)) 
		{
			System.out.println("The number "+search+" is present in the given array.");
		}
		else
		{
			System.out.println("The number "+search+" is not present in the given array.");
		}
		System.out.println();
	}		
	static int binarysearch(int arr[], int k) 
	{
		int low, high, mid;
		int n = arr.length;
		low = 0;
		high = n-1;
		while(low <= high) //Iterating through the entire array
		{
			mid = low+(high-low)/2; //Calculates the middle of the array length.
			if(arr[mid] == k) //Checks if the middle element is same as the search element
			{
				return k;	 //This means that the element is present in the array.
			}			
			else if(arr[mid] < k) /*As the array is in ascending order, if the middle element is less than the search element, the element is present in the right sub-array, so we will increase the low pointer to middle + 1 */				{
				low = mid + 1;	
			}
			/*As the array is in ascending order, if the middle element is greater than the search element, the element is present in the left sub-array, so we will increase the high pointer to middle - 1 */	
			else  
			{
				high = mid - 1;
			}
		}
		return -1; //This means that the element is not present in the array.
	}
}