#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define N 10005
void read(int *m, int &n)
{
    char *p;
    const char *sep = ",";
    char s[100000];
    // FILE *ff;
    // ff=fopen("print.txt","r");
    // fscanf(ff,"[%s]",s);
    scanf("%s", s);
    p = strtok(s, sep);
    while (p)
    {
        m[++n] = atoi(p);
        // cout<<m[n]<<" ";
        p = strtok(NULL, sep);
    }
}
int s[N],n1,n2;
int main()
{
    read(s,n1);
    read(s+n1,n2);
    int n=n1+n2;
    sort(s+1,s+n+1);
    if(n&1) cout<<s[n/2+1];
    else cout<<(s[n/2]+s[n/2+1])/2.0;

}