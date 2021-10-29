// Quick sort

#include <bits/stdc++.h>
using namespace std;

/*partitioning array such that on left side of pivot contains all the smaller elements and 
right contains greater elements than pivot*/
int partition(int *a,int s,int e) {

    int i=s-1;
    int pivot=a[e];		//setting last element as the pivot.

    for(int j=s;j<=e-1;j++) {
        if(a[j]<pivot) {
            i++;		//enlarging the smaller zone.
            swap(a[i],a[j]);
        }
    }

    swap(a[i+1],a[e]);		//placing the pivot element
    return i+1;			//returns the pivot

}

void quick_sort(int *a,int s,int e) {

    if(s>=e) {
        return;
    }

    int p= partition(a,s,e);

    quick_sort(a,s,p-1);
    quick_sort(a,p+1,e);
}

int main() {
    int n;
    cout<<"Enter number of elements in array\n"; 
    cin>>n;
	
    int a[n];	    

    cout<<"Enter elements\n";

    for(int i=0;i<n;i++) {
        cin>>a[i];
    }
    quick_sort(a,0,n-1);

     cout<<"Sorted elements are : \n";	
    for(int i=0;i<n;i++) {
        cout<<a[i]<<" ";
    }

}
