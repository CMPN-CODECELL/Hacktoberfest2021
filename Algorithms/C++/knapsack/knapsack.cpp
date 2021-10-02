#include<iostream>
#include <vector>
using namespace std;
int knapsack(int wt[],int val[],int maxweight,int n){

    vector<int> *dp=new vector<int>[n+1];
    for(int i=0;i<n+1;i++){
        vector<int> rows(maxweight+1, -1);
        dp[i]=rows;
    }

    for(int i=0;i<n+1;i++){
        for (int j=0;j<maxweight+1;j++){

            if(i==0 || j==0){
                dp[i][j]=0;
            }
            else if (wt[i-1]<maxweight){
                dp[i][j]=   max(   val[i-1] + dp[i-1][j-wt[i-1]]  ,   dp[i][j-1]  );
            }
            else{
                dp[i][j]=   dp[i-1][j];
            }
        }
    }

    for(int i=0;i<n+1;i++){
        for (int j=0;j<maxweight+1;j++){
            cout<<"dp["<<i<<"]"<<"["<<j<<"]"<<dp[i][j]<<'\t';
        }
        cout<<"\n";
    }
    
    return dp[n][maxweight];
    
}
int main()
{
    int n;
    cin>>n;
    int *wt=new int[n];
    int *val=new int[n];
    for(int i=0;i<n;i++){
        cin>>wt[i];
    }
    for(int i=0;i<n;i++){
        cin>>val[i];
    }
    int weight;
    cin>>weight;
    int ans=knapsack(wt,val,weight,n);
    cout<<ans;
}
