#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *next;
    struct node *prev;
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
            newn->prev=0;
        }
        else
        {
            temp->next=newn;
            newn->prev=temp;
            temp=newn;
        }
        printf("Enter 1 to create another node and 0 to exit : ");
        scanf("%d",&ch);
    }while(ch==1);
}
void ins_beg()
{
    struct node *newn;
    newn=(struct node *)malloc(sizeof(struct node));
    printf("Enter data : ");
    scanf("%d",&newn->data);
    newn->next=head;
    newn->prev=0;
    head->prev=newn;
    head=newn;
}
void ins_end()
{
    struct node *temp,*newn;
    newn=(struct node *)malloc(sizeof(struct node));
    printf("Enter data : ");
    scanf("%d",&newn->data);
    newn->next=0;
    temp=head;
    while(temp->next!=0)
        temp=temp->next;
    temp->next=newn;
    newn->prev=temp;
}
void ins_aft()
{
    int d;
    struct node *temp,*newn;
    printf("Enter the data in the node after which you want the new node : ");
    scanf("%d",&d);
    newn=(struct node *)malloc(sizeof(struct node));
    printf("Enter data : ");
    scanf("%d",&newn->data);
    temp=head;
    while(temp->data!=d)
        temp=temp->next;
    newn->next=temp->next;
    newn->prev=temp;
    temp->next->prev=newn;
    temp->next=newn;
}
void ins_bef()
{
    int d;
    struct node *temp,*newn;
    printf("Enter the data in the node before which you want the new node : ");
    scanf("%d",&d);
    newn=(struct node *)malloc(sizeof(struct node));
    printf("Enter data : ");
    scanf("%d",&newn->data);
    temp=head;
    while(temp->data!=d)
        temp=temp->next;
    newn->next=temp;
    newn->prev=temp->prev;
    temp->prev->next=newn;
    temp->prev=newn;
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
        head=head->next;
        head->prev=0;
        printf("%d deleted\n",temp->data);
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
        struct node *temp;
        temp=head;
        while(temp->next!=0)
            temp=temp->next;
        temp->prev->next=0;
        printf("%d deleted\n",temp->data);
        free(temp);
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
void del_aft()
{
    if(head==0)
    {
        printf("List empty\n");
    }
    else
    {
        int d;
        struct node *temp;
        temp=head;
        printf("Enter the data in the node after which you want the to delete node : ");
        scanf("%d",&d);
        while(temp->data!=d)
            temp=temp->next;
        temp->next->next->prev=temp;
        temp->next=temp->next->next;
        temp=temp->next;
        printf("%d deleted\n",temp->data);
        free(temp);
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
        temp=head;
        printf("Enter the data in the node after which you want the to delete node : ");
        scanf("%d",&d);
            while(temp->data!=d)
            {
                temp=temp->next;
                if(temp==0)
                    break;
            }
            if(temp==0)
                printf("Node not found\n");
            else
            {
                temp->prev=temp->prev->prev;
                temp->prev->prev->next=temp;
                temp=temp->prev;
                printf("%d deleted\n",temp->data);
                free(temp);
            }

    }
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

