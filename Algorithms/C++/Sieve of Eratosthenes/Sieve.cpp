#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define mod 1000000007
bool Sieve[100000001];

ll modularexponentiation(ll base,ll n){
	ll ans=1;
	while(n>0){
		if (n%2==0){
			base=(base*base)%mod;
			n=n/2;
		}
		else{
			ans=(base*ans)%mod;
			n=n-1;
		}
	}
	return ans;
}

void createSieve(int range=100000000){

	for (int i=1;i<=range;i++){
		Sieve[i]=true;
	}

	Sieve[1]=false;

	for(int i=2;i*i<=range;i++)
	{
		if(Sieve[i]==true)
		{
			for (int j = i*i; j <= range ;j += i)
				Sieve[j]=false;
		}
	}
	return;
}


int main() {
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    createSieve();
    int cnt=0;
    for(int i =1;i<=100000000;i++){
		if (Sieve[i]==true){
			cnt++;
			if(cnt%100==1){
				cout<<i<<"\n";
			}
		}
	}
    return 0;
}