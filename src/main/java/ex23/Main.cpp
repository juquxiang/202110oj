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
int s[N],n;
int main()
{
    read(s,n);
    for(int i=1;i<=n;i++)s[i+n]=s[i];
    n<<=1;
    for(int i=1;i<=n;i++)
        s[i]+=s[i-1];
    int mx=-100000;
    for(int len=1;len<=n/2;len++){
        for(int i=1,r=i+len-1;r<=n;i++,r++){
            mx=max(s[r]-s[i-1],mx);

        }
    }
    cout<<mx;

}