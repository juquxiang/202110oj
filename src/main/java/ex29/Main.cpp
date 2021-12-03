#include <bits/stdc++.h>
using namespace std;
#define ll long long
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
#define N 100006
map<int, int> a;
struct node
{
    int num, val;
    bool operator<(node aa)
    {
        return num == aa.num ? val < aa.val : num > aa.num;
    }
} t[N];
int tot = 0;
vector<int> ans;
void solve(vector<int> &nums, int k)
{
    for (int i = 0; i < nums.size(); i++)
    {
        a[nums[i]]++;
    }
    for (auto y : a)
    {
        t[++tot] = {y.second, y.first};
    }
    sort(t + 1, t + tot + 1);

    for (int i = 1; i <= k; i++)
    {
        ans.push_back(t[i].val);
    }
}
int s[N],n;
int main()
{
    read(s, n);
    int k;
    cin >> k;
    vector<int> nums;
    for (int i = 1; i <= n; i++)
        nums.push_back(s[i]);
    solve(nums,k);
    sort(ans.begin(),ans.end());
    for(int i=0;i<ans.size();i++){
        cout<<ans[i];
        if(i!=ans.size()-1) cout<<",";
    }
}