#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define N 20007
#define LIM 15000

int main(){
    map<ll,int>  mp;
    int x=0;
    cin>>x;
    for(ll a=1;a<=INT_MAX;a*=2)for(ll b=a;b<=INT_MAX;b*=3)for(ll c=b;c<=INT_MAX;c*=5)
        mp[c]=1;
    int t=0;
    for(auto y:mp){
        t++;
        if(t==x)    {cout<<y.first<<" ";return 0;}
    }

}