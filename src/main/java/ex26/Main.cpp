#include<bits/stdc++.h>
using namespace std;
#define N 10007
#define ll long long
char a[N],b[N];
int f[N][N];
int main(){
    cin>>(a+1)>>(b+1);
    int n=strlen(a+1),m=strlen(b+1);
    f[0][0]=1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(b[j]=='*')   for(int k=0;k<i;k++) f[i][j]=max(f[i][j],f[k][j-1]);
            else if(b[j]=='?'){
                f[i][j]=max(f[i][j],f[i-1][j-1]);
            }
            else if(b[j]==a[i]){
                f[i][j]=max(f[i][j],f[i-1][j-1]);
            }
        }
    }
    cout<<f[n][m];
}