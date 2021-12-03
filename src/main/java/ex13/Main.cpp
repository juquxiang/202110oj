#include<bits/stdc++.h>
using namespace std;
#define N 50005
#define ll long long
int main(){
    int n,k;
    cin>>n>>k;
    int p=0;
    while(n!=1){
        int sum=(1<<(n-1));
        if(k>sum/2) k-=sum/2,p^=1;
        n--;
    }
    cout<<p<<endl;
}