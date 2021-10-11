#include <iostream>
using namespace std;
int binary_search(int a[],int n,int key)
{
    int s=0;
    int e=n-1;
    while(s<=e){
        int mid=(s+e)/2;
        if(a[mid]==key)
            return mid;
        else if(a[mid]>key)
            e=mid-1;
        else
            s=mid+1;
    }
    return -1;
}
int main() {
    int n,key;
    cin>>n;
    int a[n];
    //Array should be sorted
    for(int i=0;i<n;i++)
        cin>>a[i];
    cin>>key;
    if(binary_search(a,n,key) == -1){
        cout<<"Number not found";
    }else{
        cout<<"Number found at index "<<binary_search(a,n,key);
    }
}

