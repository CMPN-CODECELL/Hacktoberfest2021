import java.io.*;
public class Selection_Sort
{
	static int n;
	public static void main(String args[])throws IOException
	{
		int i,n;
		InputStreamReader read = new InputStreamReader(System.in);
      		BufferedReader in = new BufferedReader(read);
		System.out.println("Enter The Number Of Integers: "); // Enter the length of how many integers will be added for sorting.
		n = Integer.parseInt(in.readLine());
		int arr[] = new int[n]; //Making an array of length n to store all the integers.
		System.out.println("Enter the Integers: "); //Enter all the integers for sorting.
		for(i = 0; i < n; i++) 
		{
			arr[i] = Integer.parseInt(in.readLine());	
		}	
		System.out.println("Integer Array Before Sorting :  ");  // Displaying the elements of the array before performing Selection Sort
		for(i = 0; i < n; i++)
		{
			if(i==(n-1)) 
			{
				System.out.print(arr[i] + ".");
				break;
			}
			System.out.print(arr[i] + ", ");	 
		}
		System.out.println();
		selectionsort(arr); // Performs selection sort
	}		
	static void selectionsort(int arr[]) 
	{
		int i, minimum, t; // Here t is a temporary variable for storing the integer.
		int n = arr.length;
		for(i=0;i<n-1;i++)
		{
			minimum = arr[i];  // Selecting the i th element as the minimum number.
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]<arr[i])  //Performing swapping if the (i+1)th element is less than the i th element.
				{
					t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
		}
		System.out.println("Integer Array After Sorting :  ");  // Displaying the elements of the array after performing Selection Sort
		for(i = 0; i < n; i++)
		{
			if(i==(n-1)) 
			{
				System.out.print(arr[i] + ".");
				break;
			}
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}
}