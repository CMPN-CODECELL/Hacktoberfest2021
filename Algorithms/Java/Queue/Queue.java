/*
A queue is linear data structure
It performs the operations in first in first out(FIFO) order. For instance we can consider a queue of people outside a 
shop, the person who is standing first in the queue takes the items and leaves first.
Queue data structures can be used in CPU scheduling, disk scheduling algorithms where the task which arrives first is 
served first
Queues can be implemented using arrays, stacks, linked lists
*/

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class Queue{
    static Node front, rear;//nodes that will point to the front and rear of the queue
    static Scanner s = new Scanner(System.in);
    public static void main(String args[])
    {
        while(true){//runs until user chooses to exit
            System.out.println();
            System.out.println("Operations:");
            System.out.println("1. Insert an element in the queue");
            System.out.println("2. Remove an elementt from the queue");
            System.out.println("3. Peek - See the first element of the queue");
            System.out.println("4. Display the queue");
            System.out.println("Enter 0 to exit");
            int c;
            System.out.println();
            while(true){//Runs until user enters a valid option
                System.out.println("Enter the option for the operation you want to perform");
                try{
                    c = s.nextInt();
                    if(c>=0&&c<=4)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Please enter an option between 0 and 4");
                        continue;
                    }
                }catch(InputMismatchException e){//If user does not enter an integer
                    s.nextLine();
                    System.out.println("Please enter an option between 0 and 4");
                    continue;
                }
            }
            if(c==0)
            break;
            switch(c)//Calling different methods based on the selected operation
            {
                case 1:
                enqueue();
                break;
                case 2:
                dequeue();
                break;
                case 3:
                peek();
                break;
                case 4:
                display();
                break;
            }
            System.out.println();
        }
    }

    static void enqueue()
    {
        System.out.print("Enter the data you want to add: ");
        while(!s.hasNextInt())
        {
            s.nextLine();s.nextLine();
            System.out.println("Please enter an integer value");
        }
        int d = s.nextInt();//data to add
        Node newnode = new Node(d);
        if(rear==null)//The queue is empty
        {
            front=rear=newnode;//Initialising both front and rear to the first node
            return;
        }
        rear.next = newnode;//Adding new node to the end of the queue
        rear = newnode;
        System.out.println(d+" added to the listed");
    }

    static void dequeue()
    {
        if(front==null)//If queue is empty
        {
            System.out.println("The queue is empty!");
            return;
        }
        System.out.println("Removed "+front.data+" from the queue");
        front = front.next;//Removing the first node
        if(front==null)//If the element removed was the last element in the queue
        rear=null;
    }

    static void peek()
    {
        if(front==null)//If queue is empty
        {
            System.out.println("The queue is empty!");
            return;
        }
        System.out.println("The first element in the queue is "+front.data);
    }

    static void display()
    {
        if(front==null)
        {
            System.out.println("The queue is empty!");
            return;
        }
        System.out.println("The elements of the queue are:");
        Node temp = front;
        while(temp!=null)//Prints all the elements one by one
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}