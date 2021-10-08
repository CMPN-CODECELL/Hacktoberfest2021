#include <iostream>

using namespace std;

void asc(int a[100],int n)
{
    int i,j,temp,m,pos;
    for(i=0;i<n;i++)
    {
        m=a[i];
        pos=i;
        for(j=i+1;j<n;j++)
        {
            if(a[j]<m)
            {
                m=a[j];
                pos=j;
            }
        }
        temp=a[i];
        a[i]=a[pos];
        a[pos]=temp;
    }
}
void des(int a[100],int n)
{
    int i,j,temp,m,pos;
    for(i=0;i<n;i++)
    {
        m=a[i];
        pos=i;
        for(j=i+1;j<n;j++)
        {
            if(a[j]>m)
            {
                m=a[j];
                pos=j;
            }
        }
        temp=a[i];
        a[i]=a[pos];
        a[pos]=temp;
    }
}
void pr(int a[100],int n)
{
    int i;
    for(i=0;i<n;i++)
    {
        cout<<a[i]<<" ";
    }
    cout<<"\n\n";
}
int main()
{
    int a[100],n,ch,ch1,i,fl=0;
    a:
    cout<<"\n1.Sort data in ascending order\n2.Sort data in descending order\nEnter choice : ";
    cin>>ch;
    if(ch!=1&&ch!=2)
    {
        cout<<"Wrong choice\n";
        goto a;
    }
    cout<<"Enter the number of elements you wish to sort : ";
    cin>>n;
    for(i=0;i<n;i++)
    {
        cout<<"Enter element "<<i+1<<" : ";
        cin>>a[i];
    }
    cout<<"\nThe data is\n";
    pr(a,n);
    if(ch==1)
    {
        asc(a,n);
    }
    else
    {
        des(a,n);
    }
    cout<<"The sorted data is\n";
    pr(a,n);
    b:
    if(ch==1)
        cout<<"1.Sort entered elements in descending order\n";
    else
        cout<<"1.Sort entered elements in ascending order\n";
    cout<<"2.Enter new data\n3.Exit\nEnter choice : ";
    cin>>ch1;
    switch(ch1)
    {
    case 1:
        if(ch==1)
            des(a,n);
        else
            asc(a,n);
        cout<<"\nThe sorted data is\n";
        pr(a,n);
        break;
    case 2:
        goto a;
        break;
    case 3:
        return 0;
    default:
        cout<<"Wrong choice\n";
        goto b;
    }
    cout<<"1.Enter new data\n2.Exit\nEnter choice : ";
    cin>>ch1;
    if(ch1==1)
        goto a;
    return 0;
}
