#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define N 600
ll f[N][N];//第i步的偏移量
const int mod=1e9+7;
int main(){
    int step,x;
    cin>>step>>x;
    x=min(step,x-1);
    f[0][0]=1;
    for(int i=1;i<=step;i++){
        for(int j=0;j<=x;j++){
            f[i][j]=f[i-1][j];
            if(j-1>=0) f[i][j]+=f[i-1][j-1];
            if(j+1<=x) f[i][j]+=f[i-1][j+1];
          f[i][j]%=mod;
        }
    }
    cout<<f[step][0];


}