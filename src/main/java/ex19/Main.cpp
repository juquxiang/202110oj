#include<bits/stdc++.h>
using namespace std;
void read(int *m,int &n){
    char *p;const char *sep = ",";char s[100000];
    // FILE *ff;
    // ff=fopen("print.txt","r");
    // fscanf(ff,"[%s]",s);
    scanf("[%s]",s);
    p=strtok(s, sep);
    while (p){
        m[++n]=atoi(p);
        // cout<<m[n]<<" ";
        p = strtok(NULL, sep);
	}
}
#define N 100005
int s[N],n;
int main(){
    read(s,n);
    int m;cin>>m;
    sort(s+1,s+n+1);
    cout<<"[";
    for(int i=1;i<=m;i++){
        cout<<s[i];
        if(i!=m)cout<<", ";
    }
    cout<<"]";
}