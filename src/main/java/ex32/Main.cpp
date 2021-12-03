#include<bits/stdc++.h>
using namespace std;
#define N 10007
#define ll long long
const int mod=1337;
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
ll a[11]={1,0};
ll ksm(int *b,int n){
    ll res=1;
    int id=n;
    while(id){
        if(b[id]){
            res=res*a[b[id]]%mod;
        }
        for(int i=1;i<=9;i++)
        {
            int t=a[i];for(int k=2;k<=10;k++)a[i]=a[i]*t%mod;
        }
        id--;
    }
    return res;
}
int s[N],n;
int main(){
   scanf("%lld\n",&a[1]);
   read(s,n);
   for(int i=1;i<=10;i++) a[i]=a[i-1]*a[1]%mod;
   cout<<ksm(s,n);
}