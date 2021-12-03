#include<bits/stdc++.h>
using namespace std;
#define N 10005
int f[N+100],m[N],d[N];
int n;
void read(){
    char *p;
    const char *sep = ",";
    char s[N*10];
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
int main(){
    read();
    for(int i=1;i<=n;i++) f[m[i]]++;
    d[1]=f[1];
    for(int i=2;i<=10000;i++){
        d[i]=max(d[i-1],d[i-2]+f[i]*i);
        if(f[i-1]==0)
            d[i]=max(d[i],d[i-1]+f[i]*i);

    }
    cout<<d[10000];


}