#DFS(Depth-First-Search) Algorithm for Binary tree in Python
# In this we will consider In-Order Traversal in which we first go to  left node and then root node and then the right node
# In-Order -> left,root,right
# We will be using Iterative In-Order traversal for in depth understanding 


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
3 1 2
***NOTE this line and below this line is not the part of output
Explanation:

first we move to left node i.e node(3) data then the left and right is None so we print the current node data and return
at node(1) and print the node data then move to right node i.e node(2) and move left and right as both are None we print the current node data return to previous node i.e node(1)
and the traversal is completed
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
3 2 5 4 6 1 7
***NOTE this line and below this line is not the part of output
we follow the left node root node and then right node for every node
'''

#DFS- In-Order Algorithm
class Algorithm:
    def InOrder(self,root):
        if root is None: # Base case if the root node itself is None
            return None
        Inorder = []
        stack = [] # a stack initialization
        node = root
        while (True): 
            if node is not None:
                stack.append(node)
                node = node.left
            else:
                if len(stack)==0: break 
                node = stack.pop()
                Inorder.append(node.data)
                node = node.right

            '''
            go to the left until we don't find None and when we do we check if the node is empty
            then move forward and take the top element and pop it from the stack and add the popped element data
            in the answer and then move right of the popped element and repeat the process
            '''
        
        return Inorder

#input code for taking input from the user
array = input().split() #taking input in the form of string and splitting it to a list
root = Build_BT(array) #passing the list to the function to build the Binary Tree
ans = Algorithm().InOrder(root) #This InOrder is function created seperately in Algorithm class
# ans will consist of list of data of post order traversal
print(*ans)

# The Time complexity of this Algorithm is ~O(N) where N is the number of nodes as we are traversing every node once.
#The Space Complexity of this Algorithm is ~O(H) where H is the Height of the Binary Tree 