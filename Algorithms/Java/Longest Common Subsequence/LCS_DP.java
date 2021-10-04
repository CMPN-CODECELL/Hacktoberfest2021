/*
The longest common subsequence between two strings is the longest subsequence that is common to both the strings.
The characters of the subsequences may not be consecutive characters in the original strings
eg.
1)
Input:
String 1 = "aabcdef"
String 2 = "abacde"
Output:
size = 5
LCS = abcde
"abcde" occurs in both the strings, not as consecutive charcters but the charcters are present in
increasing order in both the sequences.

2)
Input:
String 1 = "abcdef"
String 2 = "apbkcl"
Output:
size = 3
LCS = abc
"abc" is present in string 1 as consecutive characters, in string 2 it is not consecutive but the indices of the characters a,b,c are increasing
from a to c in both strings


If l1 is the length of the first sequence and l2 is the length of the second sequence, the time complexity of the problem is O(mn) by the dynamic programming
approach
*/
import java.util.Scanner;

class LCS_DP{
  static void lcs(String s1, String s2, int l1, int l2) {
    int[][] table = new int[l1 + 1][l2 + 1];//creating a table of dimension l1*l2

    for (int i=0; i<=l1; i++){
      for (int j=0; j<=l2; j++){
        if(i==0||j==0)     //initialising the first row and first column to zero
          table[i][j] = 0;
        else if(s1.charAt(i-1) == s2.charAt(j-1))
        //setting the element as diagonal element + 1 if the characters match
          table[i][j] = table[i-1][j-1]+1;
        else
        //maximum of the previous row and previous column
          table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
        }
    }

    int l = table[l1][l2];    //the last element in the table gives the length of the lcs
    int a = l;

    char[] lcs = new char[l];//longest common subsequence

    int i=l1, j=l2;
    while (i>0 && j>0)//following the path from last element to find the sequence
    {
      if (s1.charAt(i-1) == s2.charAt(j-1))
      {
        lcs[a-1] = s1.charAt(i-1);
        i--;
        j--;
        a--;
      }
      else if(table[i-1][j] > table[i][j-1])
        i--;
      else
        j--;
    }

    System.out.println("Length of the LCS is "+l);
    System.out.println("S1 : "+s1+"\nS2 : "+s2);
    System.out.print("The Longest common subsequence is: ");
    for (i=0; i<l; i++)
      System.out.print(lcs[i]);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the first string: ");
    String s1 = sc.nextLine();
    System.out.print("Enter the second string: ");
    String s2 = sc.nextLine();
    int l1 = s1.length();
    int l2 = s2.length();
    lcs(s1, s2, l1, l2);
  }
}
