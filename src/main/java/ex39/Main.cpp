#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define N 600
const int MOD=1e9+7;
int dx[10]={-1,1,0,0};
int dy[10]={0,0,-1,1};
int main(){
    int m,n, mx, x, y;
    cin>>m>>n>>mx>>x>>y;
    int num = 0;
    vector<vector<int>> dp(m, vector<int>(n));
    dp[x][y] = 1;
    for (int i = 0; i < mx; i++) {
        vector<vector<int>> tmp(m, vector<int>(n));
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                int cnt = dp[j][k];
                if (cnt > 0) {
                    for(int kk=0;kk<4;kk++) {
                        int j1 = j + dx[kk], k1 = k + dy[kk];
                        if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                            tmp[j1][k1] = (tmp[j1][k1] + cnt) % MOD;
                        } else {
                            num = (num + cnt) % MOD;
                        }
                    }
                }
            }
        }
        dp = tmp;
    }
    cout<< num;
}