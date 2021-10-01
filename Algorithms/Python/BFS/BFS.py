#BFS(Breadth-First-Search) Algorithm for Binary tree in Python

#Binary Tree is actually a Data Structure but the traversal technique(BFS) we will use on it is an Algorithm

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

#Example Input1:
'''
1 3 2

***NOTE this line and below this line is not the part of input
Taking input 
this input will look like =>    1
                               / \
                              3   2 
'''
#Example Output1:
'''
1 3 2

***NOTE this line and below this line is not the part of output
we first traverse the starting node i.e node(1), then we move to the next level which consists of node(3) and node(2)
when we move from left to right, since after this all the child nodes are none we don't move forward with the Algorithm
'''


#Example Input2:
'''
7 12 15 20 N N N 30 N

***NOTE this line and below this line is not the part of input
Taking input
this input will look like =>        7
                                   / \
                                  12  15
                                 / \  / \
                                20  N N  N
                               /  \
                               30  N
'''
#Example Output@:
'''
7 12 15 20 30 

***NOTE this line and below this line is not the part of output
we first traverse from left to right at every level considering the root node to be the initial/start level
node(7) -> level 1
node(12),node(15) -> level 2 from left to right
node(20) -> level 3 from left to right
node(30) -> level 4 
'''

#BFS Algorithm
class Algorithm:
    def BFS_levelOrder(self,root):
        if root is None: #Base case if the root node itself is None
            return 0
        q = [root] #creating a list with root node in it and we will treat it as queue 
        LevelOrder = [] #This is the answer which we gonna return 
        while(len(q)>0):
            for i in range(len(q)):
                x = q.pop(0) #popping the element at the front
                LevelOrder.append(x.data) #adding current value of the node to the answer
                if x.left is not None: #priority if given to left child in level traversal
                    q.append(x.left)
                if x.right is not None: #checking if right child node is not None and then adding it to queue
                    q.append(x.right)
        return LevelOrder

#input code for taking input from the user
array = input().split() #taking input in the form of string and splitting it to a list
root = Build_BT(array) #passing the list to the function to build the Binary Tree
ans = Algorithm().BFS_levelOrder(root) #This BFS_levelOrder is function created seperately in Algorithm class
# ans will consist of list of data of level order traversal
print(*ans)

# The Time complexity of this Algorithm is O(N) where N is the number of nodes as we are traversing every node once.
#The Space Complexity of this Algorithm is O(N) where N is the number of nodes as we are storing every node once.

