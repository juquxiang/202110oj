#include<bits/stdc++.h>
using namespace std;
#define ll long long
const ll mod=1e9+7;
ll ksm(ll a,ll b){ll res=1;while(b){if(b&1){res=(res*a%mod+mod)%mod;}a=(a*a%mod+mod)%mod;b>>=1;}return (res+mod)%mod;}
int main(){
    ll n;cin>>n;
    ll ans=(ksm(20,(n)/2)*((n&1)?5:1))%mod;
    cout<<(ans+mod)%mod<<endl;
}