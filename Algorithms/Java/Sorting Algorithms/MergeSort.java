import java.util.*;
import java.util.regex.*;
class MergeSort{
  static int n;
  public static void main(String args[]){
    System.out.println("Enter the number of elements in the array");
    Scanner sc = new Scanner(System.in);
    while(true){
      try{
        n = sc.nextInt();
        break;
      }catch(InputMismatchException e)
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
          System.out.println("Please enter an option between 1 and 2");
          System.out.println("Please");
          continue;
        }
      }catch(InputMismatchException e){
        sc.nextLine();
        System.out.println("Please enter an option between 1 and 2");
        continue;
      }
    }
    if(c==1)//integer array
    {
      int arr[] = new int[n];
      System.out.println("Enter the elements of the array");
      for(int i=0;i<n;i++)
      {
        System.out.println();
        System.out.print("Element "+(i+1)+" :");
        try   //checks if user has entered integer, else asks for input again
        {
          arr[i] = sc.nextInt();
          continue;
        }
        catch(InputMismatchException e){
          System.out.println("Please enter an integer");
          sc.nextLine();
          i--;
          continue;
        }
      }
      sort(arr,0,n-1);
      System.out.println();
      System.out.println("Sorted array: ");
      System.out.println(Arrays.toString(arr));
    }
    else//character array
    {
      char arr[] = new char[n];
      System.out.println("Enter the elements of the array");
      for(int i=0;i<n;i++)
      {
        System.out.println();
        System.out.print("Element "+(i+1)+" :");
        String str = sc.next(".");
        arr[i] = str.charAt(0);//takes only one character
        if(!Pattern.matches("[a-zA-Z]",str))
        {
          System.out.println("Please enter a valid character");
          i--;
          continue;
        }
      }
      sort(arr,0,n-1);
      System.out.println();
      System.out.println("Sorted array: ");
      System.out.println(Arrays.toString(arr));
    }
  }

  static void sort(int arr[], int l, int r)//method for integer arrays
  {
    if (l < r)
    {
      int m =l+(r-l)/2;
      sort(arr, l, m);
      sort(arr, m+1, r);
      merge(arr, l, r);
    }
  }
  static void sort(char arr[], int l, int r)//method for character arrays
  {
    if (l < r)
    {
      int m =l+(r-l)/2;
      sort(arr, l, m);
      sort(arr, m+1, r);
      merge(arr, l, r);
    }
  }

  static void merge(int arr[], int l, int r)
  {
    int m = (l+r)/2;
    int n1 = m - l + 1;
    int n2 = r - m;
    int L[] = new int[n1];//left subarray
    int R[] = new int[n2];//right subarray
    for (int i=0;i<n1;i++)
      L[i] = arr[l+i];
    for (int j=0;j<n2;j++)
      R[j] = arr[m+1+j];

    int i = 0, j = 0;
    int k = l;
    while (i<n1 && j<n2) {//adding the elements in the merged array
      if (L[i] <= R[j])
      {
        arr[k] = L[i];
        i++;
      }
      else
      {
        arr[k] = R[j];
        j++;
      }
      k++;
    }
    while (i < n1) {//adding the remaining elements from left subarray
      arr[k] = L[i];
      i++;
      k++;
    }
    while (j < n2) {//adding the remaining elements from right subarray
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  static void merge(char arr[], int l, int r)
  {
    int m = (l+r)/2;
    int n1 = m - l + 1;
    int n2 = r - m;
    char L[] = new char[n1];//left subarray
    char R[] = new char[n2];//right subarray
    for (int i=0;i<n1;i++)
      L[i] = arr[l + i];
    for (int j=0;j<n2;j++)
      R[j] = arr[m+1+j];

    int i = 0, j = 0;
    int k = l;
    while (i<n1 && j<n2) {//adding the elements in the merged array
      if (Character.compare(L[i],R[j])<=0)
      {
        arr[k] = L[i];
        i++;
      }
      else
      {
        arr[k] = R[j];
        j++;
      }
      k++;
    }
    while (i < n1) {//adding the remaining elements from left subarray
      arr[k] = L[i];
      i++;
      k++;
    }
    while (j < n2) {//adding the remaining elements from right subarray
      arr[k] = R[j];
      j++;
      k++;
    }
  }
}
