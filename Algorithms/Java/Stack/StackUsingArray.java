import java.io.*;
public class StackUsingArray {
	int stack[] = new int[20]; // Initializing an array to store all the elements of the stack.
	int top = -1; // Variable used for checking, if the stack is empty or full.
	InputStreamReader read = new InputStreamReader(System.in);
	BufferedReader in = new BufferedReader(read);
	public static void main(String[] args) throws IOException {
		StackUsingArray obj = new StackUsingArray(); // Making an object of the class StackUsingArray
		obj.menu(); // Calling the method menu using the object created.
	}

	void menu() throws IOException {
		int MAX = 20; // Variable for checking if the stack is full!
		int c, a;
		/*
		A do while loop for running the menu, as many times the user wants!!
		The user can exit by pressing 0.
		*/
		do{
			System.out.println("\nSTACK MENU(Press 0 to exit)\n");
			System.out.println("\t1)Push");
			System.out.println("\t2)Pop");
			System.out.println("\t3)Peek");
			System.out.println("\t4)Display");
			c = Integer.parseInt(in.readLine());
			switch(c)
			{
				case 1:
				{
					if (top==MAX-1)
					{
						System.out.println("Stack is Full(Stack Overflow)");
					}
					else
					{
						System.out.println("Enter the element to be inserted\n");
						a = Integer.parseInt(in.readLine());
						push(a);  // Calling the method push to add element into the stack.
					}
					break;
				}
				
				case 2:
				{
					if (top==-1)
					{
						System.out.println("Stack is Empty(Stack Underflow)");
					}
					else
					{
						pop();  // Calling the method pop to remove the element from the stack.
 					}
					break;
				}

				case 3:
				{	
					if (top==-1)
					{
						System.out.println("Stack is Empty(Stack Underflow)");
					}
					else
					{
						peek();  // To get the element present at the top of the stack.
					}
					break;
				}
				
				case 4:
				{
					if (top==-1)
					{
						System.out.println("Stack is Empty(Stack Underflow)");
					}
					else
					{
						display(); // For displaying the stack.
					}
					break;
				}
				
				case 0:
				{
					break;
				}
				
				default:
				{
					System.out.println("Invalid Choice");
				}
			}
			System.out.println();
		}while(c!=0);
	}

	void push(int element)
	{
		top = top+1; // Increasing the top value, when a new element is added.
		stack[top] = element;
		System.out.println("Element "+ element +" is Added at position "+top+".");
	}

	void display()
	{
		System.out.println("Elements in the Stack are :"); 
		for(int i=0;i<=top;i++) // Loop for printing the elements present in the stack.
		{
			System.out.print(stack[i]+"\t");
		}
		System.out.println();
	}

	void pop()
	{
		int value=stack[top];
		top--; // Decreasing the top value, once the element is popped out of the stack.
		System.out.println("Element Removed is "+value);
	}

	void peek()
	{
		System.out.println("The Element At The Top is "+stack[top]); // To print the topmost element in the stack.
	}
}