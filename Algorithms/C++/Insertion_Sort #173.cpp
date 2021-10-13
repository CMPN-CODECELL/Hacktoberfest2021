/*Adding code for Insertion sorting in C++*/

#include<iostream>
using namespace std;

int main() 
{
   int a[100] , n , i , j , temp;
   cout<<"Enter the size of array :"<<endl;
   cin>>n;
   cout<<"Enter the elements in an array :" <<endl;
   for(i=0; i<n; i++) 
   {
        cin>>a[i];
   }
   for(i=1; i<n; i++) 
   {
       j = i;
       while ( j > 0 && a[j-1] > a[j])
       {	        
            temp = a[j];
            a[j] = a[j-1];
            a[j-1] = temp;
            j--;
        }
   }
   cout<<"Output after Insertion Sort is :"<<endl;
   for(i=0; i<n; i++)
   {
        cout<<a[i]<<" ";
   }
   cout<<endl;
   return 0;
}