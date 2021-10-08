#include <bits/stdc++.h>
using namespace std;

int max(int a, int b) { return (a > b) ? a : b; }

int knapSack(int W, int weight[], int values[], int n)
{
	if (n == 0 || W == 0)
		return 0;

	/*
     If weight of the nth item is more than Knapsack capacity W, then
	 this item cannot be included n the optimal solution
    */
	if (weight[n - 1] > W){
		return knapSack(W, weight, values, n - 1);   
    } 
	else{
		return max(
			values[n - 1]
				+ knapSack(W - weight[n - 1],
						weight, values, n - 1),
			knapSack(W, weight, values, n - 1));
    }
}

int main()
{
	int values[] = { 60, 100, 120 };
	int weight[] = { 10, 20, 30 };
	int W = 50;
	int n = sizeof(values) / sizeof(values[0]);
	cout << knapSack(W, weight, values, n);
}
// This code is written by Akash