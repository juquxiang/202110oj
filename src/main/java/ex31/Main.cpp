#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n, m;
    cin >> n >> m;
    int ans = 0;
    for (int i = 2; i != n + 1; ++i)
        ans = (m + ans) % i;
    cout << ans;
    return 0;
}