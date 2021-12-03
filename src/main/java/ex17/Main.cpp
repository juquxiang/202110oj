#include <bits/stdc++.h>
using namespace std;
const int N = 50006;
#define ll long long
void read(int *m, int &n)
{
    char *p;
    const char *sep = ",";
    char s[100000];
    // FILE *ff;
    // ff=fopen("print.txt","r");
    // fscanf(ff,"[%s]",s);
    scanf("[%s]", s);
    p = strtok(s, sep);
    while (p)
    {
        m[n++] = atoi(p);
        // cout<<m[n]<<" ";
        p = strtok(NULL, sep);
    }
}
int a[N], n;
bool solve(int st)
{
    if (a[st] == 0)
        return true;
    bool vis[N];
    queue<int> q;
    q.push(st);
    vis[st] = true;
    while (!q.empty())
    {
        int u = q.front();
        q.pop();
        if (u + a[u] < n && !vis[u + a[u]])
        {
            if (a[u + a[u]] == 0)
            {
                return true;
            }
            q.push(u + a[u]);
            vis[u + a[u]] = true;
        }
        if (u - a[u] >= 0 && !vis[u - a[u]])
        {
            if (a[u - a[u]] == 0)
            {
                return true;
            }
            q.push(u - a[u]);
            vis[u - a[u]] = true;
        }
    }
    return false;
}
int main()
{
    read(a, n);
    int x;
    cin >> x;
    if (solve(x))
        cout << "true";
    else
        cout << "false";
}
