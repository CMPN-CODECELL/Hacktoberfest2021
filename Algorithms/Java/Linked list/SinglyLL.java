/*
Singly linked list is a linear data structure.
Unlike arrays it doesn't store the elements in the contiguous memory locations, the elements of linked list can be stored anywhere in the memory.

The linked list consists of elements called nodes where each node has two fields: a data field and a reference to the next node in the list.
This allows the operations of insertion and deletion in the linked list much faster as compared to arrays as for inserting a new node in between,
we need to change the reference of the previous node and store the reference of the next node.But in a linked list we can't access an element using
it's index as in array, we have to traverse through each node of the list until that element is reached.

Every linked list has a head or start node which is the first node in the list using which all the other nodes are accessed
*/
import java.util.*;

class Node{//Node class for the nodes of the linked list
  int data;
  Node next;
  Node(int data)
  {
    this.data = data;
    next = null;
  }
}

class SinglyLL{
  static Scanner s = new Scanner(System.in);
  static Node head;//Head node points to the start of the list
  public static void main(String args[])
  {
    while(true){//performs operations until user exits
      System.out.println();
      System.out.println("Operations:");
      System.out.println("1. Add an element at the start of the linked list");
      System.out.println("2. Add an element at the end of the linked list");
      System.out.println("3. Add an element after a given element of the linked list");
      System.out.println("4. Add an element before a given element of the linked list");
      System.out.println("5. Remove an element from the start of the linked list");
      System.out.println("6. Remove an element from the end of the linked list");
      System.out.println("7. Remove an element after a given element of the linked list");
      System.out.println("8. Remove an element before a given element of the linked list");
      System.out.println("9. Display the linked list");
      System.out.println("Enter 0 to exit");
      int c;
      while(true){//Runs until user enters a valid option
        System.out.println("Enter the option for the operation you want to perform");
        try{
          c = s.nextInt();
          if(c>=0&&c<=9)
          {
            break;
          }
          else
          {
            System.out.println("Please enter an option between 0 and 9");
            continue;
          }
        }catch(InputMismatchException e){
          s.nextLine();
          System.out.println("Please enter an option between 0 and 9");
          continue;
        }
      }
      if(c==0)
      break;
      switch(c)//calling different methods based on the selected operation
      {
        case 1:
        addstart();
        break;
        case 2:
        addend();
        break;
        case 3:
        addafter();
        break;
        case 4:
        addbefore();
        break;
        case 5:
        remstart();
        break;
        case 6:
        remend();
        break;
        case 7:
        remafter();
        break;
        case 8:
        rembefore();
        break;
        case 9:
        display();
        break;
      }
      System.out.println();
    }
  }

//method for adding an element at the start of the list
  static void addstart(){
    System.out.print("Enter the data you want to add: ");
    while(!s.hasNextInt())
    {
      s.nextLine();s.nextLine();
      System.out.println("Please enter an integer value");
    }
    int d = s.nextInt();//data to add
    Node newnode = new Node(d);//object for the new node to be added
    if(head==null)//Checks if the linked list is empty
    {
        head = newnode;
    }
    else{//inserting new node before the head
      newnode.next = head;
      head = newnode;
    }
    System.out.println("Added "+d+" to the list");
  }

//method for adding an element at the end of the list
  static void addend(){
    System.out.print("Enter the data you want to add: ");
    while(!s.hasNextInt())
    {
      s.nextLine();s.nextLine();
      System.out.println("Please enter an integer value");
    }
    int d = s.nextInt();//data to add
    Node newnode = new Node(d);//object for the new node to be added
    if(head==null)//Checks if the linked list is empty
    {
      head = newnode;
    }else{
      Node temp = head;
      while(temp.next!=null)//Traversing through the list until the last element is reached
      {
        temp = temp.next;
      }
      temp.next=newnode;
    }
    System.out.println("Added "+d+" to the list");
  }

//method for adding an element after a given element
  static void addafter(){

    System.out.print("Enter the data you want to add: ");
    while(!s.hasNextInt())
    {
      s.nextLine();s.nextLine();
      System.out.println("Please enter an integer value");
    }
    int d = s.nextInt();//data to add
    System.out.print("Enter the value from the list after which you want to add the data: ");
    while(!s.hasNextInt())
    {
      s.nextLine();s.nextLine();
      System.out.println("Please enter an integer value");
    }


    int k = s.nextInt();//key value to find
    Node newnode = new Node(d);

    if(head==null)//list is empty
    {
      System.out.println(k+" is not present in the list");
    }else{
    Node temp = head;//temp is used for traversing the list
    Node pre = temp;//pre stores the node present before temp node
    boolean found = false;
    while(temp.next!=null)
    {
      temp = temp.next;
      if(pre.data==k)//The key value is found
      {
        found=true;
        break;
      }
      pre = temp;
    }

    if(found==true)//adding the new element between pre and temp
    {
      pre.next = newnode;
      newnode.next = temp;
      System.out.println("Added "+d+" to the list");
    }
    else if(temp.data==k)//If k is present in the last node of the list
    {
      temp.next = newnode;
      System.out.println("Added "+d+" to the list");
    }else{
      System.out.println(k+" is not present in the list");
    }
  }
  }

//method for adding an element before a given element
  static void addbefore(){

    System.out.print("Enter the data you want to add: ");
    while(!s.hasNextInt())
    {
      s.nextLine();s.nextLine();
      System.out.println("Please enter an integer value");
    }
    int d = s.nextInt();//data to add
    System.out.print("Enter the value from the list before which you want to add the data: ");
    while(!s.hasNextInt())
    {
      s.nextLine();s.nextLine();
      System.out.println("Please enter an integer value");
    }

    int k = s.nextInt();//key value to find
    Node newnode = new Node(d);
    boolean found = false;

    if(head==null)//list is empty
    {
      System.out.println(k+" is not present in the list");
    }else if(head.data==k)//If k is present in the first node of the list
    {
      newnode.next = head;
      head = newnode;
      System.out.println("Added "+d+" to the list");
    }
    else{
    Node temp = head;//temp is used for traversing the list
    Node pre = temp;//pre stores the node present before temp node
    while(temp.next!=null)
    {
      temp = temp.next;
      if(temp.data==k)//The key value is found
      {
        found=true;
        break;
      }
      pre = temp;
    }

    if(found==true)//adding the element between pre and temp
    {
      pre.next = newnode;
      newnode.next = temp;
      System.out.println("Added "+d+" to the list");
    }
    else{
      System.out.println(k+" is not present in the list");
    }
  }
  }

//method to remove an element from the start of the list
  static void remstart(){
    if(head==null)//list is empty
    {
      System.out.println("The list is empty!");
    }
    else{
      System.out.println("Deleted "+head.data+" from the list");
      head = head.next;
    }
  }

//method to remove an element from the end of the list
  static void remend(){
    if(head==null)//list is empty
    {
      System.out.println("The list is empty!");
    }
    else{
      if(head.next==null)
      {
        head = null;
      }
      else{
      Node temp = head;
      Node pre = temp;
      while(temp.next!=null)
      {
        pre = temp;
        temp = temp.next;
      }
      System.out.println("Deleted "+temp.data+" from the list");
      pre.next=null;
      }
    }
  }

//method to remove an element after a given element
  static void remafter(){

    if(head==null)//list is empty
    {
      System.out.println("The list is empty");
    }
    else{
      System.out.print("Enter the value from the list after which you want to remove the data: ");
      while(!s.hasNextInt())
      {
        s.nextLine();s.nextLine();
        System.out.println("Please enter an integer value");
      }


      int k = s.nextInt();//key value to find
      Node temp = head;//temp is used for traversing the list
      Node pre = temp;//pre stores the node present before temp node
      boolean found = false;
      while(temp.next!=null)
      {
        temp = temp.next;
        if(pre.data==k)//The key value is found
        {
          found=true;
          break;
        }
        pre = temp;
      }

      if(found==true)//removing the element between pre and temp
      {
        pre.next = temp.next;
        System.out.println("Deleted "+temp.data+" from the list");
      }
      else if(temp.data==k)//If k is present in the last node of the list
      {
        System.out.println("There is no element after "+k+" to delete it");
      }else{
        System.out.println(k+" not found in the list");
      }
  }
}

//method to remove an element before a given element
  static void rembefore(){

    if(head==null)//list is empty
    {
      System.out.println("The list is empty");
    }
    else{
      System.out.print("Enter the value from the list before which you want to remove the data: ");
      while(!s.hasNextInt())
      {
        s.nextLine();s.nextLine();
        System.out.println("Please enter an integer value");
      }


      int k = s.nextInt();//key value to find
      if(head.data==k)//If k is present in the first node of the list
      {
        System.out.println("There is no element before "+k+" to delete it");
      }else{
        Node temp = head;//temp is used for traversing the list
        Node pre = temp;//pre stores the node present before temp node
        boolean found = false;
        while(temp.next!=null)
        {
          if(temp.next.data==k)//The key value is found
          {
            found=true;
            break;
          }
          pre = temp;
          temp = temp.next;
        }

        if(found==true)
        {
          if(temp==pre)//The node to be deleted is the first node of the list
          {
            head = pre.next;
            pre.next = null;
            temp.next = null;
          }
          else{pre.next = temp.next;}//removing the node between pre and temp
          System.out.println("Deleted "+temp.data+" from the list");
        }
        else{
          System.out.println(k+" not found in the list");
        }
      }
    }
  }

//method to display the list
  static void display(){
    if(head==null)
    {
      System.out.println("The list is empty");
    }else{
      System.out.println("The elements of the list are:");
      Node temp = head;
      while(temp.next!=null)
      {
        System.out.print(temp.data+" ");
        temp=temp.next;
      }
      System.out.print(temp.data);
    }
  }

}
