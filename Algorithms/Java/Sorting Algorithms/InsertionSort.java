/*
*   Time Complexity: O(N^2)
*   Space Complexity O(1)
*   Worst Case: Insertion sort takes maximum time to sort if elements are sorted in reverse order.
*   Best CAse : Insertion sort takes minimum time (Order of n) when elements are already sorted.
*/
public class InsertionSort {

    public static void main(String[] args) {

        // Case 1
        int[] arr ={5,3,1,4};                   // i=1      {3,5,1,4}
        arr = insertionSort(arr);               // i=2      {1,3,5,4}
        for (int i = 0; i < arr.length; i++) {  // i=3      {1,3,4,5}
            System.out.print(arr[i] + " ");
        }

        // Case 2
        int[] array = {-82, 887, 566, 9899, 25, -151, 14, 3, 8288, 10010};
        insertionSort(array);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static int[] insertionSort(int[] array){
        for (int i = 1; i < array.length; i++){
            int temp = array[i]; // i=3
            int j= i-1; // j=2
            while (j>=0 && array[j]>temp){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
        return array;
    }
}
