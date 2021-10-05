import java.util.*;
import java.io.*;

//space complexity -> O(1) => constant
//time complexity -> Best case ->  O(N) => when the array is sorted
//                -> Worst case -> O(N^2) => when is array is sorted in oppsite manner



 public class BubbleSort
{

    public static void main(String[] args) throws IOException {


        int i,n;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter The Number Of Integers: ");

        n = scan.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the Integers: ");
        for(i = 0; i < n; i++)
        {
            arr[i] =Integer.parseInt(scan.next());

        }

       bubble(arr);
       System.out.println(Arrays.toString(arr));







    }

    static void bubble(int arr[])
    {
      boolean swapped;
        // run the steps n-1 times
        for(int i = 0; i < arr.length; i++)
        {

          swapped = false;
          // for each item max item will come at the last respective index
            for(int j = 1 ; j < arr.length-i; j++)
            {
              //// swap if item is smaller than previous item
                if(arr[j] < arr[j-1])
                { 

                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;

                }
            }

            if(!swapped)
            {
              break;
            }
        }
    }







}
