#DFS(Depth-First-Search) Algorithm for Binary tree in Python
# In this we will consider Pre-Order Traversal in which we first go to root then left node and then right node
# Pre-Order -> root,left,right
# We will be using Iterative Pre-Order traversal for in depth understanding

#Binary Tree is actually a Data Structure but the traversal technique(DFS) we will use on it is an Algorithm

#first we will start off by actually creating a Basic Binary tree

from collections import deque #we will be using Queues to Build the Binary Tree
class Node:
    def __init__(self,data):
        self.data = data
        self.left = None   #assigning the left pointer of the current node to None
        self.right = None  #assigning the right pointer of the current node to None

#Now building the Binary Tree
def Build_BT(arr): #Here we will take an array as an argument in the function 
                    #(Note: The array is gonna be filled by the input the user provides in our given format mentioned below)

    if (len(arr)==0 or arr[0]=='N'): #Whenever the array is empty or the root node is None , Here 'N' denotes None,                             
        return None 

    #initializing root node
    root = Node(int(arr[0]))
    length = 0
    q = deque() #initializing the Queue

    #Pushing the root to the Queue
    q.append(root)
    length += 1

    #Now starting from the second element
    ptr = 1
    while(length>0 and ptr<len(arr)):
        Current_node = q[0] #getting the front of the queue
        q.popleft() #removing the front of the queue
        length -= 1
        Cur_val = arr[ptr] #getting the current node's value from the array
        if Cur_val!='N':
            Current_node.left = Node(int(Cur_val)) #Creating the left child for the current node
            q.append(Current_node.left) #pushing it to our Queue
            length += 1
        ptr += 1 #incrementing the value of ptr for the right child 

        if(ptr>len(arr)-1): #pointer is out of the array length
            break
        Cur_val = arr[ptr]
        if Cur_val != 'N': #checking if the right child is not None
            Current_node.right = Node(int(Cur_val)) #Creating the right child for the current node
            q.append(Current_node.right)
            length += 1
        ptr += 1
    return root #returning the root node of the Binary Tree

#SAMPLE TEST CASES:
'''
@Example Input 1:
1 3 2

***NOTE this line and below this line is not the part of input
The tree will look like ->  1
                           / \
                          3   2
@Example Output 1:
1 3 2
***NOTE this line and below this line is not the part of output
Explanation:

first we print the root node i.e node(1) data then move to left node which is node(3)
at node(3) we print node(3) data and move left and right as both are None we return to previous node i.e node(1)
now we move to right of the node(1) i.e is node(2)
at node(2) we print node(2) data and move left and then right as both are None we return and the traversal is completed
'''

'''
@Example Input 2:
1 2 7 3 4 N N N N 5 6
***NOTE this line and below this line is not the part of input
The tree will look like ->          1
                                   /  \
                                  2    7
                                 / \   / \
                                3   4  N   N
                               / \ / \
                              N  N 5  6  
@Example Output 2:
1 2 3 4 5 6 7
***NOTE this line and below this line is not the part of output
we follow the root node and then left node and then right  node for every node
'''

#DFS- Pre-Order Algorithm
class Algorithm:
    def PreOrder(self,root):
        if root is None: # Base case if the root node itself is None
            return None
        Preorder = []
        stack = [root] # a stack containing root node in it
        while (len(stack)>0): #while stack is not empty
            x = stack.pop()
            Preorder.append(x.data)
            if x.right is not None:
                stack.append(x.right)
            if x.left is not None:
                stack.append(x.left)
            #The reason x.right is added first in the stack is due to LIFO(Last In First Out) property
            # i.e we want left node first so we put it after right node as after popping we get left node which is out priority
            # as root node then left node and then right priority is followed
        return Preorder

#input code for taking input from the user
array = input().split() #taking input in the form of string and splitting it to a list
root = Build_BT(array) #passing the list to the function to build the Binary Tree
ans = Algorithm().PreOrder(root) #This PreOrder is function created seperately in Algorithm class
# ans will consist of list of data of pre order traversal
print(*ans)

# The Time complexity of this Algorithm is ~O(N) where N is the number of nodes as we are traversing every node once.
#The Space Complexity of this Algorithm is ~O(H) where H is the Height of the Binary Tree 
