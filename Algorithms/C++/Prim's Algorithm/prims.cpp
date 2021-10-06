#include <bits/stdc++.h>
using namespace std;

// Number of vertices in the graph
#define Vertices 5

// minimum key value, from the set of vertices not yet included in Minimum Spanning Tree

int minKey(int key[], bool mstSet[])
{
    // Initialize min value
    int min = INT_MAX, min_index;

    for (int v = 0; v < Vertices; v++)
        if (mstSet[v] == false && key[v] < min)
            min = key[v], min_index = v;

    return min_index;
}

void printMinSpannningTree(int parent[], int graph[Vertices][Vertices])
{
    cout << "Edge and Weight respectively" << endl;
    for (int i = 1; i < Vertices; i++)
        cout << parent[i] << " : " << i << " " << graph[i][parent[i]] << endl;
}

/* 
Function to construct and print Minimum Spanning Tree for
a graph represented using adjacency matrix representation
*/

void primMinSpanningTree(int graph[Vertices][Vertices])
{
    // Array to store constructed Minimum Spanning Tree
    int parent[Vertices];

    // Key values used to pick minimum weight edge in cut
    int key[Vertices];

    // To represent set of vertices included in
    bool mstSet[Vertices];

    // Initialize all keys as INFINITE
    for (int i = 0; i < Vertices; i++)
        key[i] = INT_MAX, mstSet[i] = false;

    // Always include first 1st vertex in Minimum Spanning Tree .
    // Make key 0 so that this vertex is picked as first vertex.

    key[0] = 0;
    parent[0] = -1; // First node is always root of Minimum Spanning Tree

    // The Minimum Spanning Tree will have V vertices
    for (int count = 0; count < Vertices - 1; count++)
    {
        // Pick the minimum key vertex from the
        // set of vertices not yet included in Minimum Spanning Tree
        int u = minKey(key, mstSet);

        // Add the picked vertex to the Minimum Spanning Tree  Set
        mstSet[u] = true;

        /*
         Update key value and parent index of
		 the adjacent vertices of the picked vertex.
		 Consider only those vertices which are not
		 yet included in Minimum Spanning Tree
         */

        for (int v = 0; v < Vertices; v++)
            if (graph[u][v] && mstSet[v] == false && graph[u][v] < key[v])
                parent[v] = u, key[v] = graph[u][v];
    }

    printMinSpannningTree(parent, graph);
}

int main()
{
    int graph[Vertices][Vertices] = {{0, 2, 0, 6, 0},
                                     {2, 0, 3, 8, 5},
                                     {0, 3, 0, 0, 7},
                                     {6, 8, 0, 0, 9},
                                     {0, 5, 7, 9, 0}};

    primMinSpanningTree(graph);

    return 0;
}
// This code is written by Akash