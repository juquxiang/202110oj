#include<bits/stdc++.h>
using namespace std;
#define N 30000
char s1[N],s2[N];
int main(){
    cin>>s1>>s2;
    int n=strlen(s1),m=strlen(s2);
    int i=0,j=0;
    while(i<n&&j<m){
        while(j<m&&s1[i]!=s2[j]) j++;
        if(j<m) i++,j++;
    }
    if(i==n) cout<<"true";else cout<<"false";
}
