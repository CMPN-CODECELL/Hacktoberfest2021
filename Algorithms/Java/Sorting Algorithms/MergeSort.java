//Time complexity of O(n*logn) in worst, average and best case

/*
It is a divide and conquer algorithm which divides the array into two subarrays at
each step until both subarrays have size of one and then arranges the elements
while merging both the arrays
*/

import java.util.*;
import java.util.regex.*;
class MergeSort{
  static int n;
  public static void main(String args[]){
    System.out.println("Enter the size of the array");//size of array
    Scanner sc = new Scanner(System.in);
    while(true){
      try{
        n = sc.nextInt();
        break;
      }catch(InputMismatchException e)//If user doesn't enter an integer
      {
        sc.nextLine();
        System.out.println("Please enter an integer");
        continue;
      }
    }
    System.out.println("What is the datatype of the elements in the array");
    System.out.println("1. Integer");
    System.out.println("2. Character");
    int c=0;
    while(true){//Runs until user enters a valid option
      System.out.println("Enter your option");
      try{
        c = sc.nextInt();
        if(c==1||c==2)
        {
          break;
        }
        else
        {
          System.out.println("Please enter either 1 or 2");
          continue;
        }
      }catch(InputMismatchException e){
        sc.nextLine();
        System.out.println("Please enter either 1 or 2");
        continue;
      }
    }
    if(c==1)//integer array
    {
      int array[] = new int[n];
      System.out.println("Enter the elements of the array");
      for(int i=0;i<n;i++)
      {
        System.out.println();
        System.out.print("Element "+(i+1)+" :");
        try   //checks if user has entered integer, else asks for input again
        {
          array[i] = sc.nextInt();
          continue;
        }
        catch(InputMismatchException e){
          System.out.println("Please enter an integer");
          sc.nextLine();
          i--;
          continue;
        }
      }
      sort(array,0,n-1);
      System.out.println();
      System.out.println("Sorted array: ");
      System.out.println(Arrays.toString(array));
    }
    else//character array
    {
      char array[] = new char[n];
      System.out.println("Enter the elements of the array");
      for(int i=0;i<n;i++)
      {
        System.out.println();
        System.out.print("Element "+(i+1)+" :");
        String str = sc.next(".");
        array[i] = str.charAt(0);//takes only one character
        if(!Pattern.matches("[a-zA-Z]",str))
        {
          System.out.println("Please enter a valid character");
          i--;
          continue;
        }
      }
      sort(array,0,n-1);
      System.out.println();
      System.out.println("Sorted array: ");
      System.out.println(Arrays.toString(array));
    }
  }

  static void sort(int array[], int l, int h)//method for integer arrays
  {
    if (l < h)
    {
      int m =l+(h-l)/2;
      sort(array, l, m);
      sort(array, m+1, h);
      merge(array, l, h);
    }
  }
  static void sort(char array[], int l, int h)//method for character arrays
  {
    if (l < h)
    {
      int m =(l+h)/2;
      sort(array, l, m);
      sort(array, m+1, h);
      merge(array, l, h);
    }
  }

  static void merge(int array[], int l, int h)
  {
    int m = (l+h)/2;
    int l_len = m-l+1;
    int r_len = h-m;
    int l_arr[] = new int[l_len];//left subarray
    int r_arr[] = new int[r_len];//right subarray
    for (int i=0;i<l_len;i++)
      l_arr[i] = array[l+i];
    for (int i=0;i<r_len;i++)
      r_arr[i] = array[m+i+1];

    int i=0, j=0;
    int array_ind=l;
    while (i<l_len && j<r_len) {//adding the elements in the merged array
      if (l_arr[i] <= r_arr[j])
      {
        array[array_ind] = l_arr[i];
        i++;
      }
      else
      {
        array[array_ind] = r_arr[j];
        j++;
      }
      array_ind++;
    }
    while (i < l_len) {//adding the remaining elements from left subarray
      array[array_ind] = l_arr[i];
      i++;
      array_ind++;
    }
    while (j < r_len) {//adding the remaining elements from right subarray
      array[array_ind] = r_arr[j];
      j++;
      array_ind++;
    }
  }

  static void merge(char array[], int l, int h)
  {
    int m = (l+h)/2;
    int l_len = m-l+1;
    int r_len = h-m;
    char l_arr[] = new char[l_len];//left subarray
    char r_arr[] = new char[r_len];//right subarray
    for (int i=0;i<l_len;i++)
      l_arr[i] = array[l + i];
    for (int i=0;i<r_len;i++)
      r_arr[i] = array[m+i+1];

    int i=0, j=0;
    int array_ind = l;
    while (i<l_len && j<r_len) {//adding the elements in the merged array
      if (Character.compare(l_arr[i],r_arr[j])<=0)
      {
        array[array_ind] = l_arr[i];
        i++;
      }
      else
      {
        array[array_ind] = r_arr[j];
        j++;
      }
      array_ind++;
    }
    while (i < l_len) {//adding the remaining elements from left subarray
      array[array_ind] = l_arr[i];
      i++;
      array_ind++;
    }
    while (j < r_len) {//adding the remaining elements from right subarray
      array[array_ind] = r_arr[j];
      j++;
      array_ind++;
    }
  }
}
