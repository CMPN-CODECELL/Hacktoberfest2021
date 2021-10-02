#include<iostream>
#include <list>

using namespace std;
 
// This class represents a directed graph using
// adjacency list representation
class Graph
{
    int Vertices;    // No. of vertices
 
    // Pointer to an array containing adjacency
    // lists
    list<int> *adj;  
public:

    // Constructor  
    Graph(int Vertices){
    this->Vertices = Vertices;
    adj = new list<int>[Vertices];
    }

    // function to add an edge to graph
    void addEdge(int v, int w){
        adj[v].push_back(w); // Add w to v’s list.
    }
 
    // prints BFS traversal from a given source s
    void BFS(int s); 
};
 
void Graph::BFS(int s)
{
    // Mark all the vertices as not visited
    bool *visited = new bool[Vertices];
    for(int i = 0; i < Vertices; i++)
        visited[i] = false;
 
    // Create a queue for BFS
    list<int> queue;
 
    // Mark the current node as visited and enqueue it
    visited[s] = true;
    queue.push_back(s);
 
    // 'i' will be used to get all adjacent
    // vertices of a vertex
    list<int>::iterator i;
 
    while(!queue.empty())
    {
        // Dequeue a vertex from queue and print it
        s = queue.front();
        cout << s << " ";
        queue.pop_front();
 
        // Get all adjacent vertices of the dequeued
        // vertex s. If a adjacent has not been visited,
        // then mark it visited and enqueue it
        for (i = adj[s].begin(); i != adj[s].end(); ++i)
        {
            if (!visited[*i])
            {
                visited[*i] = true;
                queue.push_back(*i);
            }
        }
    }
}
 
// Driver program to test methods of graph class
int main()
{
    // Create a graph given in the above diagram
    Graph graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);
 
    cout << "Following is Breadth First Traversal starting from top i.e 0" << endl;
    graph.BFS(0);
 
    return 0;
}