#include<bits/stdc++.h>
using namespace std;
#define N 17
#define ll long long
void read(int *m,int &n){
    char *p;const char *sep = ",";char s[100000];
    scanf("[%s]",s);
    p=strtok(s, sep);
    while (p){
        m[++n]=atoi(p);
        p = strtok(NULL, sep);
	}
}
int vis[N];
int ans[N],s[N],n,res=0;
void dfs(int id){
    if(id==n/2+1){
        int x[N],tm=0;
        for(int i=1;i<id;i++) x[i]=ans[i];
        sort(x+1,x+id);
        for(int i=1;i<id;i++) {tm+=i*x[i];}
        res=max(res,tm);
        return ;
    }
    int tmp=0;
    while(vis[++tmp]==1) ;
    vis[tmp]=1;
    for(int i=1;i<=n;i++){
        if(vis[i]) continue;
        vis[i]=1;
        ans[id]=__gcd(s[i],s[tmp]);
        dfs(id+1);
        vis[i]=0;
    }
    vis[tmp]=0;
}

int main(){
    read(s,n);
    dfs(1);
    cout<<res<<endl;
}
Online Judge Footer

