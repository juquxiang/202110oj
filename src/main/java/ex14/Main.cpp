#include<bits/stdc++.h>
using namespace std;
const int N=1<<15;
#define ll long long
int main(){
        int n;
        cin>>n;
        int f[N+10]={0};
        f[0] = 1;
        for (int i = 1; i < (1 << n); i++) {
            int num = __builtin_popcount(i);
            for (int j = 0; j < n; j++) {
                if (i & (1 << j) && (num % (j + 1) == 0 || (j + 1) % num == 0)) {
                    f[i] += f[i ^ (1 << j)];
                }
            }
        }
        cout<<f[(1 << n) - 1];

}