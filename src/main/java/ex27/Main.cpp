#include<bits/stdc++.h>
using namespace std;
#define N 10007
#define ll long long
char s[N];
int n;
int a[N],b[N];
int dfs(int x,int y){
    int l,r,res=0,t=0;
    int m=1;
    for(int i=x;i<=y;i++){
        if(s[i]=='+'){res+=m*t;t=0,m=1;}
        else if(s[i]=='-'){res+=m*t;t=0,m=-1;}
        else if(s[i]=='('){
            l=i,r=i+1;
            while(a[r]!=b[r]) a[r]--,r++;i=r;

            t=dfs(l+1,r-1);
        }
        else{
            t*=10;t+=s[i]-'0';
        }
    }
    res+=m*t;
    return res;
}
int main(){
    cin>>s;
    int n=strlen(s);
    for(int i=0;i<n;i++){
        a[i]=a[i-1],b[i]=b[i-1];
        if(s[i]=='(') a[i]++;
        else if(s[i]==')') b[i]++;

    }
    cout<<dfs(0,n-1);

}