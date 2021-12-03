#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define N 1005
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
        m[n++] = atoi(p);
        // cout<<m[n]<<" ";
        p = strtok(NULL, sep);
    }
}
int s[N], n, f[N][N] = {0};
int main()
{
    read(s, n);

    for (int i = 0; i < n; i++)
        f[i][i] = s[i];
    for (int len = 2; len <= n; len++)
        for (int i = 0; i < n - len + 1; i++)
        {
            int j = i + len - 1;
            f[i][j] = max(-f[i + 1][j] + s[i], -f[i][j - 1] + s[j]);
        }

    cout << (f[0][n - 1] >= 0);
}