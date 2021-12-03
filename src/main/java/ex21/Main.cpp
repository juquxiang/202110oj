#include<bits/stdc++.h>
using namespace std;
#define N 10007
#define ll long long
vector<int> dbq(string s) {
    vector<int> ans;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] >= '0' && s[i] <= '9')continue;
        vector<int> l = dbq(s.substr(0, i));
        vector<int> r = dbq(s.substr(i + 1, s.size()));
        for (int j = 0; j < l.size(); j++) {
            for (int k = 0; k < r.size(); k++) {
                if(s[i]=='+')
                    ans.push_back(l[j] + r[k]);
                else if(s[i]=='-')
                    ans.push_back(l[j] - r[k]);
                else if(s[i]=='*')
                    ans.push_back(l[j] * r[k]);
            }
        }
    }
    if (ans.size() == 0) {
        ans.push_back(stoi(s));
    }
    return ans;
}
int main(){
    string s;
    cin>>s;
    vector<int> ans=dbq(s);
    for(int i=0;i<ans.size();i++){
        cout<<ans[i];
        if(i!=ans.size()-1) cout<<" ";
    }

}