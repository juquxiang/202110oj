#include<bits/stdc++.h>
using namespace std;
#define N 30000
int a[N],tot=0;
int main(){

    while(scanf("%d",&a[++tot])!=EOF);tot--;
    a[tot+1]=0;
    for(int i=3;i<=tot+1;i++){
        a[i]+=min(a[i-1],a[i-2]);
    }
    cout<<a[tot+1];

}