#include <bits/stdc++.h>
using namespace std;


struct Node
{
    int val;
    Node *next;
}*head=NULL;

Node* insert(int value,int p,int n)
{
    Node *ptr=new Node();
    ptr->val=value;
    ptr->next=NULL;

    Node *t=head;
    
    if(p==0)
    {
        ptr->next=head;
        head=ptr;
    }
    for(int i=0;i<n;i++)
    {
        t=t->next;
        if(p==n-1)
        {
            t->next=ptr;
            return head;
        }
        if(p==i)
        {
            ptr->next=t->next;
            t=ptr;
        }
        
    }
    return head;

}

int main()
{
    #ifndef ONLINE_JUDGE
freopen("input.txt", "r", stdin);
freopen("output.txt", "w", stdout);

#endif
    int n;
    cin>>n;

    int arr[n];
    Node *t=NULL;
    t=head;
    head=t;
    for(int i=0;i<n;i++)
    {
        int x;
        cin>>x;
        Node *ptr=new Node();
        ptr->val=x;
        ptr->next=NULL;

        if(t!=NULL)
        {
            t->next=ptr;
            t=t->next;
        }
        else
        {
            t=ptr;
        }
    }

    int value,pos;
    cin>>value;
    cin>>pos;
    cout<<"ppp"<<endl;
    while(head!=NULL)
    {
        cout<<head->val;
        head=head->next;
    }

    head=insert(value,pos,n);
    cout<<"-----"<<endl;
    while(head!=NULL)
    {
        cout<<head->val;
        head=head->next;
    }
}