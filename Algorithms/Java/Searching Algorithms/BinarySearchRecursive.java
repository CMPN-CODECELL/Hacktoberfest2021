/**
	Prerequisites: 
	1. Recursion - Calling a function itself again and again until specified condition (base condition) is reached. 
	2. Binary Search can be performed only on SORTED ELEMENTS. Sorting order can be ascending or descending
		- Here ascending order is used. 
	3. Binary Search divides the array in half
		- If the middle element is equal to search key then it returns/prints the middle element
		- If middle element is less than key then it binary search searches the elements after the middle element.
		- Else it searches the element before middle element. That is why binary search needs the array to be sorted.
		- This is done till low index is less than high index. 
	4. Here we are repeating same task again and again so we can convert it into recursive function which calls itself.
*/


/*
	Time Complexity
		- The best case time complexity of Binary search is constant O(1) if the search key is equal to middle element
		- The average or worst case complexity is O(logn) as it divides the array each time when middle element is not equal to key
		- This makes binary search more effective than linear search IF THE ARRAY IS SORTED!
	
	Space Complexity
		- The binary search space complexity is constant O(1) as it does not require extra space to store the array elements 
*/


import java.util.Scanner;

class BinarySearchRecursive{
	
	int binarySearchRecursiveImpl(int[] searchArray, int low, int high, int key){
	
		if(high >= low){
			
			int middle = (low + high)  / 2;
			
			if (searchArray[middle] == key){
				return middle;
			}
			
			else if (searchArray[middle] > key){
				return binarySearchRecursiveImpl(searchArray, low, middle - 1, key); 
			}
			
			return binarySearchRecursiveImpl(searchArray, middle + 1 , high , key); 
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String args[]){
		
		System.out.println("\n-------------------Binary Search Recursive Approach-------------------\n");
		
		System.out.println("Enter the number of elements to be added in array");
		
		Scanner scanner = new Scanner(System.in);
		
		final int ARRAY_LENGTH = scanner.nextInt();
		
		int[] searchArray = new int[ARRAY_LENGTH];
		
		System.out.println("Enter "+ ARRAY_LENGTH + " elements in ascending order: ");
		
		for (int i = 0; i < ARRAY_LENGTH; i++){
			int element = scanner.nextInt();
			searchArray[i] = element;
		}
		
		int choice = 0;
		int low = 0;
		int high = ARRAY_LENGTH - 1;
		
		do{
			System.out.println("Enter the element to be searched: ");
			
			int key = scanner.nextInt();
			
			BinarySearchRecursive binarySearchRecursive = new BinarySearchRecursive();
			
			int searchResult = binarySearchRecursive.binarySearchRecursiveImpl(searchArray, low, high, key);

			System.out.println(searchResult == Integer.MIN_VALUE ? "Element not Present" : "Element present at search array index "+searchResult+".");
		
			System.out.println("Press 1 to continue");
			
			choice = scanner.nextInt();
		}while(choice == 1);	
		scanner.close();
	}	
}
