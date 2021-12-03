#include<bits/stdc++.h>
using namespace std;
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
bool dfs(vector<int>& nums, vector<int>& p, int sum, int index) {
	if (index == nums.size())
		return true;

	int cur = nums[index];
	for (int& y:p) {
		if (y + cur <= sum)
		{
			y += cur;
			if (dfs(nums, p, sum, index + 1))
				return true;
			y -= cur;
		}
		if (y == 0)
			break;
	}
	return false;
}


bool makesquare(vector<int>& nums) {
	sort(nums.begin(), nums.end(), greater<int>());
	int total = accumulate(nums.begin(), nums.end(), 0);
	if (total % 4 != 0)
		return false;

	vector<int> p(4);
	return dfs(nums, p, total / 4, 0);
}

int s[100],n;
int main(){
    read(s,n);
    vector<int> nums;
    for(int i=1;i<=n;i++) nums.push_back(s[i]);
    if(makesquare(nums)){
        cout<<"true";
    }
    else cout<<"false";


}