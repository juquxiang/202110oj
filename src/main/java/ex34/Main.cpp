#include<bits/stdc++.h>
using namespace std;
#define N 10007
#define ll long long
char s[N];
int pos[30],num[N][30],k;
int main(){
    scanf("\"%s",s+1);
    cin>>k;
    int n=strlen(s+1),mx=0;
    n--;
    for(int i=1;i<=n;i++){
        for(int j=0;j<26;j++) num[i][j]=num[i-1][j];
        pos[s[i]-'a']=i;num[i][s[i]-'a']++;
        int l=1;
        while(l<=i){

            int flag=true;
            for(int j=0;j<26;j++){
                if(num[i][j]-num[l-1][j]==0) continue;
                if(num[i][j]-num[l-1][j]>=k) continue;
                flag=false;l=pos[j]+1;break;
            }
            if(flag){ mx=max(i-l+1,mx);break;}
        }
    }
    cout<<mx<<endl;
}