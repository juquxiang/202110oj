#include<bits/stdc++.h>
using namespace std;
#define N 10007
#define ll long long
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
int n,su=0;
int low_bit(int x){return (x&-x);}
int tr[N];
void add(int pos,int val){
    for(int i=pos;i<=su;i+=low_bit(i)){
        tr[i]+=val;
    }
}
int sum(int pos){
    int sum=0;
    while(pos){
        sum+=tr[pos];
        pos-=low_bit(pos);
    }
    return sum;
}
int s[N];
int main(){
    read(s,n);
    for(int i=1;i<=n;i++){
        su=max(su,s[i]);
    }
    int ans=0;
    for(int i=1;i<=n;i++){
        add(s[i],1);
        ans+=sum(su)-sum(s[i]);
        // cout<<sum[su]-
    }
    cout<<ans;

}