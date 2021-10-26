#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
void enqueue(int n);
void dequeue();
void display();
void peek();
#define max 5
int queue[max];
int front=-1;
int rear=-1;

int main(){
    int ch,n;
    do{
    printf("\n******Menu******");
    printf("\nenter 1 for enqueue\n");
    printf("enter 2 for display\n");
    printf("enter 3 for peek\n");
    printf("enter 4 for dequeue\n");
    printf("enter 5 to exit\n");
    printf("enter your choice: ");
    scanf("%d",&ch);
    switch (ch){
    case 1:
        printf("enter the number");
        scanf("%d",&n);
        enqueue(n);
        break;
    case 2:
        display();
        break;
    case 3:
        peek();
        break;
    case 4:
        dequeue();
        break;
    case 5:
        break;
}
    }while(ch<=4 && ch>=1);
    return 0;
}
    void enqueue(int num){
        if(front==max-1){
            printf("queue is full");
        }
        else if(front==-1&&rear==-1){
            front=0;
            rear=0;
            queue[rear]=num;
        }
        else{
        rear++;
        queue[rear]=num;
        }
    }
    void display(){
        int i;
        for(i=front;i<=rear;i++)
        {
            printf("\t%d",queue[i]);

        }
    }
    void peek(){
        printf("the peek of the queue is: %d\n",queue[front]);
    }
    void dequeue(){
      if(front==-1 && rear==-1){
            printf("queue is empty");
        }
        else if(front>rear){
            front=-1;
            rear=-1;
        }
        printf("the deleted element is %d\n",queue[front++]);
        display();
    }


