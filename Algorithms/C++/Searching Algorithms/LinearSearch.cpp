/*
LINEAR SEARCH  :

Approach -  

Starting with the first element of arr[], one by one compare with each element of arr[]
If key matches with an element in an array, then the element is present. 
If not,it is not present in an array .

Example -

Enter size of an array:
5
Enter elements of an array :
1 7 3 8 5
case 1 : Enter key to be searched :
         3
case 2 : Enter key to be searched :
         9
         
Output -
for case 1 : present at location 3
for case 2 : Not present 

*/
#include <iostream>
using namespace std;

int main()
{
    int s;      
    cout<<"Enter size of an array :"<<endl;
    cin>>s;
    
    int arr[s];     //For creating an array to store all the elements.
    cout<<"Enter elements of an array :"<<endl;
    for(int i=0 ;i<s ;i++)
    {
     cin>>arr[i]; 
    }
    
    int key;      // element to be searched
    cout<<"Enter an element to be searched :"<<endl;
    cin>>key;
    int i, count=0;
    for(i=0 ;i<s ; i++)
    {
        if(key==arr[i])
        {
           cout<< key<<" is present at location "<<i+1<<endl; 
           count++;
           break;
           /* break will only search for first occurance of given element,
             ignoring all further occurances of that same element if present.
             In order to print all the occurances of given element , remove break 
             */  
        }
    }
     if (count == 0)
    {
        cout<<key<<" is not present";
    }
    return 0;
}


