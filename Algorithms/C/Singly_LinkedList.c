#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *next;
};
struct node *head;
void create()
{
    int ch;
    struct node *temp,*newn;
    do
    {
        newn=(struct node *)malloc(sizeof(struct node));
        printf("Enter data : ");
        scanf("%d",&newn->data);
        newn->next=0;
        if(head==0)
        {
            head=newn;
            temp=newn;
        }
        else
        {
            printf("El");
            temp->next=newn;
            temp=newn;
        }
        printf("Enter 1 to create another node and 0 to exit : ");
        scanf("%d",&ch);
    }while(ch==1);
}
void ins_beg()
{
    struct node *temp,*newn;
    temp=head;
    newn=(struct node *)malloc(sizeof(struct node));
    printf("Enter data : ");
    scanf("%d",&newn->data);
    head=newn;
    newn->next=temp;
}
void ins_end()
{
    struct node *temp,*newn;
    temp=head;
    newn=(struct node *)malloc(sizeof(struct node));
    printf("Enter data : ");
    scanf("%d",&newn->data);
    newn->next=0;
    while(temp->next!=0)
        temp=temp->next;
    temp->next=newn;
}
void ins_aft()
{
    int d;
    struct node *temp,*newn,*nextn;
    temp=head;
    nextn=temp->next;
    printf("Enter the data in the node after which you want the new node : ");
    scanf("%d",&d);
    newn=(struct node *)malloc(sizeof(struct node));
    printf("Enter data in new node : ");
    scanf("%d",&newn->data);
    while(temp->data!=d)
    {
        temp=temp->next;
        nextn=nextn->next;
    }
    temp->next=newn;
    newn->next=nextn;
}
void ins_bef()
{
    int d;
    struct node *temp,*newn,*prevn;
    temp=head;
    prevn=0;
    printf("Enter the data in the node before which you want the new node : ");
    scanf("%d",&d);
    newn=(struct node *)malloc(sizeof(struct node));
    printf("Enter data in new node : ");
    scanf("%d",&newn->data);
    while(temp->data!=d)
    {
        prevn=temp;
        temp=temp->next;
    }
    if(temp==head)
    {
        head=newn;
        newn->next=temp;
    }
    else
    {
        prevn->next=newn;
        newn->next=temp;
    }
}
void del_beg()
{
    if(head==0)
    {
        printf("List empty\n");
    }
    else
    {
        struct node *temp;
        temp=head;
        printf("%d deleted\n",head->data);
        head=head->next;
        free(temp);
    }
}
void del_end()
{
    if(head==0)
    {
        printf("List empty\n");
    }
    else
    {
        struct node *temp,*prevn;
        temp=head;
        prevn=0;
        while(temp->next!=0)
        {
            prevn=temp;
            temp=temp->next;
        }
        prevn->next=0;
        printf("%d deleted\n",temp->data);
        free(temp);
    }
}
void del_aft()
{
    if(head==0)
    {
        printf("List empty\n");
    }
    else
    {
        int d;
        struct node *temp,*newn,*nextn;
        temp=head;
        nextn=temp->next;
        printf("Enter the data in the node after which you want the to delete node : ");
        scanf("%d",&d);
        while(temp->data!=d)
        {
            temp=temp->next;
            nextn=nextn->next;
        }
        if(temp->next==0)
        {
            printf("No node present to delete data from\n");
        }
        else
        {
            printf("%d deleted\n",nextn->data);
            temp->next=nextn->next;
            free(nextn);
        }
    }
}
void del_bef()
{
    if(head==0)
    {
        printf("List empty\n");
    }
    else
    {
        int d;
        struct node *temp,*prevvn,*prevn;
        prevvn=head;
        prevn=prevvn->next;
        temp=prevn->next;
        printf("Enter the data in the node after which you want the to delete node : ");
        scanf("%d",&d);
        if(d==prevvn->data)
            printf("No node present to delete data from\n");
        else if(d==prevn->data)
        {
            printf("%d deleted\n",prevvn->data);
            head=prevn;
            free(prevvn);
        }
        else
        {
            while(temp->data!=d)
            {
                temp=temp->next;
                prevn=prevn->next;
                prevvn=prevvn->next;
            }
            printf("%d deleted\n",prevn->data);
            prevvn->next=temp;
            free(prevn);
        }
    }
}
void disp()
{
    struct node *temp;
    printf("The linked list currently contains\n");
    temp=head;
    while(temp!=0)
    {
        printf("%d ",temp->data);
        temp=temp->next;
    }
    printf("\n");
}
int main()
{
    int ch;
    head=0;
    printf("1.Create Linked List\n2.Start with an empty list\nEnter choice: ");
    scanf("%d",&ch);
    if(ch==1)
        create();
    do
    {
        printf("***************  Main Menu  ***********\n");
        printf("1.Insert node at beginning\n2.Insert node at end\n3.Insert node after a specified node\n4.Insert node before a specified node\n5.Delete node from beginning\n6.Delete node from end\n7.Delete node after a specified node\n8.Delete node before a specified node\n9.Display List\n10.Exit\nEnter choice: ");
        scanf("%d",&ch);
        switch(ch)
        {
        case 1:
            ins_beg();
            break;
        case 2:
            ins_end();
            break;
        case 3:
            ins_aft();
            break;
        case 4:
            ins_bef();
            break;
        case 5:
            del_beg();
            break;
        case 6:
            del_end();
            break;
        case 7:
            del_aft();
            break;
        case 8:
            del_bef();
            break;
        case 9:
            disp();
            break;
        case 10:
            break;
        default:
            printf("Wrong choice\n");
        }
    }while(ch!=10);
    return 0;
}
