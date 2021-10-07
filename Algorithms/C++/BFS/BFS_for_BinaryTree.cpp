#include <bits/stdc++.h>
#include <iostream>
#include <queue>
#include <vector>
#include <string>

using namespace std;
// Binary Trees are Trees in which every node has atmost 2 child nodes

// In this we are going to discuss about the level order traversal also known as BFS(Breadth First Search) Algorithm
// In this algorithm we are going to traverse the Binary Tree level wise 


// First let us build a Binary Tree
// A binary tree has a data value and a left pointer to the child node and a right pointer to the child node
// for this we are going to make a struct which is go

// Creating a struct
struct Node{
    int data;
    struct Node* left;
    struct Node* right;
    // Binary Tree has a data, a pointer to the left child node and a pointer to the right child node
};
// This is a utility function where we set/create every node and set it's left and right node to NULL and define it's data
Node* Newnode(int val){
    Node* newnode = new Node;
    newnode->data = val;
    newnode->left = NULL;
    newnode->right = NULL;
    return newnode;
}

// Building the Binary Tree where we take vector of string as a parameter
Node* BuildingBT(vector<string> array){
    if (array.size()==0 || array[0]=="N") // if the array is empty or the root node is NULL , NOTE:- "N" defines a NULL node
        return NULL;
    Node* root = Newnode(stoi(array[0])); // creating the root node by calling the utility function and converting the string value at index 0 to integer
    queue<Node*> q; // create a queue to build the tree and storing the nodes
    q.push(root);
    int ptr = 1; // Now starting from the second node as we already made the root node
    while(!q.empty() && ptr<array.size()){ //covering the whole tree untile the queue is not empty and the ptr does not reach length(array)
        Node* Current_Node = q.front(); // storing the front element
        q.pop(); // popping the front element
        string current_val = array[ptr]; // taking value from of the array where ptr is pointing
        if (current_val!="N"){ // checking if the value is not NULL (if it's NULL we just skip it)
            Current_Node->left = Newnode(stoi(current_val)); //setting and creating the current node's left to the current value by converting the string to integer value
            q.push(Current_Node->left); // pushing it to the queue
        }
        ptr++; // incrementing ptr as we have already passed the previous operation
        if(ptr>=array.size()) //checking if ptr has reached it's limit or not
            break; // if yes then break
        current_val = array[ptr]; // storing the current value of the array[ptr]
        if(current_val!="N"){ // checking if the value is not NULL (if it's NULL we just skip it)
            Current_Node->right = Newnode(stoi(current_val)); // creating a new node and setting the current node's right to the new node
            q.push(Current_Node->right);//pushing it to the queue
        }
        ptr++;// incrementing the ptr as we are done with that particular index
    }
    return root; //returning the Head/root of the Binary Tree
    }

//Algorithm BFS
class Algorithm
{
    public:
    //Function to return the level order traversal of a tree.
    vector<vector<int>> BFS_BT(Node* node) // node given as parameter is the root node
    {
        vector<vector<int>> ans; // our returning answer
        if(node==NULL) return ans; // if root itself is NULL 
        queue<Node*> q; // create a queue
        q.push(node); // push root
        while(!q.empty()){  //while lenght of queue is greater than 0
            vector<int> lvl; // creating the vector to store element at every level
            int size = q.size();
            for(int i=0;i<size;i++){ // traversing the particulare level
                Node* x = q.front(); 
                q.pop();
                lvl.push_back(x->data);
                if(x->left!=NULL) q.push(x->left); //pushing the left node if it's not NULL
                if(x->right!=NULL) q.push(x->right);//pushing the right node if it's not NULL
            }
            ans.push_back(lvl);//pushing the level element to our answer
        }
        return ans; // returning the 2D vector
    }
};
/*
@Example Input 1:
1 3 2

#This line and below this line are not considered in the input
The Tree according to the given info should look like this ==>     1
                                                                  / \
                                                                 3   2
@Example Output 1:
1
3 2

#This line and below this line are not considered in the output
level 1 -> 1
level 2 -> 3 2 
NOTE: we traverse from left to right in that particulare level
*/

/*
@Example Input 2:
12 36 44 N 33 7 N 9 18 N N

#This line and below this line are not considered in the input
The Tree according to the given info should look like this ==>          12
                                                                       /  \
                                                                      36    44
                                                                     /  \   / \
                                                                    N   33  7  N
                                                                       / \ / \
                                                                      9 18 N  N 
                                        
@Example Output 2:
12
36 44
33 7
9 18

#This line and below this line re not considered in the input
level 1 -> 12
level 2 -> 36 44  *from left to right
level 3 -> 33 7 
level 4 -> 9 18
*/

int main(){
    string s;
    getline(cin,s);//taking string input of the whole line from the user
    istringstream iss(s); 
    vector<string> array;
    for(string s;iss>>s;) //traversing the string and adding the elements as whole split into the array
        array.push_back(s);
    Node* root = BuildingBT(array); //building the tree according to the input 
    Algorithm call; //calling the class
    vector<vector<int>> res = call.BFS_BT(root); // calling the function of that class
    int n = res.size(); //now printing all the elements level wise
    for(int i=0;i<n;i++){
        int m = res[i].size();
        for(int j=0;j<m;j++){
            cout<<res[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<endl;
    
}

// The time complexity of BFS Algorithm is O(N), Where N is the number of Nodes as we are travering every node once.
// The space complexity of BFS Algorithm is O(N), Where N is the number of Nodes as we are storing every node once.

