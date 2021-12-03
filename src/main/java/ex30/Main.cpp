#include<bits/stdc++.h>
using namespace std;
#define N 10007
#define ll long long
char s[N];
int n;
void dfs(int l,int r){
    for(int i=l;i<=r;i++){
        if(s[i]>='a'&&s[i]<='z')
            cout<<s[i];
        else if(s[i]=='['){
            int l=i,r=i+1;
            while(s[r]!=']') r++;
            int t=i-1,num=0,z=1;
            while(t>=0&&s[t]>='0'&&s[t]<='9') {num+=(s[t]-'0')*z;z*=10;t--;}
            for(int k=1;k<=num;k++)
                dfs(l+1,r-1);
            i=r;
        }
    }
}
int main(){
    cin>>s;
    int n=strlen(s);
    dfs(0,n-1);

}